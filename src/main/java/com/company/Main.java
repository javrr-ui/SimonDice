package com.company;

import com.company.ui.GameWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("");
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
        new GameWindow(g);
        
    }
}
