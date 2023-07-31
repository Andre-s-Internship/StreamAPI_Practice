package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q6Test {

    @Test
    @DisplayName("Test for Q6")
    void Q6() {
        //Sort the countries by number of their cities in descending order
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        List<Country> cities = new ArrayList<>(countries.values());
        Comparator<Country> cityCountComparator = (country1, country2) ->
                Integer.compare(country2.getCities().size(), country1.getCities().size());
        cities.sort(cityCountComparator);
        for(Country country : cities) {
            s.append(country.getName()).append(":  ").append("Number of cities")
                    .append(" ").append(country.getCities().size()).append("\n");
        }
        assertEquals(Q6.sortCountriesByNumberOfCities(), s.toString());
    }

    }