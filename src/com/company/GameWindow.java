package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindow extends JFrame implements MouseListener{
    private JButton comenzarJuegoButton;
    private JPanel mainPanel;
    private JLabel green;
    private JLabel red;
    private JLabel yellow;
    private JLabel blue;
    private JLabel nextColor;
    private Game game;

    public GameWindow() {
        game = new Game();
        inicializarComponentes();
        this.add(mainPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,480);
        this.setVisible(true);

        green.addMouseListener(this);
        red.addMouseListener(this);
        yellow.addMouseListener(this);
        blue.addMouseListener(this);
        comenzarJuegoButton.addActionListener(e -> {
            if(game.isJuegoEnCurso()==true){
                JOptionPane.showMessageDialog(null,"Juego en curso!");
            }else{
                game.start();
            }

        });


    }
    public void mouseClicked(MouseEvent e){
        JLabel label = (JLabel) e.getSource();
        ImageIcon ic = (ImageIcon) label.getIcon();


        if(green.getIcon().hashCode()==ic.hashCode()){
            game.botonVerdePresionado();
            nextColor.setBackground(new Color(0,192,0));
            nextColor.setOpaque(true);
        }
        if(red.getIcon().hashCode()==ic.hashCode()){
            System.out.print("red");
            nextColor.setBackground(new Color(255,0,0));
            nextColor.setOpaque(true);
        }
        if(yellow.getIcon().hashCode()==ic.hashCode()){
            System.out.print("yellow");
            nextColor.setBackground(new Color(253,231,47));
            nextColor.setOpaque(true);
        }
        if(blue.getIcon().hashCode()==ic.hashCode()){
            System.out.print("blue");
            nextColor.setBackground(new Color(0,0,203));
            nextColor.setOpaque(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void inicializarComponentes(){
        mainPanel = new JPanel();
        green = new JLabel();
        red = new JLabel();
        yellow = new JLabel();
        blue = new JLabel();
        comenzarJuegoButton = new JButton("Comenzar juego");
        nextColor = new JLabel();
        nextColor.setPreferredSize(new Dimension(120,120));
        nextColor.setOpaque(false);



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
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(nextColor,gbc);
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

    public  void dormir(int seg){
        try {
            Thread.sleep(seg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
