package Tasks;

import Data.Director;
import Data.InMemoryMovieService;
import Data.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {
    //Find the number of movies of each director
    public static String findNumberOfMoviesOfDirectors() {
        Map<Integer, Director> directors = InMemoryMovieService.getInstance().getDirectors();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();

        return directors.values().stream()
                .map(director -> {
                    long movieCount = movies.values().stream()
                            .filter(movie -> movie.getDirectors().contains(director)).count();
                    return director.getName() + " has " + movieCount + " movie(s)";
                })
                .collect(Collectors.joining("\n"));

    }
}
