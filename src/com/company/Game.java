package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<String> colores = new ArrayList<>();
    ArrayList<String> coloresJuego = new ArrayList<>();
    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");

        Scanner scan = new Scanner(System.in);

        System.out.println("Comenzar juego? (si/no)");
        if(scan.nextLine().equals("si")){
            start();
        }else {
            System.out.println("Vayase a la verga ps!");
        }

    }
    public void start(){


    }



}
