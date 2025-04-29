package com.tamurbek.services;

import com.tamurbek.model.Product;
import com.tamurbek.model.Users;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Users getUserById(Long id) {
        String url = "http://localhost:8085/api/users/"+id;
        return restTemplate.getForObject(url, Users.class);
    }

    public List<Users> getUserAll() {
        String url = "http://localhost:8085/api/users/all";

        ResponseEntity<List<Users>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Users>>() {}
        );

        return response.getBody();
    }

    public List<Product> getFoods() {
        String url = "http://192.168.1.29/SamandarMilkFoods/en_US/hs/v1";

        String username = "Админ";
        String password = "";

        String authStr = username + ":" + password;
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + base64Creds);
        headers.set("Content-Type", "application/json");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<List<Product>>() {},
                MediaType.APPLICATION_JSON
        );
        return response.getBody();
    }

}
