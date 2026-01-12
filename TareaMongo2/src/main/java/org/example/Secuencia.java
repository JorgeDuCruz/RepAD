package org.example;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.service.PaisService;
import org.example.service.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Secuencia {

    @Autowired
    private PaisService paisService;

    @Autowired
    private PresidenteService presidenteService;

    public void ejecutar() {
        System.out.println("Insertar datos...");
        paisService.subirJson();
        presidenteService.subirJson();

        System.out.println("Leer datos...");
        System.out.println(paisService.buscarPaiss());
        System.out.println(presidenteService.buscarPresidentees());

        System.out.println("Modificando datos...");
        System.out.println("Modificando pais...");
        Pais pais = paisService.buscarPais("!");
        ArrayList<String> partidos = pais.getPartidos();
        partidos.add("Creacionistas");
        pais.setPartidos(partidos);
        paisService.crearActualizarPais(pais);
        System.out.println("Modificado pais");

        System.out.println("Modificando presidente...");
        Presidente presidente = presidenteService.buscarPresidente("!");
        presidente.setNome("Juan");
        presidenteService.crearActualizarPresidente(presidente);
        System.out.println("modificado presidente");

        System.out.println("Leer datos...");
        System.out.println(paisService.buscarPaiss());
        System.out.println(presidenteService.buscarPresidentees());

        presidenteService.borrarPresidentes();
        paisService.borrarPaises();



    }
}
