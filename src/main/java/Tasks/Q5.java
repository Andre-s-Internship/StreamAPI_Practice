package Tasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Q5 {
    //Find the highest populated capital city of each continent

    public static @NotNull String getMostPopulatedCitiesOfEachContinent() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Map<Integer, City> cities = InMemoryWorldDao.getInstance().getCities();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        Set<City> capitals = new HashSet<>();
        continents.forEach(continent -> {
            countries.values().stream()
                    .filter(country -> country.getContinent().equals(continent))
                    .forEach(country -> capitals.add(cities.get(country.getCapital())));
            capitals.stream().filter(Objects::nonNull).max(Comparator.comparingInt(City::getPopulation))
                    .ifPresent(mostPopulatedCapital -> s.append("Most populated capital of ")
                            .append(continent).append(": ").append(mostPopulatedCapital.getName()).append("\n"));
            capitals.clear();

        });
        return s.toString();

    }
}
