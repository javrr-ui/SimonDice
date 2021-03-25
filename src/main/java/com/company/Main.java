package com.company;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        if(args!=null && args.length>0){
            for(String argumentos: args){
                if(argumentos.equals("no-gui")){
                    Game game = new Game();
                    game.consoleMode();
                }else{
                    System.out.println("Argumento no reconocido, se ejecutara modo consola por defecto");
                    Game game = new Game();
                    game.consoleMode();
                }
            }
        }else{
            modoNormal();
        }
    }
    public static void modoNormal(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException|InstantiationException|UnsupportedLookAndFeelException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        GameWindowOld window = new GameWindowOld();
        window.startGame();
    }
}
