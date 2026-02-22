package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Videoxogo;
import org.example.service.VideoxogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestVideoxogo.MAPPING)
public class RestVideoxogo {

    public static final String MAPPING = "/postgres/videoxogo";

    @Autowired
    private VideoxogoService videoxogoService;

    @GetMapping("/VideoxogosEspadaMaestra")
    public ResponseEntity<List<Videoxogo>> obterVideoxogosProtagonistaEspadaMaestra() {
        List<Videoxogo> videoxogos = videoxogoService.obterVideoxogoProtagonistaPoderNombreEspadaMaestra();
        return new ResponseEntity<>(videoxogos,HttpStatus.OK);
    }

    @GetMapping("/IDTres")
    public ResponseEntity<List<Videoxogo>> obterVideoxogosProtagonistaID() {
        List<Videoxogo> videoxogos = videoxogoService.obterVideoxogoProtagonistaID3();
        return new ResponseEntity<>(videoxogos,HttpStatus.OK);
    }

    @GetMapping("/VideoxogosFrieza")
    public ResponseEntity<List<Videoxogo>> obterVideoxogosInimigoFrieza() {
        List<Videoxogo> videoxogos = videoxogoService.obterVideoxogoInimigoNombreFrieza();
        return new ResponseEntity<>(videoxogos,HttpStatus.OK);
    }

    @GetMapping("/PublicadoAntes2000")
    public ResponseEntity<List<Videoxogo>> obterVideoxogoAntesDel2000(){
        List<Videoxogo> videoxogos = videoxogoService.obterVideoxogoPublicadoAntesDel2000();
        return new ResponseEntity<>(videoxogos,HttpStatus.OK);
    }
}
