package com.company;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Game {

    private Stack<String> secuencia;
    private Stack<String> secuenciaJugador;

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


    private int puntuacion;
    private Scanner scanner;
    private Random randomColor = new Random();
    private boolean juegoEnCurso;
    private boolean gameStarted;


    public boolean isGameStarted() {
        return gameStarted;
    }

    Game(){
        secuencia = new Stack<>();
        secuenciaJugador = new Stack<>();
        scanner = new Scanner(System.in);
    }

    public Stack<String> getSecuencia() {
        return secuencia;
    }

    public void clearStackJugador(){
        secuenciaJugador.clear();
    }
    public void clearStackJuego(){
        secuencia.clear();
    }
    public void startJuego(){
        juegoEnCurso=true;
        gameStarted =true;
    }

    public boolean haEmpezadoJuego() {
        return gameStarted;
    }


    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public void startWindowMode(){
        juegoEnCurso=true;
        gameStarted =true;
        clearStackJugador();
        agregarColor();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void consoleMode(){

        while(true){
            clearStackJugador(); //limpia el stack del jugador para que cada ronda comience de nuevo
            agregarColor(); //agrega un color nuev ala secuencia de colores vigente
            imprimirStack(secuencia,"Secuencia juego: ");
            for(String color: secuencia){
                leerColor(scanner.nextLine());
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
    public void comenzarDeNuevoVentana(){
        setPuntuacion(0);
        clearStackJuego();
        clearStackJugador();
        agregarColor();
    }

    public void  comenzarDeNuevo(){
        System.out.print("Comenzar de nuevo? (si/no): ");
        String res = scanner.nextLine();
        res.toLowerCase();
        if(res.equals("si")){
            secuencia.clear();
            clearPuntuacion();

        }else{
            System.exit(0);
        }
    }
    public void clearPuntuacion(){
        puntuacion = 0;
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

    public void leerColor(String color){
            secuenciaJugador.push(color);
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
