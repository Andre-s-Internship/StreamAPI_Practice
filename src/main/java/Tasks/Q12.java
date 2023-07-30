package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Q12 {
    //Find the minimum, the maximum and the average population of each continent.

    public static @NotNull String countryPopulationValuesByContinents() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        Set<Country> countrySet = new HashSet<>();
        continents.forEach(continent -> {
            countries.values().stream()
                    .filter(country -> country.getContinent().equals(continent))
                    .forEach(countrySet::add);
            countrySet.stream().filter(Objects::nonNull).max(Comparator.comparingInt(Country::getPopulation)
            ).ifPresent(mostPopulatedCountry -> s.append(continent).append("\n")
                    .append("Most populated country of ").append(continent)
                    .append(": ").append(mostPopulatedCountry.getName()).append("\n"));
            countrySet.stream().filter(Objects::nonNull).min(Comparator.comparingInt(Country::getPopulation)
            ).ifPresent(minPopulatedCountry -> s.append("Minimum populated country of ").append(continent)
                    .append(": ").append(minPopulatedCountry.getName()).append("\n"));
            s.append("Average population of a country in ").append(continent)
                    .append(": ")
                    .append(countrySet.stream()
                            .mapToInt(Country::getPopulation)
                            .sum()/countrySet.size()).append("\n");
            countrySet.clear();
        });
        return s.toString();
    }

}
