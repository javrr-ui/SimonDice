package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException|InstantiationException|UnsupportedLookAndFeelException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        GameWindow window = new GameWindow();
    }
}
