package org.example.service;

import org.example.model.Actores;
import org.example.model.Peliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {

    @Autowired
    private RestTemplate restTemplate;


    private static final String POSTGRES_BASE_URL_PELICULASES = "http://localhost:8081/postgres/peliculass";
    private static final String POSTGRES_BASE_URL_ACTORESS = "http://localhost:8081/postgres/actoreses";
    // ========== PELICULASES ==========
    public List<Peliculas> getAllPeliculases() {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES;
            ResponseEntity<List<Peliculas>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Peliculas>>() {}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter peliculases: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Peliculas getPeliculasById(Long id) {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES + "/" + id;
            ResponseEntity<Peliculas> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Peliculas.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter peliculas " + id + ": " + e.getMessage());
            return null;
        }
    }
    public List<Peliculas> getPeliculasByTitulo(String titulo) {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES + "/titulo/" + titulo;
            ResponseEntity<List<Peliculas>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Peliculas>>() {}
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter peliculas " + titulo + ": " + e.getMessage());
            return null;
        }
    }

    public Peliculas createPeliculas(Peliculas peliculas) {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Peliculas> request = new HttpEntity<>(peliculas, headers);

            ResponseEntity<Peliculas> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Peliculas.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao crear peliculas: " + e.getMessage());
            return null;
        }
    }

    public Peliculas updatePeliculas(Long id, Peliculas datos) {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES + "/" + id;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Peliculas> request = new HttpEntity<>(datos, headers);

            ResponseEntity<Peliculas> response = restTemplate.exchange(
                    url, HttpMethod.PUT, request, Peliculas.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao actualizar peliculas " + id + ": " + e.getMessage());
            return null;
        }
    }

    public boolean deletePeliculas(Long id) {
        try {
            String url = POSTGRES_BASE_URL_PELICULASES + "/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao borrar peliculas " + id + ": " + e.getMessage());
            return false;
        }
    }

    //ACTORES
    public List<Actores> getAllActoress() {
        try {
            String url = POSTGRES_BASE_URL_ACTORESS;
            ResponseEntity<List<Actores>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Actores>>() {}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter actoress: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Actores getActoresById(Long id) {
        try {
            String url = POSTGRES_BASE_URL_ACTORESS + "/" + id;
            ResponseEntity<Actores> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Actores.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao obter actores " + id + ": " + e.getMessage());
            return null;
        }
    }

    public Actores createActores(Actores actores) {
        try {
            String url = POSTGRES_BASE_URL_ACTORESS;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Actores> request = new HttpEntity<>(actores, headers);
            ResponseEntity<Actores> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Actores.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao crear actores: " + e.getMessage());
            return null;
        }
    }

    public Actores updateActores(Long id, Actores datos) {
        try {
            String url = POSTGRES_BASE_URL_ACTORESS + "/" + id;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Actores> request = new HttpEntity<>(datos, headers);
            ResponseEntity<Actores> response = restTemplate.exchange(
                    url, HttpMethod.PUT, request, Actores.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao actualizar actores " + id + ": " + e.getMessage());
            return null;
        }
    }

    public boolean deleteActores(Long id) {
        try {
            String url = POSTGRES_BASE_URL_ACTORESS + "/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao borrar actores " + id + ": " + e.getMessage());
            return false;
        }
    }
}
