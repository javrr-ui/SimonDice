package com.company;
import java.awt.Color;
import java.util.Random;

public class Colors {
    private static String[] colores ={"verde","rojo","azul","amarillo"};
    public static Color ROJO = new Color(255,0,0);
    public static Color AZUL = new Color(0,0,203);
    public static Color VERDE = new Color(0, 192, 0);
    public static Color AMARILLO = new Color(253,231,47);
    private static Random rand = new Random();

    public static String getRandomColor(){
        return colores[rand.nextInt(colores.length)];
    }
}