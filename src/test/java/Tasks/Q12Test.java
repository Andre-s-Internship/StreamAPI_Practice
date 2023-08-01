package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q12Test {
    //Find the minimum, the maximum and the average population of each continent.
    @Test
    @DisplayName("Test for Q12")
    void Q12() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Map<String, List<Country>> countryContinentMap = new TreeMap<>();
        Set<String> continents = InMemoryWorldDao.getInstance().getContinents();
        for(Country country : countries.values()) {
            if(countryContinentMap.get(country.getContinent()) == null) {
                List<Country> list = new ArrayList<>();
                list.add(country);
                countryContinentMap.put(country.getContinent(), list);
            } else {
                countryContinentMap.get(country.getContinent()).add(country);
            }
        }

        for(String continent : continents) {
            Country maxCountry = findMax(countryContinentMap.get(continent));
            Country minCountry = findMin(countryContinentMap.get(continent));
            int average = findAverage(countryContinentMap.get(continent));
            s.append(continent).append("\n")
                    .append("Most populated country of ").append(continent)
                    .append(": ").append(maxCountry.getName()).append("\n");
            s.append("Minimum populated country of ").append(continent)
                    .append(": ").append(minCountry.getName()).append("\n");
            s.append("Average population of a country in ").append(continent)
                    .append(": ").append(average).append("\n");
        }
        //System.out.println(countryContinentMap.get("Antarctica"));

        assertEquals(Q12.countryPopulationValuesByContinents(), s.toString());


    }

    private Country findMax(List<Country> list) {
        int maxPopulation = -1;
        Country maxPopulated = null;
        for(Country country : list) {
            if(country.getPopulation() > maxPopulation) {
                maxPopulation = country.getPopulation();
                maxPopulated = country;
            }
        }
        return maxPopulated;
    }
    private Country findMin(List<Country> list) {
        int minPopulation = findMax(list).getPopulation() + 1; // +1 was needed for not to have null for Antarctica, as all countries there have 0 population
        Country minPopulated = null;
        for(Country country : list) {
            if(country.getPopulation() < minPopulation) {
                minPopulation = country.getPopulation();
                minPopulated = country;
            }
        }
        return minPopulated;
    }

    private int findAverage(List<Country> list) {
        int sumPopulation = 0;
        for(Country country : list) {
                sumPopulation += country.getPopulation();
            }
        return sumPopulation/ list.size();

    }

}