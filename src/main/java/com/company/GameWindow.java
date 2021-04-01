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
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
    private JDialog colorPicker;
    private JButton comenzarJuegoButton;
    private JButton configButton;
    private JLabel greenLbl;
    private JButton helpButton;
    private JMenu helpMenu;
    private JButton instructionsButton;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton8;
    private JColorChooser jColorChooser1;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JMenuItem jMenuItem1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTabbedPane jTabbedPane1;
    private JToggleButton jToggleButton2;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JLabel nextColor;
    private JDialog optionDialog;
    private JMenu optionsMenu;
    private JPanel panelInicio;
    private JPanel panelJuego;
    private JLabel redLbl;
    private JLabel yellowLbl;
    // End of variables declaration//GEN-END:variables

    private Game game;
    private Sound sonido;
    private JLabel javierGithub;
    private JLabel ruslanGithub;
    private JLabel creditosSonido;
    private Color backgroundColor;

    /**
     * Creates new form GameWindow
     */
    public GameWindow(Game g) {
        this.game = g;
        initComponents();
        
        escuchadores();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void escuchadores() {
        javierGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/javrr-ui"));
                } catch (IOException | URISyntaxException ex) {
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
                } catch (IOException | URISyntaxException ex) {
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

        creditosSonido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("https://www.zapsplat.com/"));
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

        optionDialog = new JDialog();
        jTabbedPane1 = new JTabbedPane();
        jPanel2 = new JPanel();
        jLabel16 = new JLabel();
        jComboBox3 = new JComboBox<>();
        jLabel18 = new JLabel();
        jComboBox4 = new JComboBox<>();
        jPanel1 = new JPanel();
        jLabel20 = new JLabel();
        jLabel2 = new JLabel();
        jButton8 = new JButton();
        jPanel3 = new JPanel();
        jLabel17 = new JLabel();
        jToggleButton2 = new JToggleButton();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        colorPicker = new JDialog();
        jColorChooser1 = new JColorChooser();
        jMenuItem1 = new JMenuItem();
        URL githubImgUrl = ClassLoader.getSystemResource("img/github.png");
        ImageIcon gitIcon = new ImageIcon(new ImageIcon(githubImgUrl).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
        javierGithub = new JLabel("javrr-ui",gitIcon,JLabel.LEFT);
        ruslanGithub = new JLabel("javatlacati",gitIcon,JLabel.LEFT);
        creditosSonido = new JLabel("https://www.zapsplat.com");
        backgroundColor = new Color(240,240,240);
        try{
            sonido = new Sound();
        }catch(Exception e){
            e.printStackTrace();
        }
        mainPanel = new JPanel();
        panelInicio = new JPanel();
        jLabel1 = new JLabel();
        comenzarJuegoButton = new JButton();
        instructionsButton = new JButton();
        configButton = new JButton();
        helpButton = new JButton();
        panelJuego = new JPanel();
        yellowLbl = new JLabel();
        blueLbl = new JLabel();
        nextColor = new JLabel();
        greenLbl = new JLabel();
        redLbl = new JLabel();
        menuBar = new JMenuBar();
        optionsMenu = new JMenu();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();

        optionDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        optionDialog.setTitle("Opciones");
        optionDialog.setMaximumSize(new Dimension(2147483647, 300));
        optionDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        optionDialog.setPreferredSize(new Dimension(400, 280));
        optionDialog.setSize(new Dimension(400, 280));
        optionDialog.setLocationRelativeTo(null);

        jLabel16.setText("Interfaz preferida");

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "GUI", "CLI" }));
        jComboBox3.setEnabled(false);

        jLabel18.setText("Idioma");

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Español", "English" }));
        jComboBox4.setEnabled(false);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, 89, Short.MAX_VALUE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jLabel20.setText("Color de fondo");

        jLabel2.setBackground(backgroundColor);
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new Dimension(60, 14));

        jButton8.setText("Seleccionar color");
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Graficos", jPanel1);

        jLabel17.setText("Modo daltonico");

        jToggleButton2.setText("Desactivado");
        jToggleButton2.setEnabled(false);

        jLabel11.setBackground(new Color(253, 231, 47));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("S");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new Color(0, 0, 203));
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setText("A");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new Color(0, 192, 0));
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setText("Q");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new Color(255, 0, 0));
        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setText("W");
        jLabel14.setOpaque(true);

        jLabel15.setText("Asignacion de teclas");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel15))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jToggleButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Accesibilidad", jPanel3);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout optionDialogLayout = new GroupLayout(optionDialog.getContentPane());
        optionDialog.getContentPane().setLayout(optionDialogLayout);
        optionDialogLayout.setHorizontalGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(optionDialogLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionDialogLayout.setVerticalGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(optionDialogLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        GroupLayout colorPickerLayout = new GroupLayout(colorPicker.getContentPane());
        colorPicker.getContentPane().setLayout(colorPickerLayout);
        colorPickerLayout.setHorizontalGroup(colorPickerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(colorPickerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jColorChooser1, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colorPickerLayout.setVerticalGroup(colorPickerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(colorPickerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jColorChooser1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jMenuItem1.setText("jMenuItem1");

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

        instructionsButton.setText("Instrucciones");

        configButton.setText("Configuracion");
        configButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                configButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Ayuda");

        GroupLayout panelInicioLayout = new GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(comenzarJuegoButton)
                            .addComponent(instructionsButton)
                            .addComponent(configButton)
                            .addComponent(helpButton)))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1)))
                .addGap(346, 346, 346))
        );

        panelInicioLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {comenzarJuegoButton, configButton, helpButton, instructionsButton});

        panelInicioLayout.setVerticalGroup(panelInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(comenzarJuegoButton)
                .addGap(18, 18, 18)
                .addComponent(instructionsButton)
                .addGap(32, 32, 32)
                .addComponent(configButton)
                .addGap(18, 18, 18)
                .addComponent(helpButton)
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
                .addContainerGap(47, Short.MAX_VALUE))
        );

        mainPanel.add(panelJuego, "panelJuego");

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        optionsMenu.setText("Configuracion");
        optionsMenu.setName("optionsMenu"); // NOI18N
        optionsMenu.addMenuListener(new MenuListener() {
            public void menuCanceled(MenuEvent evt) {
            }
            public void menuDeselected(MenuEvent evt) {
            }
            public void menuSelected(MenuEvent evt) {
                optionsMenuMenuSelected(evt);
            }
        });
        optionsMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                optionsMenuMouseClicked(evt);
            }
        });
        optionsMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                optionsMenuActionPerformed(evt);
            }
        });
        menuBar.add(optionsMenu);

        helpMenu.setText("Ayuda");

        aboutMenuItem.setText("Acerca de");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

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
        jp.add(new JLabel("Sound effects obtained from "));
        jp.add(creditosSonido);
        JOptionPane.showMessageDialog(null, jp, "About", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void redLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_redLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_redLblMouseClicked
    private void greenLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_greenLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_greenLblMouseClicked

    private void blueLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_blueLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_blueLblMouseClicked

    private void yellowLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_yellowLblMouseClicked
        lblClicked(evt);
    }//GEN-LAST:event_yellowLblMouseClicked

    private void configButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_configButtonActionPerformed
        // TODO add your handling code here:

        optionDialog.setVisible(true);
        optionDialog.pack();


    }//GEN-LAST:event_configButtonActionPerformed

    private void jButton8ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        backgroundColor = JColorChooser.showDialog(GameWindow.this, "Selecciona color de fondo", backgroundColor);
        jLabel2.setBackground(backgroundColor);
        
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void optionsMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_optionsMenuActionPerformed


    }//GEN-LAST:event_optionsMenuActionPerformed

    private void optionsMenuMenuSelected(MenuEvent evt) {//GEN-FIRST:event_optionsMenuMenuSelected
        
    }//GEN-LAST:event_optionsMenuMenuSelected

    private void optionsMenuMouseClicked(MouseEvent evt) {//GEN-FIRST:event_optionsMenuMouseClicked
        optionDialog.setVisible(true);
            optionDialog.pack();
            optionsMenu.setSelected(false);
    }//GEN-LAST:event_optionsMenuMouseClicked

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        panelJuego.setBackground(backgroundColor);
        nextColor.setBackground(backgroundColor);
        optionDialog.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         jLabel2.setBackground(panelJuego.getBackground());
        optionDialog.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblClicked(MouseEvent e) {
//
//        try {
//            sonido.play();
//        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
//        }

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
            nextColor.setBackground(c);
            nextColor.paintImmediately(nextColor.getVisibleRect());
            dormir(MILISEGUNDOS);
            nextColor.setBackground(backgroundColor);
            nextColor.paintImmediately(nextColor.getVisibleRect());
            dormir(MILISEGUNDOS);
            System.out.print(color + " ");
        });
    }

    public void dormir(int seg) {
        try {
            Thread.sleep(seg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
