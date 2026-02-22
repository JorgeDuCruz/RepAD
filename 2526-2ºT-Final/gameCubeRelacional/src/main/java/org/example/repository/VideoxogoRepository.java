package org.example.repository;

import org.example.model.Videoxogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VideoxogoRepository extends JpaRepository<Videoxogo, Long> {

    List<Videoxogo> findByProtagonista_Poder_Nombre(String nombrePoder);

    List<Videoxogo> findByProtagonista_Id(Long id);

    List<Videoxogo> findByInimigo_Nombre(String nombre);

    List<Videoxogo> findByDataLanzamentoBefore(LocalDate dataLanzamento);
}
