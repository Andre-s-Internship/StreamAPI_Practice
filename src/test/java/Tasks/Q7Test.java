package Tasks;

import Data.Genre;
import Data.InMemoryMovieService;
import Data.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q7Test {
    //Find the list of movies having the genres "Drama" and "Comedy" only
    @Test
    @DisplayName("Test for Q7")
    void Q7() {
        StringBuilder s = new StringBuilder();
        Map<Integer, Movie> movies = InMemoryMovieService.getInstance().getMovies();
        Map<Integer, Genre> genres = InMemoryMovieService.getInstance().getGenres();
        Optional<Genre> drama = genres.values().stream().filter(genre -> genre.getName().equals("Drama")).findFirst();
        Optional<Genre> comedy = genres.values().stream().filter(genre -> genre.getName().equals("Comedy")).findFirst();
        List<Movie> comedyAndDrama = new ArrayList<>();
        for(Movie movie: movies.values()) {
            if(movie.getGenres().contains(drama.orElse(null)) && movie.getGenres().contains(comedy.orElse(null)) && movie.getGenres().size()==2) {
                comedyAndDrama.add(movie);
            }
        }
        for(Movie movie : comedyAndDrama){
            s.append(movie.getTitle()).append("\n");
        }
        assertEquals(Q7.findExactGenres(), s.toString());
    }

}