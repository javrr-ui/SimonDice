package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<String> colores = new ArrayList<>(); //array de colores existentes
    private ArrayList<String> coloresJuego = new ArrayList<>(); // array de colores aleatorios que se van añadiendo conforme avanza la partida
    private ArrayList<String> coloresPresionados = new ArrayList<>(); // array de colores presionados por el usuario
    private Random randomColor = new Random();
    private boolean juegoEnCurso;
    private boolean haEmpezadoJuego;


    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
    }

    public void agregarColor(){
        coloresJuego.add(colores.get(randomColor.nextInt(4)));
    }

    public boolean colorPresionado(String color){
        coloresPresionados.add(color); //agrega los colores presionados por el jugador
        if((coloresJuego.size()==coloresPresionados.size())&&(coloresJuego.equals(coloresPresionados))){
            agregarColor();
            coloresPresionados.clear();
            return true;
        }else{
            if((coloresJuego.size()==coloresPresionados.size())&&(!coloresJuego.equals(coloresPresionados))){
                perdiste();
            }
            return false;
        }
    }

    public boolean haEmpezadoJuego() {
        return haEmpezadoJuego;
    }

    public void start(){
        juegoEnCurso=true;
        haEmpezadoJuego=true;
        agregarColor();
    }
    public void restart(){

        haEmpezadoJuego=true;
        coloresJuego.clear();
        coloresPresionados.clear();
        start();
    }

    public void perdiste(){
        juegoEnCurso=false;
        haEmpezadoJuego = false;
    }

    public void ganaste(){
        //do something when you win
    }
    public ArrayList<String> getColoresJuego() {
        return coloresJuego;
    }

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public void consoleMode(){
        System.out.println("Modo consola iniciado.");
    }


}
