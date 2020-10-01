package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class GameWindow extends JFrame implements MouseListener{
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem aboutMenuItem;
    private JButton comenzarJuegoButton;
    private JPanel mainPanel;
    private JLabel greenLbl;
    private JLabel redLbl;
    private JLabel yellowLbl;
    private JLabel blueLbl;
    private JLabel nextColor;
    private JLabel javierGithub;
    private JLabel ruslanGithub;
    private final Game game;

    public GameWindow() {
        game = new Game();
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
            ImageIcon gitIcon = new ImageIcon(new ImageIcon("./img/github.png").getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
            JPanel jp = new JPanel();
            jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));

            jp.add(new JLabel("Juego desarrollado por javrr-ui, con ayuda de javatlacati."));
            jp.add(javierGithub);
            jp.add(ruslanGithub);
            JOptionPane.showMessageDialog(null,jp,"About",JOptionPane.PLAIN_MESSAGE);

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
        int opc = JOptionPane.showConfirmDialog(null,"Perdiste, quieres comenzar de nuevo?","Perdiste .|.",JOptionPane.YES_NO_OPTION);
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
        ImageIcon ic = (ImageIcon) label.getIcon();


        if(greenLbl.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("verde")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(redLbl.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("rojo")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(yellowLbl.getIcon().hashCode()==ic.hashCode()){
            if(game.colorPresionado("amarillo")){
                secuenciaColores();
            }else{
                if(!game.isJuegoEnCurso()){
                    perdiste();
                }
            }
        }
        if(blueLbl.getIcon().hashCode()==ic.hashCode()){
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
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        comenzarJuegoButton = new JButton("Comenzar juego");
        mainPanel = new JPanel();
        greenLbl = new JLabel();
        redLbl = new JLabel();
        yellowLbl = new JLabel();
        blueLbl = new JLabel();

        //labels de about message dialog
        ImageIcon gitIcon = new ImageIcon(new ImageIcon("./img/github.png").getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
        javierGithub = new JLabel("javrr-ui",gitIcon,JLabel.LEFT);
        ruslanGithub = new JLabel("javatlacati",gitIcon,JLabel.LEFT);

        //Label donde se muestra la secuencia de colores
        nextColor = new JLabel();
        nextColor.setPreferredSize(new Dimension(120,120));
        nextColor.setOpaque(true);

        //menu
        helpMenu.add(aboutMenuItem);
        helpMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(helpMenu);



        //crea imageIcon a partir de una imagen y la reescala XD
        ImageIcon blueIcon = new ImageIcon(new ImageIcon("./img/blue.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon redIcon = new ImageIcon(new ImageIcon("./img/red.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon yellowIcon = new ImageIcon(new ImageIcon("./img/yellow.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));
        ImageIcon greenIcon = new ImageIcon(new ImageIcon("./img/green.png").getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH));

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