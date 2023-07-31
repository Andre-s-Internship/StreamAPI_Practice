package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.Map;

public class Q11 {
    //Find the minimum, the maximum and the average population of world countries.

    public static @NotNull String countryPopulationValues() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        countries.values().stream().filter(country -> country.getPopulation() != 0)
                .max(Comparator.comparingInt(Country::getPopulation))
                .ifPresent(country -> s.append("Country with maximum population: ")
                        .append(country.getName()).append(" with population ").append(country.getPopulation()).append("\n"));
        countries.values().stream().filter(country -> country.getPopulation() != 0)
                .min(Comparator.comparingInt(Country::getPopulation))
                .ifPresent(country -> s.append("Country with minimum population: ")
                        .append(country.getName()).append(" with population ").append(country.getPopulation()).append("\n"));
        s.append("Average population of a country ").append(countries.values().stream()
                .mapToInt(Country::getPopulation)
                .sum() /countries.values().size());

        return s.toString();
    }
}
