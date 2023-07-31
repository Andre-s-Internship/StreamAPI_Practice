package Tasks;

import Data.Director;
import Data.InMemoryMovieService;
import Data.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Q2Test {
    //Find the number of movies of each director
    @Test
    @DisplayName("Test for Q2")
    void Q2() {
        Map<Integer, Director> directors = InMemoryMovieService.getInstance().getDirectors();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Director, Integer> directorMovies = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for(Director director : directors.values()) {
            for(Movie movie : movies.values()) {
                if(movie.getDirectors().contains(director)) {
                    if(!directorMovies.containsKey(director)) {
                        directorMovies.put(director, 1);
                    } else directorMovies.put(director, directorMovies.get(director) + 1);
                }
            }
            s.append(director.getName()).append(" has ").append(directorMovies.get(director)).append(" movie(s)").append("\n");
        }
        //Remove the last "newLine"
        String answer = s.toString();
        answer = answer.stripTrailing();
        assertEquals(Q2.findNumberOfMoviesOfDirectors(), answer);
    }

}