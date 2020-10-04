package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        if(args[0].equals("no-gui")){
            Game game = new Game();
            game.consoleMode();
        }else{
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (IllegalAccessException|InstantiationException|UnsupportedLookAndFeelException|ClassNotFoundException e) {
                e.printStackTrace();
            }
            GameWindow window = new GameWindow();
            window.startGame();
        }

    }
}
