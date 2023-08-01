package Tasks;

import Data.Genre;
import Data.InMemoryMovieService;
import Data.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q8 {
    //Group the movies by the year and list them

    public static String groupMoviesByYears() {
        StringBuilder s = new StringBuilder();
        Map<Integer, List<Movie>> moviesByYear = InMemoryMovieService.getInstance().getMovies().values()
                .stream()
                .collect(Collectors.groupingBy(Movie::getYear));

        moviesByYear.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<Movie>>comparingByKey().reversed())
            .forEach(entry -> {
                List<Movie> moviesOfYear = entry.getValue();
                moviesOfYear.stream().forEach(movie -> {
                    s.append(movie.getTitle()).append(" ").append(movie.getYear())
                            .append("\n");
                });
            });
        return s.toString();
    }
}
