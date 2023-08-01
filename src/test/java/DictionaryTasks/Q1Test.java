package DictionaryTasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Q1Test {
    @Test
    @DisplayName("Test for Q1")
    void Q1() {
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        Set<City> citiesOfContinent = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for(String continent : continents) {
                for(Country country : countries.values()) {
                    if (country.getContinent().equals(continent)) {
                        citiesOfContinent.addAll(country.getCities());
                    }
                }
                if(citiesOfContinent.isEmpty()) { //There are continents (Antarctica for example) which doesn't have any countries or cities
                    continue;
                }
                int max = 0;
                City maxCity = null;
                for(City city : citiesOfContinent) {
                    if(city.getPopulation() > max) {
                        max = city.getPopulation();
                        maxCity = city;
                    }
                }
            assert maxCity != null;
            s.append("Most populated city of ").append(continent).append(": ").append(maxCity.getName()).append("\n");
            citiesOfContinent.clear();
            }
        assertEquals(s.toString(), Tasks.Q1.getMostPopulatedCitiesOfEachContinent());
        }
}