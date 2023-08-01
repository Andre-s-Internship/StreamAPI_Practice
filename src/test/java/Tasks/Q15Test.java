package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q15Test {
    //Group the countries by continent, and then sort the countries in continent by number of cities in each continent.

    @Test
    @DisplayName("Test for Q15")
    void Q15() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Map<String, List<Country>> continentCountryMap = new HashMap<>();
        for(Country country : countries.values()) {
            if(continentCountryMap.get(country.getContinent()) == null) {
                List<Country> list = new ArrayList<>();
                list.add(country);
                continentCountryMap.put(country.getContinent(), list);
            } else {
                continentCountryMap.get(country.getContinent()).add(country);
            }
        }
        Comparator<Country> cityCountComparator = (country1, country2) ->
                Integer.compare(country2.getCities().size(), country1.getCities().size());

        for(String continent : continentCountryMap.keySet()) {
            List<Country> list = continentCountryMap.get(continent);
            list.sort(cityCountComparator);
            continentCountryMap.put(continent, list);
            s.append(continent).append("\n");
            for(Country country : list) {
                s.append(country.getName()).append(":  ").append("Number of cities")
                        .append(" ").append(country.getCities().size()).append("\n");
            }
        }
        assertEquals(Q15.groupAndSortCountriesByNumberOfCities(), s.toString());

    }

}