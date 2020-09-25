package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
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
        Random randomColor = new Random();
        int i=0;
       do{
            coloresJuego.add(colores.get(randomColor.nextInt(4)));
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException ex){
//                Thread.currentThread().interrupt();
//            }
            i=i+1;
       }while(i<10);
        Iterator<String> it = coloresJuego.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
