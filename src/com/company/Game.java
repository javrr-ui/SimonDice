package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Game {
    ArrayList<String> colores = new ArrayList<>();
    ArrayList<String> coloresJuego = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
    }
    public void start(){

    }
    public void perdiste(){

    }

    public void ganaste(){
    }
    public void botonVerdePresionado(){
        System.out.print("Presionaste el boton verde");
    }
}
