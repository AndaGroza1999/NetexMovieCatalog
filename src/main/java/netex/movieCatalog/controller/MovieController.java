package netex.movieCatalog.controller;

import netex.movieCatalog.model.Movie;
import netex.movieCatalog.model.QMovie;
import netex.movieCatalog.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    //POST
    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PostMapping("/addMoviesList")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        return movieService.saveAllMovies(movies);
    }


    //GET
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/moviesById/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMoviebyId(id);
    }


    //PUT
    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        return movieService.deleteMovie(id);
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------

    //POST
    @PostMapping("/postMovies/{search}")
    public List<Movie> addALLMovies(@PathVariable String search) {
        return movieService.postMovies(search);
    }


    //GET
    @GetMapping("/getMoviesBetweenYears/{a}/{b}")
    public List<Movie> getMoviesBetweenYearsAB(@PathVariable Integer a, @PathVariable Integer b) {
        List<Movie> movieList = new ArrayList<>();
        List<Movie> movieList2 = movieService.getMovieList();

        for (Movie movie : movieList2) {
            if (a <= Integer.parseInt(movie.getReleaseYear()) && Integer.parseInt(movie.getReleaseYear()) <= b && movie.getType().equals("movie")) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    @GetMapping("/getMoviesByTitle/{search}")
    public List<Movie> getMovieByTitle(@PathVariable String search) {
        return movieService.getQueryFactory().selectFrom(QMovie.movie).where(QMovie.movie.title.contains(search)).fetch();
    }

    @GetMapping("/orderByTitleAsc")
    public List<Movie> orderMoviesByTitleAsc() {
        return movieService.getQueryFactory().selectFrom(QMovie.movie).orderBy(QMovie.movie.title.asc()).fetch();
    }

    @GetMapping("/orderByTitleDesc")
    public List<Movie> orderMoviesByTitleDesc() {
        return movieService.getQueryFactory().selectFrom(QMovie.movie).orderBy(QMovie.movie.title.desc()).fetch();
    }

    @PostMapping("/postMovies")
    public List<Movie> addALLMovies() {
        return movieService.postMovies("death");
    }
}