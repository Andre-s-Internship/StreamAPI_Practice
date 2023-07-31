package Tasks;

import Data.Director;
import Data.InMemoryMovieService;
import Data.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Q3Test {
    //Find the number of genres of each director's movies
    @Test
    @DisplayName("Test for Q3")
    void Q3() {
        Map<Integer, Director> directors = InMemoryMovieService.getInstance().getDirectors();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Director, Integer> genreCount = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for(Director director : directors.values()) {
            for (Movie movie : movies.values()) {
                if(movie.getDirectors().contains(director)) {
                    if(!genreCount.containsKey(director)) {
                        genreCount.put(director, movie.getGenres().size());
                    } else genreCount.put(director, genreCount.get(director) + movie.getGenres().size());
                }
            }
            s.append(director.getName()).append(" has ").append(genreCount.get(director)).append(" genres(s)").append("\n");
        }
        String answer = s.toString().stripTrailing();
        assertEquals(Q3.findNumberOfGenresOfDirectors(), answer);
    }

}