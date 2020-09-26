package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameWindow extends JFrame{
    private JButton comenzarJuegoButton;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JLabel green;
    private JLabel red;
    private JLabel yellow;
    private JLabel blue;
   private JLabel nextGreen;
   private JLabel nextRed;
   private JLabel nextYellow;
   private JLabel nextBlue;

    public GameWindow() {

        inicializarComponentes();

        this.add(leftPanel);
        this.add(mainPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,480);
        this.setVisible(true);
    }

    public void inicializarComponentes(){
        mainPanel = new JPanel();
        leftPanel = new JPanel();
        green = new JLabel();
        red = new JLabel();
        yellow = new JLabel();
        blue = new JLabel();
        comenzarJuegoButton = new JButton("Comenzar juego");

        //crea imageIcon a partir de una imagen y la reescala XD
        ImageIcon blueIcon = new ImageIcon(new ImageIcon("./img/blue.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon redIcon = new ImageIcon(new ImageIcon("./img/red.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon yellowIcon = new ImageIcon(new ImageIcon("./img/yellow.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon greenIcon = new ImageIcon(new ImageIcon("./img/green.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));

        green.setIcon(greenIcon);
        red.setIcon(redIcon);
        yellow.setIcon(yellowIcon);
        blue.setIcon(blueIcon);

        //BOTONES




        //main panel settings
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(comenzarJuegoButton,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(green,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(red,gbc);
        gbc.gridx =1;
        gbc.gridy =1;
        mainPanel.add(yellow,gbc);
        gbc.gridx =2;
        gbc.gridy =1;
        mainPanel.add(blue,gbc);
    }
}
