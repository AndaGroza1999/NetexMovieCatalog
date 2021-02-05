package netex.movieCatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyProperties {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public String getApiKey() {
        String apiKey = "2f06300a";
        return apiKey;
    }

    public String getUrl() {
        String url = "https://www.omdbapi.com/?";
        return url;
    }
}
