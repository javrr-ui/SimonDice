/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Javi
 */
public class Sound {

    private final Clip clip;

    private final AudioInputStream audioInputStream;
    private final InputStream inputStream;

    public Sound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        //codigo de prueba para comprobar que si encuentra los archivos en el jar
//        URL url = Main.class.getClassLoader().getResource("soundEffects/click.au");
//        URL url2 = Main.class.getClassLoader().getResource("default.properties");
//        System.out.println("url: "+url);
//        System.out.println("url2: "+url2);
        inputStream = Config.class.getClassLoader().getResourceAsStream("soundEffects/click.au");

        //se tiene que usar un BufferedInputStream, o el programa se apendeja y no reproduce el audio
        InputStream bufferedIn = new BufferedInputStream(inputStream);
        audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);

        // Fuente: https://www.iteramos.com/pregunta/44907/javaioioexception-marcareset-no-se-admite
        
        
         //create clip reference
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {

        clip.setMicrosecondPosition(0);
        clip.start();

    }

}
