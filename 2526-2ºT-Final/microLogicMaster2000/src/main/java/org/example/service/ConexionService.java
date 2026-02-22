package org.example.service;

import org.example.model.Exercicio;
import org.example.model.Videoxogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConexionService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String MONGO_BASE_URL = "http://localhost:8080/Mongo/exercicio";

    private static final String POSTGRES_BASE_URL = "http://localhost:8081/postgres/videoxogo";

    //Mongo
    public Exercicio crearExercicio(Exercicio exercicio) {
        try {
            String url = MONGO_BASE_URL+"/Exercicio";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Exercicio> request = new HttpEntity<>(exercicio,headers);

            ResponseEntity<Exercicio> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Exercicio.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Exercicio> buscarMongoTodos() {
        try {
            String url = MONGO_BASE_URL+"/Todos";
            ResponseEntity<List<Exercicio>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Exercicio>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Exercicio> borrarMongoTodos() {
        try {
            String url = MONGO_BASE_URL+"/Todos";
            ResponseEntity<List<Exercicio>> response = restTemplate.exchange(
                    url, HttpMethod.DELETE, null, new ParameterizedTypeReference<List<Exercicio>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }
    //Postgres

    public List<Videoxogo> buscarVideoxogoExemplo() {
        try {
            String url = POSTGRES_BASE_URL;
            ResponseEntity<List<Videoxogo>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Videoxogo>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Videoxogo> buscarVideoxogoEspadamaestra() {
        try {
            String url = POSTGRES_BASE_URL+"/VideoxogosEspadaMaestra";
            ResponseEntity<List<Videoxogo>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Videoxogo>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Videoxogo> buscarVideoxogoIDTres() {
        try {
            String url = POSTGRES_BASE_URL+"/IDTres";
            ResponseEntity<List<Videoxogo>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Videoxogo>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Videoxogo> buscarVideoxogoEnemigoFrieza() {
        try {
            String url = POSTGRES_BASE_URL+"/VideoxogosFrieza";
            ResponseEntity<List<Videoxogo>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Videoxogo>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }

    public List<Videoxogo> buscarVideoxogoPublicacionAntes2000() {
        try {
            String url = POSTGRES_BASE_URL+"/PublicadoAntes2000";
            ResponseEntity<List<Videoxogo>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Videoxogo>>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error ao chamar ao endpoint: " + e.getMessage());
            return null;
        }
    }


}
