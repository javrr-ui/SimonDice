package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Dimension;
import java.net.URI;

public class GameWindow extends JFrame implements MouseListener{
    private JMenuBar menuBar;
    private JMenuItem aboutMenuItem;
    private JMenuItem consoleModeMenuItem;
    private JButton comenzarJuegoButton;
    private JPanel mainPanel;
    private JLabel greenLbl;
    private JLabel redLbl;
    private JLabel yellowLbl;
    private JLabel blueLbl;
    private JLabel nextColor;
    private JLabel javierGithub;
    private JLabel ruslanGithub;
    private Game game;

    public GameWindow() {

        inicializarComponentes();
        setJMenuBar(menuBar);
        this.add(mainPanel); //se agrega panel al frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        escuchadores();
    }
     public void startGame(){
        game = new Game();
    }

    private void escuchadores() {
        greenLbl.addMouseListener(this);
        redLbl.addMouseListener(this);
        yellowLbl.addMouseListener(this);
        blueLbl.addMouseListener(this);
        comenzarJuegoButton.addActionListener(e -> {
            if(game.isJuegoEnCurso()){
                int opc = JOptionPane.showConfirmDialog(null,"El juego está en curso, quieres comenzar de nuevo?","Warning",JOptionPane.YES_NO_OPTION);
                if(opc==JOptionPane.YES_OPTION){
                    game.restart();
                    secuenciaColores();
                }
            }else{
                game.start();
                secuenciaColores();
            }
        });

        aboutMenuItem.addActionListener(e -> {
            JPanel jp = new JPanel();
            jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));

            jp.add(new JLabel("Juego desarrollado por javrr-ui, con ayuda de javatlacati."));
            jp.add(javierGithub);
            jp.add(ruslanGithub);
            JOptionPane.showMessageDialog(null,jp,"About",JOptionPane.PLAIN_MESSAGE);

        });

        consoleModeMenuItem.addActionListener(e -> {
            dispose();
            game.consoleMode();
        });

        javierGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    Desktop.getDesktop().browse(new URI("https://github.com/javrr-ui"));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JLabel lbl = (JLabel) e.getSource();
                lbl.setForeground(Color.BLUE);
                lbl.paintImmediately(lbl.getVisibleRect());
                lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                super.mouseExited(e);
                JLabel lbl = (JLabel) e.getSource();
                lbl.setForeground(Color.black);
                lbl.paintImmediately(lbl.getVisibleRect());
                lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        ruslanGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    Desktop.getDesktop().browse(new URI("https://github.com/javatlacati"));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JLabel lbl = (JLabel) e.getSource();
                lbl.setForeground(Color.BLUE);
                lbl.paintImmediately(lbl.getVisibleRect());
                lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                super.mouseExited(e);
                JLabel lbl = (JLabel) e.getSource();
                lbl.setForeground(Color.black);
                lbl.paintImmediately(lbl.getVisibleRect());
                lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public void perdiste(){
        int opc = JOptionPane.showConfirmDialog(null,"Perdiste, quieres comenzar de nuevo?","Perdiste!",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            game.restart();
            secuenciaColores();
        }else{
            System.exit(0);
        }
    }

    public void secuenciaColores(){

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

        if( ((JLabel) e.getSource()).getName().equals("green")){
            if(game.colorPresionado("verde")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(label.getName().equals("red")){
            if(game.colorPresionado("rojo")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(label.getName().equals("yellow")){
            if(game.colorPresionado("amarillo")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(label.getName().equals("blue")){
            if(game.colorPresionado("azul")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //do something when mouse pressed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //do something when mouse released
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //do something when mouse entered
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //do something when mouse exited
    }

    public void inicializarComponentes(){
        JMenu helpMenu = new JMenu("Help");
        JMenu optionsMenu = new JMenu("Options");

        menuBar = new JMenuBar();
        aboutMenuItem = new JMenuItem("About");
        consoleModeMenuItem = new JMenuItem("Activar Modo Consola");

        comenzarJuegoButton = new JButton("Comenzar juego");
        mainPanel = new JPanel();
        greenLbl = new JLabel();
        redLbl = new JLabel();
        yellowLbl = new JLabel();
        blueLbl = new JLabel();
        //setName para labels
        greenLbl.setName("green");
        redLbl.setName("red");
        yellowLbl.setName("yellow");
        blueLbl.setName("blue");

        //labels de about message dialog
        ImageIcon gitIcon = new ImageIcon(new ImageIcon("src/main/resources/img/github.png").getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
        javierGithub = new JLabel("javrr-ui",gitIcon,JLabel.LEFT);
        ruslanGithub = new JLabel("javatlacati",gitIcon,JLabel.LEFT);

        //Label donde se muestra la secuencia de colores
        nextColor = new JLabel();
        nextColor.setPreferredSize(new Dimension(120,120));
        nextColor.setOpaque(true);

        //menuBar Setup
        helpMenu.add(aboutMenuItem);
        helpMenu.setMnemonic(KeyEvent.VK_A);
        optionsMenu.add(consoleModeMenuItem);
        menuBar.add(helpMenu);
        menuBar.add(optionsMenu);
        
        //crea imageIcon a partir de una imagen y la reescala XD
        ImageIcon blueIcon = new ImageIcon(new ImageIcon("src/main/resources/img/blue.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon redIcon = new ImageIcon(new ImageIcon("src/main/resources/img/red.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon yellowIcon = new ImageIcon(new ImageIcon("src/main/resources/img/yellow.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon greenIcon = new ImageIcon(new ImageIcon("src/main/resources/img/green.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));

        greenLbl.setIcon(greenIcon);
        redLbl.setIcon(redIcon);
        yellowLbl.setIcon(yellowIcon);
        blueLbl.setIcon(blueIcon);


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
        mainPanel.add(greenLbl,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(redLbl,gbc);
        gbc.gridx =1;
        gbc.gridy =1;
        mainPanel.add(yellowLbl,gbc);
        gbc.gridx =2;
        gbc.gridy =1;
        mainPanel.add(blueLbl,gbc);
    }

    public  void dormir(int seg){
        try {
            Thread.sleep(seg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}