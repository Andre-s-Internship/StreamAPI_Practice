package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q9Test {
    //Sort the countries by their population densities in descending order ignoring zero population countries

    @Test
    @DisplayName("Test for Q9")
    void Q9() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        Comparator<Country> populationComparator = (country1, country2) ->
                Double.compare((country2.getPopulation()/country2.getSurfaceArea()), (country1.getPopulation()/country1.getSurfaceArea()));
        List<Country> countryList = new ArrayList<>(countries.values());
        countryList.removeIf(country -> country.getPopulation() == 0);
        countryList.sort(populationComparator);
        for(Country country : countryList) {
        s.append(country.getName()).append(":  ")
                .append("Population ").append(country.getPopulation())
                .append(", Surface area ").append((int) country.getSurfaceArea())
                .append(", Density ").append(decimalFormat.format(country.getPopulation()/country.getSurfaceArea()))
                .append("\n");
        }
        assertEquals(Q9.sortCountriesByPopulation(), s.toString());
    }

}