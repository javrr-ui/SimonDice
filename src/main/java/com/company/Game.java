package com.company;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Game {

    private final Stack<String> secuencia;
    private final Stack<String> secuenciaJugador;
    private int puntaje;
    private final Scanner scanner;
    private boolean juegoEnCurso;
    private boolean gameStarted;

    Game(){
        secuencia = new Stack<>();
        secuenciaJugador = new Stack<>();
        scanner = new Scanner(System.in);
    }


    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public boolean isGameStarted() {
        return gameStarted;
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

    public int getPuntaje() {
        return puntaje;
    }

    public void consoleMode(){
        menu();
        while(true){
            clearStackJugador(); //limpia el stack del jugador para que cada ronda comience de nuevo
            agregarColor(); //agrega un color nuev ala secuencia de colores vigente
            imprimirStack(secuencia,"Secuencia juego: ");
            for(String ignored : secuencia){
                leerColor(scanner.nextLine());
                if(compararStacks()){
                    if(tamanoStackIguales()){
                        //si los stacks son iguales y del mismo tamaño muestra un mensaje
                        //System.out.println("Stacks iguales");

                       //puntuacio
                        puntaje = secuenciaJugador.size()+ puntaje;
                    }
                }else{
                    clearScreen();
                    System.out.println("Te equivocaste!");
                    System.out.println("Tu puntaje es: "+ puntaje);
                    setPuntaje(0);
                    clearStackJuego();
                    clearStackJugador();
                    consoleMode();
                    //comenzarDeNuevo();
                    break;
                }
            }
        }
    }
    public void restart(){
        setPuntaje(0);
        clearStackJuego();
        clearStackJugador();
        agregarColor();
    }

    public void  comenzarDeNuevo(){

        System.out.print("Comenzar de nuevo? (si/no): ");
        String res = scanner.nextLine();
        res = res.toLowerCase();
        if(res.equals("si")){
            clearStackJuego();
            clearPuntuacion();
            consoleMode();

        }else{
            System.exit(0);
        }
    }
    public void clearPuntuacion(){
        puntaje = 0;
    }

    public void imprimirStack(Stack<String> stack, String text){
        Stream stream = stack.stream();
        System.out.print(text);
        stream.forEach((color) -> System.out.print(color+" "));
        System.out.println(" ");

    }


    public void agregarColor(){
        secuencia.push(Colors.getRandomColor());
    }

    public void leerColor(String color){
            secuenciaJugador.push(color);
    }

    public boolean tamanoStackIguales(){
        return secuencia.size() == secuenciaJugador.size();
    }

    public boolean compararStacks(){

        boolean resultado=false;
        Iterator it = secuenciaJugador.iterator();
        Iterator it2 = secuencia.iterator();

        while(it.hasNext()){
            if(it.next().equals(it2.next())){
                resultado = true;
            }else{
                resultado = false;
                break;
            }
        }
        return resultado;
    }

    public void menu(){
        String input;
        int opc=0;
        clearScreen();
        System.out.println("MENU");
        System.out.println("[1] COMENZAR PARTIDA");
        System.out.println("[2] INSTRUCCIONES");
        System.out.println("[3] OPCIONES");
        System.out.println("[4] SALIR");
        do{
            input  = scanner.nextLine();
            if(esOpcionValida(input)){
                opc = Integer.parseInt(input);
            }else{
                System.out.println("No existe esa opción, por favor ingrese un numero valido");
            }

        }while(!esOpcionValida(input));
        switch(opc){
            case 1:
                //no ase nada XD
                break;
            case 2:
                mostrarInstrucciones();
                break;
            case 3:
                opciones();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    public void mostrarInstrucciones(){
        //aqui deben mostrarse las instrucciones del juego.
        System.out.println("INSTRUCCIONES:");
        System.out.println("Al comenzar el juego, iniciara una secuencia de colores aleatorios");
        System.out.println("Debes escribir un color y presionar ENTER, y continuar de esta manera hasta escribir cada color");
    }

    public void opciones(){
        //aqui deben mostrarse las opciones para configurar el juego
    }

    public boolean esOpcionValida(String input){
        //codigo de validacion aprueba de pendejos (solo acepta valores del 1 al 4)
        if(input ==null||input.length()<0){
            return false;
        }
        input = input.trim();
        if("".equals(input)){
            return false;
        }
        return input.matches("[1-4]");
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
