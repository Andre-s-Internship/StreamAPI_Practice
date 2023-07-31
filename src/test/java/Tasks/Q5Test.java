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

class Q5Test {
    //Find the highest populated capital city of each continent
    @Test
    @DisplayName("Test for Q5")
    void Q5() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Map<Integer, City> cities = InMemoryWorldDao.getInstance().getCities();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        Set<City> continentCapitals = new HashSet<>();
        for(String continent : continents) {
            for(Country country : countries.values()) {
                if(country.getContinent().equals(continent)) {
                    continentCapitals.add(cities.get(country.getCapital()));
                }
            }
            int max = 0;
            City mostPopulatedCapital = null;
            for(City capital : continentCapitals) {
                if(capital == null) continue;
                if(capital.getPopulation() > max) {
                    max = capital.getPopulation();
                    mostPopulatedCapital = capital;
                }
            }
            if(mostPopulatedCapital == null) continue;
            s.append("Most populated capital of ").append(continent).append(": ").append(mostPopulatedCapital.getName()).append("\n");
            continentCapitals.clear();
        }
        assertEquals(Q5.getMostPopulatedCitiesOfEachContinent(), s.toString());
    }

}