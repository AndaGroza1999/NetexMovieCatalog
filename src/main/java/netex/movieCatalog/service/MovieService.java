package netex.movieCatalog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
<<<<<<< HEAD
import com.querydsl.jpa.impl.JPAQueryFactory;
=======
>>>>>>> 50acadc755c72cd33ac06df1858c19dddb377682
import netex.movieCatalog.MyConfiguration;
import netex.movieCatalog.model.Movie;
import netex.movieCatalog.model.QMovie;
import netex.movieCatalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
=======
>>>>>>> 50acadc755c72cd33ac06df1858c19dddb377682
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    String resourceUrl = "https://www.omdbapi.com/?apikey=2f06300a&s=death&page=";

    @Autowired
    private MovieRepository movieRepository;

<<<<<<< HEAD
    @Autowired
    private RequestService requestService;
=======
    private final RequestService requestService;
>>>>>>> 50acadc755c72cd33ac06df1858c19dddb377682

    @Autowired
    private MyConfiguration prop;

    public MovieService(RequestService requestService) {
        this.requestService = requestService;
    }

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

//------------------------------------------------------------------------------------------------------------------------------------------------------

    public List<Movie> postMovies(String search) {

        List<Movie> movies = new ArrayList<>();

        Map<String, String> urlParams = new LinkedHashMap<>();
        urlParams.put("apikey", prop.getApiKey());
        urlParams.put("s", search);

        for (int i = 0; i < 15; i++) {
            urlParams.put("page", String.valueOf(i));
            try {
                JsonNode jsonN = requestService.getRS(prop.getUrl(), urlParams);
                if (jsonN.get("Response").asText().equalsIgnoreCase("true") && jsonN.get("Search").isArray()) {
                    for (JsonNode j : jsonN.get("Search")) {
                        Movie m = new Movie();
<<<<<<< HEAD
                        if(j.get("Type").equals("movies")) {
                            m.setId(m.getId());
                            m.setTitle(j.get("Title").asText());
                            m.setReleaseYear(j.get("Year").asText());
                            m.setImdbid(j.get("imdbID").asText());
                            m.setType(j.get("Type").asText());
                            m.setPoster(j.get("Poster").asText());
                            movies.add(m);
                        }
=======
                        m.setId(m.getId());
                        m.setTitle(j.get("Title").asText());
                        m.setReleaseYear(j.get("Year").asText());
                        m.setImdbid(j.get("imdbID").asText());
                        m.setType(j.get("Type").asText());
                        m.setPoster(j.get("Poster").asText());
                        movies.add(m);
>>>>>>> 50acadc755c72cd33ac06df1858c19dddb377682
                    }
                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return saveAllMovies(movies);
    }

<<<<<<< HEAD
    public JPAQueryFactory getQueryFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("moviestabel");
        EntityManager em = emf.createEntityManager();
        return new JPAQueryFactory(em);
    }

    public List<Movie> getMovieList() {
        return getQueryFactory().selectFrom(QMovie.movie).fetch();
    }


=======
>>>>>>> 50acadc755c72cd33ac06df1858c19dddb377682
}
