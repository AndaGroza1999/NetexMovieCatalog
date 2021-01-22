package netex.movieCatalog.service;

import netex.movieCatalog.model.Movie;
import netex.movieCatalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //POST
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    //POST
    public List<Movie> saveAllMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    //GET
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //GET
    public Movie getMoviebyId(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    //GET
//    public Movie getMovieByTitle(String title) {
//        return movieRepository.findByName(title).orElse(null);
//    }

    //PUT
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setReleaseYear(movie.getReleaseYear());
        existingMovie.setImdbid(movie.getImdbid());
        existingMovie.setType(movie.getType());
        existingMovie.setPoster(movie.getPoster());
        return movieRepository.save(existingMovie);
    }

    //DELETE
    public String deleteMovie(int id) {
        movieRepository.deleteById(id);
        return "Movie with id " + id + " was deleted!";
    }
}
