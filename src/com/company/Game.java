package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    ArrayList<String> colores = new ArrayList<>(); //array de colores existentes

    public ArrayList<String> getColoresJuego() {
        return coloresJuego;
    }

    public void setColoresJuego(ArrayList<String> coloresJuego) {
        this.coloresJuego = coloresJuego;
    }

    ArrayList<String> coloresJuego = new ArrayList<>(); // array de colores aleatorios que se van añadiendo conforme avanza la partida
    Random randomColor = new Random();

    boolean juegoEnCurso=false;

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public void setJuegoEnCurso(boolean juegoEnCurso) {
        this.juegoEnCurso = juegoEnCurso;
    }

    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");

        coloresJuego.add(colores.get(randomColor.nextInt(4)));
        coloresJuego.add(colores.get(randomColor.nextInt(4)));
        coloresJuego.add(colores.get(randomColor.nextInt(4)));
        coloresJuego.add(colores.get(randomColor.nextInt(4)));
        coloresJuego.add(colores.get(randomColor.nextInt(4)));
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
        juego();
    }

    public void juego(){
       // coloresJuego.add(colores.get(randomColor.nextInt(4)));
    }


    public void perdiste(){
        juegoEnCurso=false;
    }

    public void ganaste(){
    }
    public void botonVerdePresionado(){
        System.out.println("Presionaste el boton verde");
    }
}
