package Tasks;

import Data.Genre;
import Data.InMemoryMovieService;
import Data.Movie;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Q8 {
    //Group the movies by the year and list them

    public static String groupMoviesByYears() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        movies.values().stream().sorted(Comparator.comparingInt(Movie::getYear).reversed())
                .forEach(movie -> {
                    s.append(movie.getTitle()).append(" ").append(movie.getYear())
                            .append("\n");
                });
        return s.toString();


    }
}
