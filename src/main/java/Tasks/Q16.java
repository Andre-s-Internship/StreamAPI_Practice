package Tasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Map;

public class Q16 {
    //Find the cities with the minimum and the maximum population in countries.
    public static @NotNull String minMaxCitiesOfCountries() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();

        countries.values().stream()
                .sorted(Comparator.comparingInt(Country::getPopulation).reversed())
                .forEach(country -> {
                    s.append(country.getName()).append("\n");
            country.getCities().stream()
                    .max(Comparator.comparingInt(City::getPopulation))
                    .ifPresent(mostPopulatedCity -> s.append("Most populated city: ")
                            .append(mostPopulatedCity.getName())
                            .append(" with population of ")
                            .append(mostPopulatedCity.getPopulation())
                            .append("\n"));
            country.getCities().stream()
                    .min(Comparator.comparingInt(City::getPopulation))
                    .ifPresent(minPopulatedCity -> s.append("Minimum populated city: ")
                            .append(": ").append(minPopulatedCity.getName())
                            .append(" with population of ")
                            .append(minPopulatedCity.getPopulation())
                            .append("\n"));
        });

        return s.toString();
    }
}
