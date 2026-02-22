package org.example.repository;

import org.example.model.Exercicio;
import org.example.model.Videoxogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExercicioRepository extends MongoRepository<Exercicio, Long> {
}
