package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class Q15 {
    //Group the countries by continent, and then sort the countries in continent by number of cities in each continent.
    public static @NotNull String groupAndSortCountriesByNumberOfCities() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        Comparator<Country> cityCountComparator = (country1, country2) ->
                Integer.compare(country2.getCities().size(), country1.getCities().size());
        continents.forEach(continent -> {
            s.append(continent).append("\n");
            countries.values().stream().filter(country -> country.getContinent().equals(continent))
                    .sorted(cityCountComparator)
                    .forEach(country -> s.append(country.getName()).append(":  ").append("Number of cities")
                            .append(" ").append(country.getCities().size()).append("\n"));
        });
        return s.toString();
    }
}
