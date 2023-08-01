package Tasks;

import Data.InMemoryMovieService;
import Data.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q8Test {
    //Group the movies by the year and list them
    @Test
    @DisplayName("Test for Q8")
    void Q8() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Integer, List<Movie>> moviesByYear = new TreeMap<>(Collections.reverseOrder());
        for(Movie movie : movies.values()) {
            if(moviesByYear.get(movie.getYear()) == null) {
                List<Movie> list = new ArrayList<>();
                list.add(movie);
                moviesByYear.put(movie.getYear(), list);
            } else {
                moviesByYear.get(movie.getYear()).add(movie);
            }
        }
        for(Map.Entry<Integer, List<Movie>> entry : moviesByYear.entrySet()) {
            List<Movie> listByYear = entry.getValue();
            for(Movie movie : listByYear){
                s.append(movie.getTitle()).append(" ").append(movie.getYear())
                        .append("\n");
            }
        }
        assertEquals(Q8.groupMoviesByYears(), s.toString());
    }

}