package com.company;
import java.util.Random;

public class Colors {
    private static String[] colores ={"verde","rojo","azul","amarillo"};
    private static Random rand = new Random();

    public static String getRandomColor(){
        return colores[rand.nextInt(colores.length)];
    }
}