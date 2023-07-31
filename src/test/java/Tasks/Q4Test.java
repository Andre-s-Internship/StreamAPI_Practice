package Tasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Q4Test {
    //Find the highest populated capital city
    @Test
    @DisplayName("Test for Q4")
    void Q4() {
            StringBuilder city = new StringBuilder("The most populated Capital city: ");
            Map<Integer, City> cities = InMemoryWorldDao.getInstance().getCities();
            Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
            Set<City> capitals = new HashSet<>();
            for(Country country : countries.values()) {
                capitals.add(cities.get(country.getCapital()));
            }
            int max = 0;
            City maxPopulated = null;
            for(City city1 : capitals) {
                if(city1 == null) continue;
                if(city1.getPopulation() > max) {
                    max = city1.getPopulation();
                    maxPopulated = city1;
                }
            }
            city.append(maxPopulated.getName());
            assertEquals(Q4.highestPopulatedCapitalCity(), city.toString());
    }

}