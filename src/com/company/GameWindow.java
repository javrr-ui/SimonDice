package com.company;

import javax.swing.*;
import java.awt.*;
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

        this.add(mainPanel); //se agrega panel al frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,480);
        this.setResizable(false);
        this.setVisible(true);

        green.addMouseListener(this);
        red.addMouseListener(this);
        yellow.addMouseListener(this);
        blue.addMouseListener(this);
        comenzarJuegoButton.addActionListener(e -> {
            if(game.isJuegoEnCurso()){
                int opc = JOptionPane.showConfirmDialog(null,"El juego está en curso, quieres comenzar de nuevo?","Warning",JOptionPane.YES_NO_OPTION);
                if(opc==JOptionPane.YES_OPTION){
                    game.restart();
                    juegoXd();
                }
            }else{
                game.start();
                juegoXd();
            }
        });
    }
    public void perdiste(){
        int opc = JOptionPane.showConfirmDialog(null,"Perdiste, quieres comenzar de nuevo?","Perdiste .|.",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            game.restart();
            juegoXd();
        }else{
            System.exit(0);
        }
    }

    public void juegoXd(){

        try{
            game.getColoresJuego().forEach((n) -> {
                        switch (n){
                            case "rojo":
                                nextColor.setBackground(new Color(255,0,0));
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                nextColor.setBackground(this.getBackground());
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                System.out.print(n+" ");
                                break;
                            case "azul":
                                nextColor.setBackground(new Color(0,0,203));
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                nextColor.setBackground(this.getBackground());
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                System.out.print(n+" ");
                                break;
                            case "verde":
                                nextColor.setBackground(new Color(0,192,0));
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                nextColor.setBackground(this.getBackground());
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                System.out.print(n+" ");
                                break;
                            case "amarillo":
                                nextColor.setBackground(new Color(253,231,47));
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                nextColor.setBackground(this.getBackground());
                                nextColor.paintImmediately(nextColor.getVisibleRect());
                                dormir(500);
                                System.out.print(n+" ");
                                break;
                            default:
                                break;
                        }
                    }
            );
        }catch(Exception e){
            System.out.print("Error "+e);
        }
    }

    public void mouseClicked(MouseEvent e){
        JLabel label = (JLabel) e.getSource();
        ImageIcon ic = (ImageIcon) label.getIcon();


        if(green.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("verde")){
                juegoXd();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(red.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("rojo")){
                juegoXd();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(yellow.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("amarillo")){
                juegoXd();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(blue.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("azul")){
                juegoXd();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
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
        nextColor.setOpaque(true);



        //crea imageIcon a partir de una imagen y la reescala XD
        ImageIcon blueIcon = new ImageIcon(new ImageIcon("./img/blue.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon redIcon = new ImageIcon(new ImageIcon("./img/red.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon yellowIcon = new ImageIcon(new ImageIcon("./img/yellow.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon greenIcon = new ImageIcon(new ImageIcon("./img/green.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));

        green.setIcon(greenIcon);
        red.setIcon(redIcon);
        yellow.setIcon(yellowIcon);
        blue.setIcon(blueIcon);


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