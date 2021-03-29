/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 *
 * @author RuslanLopez
 */
public class GameWindow extends JFrame {

    public static final int IMGSCALEDWIDTH = 180;
    public static final int IMGSCALEDHEIGHT = 180;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 480;
    public static final int MILISEGUNDOS = 500;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuItem aboutMenuItem;
    private JLabel blueLbl;
    private JButton comenzarJuegoButton;
    private JMenuItem consoleModeMenuItem;
    private JLabel greenLbl;
    private JMenu helpMenu;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JLabel nextColor;
    private JMenu optionsMenu;
    private JLabel redLbl;
    private JLabel yellowLbl;
    // End of variables declaration//GEN-END:variables

    private Game game;
    private JLabel javierGithub;
    private JLabel ruslanGithub;

    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
        escuchadores();
        setVisible(true);
    }
    
    private void escuchadores() {
        javierGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/javrr-ui"));
                } catch (Exception ex) {
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
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/javatlacati"));
                } catch (Exception ex) {
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

    public void startGame() {
        game = new Game();


        });

        consoleModeMenuItem.addActionListener(e -> {
            dispose();
            //game.comenzarDeNuevo();
            game.consoleMode();
        });

        comenzarJuegoButton.addActionListener(e -> {
            if(game.haEmpezadoJuego()){
                juegoEnCurso();
            }else{
                game.startWindowMode();
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
            //game.comenzarDeNuevo();
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
                //game.comenzarDeNuevo();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        URL githubImgUrl = ClassLoader.getSystemResource("img/github.png");
        ImageIcon gitIcon = new ImageIcon(new ImageIcon(githubImgUrl).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
        javierGithub = new JLabel("javrr-ui",gitIcon,JLabel.LEFT);
        ruslanGithub = new JLabel("javatlacati",gitIcon,JLabel.LEFT);
        mainPanel = new JPanel();
        comenzarJuegoButton = new JButton();
        nextColor = new JLabel();
        URL greenUrl = ClassLoader.getSystemResource("img/green.png");
        ImageIcon greenIcon = new ImageIcon(new ImageIcon(greenUrl).getImage().getScaledInstance(IMGSCALEDWIDTH,IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));
        greenLbl = new JLabel();
        URL redUrl = ClassLoader.getSystemResource("img/red.png");
        ImageIcon redIcon = new ImageIcon(new ImageIcon(redUrl).getImage().getScaledInstance(IMGSCALEDWIDTH, IMGSCALEDHEIGHT, Image.SCALE_SMOOTH));
        redLbl = new JLabel();
        URL yellowUrl = ClassLoader.getSystemResource("img/yellow.png"); ImageIcon yellowIcon = new ImageIcon(new ImageIcon(yellowUrl).getImage().getScaledInstance(IMGSCALEDWIDTH, IMGSCALEDHEIGHT, Image.SCALE_SMOOTH));
        yellowLbl = new JLabel();
        URL blueUrl = ClassLoader.getSystemResource("img/blue.png"); ImageIcon blueIcon = new ImageIcon(new ImageIcon(blueUrl).getImage().getScaledInstance(IMGSCALEDWIDTH, IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));
        blueLbl = new JLabel();
        menuBar = new JMenuBar();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();
        optionsMenu = new JMenu();
        consoleModeMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);

        mainPanel.setLayout(new GridBagLayout());

        comenzarJuegoButton.setText("Comenzar juego");
        comenzarJuegoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comenzarJuegoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        mainPanel.add(comenzarJuegoButton, gridBagConstraints);

        nextColor.setOpaque(true);
        nextColor.setPreferredSize(new Dimension(120, 120));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        mainPanel.add(nextColor, gridBagConstraints);

        greenLbl.setIcon(greenIcon);
        greenLbl.setName("verde"); // NOI18N
        greenLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                greenLblMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        mainPanel.add(greenLbl, gridBagConstraints);

        redLbl.setIcon(redIcon);
        redLbl.setName("rojo"); // NOI18N
        redLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                redLblMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        mainPanel.add(redLbl, gridBagConstraints);

        yellowLbl.setIcon(yellowIcon);
        yellowLbl.setName("amarillo"); // NOI18N
        yellowLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                yellowLblMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        mainPanel.add(yellowLbl, gridBagConstraints);

        blueLbl.setIcon(blueIcon
        );
        blueLbl.setName("azul"); // NOI18N
        blueLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                blueLblMouseClicked(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        mainPanel.add(blueLbl, gridBagConstraints);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        helpMenu.setText("Help");

        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        optionsMenu.setText("Options");

        consoleModeMenuItem.setText("Activar Modo Consola");
        consoleModeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                consoleModeMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(consoleModeMenuItem);

        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comenzarJuegoButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_comenzarJuegoButtonActionPerformed
        if (game.haEmpezadoJuego()) {
            juegoEnCurso();
        } else {
            game.startWindowMode();
            secuenciaColores();
        }
    }//GEN-LAST:event_comenzarJuegoButtonActionPerformed

    private void aboutMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        jp.add(new JLabel("Juego desarrollado por javrr-ui, con ayuda de javatlacati."));
        jp.add(javierGithub);
        jp.add(ruslanGithub);
        JOptionPane.showMessageDialog(null, jp, "About", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void consoleModeMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_consoleModeMenuItemActionPerformed
        dispose();
        //game.comenzarDeNuevo();
        game.consoleMode();
    }//GEN-LAST:event_consoleModeMenuItemActionPerformed

    private void greenLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_greenLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_greenLblMouseClicked

    private void yellowLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_yellowLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_yellowLblMouseClicked

    private void redLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_redLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_redLblMouseClicked

    private void blueLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_blueLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_blueLblMouseClicked

    private void lblClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();

        if (label!= null && label.getName().matches("verde|rojo|amarillo|azul") && (game.isGameStarted())) {
            game.leerColor(label.getName());
            if (game.compararStacks()) {
                if (game.tamanoStackIguales()) {
                    System.out.println("Stacks iguales");
                    //puntuacion XD
                    game.setPuntaje(game.getPuntaje() + 1);
                    game.clearStackJugador();
                    game.agregarColor();
                    secuenciaColores();
                }
            } else {
                System.out.println("Te equivocaste!");
                System.out.println("Tu puntuacion es: " + game.getPuntaje());
                perdiste();
            }
        }
    }

    public void perdiste() {
        int opc = JOptionPane.showConfirmDialog(null, "Tu puntuación fue: " + game.getPuntaje() + ", quieres comenzar de nuevo?", "Perdiste!", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            game.restart();
            secuenciaColores();
        } else {
            System.exit(0);
        }
    }

    public void juegoEnCurso() {
        int opc = JOptionPane.showConfirmDialog(null, "Juego en curso, quieres comenzar de nuevo?", "Cuidado!", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            game.restart();
            secuenciaColores();
        }
    }

    public void secuenciaColores() {
        try {
            game.getSecuencia().forEach((color) -> {
                switch (color) {
                    case "rojo":
                        pintarColorSecuencia(color, Colors.ROJO);
                        break;
                    case "azul":
                        pintarColorSecuencia(color, Colors.AZUL);
                        break;
                    case "verde":
                        pintarColorSecuencia(color, Colors.VERDE);
                        break;
                    case "amarillo":
                        pintarColorSecuencia(color, Colors.AMARILLO);
                        break;
                    default:
                        break;
                }
            }
            );
        } catch (Exception e) {
            System.out.print("Error: " + e);
        }
    }

    private void pintarColorSecuencia(String color, Color c) {
        nextColor.setBackground(c);
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        nextColor.setBackground(getBackground());
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        System.out.print(color + " ");
    }

    public void dormir(int seg) {
        try {
            Thread.sleep(seg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }

}
