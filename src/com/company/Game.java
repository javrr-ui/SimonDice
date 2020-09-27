package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Game {
    ArrayList<String> colores = new ArrayList<>(); //array de colores existentes
    ArrayList<String> coloresJuego = new ArrayList<>(); // array de colores aleatorios que se van añadiendo conforme avanza la partida
    boolean juegoEnCurso=false;

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public void setJuegoEnCurso(boolean juegoEnCurso) {
        this.juegoEnCurso = juegoEnCurso;
    }



    Scanner scan = new Scanner(System.in);

    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
    }

    @Override
    public String toString() {
        return "Game{" +
                "juegoEnCurso=" + juegoEnCurso +
                '}';
    }

    public void start(){
        juegoEnCurso=true;
        System.out.print(toString());

    }
    public void perdiste(){
        juegoEnCurso=false;
    }

    public void ganaste(){
    }
    public void botonVerdePresionado(){
        System.out.print("Presionaste el boton verde");
    }
}
