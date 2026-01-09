package org.example.controller;

import org.example.model.Presidente;
import org.example.service.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPresidente.MAPPING)
public class RestPresidente {

    public static final String MAPPING = "/mongodb/Presidente";

    @Autowired
    private PresidenteService PresidenteService;

    @PostMapping("/gardar")
    public ResponseEntity<Presidente> gardar(@RequestBody Presidente Presidente) {
        PresidenteService.crearActualizarPresidente(Presidente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Presidente>> listarColeccion() {
        List <Presidente> Presidentes = PresidenteService.buscarPresidentees();
        return new ResponseEntity<>(Presidentes,HttpStatus.OK);
    }



}
