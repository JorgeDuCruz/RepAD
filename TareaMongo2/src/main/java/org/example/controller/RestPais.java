package org.example.controller;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPais.MAPPING)
public class RestPais {

    public static final String MAPPING = "/mongodb/Pais";

    @Autowired
    private PaisService PaisService;

    @PostMapping("/gardar")
    public ResponseEntity<Pais> gardar(@RequestBody Pais Pais) {
        PaisService.crearActualizarPais(Pais);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pais>> listarColeccion() {
        List <Pais> Paiss = PaisService.buscarPaiss();
        return new ResponseEntity<>(Paiss,HttpStatus.OK);
    }


    @GetMapping("/getProfedePais/{id}")
    public ResponseEntity<Presidente> actualizarGrupo(@PathVariable String id) {
        Presidente p = PaisService.buscarPresidenteDePais(id);

        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

}
