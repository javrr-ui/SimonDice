package com.company;

import com.company.ui.GameWindow;
import com.company.constants.Arguments;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("");
        if (args != null && args.length > 0) {
            for (String argumento : args) {
                if (Arguments.NO_GUI.equals(argumento)) {

                    game.consoleMode();
                } else {
                    System.out.println(Arguments.MSG_ARG_NO_RECONOCIDO);
                    System.out.println(Arguments.MSG_USO_CONSOLA);
                    game.consoleMode();
                }
            }
        } else {
            modoNormal(game);
        }
    }

    public static void modoNormal(Game g) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
        new GameWindow(g);

    }
}
