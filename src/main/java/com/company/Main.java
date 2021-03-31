package com.company;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        
        if(args!=null && args.length>0){
            for(String argumentos: args){
                if(argumentos.equals("no-gui")){
                    
                    game.consoleMode();
                }else{
                    System.out.println("Argumento no reconocido, se ejecutara modo consola por defecto");
                    System.out.println("Para ejecutar el modo consola, usar no-gui");
                    
                    game.consoleMode();
                }
            }
        }else{
            modoNormal(game);
        }
    }
    public static void modoNormal(Game g){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException|InstantiationException|UnsupportedLookAndFeelException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        GameWindow window = new GameWindow(g);
        window.startGame();
    }
}
