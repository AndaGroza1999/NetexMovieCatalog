package netex.movieCatalog.controller;

import netex.movieCatalog.model.Movie;
import netex.movieCatalog.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/postMovies")
    public List<Movie> addALLMovies() {
        return movieService.postMovies("death");
    }


}
