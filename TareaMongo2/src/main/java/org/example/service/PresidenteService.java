package org.example.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.repository.PresidenteRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class PresidenteService {

    private final PresidenteRepository PresidenteRepo;

    public PresidenteService(PresidenteRepository PresidenteRepo) {
        this.PresidenteRepo = PresidenteRepo;
    }

    public void crearActualizarPresidente(Presidente a) {
        PresidenteRepo.save(a);
    }

    public void borrarPresidentes() {
        PresidenteRepo.deleteAll();
    }

    public Presidente buscarPresidente(String id) {
        return PresidenteRepo.findById(id).orElse(null);
    }
    // Buscar Presidente
    public List<Presidente> buscarPresidentees() {
        return PresidenteRepo.findAll();
    }

    public List<Presidente> subirJson(){
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/main/java/org/example/Json/Presidente.json");
            Type tipoLista = new TypeToken<List<Presidente>>() {}.getType();
            List<Presidente> presidentes = gson.fromJson(reader, tipoLista);

            for (Presidente presidente : presidentes) {
                PresidenteRepo.save(presidente);
            }

            return presidentes;
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
            return null;
        }
    }
}