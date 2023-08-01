package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;
import java.util.*;
import java.util.stream.Collectors;

public class Q15 {
    //Group the countries by continent, and then sort the countries in continent by number of cities in each continent.
    public static @NotNull String groupAndSortCountriesByNumberOfCities() {

        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Map<String, List<Country>> continentCountryMap = countries.values()
                .stream()
                .collect(Collectors.groupingBy(Country::getContinent));

        Comparator<Country> cityCountComparator = (country1, country2) ->
                Integer.compare(country2.getCities().size(), country1.getCities().size());

        continentCountryMap.values().forEach(countryList -> {
            countryList.sort(cityCountComparator);
        });

        continentCountryMap.forEach((key, value) -> {
            s.append(key).append("\n");
            value.forEach(country -> {
                s.append(country.getName()).append(":  ").append("Number of cities")
                        .append(" ").append(country.getCities().size()).append("\n");
                    });

        });
        return s.toString();
    }
}
