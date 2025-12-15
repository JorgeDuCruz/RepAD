package org.example.repository;

import org.example.model.PokemonFull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PokemonFullRepository extends MongoRepository<PokemonFull,String>{
    PokemonFull findBynome(String nome);
    void deleteBynome(String nome);
}
