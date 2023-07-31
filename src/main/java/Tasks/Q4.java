package Tasks;
import Data.*;

import java.util.*;

public class Q4 {
    //Find the highest populated capital city
    public static String highestPopulatedCapitalCity() {
        StringBuilder city = new StringBuilder("The most populated Capital city: ");
        Map<Integer, City> cities = InMemoryWorldDao.getInstance().getCities();
        Map<String, Country> countries = InMemoryWorldDao.getInstance().getCountries();
        Set<City> capitals = new HashSet<>();
        countries.values().forEach(country -> capitals.add(cities.get(country.getCapital())));
        capitals.stream().filter(Objects::nonNull).max(Comparator.comparingInt(City::getPopulation)).ifPresent(mostPopulatedCapital -> city.append(mostPopulatedCapital.getName()));
        return city.toString();
    }

}
