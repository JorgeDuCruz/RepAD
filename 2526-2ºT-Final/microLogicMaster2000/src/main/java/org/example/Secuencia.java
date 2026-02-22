package org.example;

import org.example.model.Exercicio;
import org.example.model.Videoxogo;
import org.example.service.ConexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Secuencia {

    @Autowired
    private final ConexionService conexionService;


    public Secuencia(ConexionService conexionService) {
        this.conexionService = conexionService;
    }

    public void exameSolucion() {

        exercicio1();
        exercicio2();
        exercicio3();
        exercicio4();
        exercicio5();
        exercicio6();
        exercicio7();

    }

    private void exercicio1() {
        System.out.println("Execución Exercicio 1");

        Exercicio ex1 = new Exercicio();
        List<Videoxogo> list;

        list = conexionService.buscarVideoxogoEspadamaestra();
        ex1.setVideoxogos(list);
        ex1.setExercicio("Exercicio 1");
        conexionService.crearExercicio(ex1);

        System.out.println("Fin Exercicio 1");
    }

    private void exercicio2() {
        System.out.println("Execución Exercicio 2");

        Exercicio ex2 = new Exercicio();
        List<Videoxogo> list;

        list = conexionService.buscarVideoxogoIDTres();
        ex2.setVideoxogos(list);
        ex2.setExercicio("Exercicio 2");
        conexionService.crearExercicio(ex2);

        System.out.println("Fin Exercicio 2");

    }

    private void exercicio3() {
        System.out.println("Execución Exercicio 3");

        Exercicio ex3 = new Exercicio();
        List<Videoxogo> list;

        list = conexionService.buscarVideoxogoEnemigoFrieza();
        ex3.setVideoxogos(list);
        ex3.setExercicio("Exercicio 3");
        conexionService.crearExercicio(ex3);

        System.out.println("Fin Exercicio 3");

    }

    private void exercicio4() {
        System.out.println("Execución Exercicio 4");
        List<Exercicio> videoxogos = conexionService.buscarMongoTodos();
        for (Exercicio vid:videoxogos){
            System.out.println(vid);
        }
        System.out.println("Fin Exercicio 4");

    }

    private void exercicio5() {
        System.out.println("Execución Exercicio 5");
        conexionService.borrarMongoTodos();
        System.out.println("Fin Exercicio 5");
    }

    private void exercicio6() {

        System.out.println("Execución Exercicio 6");

        Exercicio ex6 = new Exercicio();
        List<Videoxogo> list;

        list = conexionService.buscarVideoxogoPublicacionAntes2000();
        ex6.setVideoxogos(list);
        ex6.setExercicio("Exercicio 6");
        conexionService.crearExercicio(ex6);

        System.out.println("Fin Exercicio 6");
    }

    private void exercicio7() {
        System.out.println("Execución Exercicio 6");
        List<Exercicio> exercicios = conexionService.buscarMongoTodos();

        for (Exercicio ex:exercicios){
            if (ex.getExercicio().equals("Exercicio 6")){
                ex.setExercicio("Exercicio 7");
                conexionService.crearExercicio(ex);
                break;
            }
        }

        System.out.println("Fin Exercicio 6");
    }
}
