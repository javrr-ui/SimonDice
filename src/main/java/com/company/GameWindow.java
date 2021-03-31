/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author RuslanLopez
 */
public class GameWindow extends JFrame {

    public static final int IMGSCALEDWIDTH = 180;
    public static final int IMGSCALEDHEIGHT = 180;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 500;
    public static final int MILISEGUNDOS = 1000;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuItem aboutMenuItem;
    private JLabel blueLbl;
    private JButton comenzarJuegoButton;
    private JMenuItem consoleModeMenuItem;
    private JLabel greenLbl;
    private JMenu helpMenu;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JLabel nextColor;
    private JMenu optionsMenu;
    private JPanel panelInicio;
    private JPanel panelJuego;
    private JLabel redLbl;
    private JLabel yellowLbl;
    // End of variables declaration//GEN-END:variables

    private Game game;
    private JLabel javierGithub;
    private JLabel ruslanGithub;

    /**
     * Creates new form GameWindow
     */
    public GameWindow(Game g) {
        this.game = g;
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
        game.startWindowMode();
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
        panelInicio = new JPanel();
        jLabel1 = new JLabel();
        comenzarJuegoButton = new JButton();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        panelJuego = new JPanel();
        yellowLbl = new JLabel();
        blueLbl = new JLabel();
        nextColor = new JLabel();
        greenLbl = new JLabel();
        redLbl = new JLabel();
        menuBar = new JMenuBar();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();
        optionsMenu = new JMenu();
        consoleModeMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);

        mainPanel.setPreferredSize(new Dimension(900, 500));
        mainPanel.setLayout(new CardLayout());

        jLabel1.setFont(new Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Simon dice");

        comenzarJuegoButton.setText("Comenzar juego");
        comenzarJuegoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comenzarJuegoButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Instrucciones");

        jButton2.setText("Configuracion");

        jButton3.setText("Ayuda");

        GroupLayout panelInicioLayout = new GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(comenzarJuegoButton)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1)))
                .addGap(346, 346, 346))
        );

        panelInicioLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {comenzarJuegoButton, jButton1, jButton2, jButton3});

        panelInicioLayout.setVerticalGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(comenzarJuegoButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );

        mainPanel.add(panelInicio, "panelInicio");

        yellowLbl.setBackground(new Color(253, 231, 47));
        yellowLbl.setName("amarillo"); // NOI18N
        yellowLbl.setOpaque(true);
        yellowLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                yellowLblMouseClicked(evt);
            }
        });

        blueLbl.setBackground(new Color(0, 0, 203));
        blueLbl.setName("azul"); // NOI18N
        blueLbl.setOpaque(true);
        blueLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                blueLblMouseClicked(evt);
            }
        });

        nextColor.setOpaque(true);
        nextColor.setPreferredSize(new Dimension(120, 120));

        greenLbl.setBackground(new Color(0, 192, 0));
        greenLbl.setName("verde");
        greenLbl.setOpaque(true);
        greenLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                greenLblMouseClicked(evt);
            }
        });

        redLbl.setBackground(new Color(255, 0, 0));
        redLbl.setName("rojo"); // NOI18N
        redLbl.setOpaque(true);
        redLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                redLblMouseClicked(evt);
            }
        });

        GroupLayout panelJuegoLayout = new GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(blueLbl, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(nextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(greenLbl, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(yellowLbl, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                    .addComponent(redLbl, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(468, Short.MAX_VALUE))
        );

        panelJuegoLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {blueLbl, greenLbl, redLbl, yellowLbl});

        panelJuegoLayout.setVerticalGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(greenLbl, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                    .addComponent(redLbl, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJuegoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(blueLbl, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                    .addComponent(yellowLbl, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        mainPanel.add(panelJuego, "panelJuego");

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
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "panelJuego");
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

    private void redLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_redLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_redLblMouseClicked
    private void greenLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_greenLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_greenLblMouseClicked

    private void blueLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_blueLblMouseClicked
    private void lblClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();

        if (label != null && label.getName().matches("verde|rojo|amarillo|azul") && (game.isGameStarted())) {
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
        

        SwingUtilities.invokeLater(() -> {
//            System.out.println(color + " "+c);
//            nextColor.setBackground(c);
//            panelJuego.revalidate();
//            dormir(1000);
//            
//            nextColor.setBackground(panelJuego.getBackground());
//            
            
             nextColor.setBackground(c);
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        nextColor.setBackground(getBackground());
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        System.out.print(color + " ");
            

        });
        
       

////        Runnable r2 = () -> {
////            nextColor.setBackground(panelJuego.getBackground());
////            nextColor.repaint();
////        };
////        SwingUtilities.invokeLater(r);
//        int num = game.getSecuencia().size() * 2;
//        for (int i = 0; i < num; i++) {
//            if (i % 2 == 0) {
//                Runnable r2 = () -> {
//                    nextColor.setBackground(panelJuego.getBackground());
//                    nextColor.repaint();
//                    System.out.println("pinta color panel");
//                };
//                SwingUtilities.invokeLater(r2);
//            } else {
//                Runnable r2 = () -> {
//                    nextColor.setBackground(c);
//                    nextColor.repaint();
//                    System.out.println("pinta color ");
//                    
//                };
//                SwingUtilities.invokeLater(r2);
//            }
//
//        }
    }
    

    public void dormir(int seg) {
        try {
            Thread.sleep(seg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
