package Tasks;

import Data.City;
import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q16Test {
    //Find the cities with the minimum and the maximum population in countries.
    @Test
    @DisplayName("Test for Q16")
    void Q16() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        List<Country> countryList = new ArrayList<>(countries.values().stream().toList());

        Comparator<Country> countryPopulationComparator = (country1, country2) ->
                Integer.compare(country2.getPopulation(), country1.getPopulation());
        countryList.sort(countryPopulationComparator);

        for(Country country : countryList) {
            s.append(country.getName()).append("\n");
            if(country.getCities().isEmpty()) continue;
            City maxPopulated = maxCity(country);
            City minPopulated = minCity(country);
            s.append("Most populated city: ")
                    .append(maxPopulated.getName())
                    .append(" with population of ")
                    .append(maxPopulated.getPopulation())
                    .append("\n");
            s.append("Minimum populated city: ")
                    .append(": ").append(minPopulated.getName())
                    .append(" with population of ")
                    .append(minPopulated.getPopulation())
                    .append("\n");
        }
        assertEquals(Q16.minMaxCitiesOfCountries(), s.toString());
    }

    private City maxCity(Country country) {
        int maxPopulation = -1;
        City maxPopulated = null;
        for(City city : country.getCities()) {
            if(city.getPopulation() > maxPopulation) {
                maxPopulation = city.getPopulation();
                maxPopulated = city;
            }
        }
        return maxPopulated;
    }

    private City minCity(Country country) {
        int minPopulation = maxCity(country).getPopulation() + 1;
        City minPopulated = null;
        for(City city : country.getCities()) {
            if(city.getPopulation() < minPopulation) {
                minPopulation = city.getPopulation();
                minPopulated = city;
            }
        }
        return minPopulated;
    }

}