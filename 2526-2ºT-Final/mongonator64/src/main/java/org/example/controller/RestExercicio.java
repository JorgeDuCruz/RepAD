package org.example.controller;

import org.example.model.Exercicio;
import org.example.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestExercicio.MAPPING)
public class RestExercicio {

    public static final String MAPPING = "/Mongo/exercicio";

    @Autowired
    private ExercicioService exercicioService;
    

    @GetMapping("/Todos")
    public ResponseEntity<List<Exercicio>> obterExercicioTodos(){
        List<Exercicio> exercicios = exercicioService.obterExercicioTodos();
        return new ResponseEntity<>(exercicios,HttpStatus.OK);
    }

    @DeleteMapping("/Todos")
    public ResponseEntity<List<Exercicio>> borrarExercicioTodos(){
        exercicioService.borrarExercicioTodos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/Exercicio")
    public ResponseEntity<Exercicio> crearExercicio(@RequestBody Exercicio vid){
        Exercicio v = exercicioService.crearExercicio(vid);
        if (v != null){
            return new ResponseEntity<>(v,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
