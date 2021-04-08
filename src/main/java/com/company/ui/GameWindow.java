/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ui;

import com.company.ColorConstants;
import com.company.Config;
import com.company.Game;
import com.company.Sound;
import com.company.StringUtils;
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
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
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
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
    
    
    
    
    
    
    
    
    
    private JDialog instructionsDialog;
    
    
    
    
    
    
    
    
    
    
    
    
    
    private JLabel jLabel2;
    
    
    
    
    
    
    
    
    
    
    
    
    
    private JSlider jSlider1;
    
    
    
    private volatile JPanel mainPanel;
    
    private JLabel nextColor;
    private JDialog optionDialog;
    
    
    private JMenu optionsMenu;
    
    private JPanel panelJuego;
    
    // End of variables declaration//GEN-END:variables

    private Game game;
    private Sound sonido;
    private JLabel javierGithub;
    private JLabel ruslanGithub;
    private JLabel reportarError;
    private JLabel creditosSonido;
    private Color backgroundColor;

    //mientras menos sea el valor, es mas dificil
    private int dificultad;
    private int dificultad_aux;
    private Config configuracion;
    private Properties userProperties;
    private Properties defaultProperties;

    /**
     * Creates new form GameWindow
     */
    public GameWindow(Game g) {

        configuracion();

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

        reportarError.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/javrr-ui/SimonDice/issues"));
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

    private void configuracion() {
        configuracion = new Config();
        configuracion.loadDefaultSettings();
        configuracion.loadUserSettings();
        userProperties = configuracion.getUserProperties();
        defaultProperties = configuracion.getDefaultProperties();
        System.out.println("config file " + configuracion.configFileExists());
        System.out.println("==Default properties==");
        defaultProperties.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });

        System.out.println("==User properties==");
        userProperties.forEach((key, value) -> {
            System.out.println(key + "=" + value);
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

        optionDialog = new JDialog();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel16 = new JLabel();
        JComboBox<String> jComboBox3 = new JComboBox<>();
        JLabel jLabel18 = new JLabel();
        JComboBox<String> jComboBox4 = new JComboBox<>();
        JLabel jLabel7 = new JLabel();
        jSlider1 = new JSlider();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel20 = new JLabel();
        jLabel2 = new JLabel();
        JButton jButton8 = new JButton();
        JPanel jPanel3 = new JPanel();
        JLabel jLabel17 = new JLabel();
        JToggleButton jToggleButton2 = new JToggleButton();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel15 = new JLabel();
        JButton optionDialogAceptar = new JButton();
	JButton optionDialogCancelar = new JButton();
        JDialog colorPicker = new JDialog();
        JColorChooser jColorChooser1 = new JColorChooser();
        instructionsDialog = new JDialog();
        JTabbedPane jTabbedPane2 = new JTabbedPane();
        JPanel jPanel4 = new JPanel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JPanel jPanel5 = new JPanel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        URL githubImgUrl = ClassLoader.getSystemResource("img/github.png");
        ImageIcon gitIcon = new ImageIcon(new ImageIcon(githubImgUrl).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH));
        ImageIcon icono = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("img/simonDice.png")).getImage());
        javierGithub = new JLabel("javrr-ui",gitIcon,JLabel.LEFT);
        ruslanGithub = new JLabel("javatlacati",gitIcon,JLabel.LEFT);
        creditosSonido = new JLabel("https://www.zapsplat.com");
        reportarError = new JLabel("https://github.com/javrr-ui/SimonDice/issues");
        try{
            dificultad = Integer.parseInt(userProperties.getProperty("difficulty"));
        }catch(Exception e){
            System.out.println("Error loading custom difficulty");
            dificultad = Integer.parseInt(defaultProperties.getProperty("difficulty"));
        }
        dificultad_aux = jSlider1.getMaximum();
        backgroundColor = StringUtils.getColorXD(userProperties.getProperty("backgroundColor"));
        try{
            sonido = new Sound();
        }catch(Exception e){
            e.printStackTrace();
        }
        mainPanel = new JPanel();
        JPanel panelInicio = new JPanel();
        JLabel jLabel1 = new JLabel();
        JButton comenzarJuegoButton = new JButton();
        JButton instructionsButton = new JButton();
        JButton configButton = new JButton();
        JButton helpButton = new JButton();
        panelJuego = new JPanel();
        JLabel yellowLbl = new JLabel();
        JLabel blueLbl = new JLabel();
        nextColor = new JLabel();
        JLabel greenLbl = new JLabel();
        JLabel redLbl = new JLabel();
        JMenuBar menuBar = new JMenuBar();
        optionsMenu = new JMenu();
        JMenu helpMenu = new JMenu();
        JMenuItem aboutMenuItem = new JMenuItem();

        optionDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        optionDialog.setTitle("Opciones");
        optionDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        optionDialog.setSize(new Dimension(400, 280));
        optionDialog.setLocationRelativeTo(null);

        jLabel16.setText("Interfaz preferida");

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "GUI", "CLI" }));
        jComboBox3.setEnabled(false);

        jLabel18.setText("Idioma");

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Español", "English" }));
        jComboBox4.setEnabled(false);

        jLabel7.setText("Dificultad");

        jSlider1.setMajorTickSpacing(3);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(dificultad/100);
        jSlider1.setInverted(true);
        jSlider1.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        jSlider1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jSlider1MouseClicked(evt);
            }
        });

        jLabel8.setText("Facil");

        jLabel9.setText("Dificil");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, 89, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel9)))
                .addContainerGap(174, Short.MAX_VALUE))
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jLabel20.setText("Color de fondo");

        jLabel2.setBackground(backgroundColor);
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new Dimension(60, 14));

        jButton8.setText("Seleccionar color");
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton8ActionPerformed();
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
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addContainerGap(128, Short.MAX_VALUE))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Accesibilidad", jPanel3);

        optionDialogAceptar.setText("Aceptar");
        optionDialogAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                optionDialogAceptarActionPerformed(evt);
            }
        });

        optionDialogCancelar.setText("Cancelar");
        optionDialogCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                optionDialogCancelarActionPerformed(evt);
            }
        });

        GroupLayout optionDialogLayout = new GroupLayout(optionDialog.getContentPane());
        optionDialog.getContentPane().setLayout(optionDialogLayout);
        optionDialogLayout.setHorizontalGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(optionDialogLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(optionDialogAceptar)
                .addGap(18, 18, 18)
                .addComponent(optionDialogCancelar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionDialogLayout.setVerticalGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(optionDialogLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(optionDialogLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(optionDialogCancelar)
                    .addComponent(optionDialogAceptar))
                .addContainerGap(49, Short.MAX_VALUE))
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

        instructionsDialog.setTitle("Instrucciones");
        instructionsDialog.setModal(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        jLabel3.setText("Presionar el botón \"Comenzar juego\" para iniciar el juego.");

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/img/instructions/ins1.PNG"))); // NOI18N

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("1", jPanel4);

        jLabel5.setText("Esperar a que termine de mostrarse la secuencia de colores, y luego presionar los colores siguiendo la secuencia mostrada");

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/img/instructions/ins2.PNG"))); // NOI18N

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("2", jPanel5);

        GroupLayout instructionsDialogLayout = new GroupLayout(instructionsDialog.getContentPane());
        instructionsDialog.getContentPane().setLayout(instructionsDialogLayout);
        instructionsDialogLayout.setHorizontalGroup(instructionsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        instructionsDialogLayout.setVerticalGroup(instructionsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simon Dice");
        setIconImage(icono.getImage());
        setSize(WIDTH,HEIGHT);

        mainPanel.setPreferredSize(new Dimension(900, 500));
        mainPanel.setLayout(new CardLayout());

        jLabel1.setFont(new Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Simon dice");

        comenzarJuegoButton.setText("Comenzar juego");
        comenzarJuegoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comenzarJuegoButtonActionPerformed();
            }
        });

        instructionsButton.setText("Instrucciones");
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                instructionsButtonActionPerformed(evt);
            }
        });

        configButton.setText("Configuracion");
        configButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                configButtonActionPerformed();
            }
        });

        helpButton.setText("Ayuda");
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed();
            }
        });

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
                .addContainerGap(214, Short.MAX_VALUE))
        );

        mainPanel.add(panelInicio, "panelInicio");

        panelJuego.setBackground(StringUtils.getColorXD(userProperties.getProperty("backgroundColor")));

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
                optionsMenuActionPerformed();
            }
        });
        menuBar.add(optionsMenu);

        helpMenu.setText("Ayuda");

        aboutMenuItem.setText("Acerca de");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutMenuItemActionPerformed();
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comenzarJuegoButtonActionPerformed() {//GEN-FIRST:event_comenzarJuegoButtonActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "panelJuego");
        if (game.haEmpezadoJuego()) {
            juegoEnCurso();
        } else {
            game.setGameStarted(true);
            game.startWindowMode();
            secuenciaColores();
        }
    }//GEN-LAST:event_comenzarJuegoButtonActionPerformed

    private void aboutMenuItemActionPerformed() {//GEN-FIRST:event_aboutMenuItemActionPerformed

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

    private void configButtonActionPerformed() {//GEN-FIRST:event_configButtonActionPerformed
        // TODO add your handling code here:

        optionDialog.setVisible(true);
        optionDialog.pack();


    }//GEN-LAST:event_configButtonActionPerformed

    private void jButton8ActionPerformed() {//GEN-FIRST:event_jButton8ActionPerformed
        backgroundColor = JColorChooser.showDialog(GameWindow.this, "Selecciona color de fondo", backgroundColor);
        jLabel2.setBackground(backgroundColor);

        repaint();
        revalidate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void optionsMenuActionPerformed() {//GEN-FIRST:event_optionsMenuActionPerformed


    }//GEN-LAST:event_optionsMenuActionPerformed

    private void optionsMenuMenuSelected(MenuEvent evt) {//GEN-FIRST:event_optionsMenuMenuSelected

    }//GEN-LAST:event_optionsMenuMenuSelected

    private void optionsMenuMouseClicked(MouseEvent evt) {//GEN-FIRST:event_optionsMenuMouseClicked
        optionDialog.setVisible(true);
        optionDialog.pack();
        optionsMenu.setSelected(false);
    }//GEN-LAST:event_optionsMenuMouseClicked

    private void optionDialogAceptarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_optionDialogAceptarActionPerformed

        //setea el color de fondo
        panelJuego.setBackground(backgroundColor);
        nextColor.setBackground(backgroundColor);

        //pasa un color a un string de la forma "250,250,250"
        String colorsito = StringUtils.colorToStringRGB(backgroundColor);
        //modifica la propiedad
        userProperties.setProperty("backgroundColor", colorsito);
        //guarda la configuracion en el archivo
        configuracion.saveUserSettings();

        //cambia el valor de dificultad
        if (dificultad_aux < jSlider1.getMaximum()) {
            dificultad = dificultad_aux * 100;
        }
        if (dificultad_aux == jSlider1.getMaximum()) {
            dificultad = 1000;
        }

        //System.out.println("dificultad_aux:" + dificultad_aux);
        //System.out.println("dificultad:" + dificultad);
        optionDialog.dispose();
    }//GEN-LAST:event_optionDialogAceptarActionPerformed

    private void optionDialogCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_optionDialogCancelarActionPerformed
        jLabel2.setBackground(panelJuego.getBackground());
        optionDialog.dispose();
    }//GEN-LAST:event_optionDialogCancelarActionPerformed

    private void instructionsButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_instructionsButtonActionPerformed
        instructionsDialog.pack();
        instructionsDialog.setVisible(true);


    }//GEN-LAST:event_instructionsButtonActionPerformed

    private void helpButtonActionPerformed() {//GEN-FIRST:event_helpButtonActionPerformed
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        jp.add(new JLabel("Para reportar un error ingrese al siguiente enlace"));
        jp.add(reportarError);
        jp.add(new JLabel("\n"));
        jp.add(new JLabel("Para resolver una duda comunicarse con: "));
        jp.add(javierGithub);
        JOptionPane.showMessageDialog(null, jp, "Ayuda", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_helpButtonActionPerformed

    private void jSlider1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseClicked
        JSlider js = (JSlider) evt.getSource();
        dificultad_aux = js.getValue();
    }//GEN-LAST:event_jSlider1MouseClicked

    private void jSlider1MouseDragged(MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        JSlider js = (JSlider) evt.getSource();
        dificultad_aux = js.getValue();
    }//GEN-LAST:event_jSlider1MouseDragged

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
                perdiste();
            }
        }
        try {
            sonido.play();
        } catch (Exception ex) {
            System.out.println("Could't play sound: " + ex);
        }

    }

    public void perdiste() {
        int opc = JOptionPane.showConfirmDialog(null, "Tu puntuación fue: " + game.getPuntaje() + ", quieres comenzar de nuevo?", "Perdiste!", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            game.restart();
            game.setGameStarted(true);
            secuenciaColores();
        } else {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "panelInicio");
            game.restart();
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
            game.getSecuencia().forEach(color -> {
                switch (color) {
                    case "rojo":
                        pintarColorSecuencia(color, ColorConstants.ROJO);
                        break;
                    case "azul":
                        pintarColorSecuencia(color, ColorConstants.AZUL);
                        break;
                    case "verde":
                        pintarColorSecuencia(color, ColorConstants.VERDE);
                        break;
                    case "amarillo":
                        pintarColorSecuencia(color, ColorConstants.AMARILLO);
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
            dormir(dificultad);
            nextColor.setBackground(backgroundColor);
            nextColor.paintImmediately(nextColor.getVisibleRect());
            dormir(dificultad);
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
