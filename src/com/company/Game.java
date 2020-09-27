package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Game {
    ArrayList<String> colores = new ArrayList<>();
    ArrayList<String> coloresJuego = new ArrayList<>();

    public ArrayList<String> getColoresJuego() {
        return coloresJuego;
    }

    public void setColoresJuego(ArrayList<String> coloresJuego) {
        this.coloresJuego = coloresJuego;
    }



    public String getColor() {
        return color;
    }



    String color;
    Scanner scan = new Scanner(System.in);

    Game(){
        colores.add("rojo");
        colores.add("azul");
        colores.add("amarillo");
        colores.add("verde");
    }
    public void start(){
        coloresJuego.clear();
        Random randomColor = new Random();
        Iterator<String> it;
        int i=0;

            coloresJuego.add(colores.get(randomColor.nextInt(4)));
            System.out.print("Simon dice: ");
            it = coloresJuego.iterator();
            while(it.hasNext()){
               System.out.print(it.next()+" ");
            }
            color = getColor();
            it = coloresJuego.iterator();
            while (it.hasNext()){
                if (color.equals(it.next())){
                    perdiste();
                }
            }
            i++;
    }
    public void perdiste(){

    }

    public void ganaste(){
    }
}
