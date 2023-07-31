package Tasks;

import Data.InMemoryMovieService;
import Data.Movie;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q18 {
    //Find the year when the maximum number of movie is available
    public static @NotNull String findMovieMaxYear() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Integer, Long> yearCounts = new HashMap<>(); // year -> count


        movies.values().stream().sorted(Comparator.comparingInt(Movie::getYear).reversed())
                .map(Movie::getYear)
                .forEach(year -> {
                    yearCounts.put(year, movies.values().stream().filter(movie -> movie.getYear() == year).count());
                });
        yearCounts.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(entry -> s.append(entry.getKey()).append(" was the year with most movies: ")
                        .append(entry.getValue()));
        return s.toString();

    }
}
