package com.tamurbek.services;

import com.tamurbek.model.Users;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
