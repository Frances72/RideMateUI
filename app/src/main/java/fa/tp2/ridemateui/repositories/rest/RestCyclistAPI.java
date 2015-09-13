package fa.tp2.ridemateui.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.RestAPI;

/**
 * Created by User on 2015/09/12.
 */
public class RestCyclistAPI implements RestAPI<Cyclist, Long> {
    //final String BASE_URL = "http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Cyclist get(Long id) {
        final String url = BASE_URL + "Cyclist/" + id.toString();
        HttpEntity<Cyclist> requestEntity = new HttpEntity<Cyclist>(requestHeaders);
        ResponseEntity<Cyclist> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Cyclist.class);
        Cyclist cyclist = responseEntity.getBody();
        return cyclist;
    }

    @Override
    public String post(Cyclist entity) {
        final String url = BASE_URL + "cyclist/create";
        HttpEntity<Cyclist> requestEntity = new HttpEntity<Cyclist>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Cyclist entity) {
        final String url = BASE_URL + "cyclist/update/" + entity.getId().toString();
        HttpEntity<Cyclist> requestEntity = new HttpEntity<Cyclist>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Cyclist entity) {
        final String url = BASE_URL + "cyclist/delete/" + entity.getId().toString();
        HttpEntity<Cyclist> requestEntity = new HttpEntity<Cyclist>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Cyclist> getAll() {
        List<Cyclist> cyclists = new ArrayList<>();
        final String url = BASE_URL + "cyclists/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Cyclist[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Cyclist[].class);
        Cyclist[] results = responseEntity.getBody();

        for (Cyclist cyclist : results) {
            cyclists.add(cyclist);
        }
        return cyclists;
    }
}


