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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

       // escuchadores();
    }

    public void startGame(){
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuItemModoConsola = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));

        jMenuOpciones.setText("Opciones");

        jMenuItemModoConsola.setText("Activar Modo Consola");
        jMenuItemModoConsola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModoConsolaActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemModoConsola);

        jMenuBar1.add(jMenuOpciones);

        jMenuAyuda.setText("Ayuda");

        jMenuItemAcercaDe.setText("Acerca de");
        jMenuAyuda.add(jMenuItemAcercaDe);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemModoConsolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModoConsolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemModoConsolaActionPerformed


    public void perdiste(){
        int opc = JOptionPane.showConfirmDialog(null,"Tu puntuación fue: "+game.getPuntaje()+", quieres comenzar de nuevo?","Perdiste!",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            game.restart();
            secuenciaColores();
        }else{
            System.exit(0);
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

    public void juegoEnCurso(){
        int opc = JOptionPane.showConfirmDialog(null,"Juego en curso, quieres comenzar de nuevo?","Cuidado!",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            game.restart();
            secuenciaColores();
        }
    }

    public void secuenciaColores(){
        try{
            game.getSecuencia().forEach((color) -> {
                        switch (color){
                            case "rojo":
                                pintarColorSecuencia(color,Colors.ROJO);
                                break;
                            case "azul":
                                pintarColorSecuencia(color,Colors.AZUL);
                                break;
                            case "verde":
                                pintarColorSecuencia(color,Colors.VERDE);
                                break;
                            case "amarillo":
                                pintarColorSecuencia(color,Colors.AMARILLO);
                                break;
                            default:
                                break;
                        }
                    }
            );
        }catch(Exception e){
            System.out.print("Error: "+e);
        }
    }

    private void pintarColorSecuencia(String color,Color c){
        nextColor.setBackground(c);
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        nextColor.setBackground(getBackground());
        nextColor.paintImmediately(nextColor.getVisibleRect());
        dormir(MILISEGUNDOS);
        System.out.print(color + " ");
    }
    
    public void mouseClicked(MouseEvent e){
        JLabel label = (JLabel) e.getSource();

        if(label.getName().matches("verde|rojo|amarillo|azul")&&(game.isGameStarted())){
            game.leerColor(label.getName());
            if(game.compararStacks()){
                if(game.tamanoStackIguales()){
                    System.out.println("Stacks iguales");
                    //puntuacion XD
                    game.setPuntaje(game.getPuntaje()+1);
                    game.clearStackJugador();
                    game.agregarColor();
                    secuenciaColores();
                }
            }else{
                System.out.println("Te equivocaste!");
                System.out.println("Tu puntuacion es: "+game.getPuntaje());
                perdiste();
            }
        }
    }


    public void inicializarComponentes() {
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
        greenLbl.setName("verde");
        redLbl.setName("rojo");
        yellowLbl.setName("amarillo");
        blueLbl.setName("azul");

        //labels de about message dialog
        URL githubImgUrl = ClassLoader.getSystemResource("img/github.png");
        //System.out.print(githubImgUrl);
        ImageIcon gitIcon = new ImageIcon(new ImageIcon(githubImgUrl).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
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

        URL blueUrl = ClassLoader.getSystemResource("img/blue.png");
        URL redUrl = ClassLoader.getSystemResource("img/red.png");
        URL yellowUrl = ClassLoader.getSystemResource("img/yellow.png");
        URL greenUrl = ClassLoader.getSystemResource("img/green.png");
        //crea imageIcon a partir de una imagen y la reescala XD
        ImageIcon blueIcon = new ImageIcon(new ImageIcon(blueUrl).getImage().getScaledInstance(IMGSCALEDWIDTH, IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));
        ImageIcon redIcon = new ImageIcon(new ImageIcon(redUrl).getImage().getScaledInstance(IMGSCALEDWIDTH,IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));
        ImageIcon yellowIcon = new ImageIcon(new ImageIcon(yellowUrl).getImage().getScaledInstance(IMGSCALEDWIDTH,IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));
        ImageIcon greenIcon = new ImageIcon(new ImageIcon(greenUrl).getImage().getScaledInstance(IMGSCALEDWIDTH,IMGSCALEDHEIGHT,Image.SCALE_SMOOTH));

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAcercaDe;
    private javax.swing.JMenuItem jMenuItemModoConsola;
    private javax.swing.JMenu jMenuOpciones;
    // End of variables declaration//GEN-END:variables
}
