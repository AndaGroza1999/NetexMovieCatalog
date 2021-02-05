package netex.movieCatalog.marshallingUnmarshalling;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import netex.movieCatalog.model.Movie;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class GetWithHeaderMovies {
//
//    public GetWithHeaderMovies() throws JsonProcessingException {
//    }
//
//    //Contact API
//    //"https://www.omdbapi.com/?apikey=2f06300a&s=death&page="
//
//
//    public String get() {
//
//        String resourceUrl = "https://www.omdbapi.com";
//
//        HttpHeaders headers = new HttpHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
//
//        UriComponentsBuilder param = UriComponentsBuilder.fromUri(URI.create(resourceUrl));
//        param.queryParam("apikey","2f06300a");
//        param.queryParam("s","death");
//
//        // HttpEntity<String>: To get result as String.
//        HttpEntity<?> entity = new HttpEntity<>(headers);
//
//        // Send request with GET method, and Headers.
//        String response = restTemplate.exchange(param.toUriString(), HttpMethod.GET, entity, String.class).getBody();
//
//        System.out.println(response);
//
//        return response;
//    }
//
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    List<Movie> myObjects = objectMapper.readValue(get(), new TypeReference<List<Movie>>() {
//    });

}

