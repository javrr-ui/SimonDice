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

        System.out.println("Comenzar juego? (si/no)");
        if(scan.nextLine().equals("si")){
            System.out.println("Ingresa el nivel de dificultad (1 al 100)");
            start(scan.nextInt());

        }else {
            System.out.println("Vayase a la verga ps!");
        }
    }
    public void start(int dificultad){
        scan.nextLine(); //linea para limpiar el pto buffer
        coloresJuego.clear();
        Random randomColor = new Random();
        Iterator<String> it;
        int i=0;
    do{
            coloresJuego.add(colores.get(randomColor.nextInt(4)));
            System.out.print("Simon dice: ");
            it = coloresJuego.iterator();
            while(it.hasNext()){
               System.out.print(it.next()+" ");
            }

            it = coloresJuego.iterator();
            while (it.hasNext()){
                if (!scan.nextLine().equals(it.next())){
                    perdiste();
                }
            }
            i++;
       }while(i<dificultad);
        ganaste();
    }
    public void perdiste(){
        System.out.println(" _____  ______ _____  _____ _____  _____ _______ ______  __          __________     __ __   _______  ");
        System.out.println("|  __ \\|  ____|  __ \\|  __ \\_   _|/ ____|__   __|  ____| \\ \\        / /  ____\\ \\   / / \\ \\ / /  __ \\ ");
        System.out.println("| |__) | |__  | |__) | |  | || | | (___    | |  | |__     \\ \\  /\\  / /| |__   \\ \\_/ /   \\ V /| |  | |");
        System.out.println("|  ___/|  __| |  _  /| |  | || |  \\___ \\   | |  |  __|     \\ \\/  \\/ / |  __|   \\   /     > < | |  | |");
        System.out.println("| |    | |____| | \\ \\| |__| || |_ ____) |  | |  | |____     \\  /\\  /  | |____   | |     / . \\| |__| |");
        System.out.println("|_|    |______|_|  \\_\\_____/_____|_____/   |_|  |______|     \\/  \\/   |______|  |_|    /_/ \\_\\_____/ ");
        System.out.println("Seguir jugando? (si/no)");
        if (scan.nextLine().equals("si")){
            System.out.println("Ingresa el nivel de dificultad (1 al 100)");
            start(scan.nextInt());
        }else{
            System.exit(0);
        }
    }

    public void ganaste(){
        System.out.println("  _____          _   _           _____ _______ ______   ______ _    _ ______ ");
        System.out.println(" / ____|   /\\   | \\ | |   /\\    / ____|__   __|  ____| |____  | |  | |____  |");
        System.out.println("| |  __   /  \\  |  \\| |  /  \\  | (___    | |  | |__        / /| |  | |   / / ");
        System.out.println("| | |_ | / /\\ \\ | . ` | / /\\ \\  \\___ \\   | |  |  __|      / / | |  | |  / /  ");
        System.out.println("| |__| |/ ____ \\| |\\  |/ ____ \\ ____) |  | |  | |____    / /  | |__| | / /   ");
        System.out.println(" \\_____/_/    \\_\\_| \\_/_/    \\_\\_____/   |_|  |______|  /_/    \\____/ /_/   ");
        System.out.println("Seguir jugando? (si/no)");
        if (scan.nextLine().equals("si")){
            System.out.println("Ingresa el nivel de dificultad (1 al 100)");
            start(scan.nextInt());
        }else{
            System.exit(0);
        }
    }
}
