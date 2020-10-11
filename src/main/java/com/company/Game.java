package com.company;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Game {
    private Stack<String> secuencia;
    private Stack<String> secuenciaJugador;
    private int puntuacion;
    private Scanner scanner;
    private Random randomColor = new Random();
    private boolean juegoEnCurso;
    private boolean haEmpezadoJuego;
    Game(){
        secuencia = new Stack<>();
        secuenciaJugador = new Stack<>();
        scanner = new Scanner(System.in);

        //System.out.println("Comenzar juego");
    }

    public Stack<String> getSecuencia() {
        return secuencia;
    }


    public void clearStackJugador(){
        secuenciaJugador.clear();
    }
    public void startJuego(){

    }


    public boolean colorPresionado(String color){
        secuenciaJugador.push(color); //agrega los colores presionados por el jugador
        return false;
    }

    public boolean haEmpezadoJuego() {
        return haEmpezadoJuego;
    }

    public void perdiste(){
        juegoEnCurso=false;
        haEmpezadoJuego = false;
    }

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }
    public void startWindowMode(){
        juegoEnCurso=true;
        haEmpezadoJuego=true;

    }


    public void consoleMode(){
        while(true){
            clearStackJugador();
            agregarColor();
            imprimirStack(secuencia,"Secuencia juego: ");
            for(String color: secuencia){
                leerColor();
                if(compararStacks()){
                    if(tamanoStackIguales()){
                        System.out.println("Stacks iguales");
                    }
                }else{
                    System.out.println("Te equivocaste!");
                    System.out.println("Tu puntuacion es: "+puntuacion);
                    comenzarDeNuevo();
                    break;
                }
            }
        }
    }
    void  comenzarDeNuevo(){
        System.out.print("Comenzar de nuevo? (si/no): ");
        String res = scanner.nextLine();
        res.toLowerCase();
        if(res.equals("si")){
            secuencia.clear();

        }else{
            System.exit(0);
        }
    }

    public void imprimirStack(Stack<String> stack,String text){
        Stream stream = stack.stream();
        System.out.print(text);
        stream.forEach((color) -> {
            System.out.print(color+" ");
        });
        System.out.println("");

    }


    public void agregarColor(){
        secuencia.push(Colors.getRandomColor());
    }

    public void leerColor(){
        secuenciaJugador.push(scanner.nextLine());
    }

    public boolean tamanoStackIguales(){
        if(secuencia.size()==secuenciaJugador.size()){
            return true;
        }else{
            return false;
        }
    }

    public boolean compararStacks(){
        boolean resultado=false;
        Iterator it = secuenciaJugador.iterator();
        Iterator it2 = secuencia.iterator();

        while(it.hasNext()){
            if(it.next().equals(it2.next())){
                resultado = true;
                puntuacion += 5;
            }else{
                resultado = false;
                break;
            }
        }
        return resultado;
    }


}
