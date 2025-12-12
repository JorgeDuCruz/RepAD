package org.example.repository;

import org.example.model.Adestrador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdestradorRepository extends MongoRepository<Adestrador, String> {

}


/**
 *
 * Modelo embebido:
 *
 * Os obxectos Protagonista, Inimigo e Poder quedan dentro do documento Videoxogo.
 * Unha escritura so
 * Máis rápido
 * Menos consultas
 * Se outros Videoxogos usan o mesmo Protagonista/Inimigo/Poder, estes datos repítense
 *
 *
 * EXEMPLO JSON:
 * {
 *   "titulo": "Zelda",
 *   "datalanzamento": "2020-12-10",
 *   "nivel": 5,
 *   "desenvolvedor": "Nintendo",
 *   "plataforma": "Switch",
 *   "categoria": "Aventura",
 *   "protagonista": {
 *     "nombre": "Link",
 *     "edad": 17,
 *     "historia": "O heroe de Hyrule",
 *     "poder": {
 *       "nombre": "Espada Mestra",
 *       "descripcion": "Arma lendaria",
 *       "nivel": 99
 *     }
 *   },
 *   "inimigo": {
 *     "nombre": "Ganon",
 *     "poder": "Maxia Escura",
 *     "nivel": 100
 *   }
 * }
 */