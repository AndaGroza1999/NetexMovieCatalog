package netex.movieCatalog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Service
public class RequestService {

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public RequestService(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    public JsonNode getRS(String requestUrl, Map<String, String> urlParams) throws JsonProcessingException {
        return getFRS(requestUrl, urlParams);
    }

    private JsonNode getFRS(final String requestUrl, final Map<String, String> urlParams) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder urlParamBuilder = UriComponentsBuilder.fromUri(URI.create(requestUrl));
        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();

            urlParamBuilder.queryParam(key, val);
        }

        HttpEntity<?> entity = new HttpEntity<>(headers);

        String response = restTemplate.exchange(urlParamBuilder.toUriString(), HttpMethod.GET, entity, String.class).getBody();

        return objectMapper.readTree(response);
    }
}