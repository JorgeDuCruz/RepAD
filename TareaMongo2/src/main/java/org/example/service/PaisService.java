package org.example.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.repository.PaisRepository;
import org.example.repository.PresidenteRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class PaisService {

    private final PaisRepository PaisRepo;
    private final PresidenteRepository PresidenteRepo;

    public PaisService(PaisRepository PaisRepo, PresidenteRepository PresidenteRepo) {
        this.PaisRepo = PaisRepo;
        this.PresidenteRepo = PresidenteRepo;
    }

    public void crearActualizarPais(Pais a) {
        PaisRepo.save(a);
    }

    // Borrar Alumno
    public void borrarPaises (){
        PaisRepo.deleteAll();
    }


    public Pais buscarPais(String id) {
        return PaisRepo.findById(id).orElse(null);
    }
    // Buscar Pais
    public List<Pais> buscarPaiss() {
        return PaisRepo.findAll();
    }

    // Buscar PresidenteDePais
    public Presidente buscarPresidenteDePais(String idPais) {
        Pais Pais = buscarPais(idPais);
        if (Pais == null) return null;

        Presidente Presidente = PresidenteRepo.findById(Pais.getId_presidente()).orElse(null);

        return Presidente;
    }

    public List<Pais> subirJson(){
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/main/java/org/example/Json/Pais.json");
            Type tipoLista = new TypeToken<List<Pais>>() {}.getType();
            List<Pais> paises = gson.fromJson(reader, tipoLista);

            for (Pais pais : paises) {
                PaisRepo.save(pais);
            }

            return paises;
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
            return null;
        }
    }


}