package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Q11Test {
    //Find the minimum, the maximum and the average population of world countries.
    @Test
    @DisplayName("Test for Q11")
    void Q11() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        int maxPopulation = 0;
        Country maxPopulated = null;
        for(Country country : countries.values()) {
            if(country.getPopulation() > maxPopulation) {
                maxPopulation = country.getPopulation();
                maxPopulated = country;
            }
        }
        int minPopulation = maxPopulation;
        Country minPopulated = null;
        for(Country country : countries.values()) {
            if(country.getPopulation() == 0) continue;
            if(country.getPopulation() < minPopulation) {
                minPopulation = country.getPopulation();
                minPopulated = country;
            }
        }
        int populationSum = 0;
        for(Country country : countries.values()) {
            populationSum += country.getPopulation();
        }
        int averagePopulation =  populationSum / countries.values().size();

        s.append("Country with maximum population: ")
                .append(maxPopulated.getName()).append(" with population ").append(maxPopulated.getPopulation()).append("\n");
        s.append("Country with minimum population: ")
                .append(minPopulated.getName()).append(" with population ").append(minPopulated.getPopulation()).append("\n");
        s.append("Average population of a country ").append(averagePopulation);

        assertEquals(Q11.countryPopulationValues(), s.toString());



    }

}