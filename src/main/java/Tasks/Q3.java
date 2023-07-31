package Tasks;

import Data.Director;
import Data.InMemoryMovieService;
import Data.Movie;

import java.util.Map;
import java.util.stream.Collectors;

public class Q3 {
    //Find the number of genres of each director's movies
    public static String findNumberOfGenresOfDirectors() {
        Map<Integer, Director> directors = InMemoryMovieService.getInstance().getDirectors();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();

        return directors.values().stream()
                .map(director -> {
                    long genreCount = movies.values().stream()
                            .filter(movie -> movie.getDirectors().contains(director))
                            .mapToInt(movie -> movie.getGenres().size()).sum();
                    return director.getName() + " has " + genreCount + " genres(s)";
                })
                .collect(Collectors.joining("\n"));

    }
}
