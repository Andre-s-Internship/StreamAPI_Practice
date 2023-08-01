package Tasks;

import Data.InMemoryMovieService;
import Data.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Q18Test {
    //Find the year when the maximum number of movie is available

    @Test
    @DisplayName("Test for Q18")
    void Q18() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Integer, Integer> yearCounts = new HashMap<>(); // year -> count
        for(Movie movie : movies.values()) {
            if(yearCounts.get(movie.getYear()) == null) {
                yearCounts.put(movie.getYear(), 1);
            } else {
                yearCounts.put(movie.getYear(), yearCounts.get(movie.getYear()) + 1);
            }
        }
        int maxCount = 0;
        Integer maxYear = 0;
        for(Map.Entry<Integer, Integer> entry : yearCounts.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxYear = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        s.append(maxYear).append(" was the year with most movies: ")
                .append(maxCount);
        assertEquals(Q18.findMovieMaxYear(), s.toString());

    }

}