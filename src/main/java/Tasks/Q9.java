package Tasks;

import Data.Country;
import Data.InMemoryWorldDao;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Map;

public class Q9 {
    //Sort the countries by their population densities in descending order ignoring zero population countries
    public static @NotNull String sortCountriesByPopulation() {
        StringBuilder s = new StringBuilder();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        Comparator<Country> populationComparator = (country1, country2) ->
                Double.compare((country2.getPopulation()/country2.getSurfaceArea()), (country1.getPopulation()/country1.getSurfaceArea()));


        countries.values().stream().sorted(populationComparator)
                .filter(country -> country.getPopulation() != 0)
                .forEach(country -> s.append(country.getName()).append(":  ")
                        .append("Population ").append(country.getPopulation())
                        .append(", Surface area ").append((int) country.getSurfaceArea())
                        .append(", Density ").append(decimalFormat.format(country.getPopulation()/country.getSurfaceArea()))
                        .append("\n"));
        return s.toString();
    }
}
