package Tasks;

import Data.Director;
import Data.Genre;
import Data.InMemoryMovieService;
import Data.Movie;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q7 {
    //Find the list of movies having the genres "Drama" and "Comedy" only
    public static String findExactGenres() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Integer, Genre> genres = InMemoryMovieService.getInstance().getGenres();
        Optional<Genre> drama = genres.values().stream().filter(genre -> genre.getName().equals("Drama")).findFirst();
        Optional<Genre> comedy = genres.values().stream().filter(genre -> genre.getName().equals("Comedy")).findFirst();

        movies.values().stream().filter(movie -> movie.getGenres().size() == 2 && movie.getGenres().contains(drama.get()) && movie.getGenres().contains(comedy.get()))
                .forEach(movie -> {
                    s.append(movie.getTitle()).append("\n");
                });
        return s.toString();


    }
}
