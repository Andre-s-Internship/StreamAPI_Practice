package Tasks;

import Data.*;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
public class Q1 {
    //Find the most populated city of each continent
    public static @NotNull String getMostPopulatedCitiesOfEachContinent() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        continents.forEach(continent -> {
            countries.values().stream()
                    .filter(country -> country.getContinent().equals(continent))
                    .flatMap(country -> country.getCities().stream())
                    .max(Comparator.comparingInt(City::getPopulation))
                    .ifPresent(mostPopulatedCity -> s.append("Most populated city of ").append(continent).append(": ").append(mostPopulatedCity.getName()).append("\n"));

        });
        return s.toString();
    }

}
