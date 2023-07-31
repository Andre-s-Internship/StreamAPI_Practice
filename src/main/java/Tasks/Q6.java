package Tasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Q6 {
    //Sort the countries by number of their cities in descending order
    public static @NotNull String sortCountriesByNumberOfCities() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();

        Comparator<Country> cityCountComparator = (country1, country2) ->
                Integer.compare(country2.getCities().size(), country1.getCities().size());

        countries.values().stream().sorted(cityCountComparator)
                .forEach(country -> s.append(country.getName()).append(":  ").append("Number of cities")
                        .append(" ").append(country.getCities().size()).append("\n"));
        return s.toString();
    }


    }
