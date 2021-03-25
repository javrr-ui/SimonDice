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
import java.net.URL;

public class GameWindow extends JFrame implements MouseListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 480;
    public static final int MILISEGUNDOS = 500;
    public static final int IMGSCALEDWIDTH = 180;
    public static final int IMGSCALEDHEIGHT = 180;
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

    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
        setJMenuBar(menuBar);
        add(mainPanel); //se agrega panel al frame
        setTitle("Simon dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        escuchadores();
    }

        private void escuchadores() {
            greenLbl.addMouseListener(this);
            redLbl.addMouseListener(this);
            yellowLbl.addMouseListener(this);
            blueLbl.addMouseListener(this);


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




        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
