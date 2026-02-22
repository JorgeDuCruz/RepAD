package org.example.service;

import org.example.model.Exercicio;
import org.example.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }


    public List<Exercicio> obterExercicioTodos() {
        return exercicioRepository.findAll();
    }

    public void borrarExercicioTodos() {
        exercicioRepository.deleteAll();
    }

    public Exercicio crearExercicio(Exercicio vid){
        return exercicioRepository.save(vid);
    }

}
