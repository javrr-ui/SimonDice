package com.company;

import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Game {
    public static final int MENU_PRINCIPAL = 1;
    //public static final int MENU_INSTRUCCIONES = 2;
    public static final int  MENU_OPCIONES = 3;


    private final Stack<String> secuencia;
    private final Stack<String> secuenciaJugador;
    private int puntaje;
    private final Scanner scanner;
    private boolean juegoEnCurso;
    private boolean gameStarted;

    Game(){
        puntaje=0;
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
            agregarColor(); //agrega un color nuevo a la secuencia de colores vigente
            imprimirStack(secuencia,"Siguiente color: ");
            for(String ignored : secuencia){
                leerColor(scanner.nextLine());
                if(compararStacks()){
                    if(tamanoStackIguales()){
                        //si los stacks son iguales y del mismo tamaño muestra un mensaje
                        //System.out.println("Stacks iguales");

                       //puntuacion
                       // puntaje = secuenciaJugador.size()+ puntaje;
                       puntaje = puntaje +1;
                    }
                }else{
                    clearScreen();
                    System.out.println("Te equivocaste!");
                    System.out.println("Tu puntaje es: "+ puntaje);
                    //setPuntaje(0);
                    clearStackJuego();
                    clearStackJugador();
                    consoleMode();

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

    public void imprimirStack(Stack<String> stack, String text){
//        Stream stream = stack.stream();
//        System.out.print(text);
//        stream.forEach((color) -> System.out.print(color+" "));
//        System.out.println(" ");
        System.out.println("Puntuación: "+puntaje);
        System.out.println(text + stack.peek());

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
    public void printMenu(int menu){
        switch (menu){
            case MENU_PRINCIPAL:
                System.out.println("MENU");
                System.out.println("[1] COMENZAR PARTIDA");
                System.out.println("[2] INSTRUCCIONES");
                System.out.println("[3] OPCIONES");
                System.out.println("[4] SALIR");
                break;
            case MENU_OPCIONES:
                System.out.println("OPCIONES");
                System.out.println("[1] ACTIVAR MODO VENTANA");
                System.out.println("[2] REGRESAR");
                break;
            default:
                break;
        }

    }


    public void menu(){
        String input;
        int opc=0;
        printMenu(MENU_PRINCIPAL); //muestra un menu con opciones

        do{
            input  = scanner.nextLine();
            if(esOpcionValida(input,4)){
                opc = Integer.parseInt(input);
            }else{
                clearScreen();
                System.out.println("No existe esa opción, por favor ingrese un numero valido");
                printMenu(MENU_PRINCIPAL);
            }

        }while(!esOpcionValida(input,4));
        switch(opc){
            case 2:
                instrucciones();
                //menu();
                consoleMode();
                break;
            case 3:
                opciones();
                consoleMode();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                break;
        }
    }


    public void opciones(){
        String input;
        int opc=0;
        printMenu(MENU_OPCIONES);

        do{
            input  = scanner.nextLine();
            if(esOpcionValida(input,2)){
                opc = Integer.parseInt(input);
            }else{
                clearScreen();
                System.out.println("No existe esa opción, por favor ingrese un numero valido");
                printMenu(MENU_OPCIONES);
            }

        }while(!esOpcionValida(input,2));
        switch(opc){
            case 1:
                Main.modoNormal();
                break;
            case 2:
                break;

            default:
                break;
        }
    }

    public boolean esOpcionValida(String entrada, int cantidadOpciones){
        String regularExpresion = "[1-"+cantidadOpciones+"]";
        //codigo de validacion aprueba de pendejos (solo acepta valores del 1 ala cantidad de opciones que se designa)
        if(entrada == null){
            return false;
        }
        entrada = entrada.trim();
        if("".equals(entrada)){
            return false;
        }
        return entrada.matches(regularExpresion);
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void instrucciones(){
        System.out.println("INSTRUCCIONES");
        System.out.println("1. Al comenzar el juego, se mostrará una secuencia de colores, comenzando con un color aleatorio.");
        System.out.println("2. Debes escribir la escuencia de colores un color a la vez y dar enter.");
        System.out.println("3. Cuando escribas todos los colores de manera correcta, se añadirá un nuevo color a la secuencia.");
        System.out.println("4. Debes escribir todos los colores desde el inicio.");
        System.out.print("Quieres ver un ejemplo? (si/no): ");
        if(scanner.nextLine().toLowerCase(Locale.getDefault()).equals("si")){
            ejemplo();
        }
    }
    public void ejemplo(){
        clearScreen();
        printMenu(MENU_PRINCIPAL);
        dormir(1000);
        printPalabraXPalabra("1",1000,1);
        clearScreen();
        System.out.println("Secuencia juego: amarillo");
        dormir(200);
        printLetraXLetra("amarillo",200);
        System.out.println("Secuencia juego: amarillo azul");
        dormir(200);
        printLetraXLetra("amarillo",200);
        printLetraXLetra("azul",200);
        System.out.println("Secuencia juego: amarillo azul rojo");
        dormir(200);
        printLetraXLetra("amarillo",200);
        printLetraXLetra("azul",200);
        printLetraXLetra("rojo",200);
    }
    public static void printLetraXLetra(String palabra, int milis){
        for(char letra:palabra.toCharArray()){
            System.out.print(letra);
            dormir(milis);
        }
        System.out.println(" ");
    }
    public static void printPalabraXPalabra(String cadena, int milis, int cantidadPalabras){
        String[] cadena_ =  cadena.split(" ",cantidadPalabras);
        for(String palabra: cadena_){
            System.out.print(palabra+" ");
            dormir(milis);
        }
    }
    public static void dormir(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
