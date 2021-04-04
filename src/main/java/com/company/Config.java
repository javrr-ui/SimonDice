/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi
 */
public class Config {

    private Properties defaultProperties;
    private Properties userProperties;
    private InputStream defaultFile;
    private InputStream userFile;
    private String jarPath;
    private String decodedPath;
    private File configFolder;
    private String actualPath;
    private File dir;
    private FileWriter configFile;
    private String configFilePath;

    Config() {
        defaultProperties = new Properties();
        userProperties = new Properties(defaultProperties);
        //obtiene el directorio donde se ejecuta el programa
        jarPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //decode al path
        try {
            decodedPath = URLDecoder.decode(jarPath, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        //crea objeto file con el path
        configFolder = new File(decodedPath);
        //se guarda el path del jar sin el nombre del jar
        actualPath = configFolder.getParent();
        //cambia los \ por diagonal doble para que sea un path valido en java
        actualPath = actualPath.replace("\"", "\\");
        //crea un objeto file con el path
        dir = new File(actualPath + "\\config");
        //verifica si existe el directorio, si no existe, lo crea
        if (!dir.exists()) {
            dir.mkdir();
        }
        //guarda el directorio completo del archivo config.properties
        configFilePath = dir.getPath() + "\\config.properties";

    }

    public boolean loadDefaultSettings() {
        //obtiene el archivo default.properties
        defaultFile = Main.class.getClassLoader().getResourceAsStream("default.properties");
        //carga el archivo default.properties
        try {
            defaultProperties.load(defaultFile);
        } catch (IOException e) {
            System.out.println("Couln't load default.properties " + e);
            return false;
        }

        //si el archivo config no existe, crea uno y guarda los datos por defecto
        if (!configFileExists()) {
            //carga la configuracion default al archivo config.properties
            try {

                defaultProperties.forEach((key, value) -> {
                    userProperties.setProperty((String) key, (String) value);
                    //System.out.println(key + "=" + value);
                });
                userProperties.store(new FileWriter(configFilePath), null);
            } catch (IOException e) {
                System.out.println("Couln't make file" + e);
            }
        }
        return true;
    }

    public boolean loadUserSettings() {
        try {
            //cambiar a \\
            configFilePath = configFilePath.replace("\"", "\\");
            //carga el archivo
            userProperties.load(new FileInputStream(new File(configFilePath)));

        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
    
    public boolean saveUserSettings(){
        try{
           userProperties.store(new FileWriter(configFilePath), null); 
        }catch(IOException e){
            System.out.println("Couln't save settins: "+e);
            return false;
        }
        return true;
    }

    public boolean configFolderExists() {

        return dir.exists();
    }

    public void createConfigFile() {

        try {
            configFile = new FileWriter(configFilePath);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean configFileExists() {

        //obtiene el archivo config.properties si es que existe
        File config = new File(configFilePath);

        //revisa si existe y retorna el resultado
        return config.exists();

    }

    public Properties getUserProperties() {
        return userProperties;
    }

    public Properties getDefaultProperties() {
        return defaultProperties;
    }

}
