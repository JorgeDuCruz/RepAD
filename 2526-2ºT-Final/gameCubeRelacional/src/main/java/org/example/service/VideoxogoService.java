package org.example.service;

import org.example.model.Videoxogo;
import org.example.repository.VideoxogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VideoxogoService {

    private final VideoxogoRepository videoxogoRepository;

    @Autowired
    public VideoxogoService(VideoxogoRepository videoxogoRepository) {
        this.videoxogoRepository = videoxogoRepository;
    }

    public List<Videoxogo> obterVideoxogoProtagonistaPoderNombreEspadaMaestra() {
        return videoxogoRepository.findByProtagonista_Poder_Nombre("Espada Maestra");
    }

    public List<Videoxogo> obterVideoxogoProtagonistaID3() {
        return videoxogoRepository.findByProtagonista_Id(3L);
    }

    public List<Videoxogo> obterVideoxogoInimigoNombreFrieza() {
        return videoxogoRepository.findByInimigo_Nombre("Frieza");
    }

    public List<Videoxogo> obterVideoxogoPublicadoAntesDel2000() {
        return videoxogoRepository.findByDataLanzamentoBefore(LocalDate.of(2000, 1, 1));
    }

}
