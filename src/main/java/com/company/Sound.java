/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Javi
 */
public class Sound {

    private Clip clip;

    private AudioInputStream audioInputStream;
    private InputStream inputStream;
    long inicio;

    public Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        //read audio data from whatever source (file/classloader/etc.)
        inputStream = Main.class.getClassLoader().getResourceAsStream("soundEffects\\click.au");

        //audio input stream
        audioInputStream = AudioSystem.getAudioInputStream(inputStream);

        //create clip reference
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {

        
        clip.setMicrosecondPosition(0);
        clip.start();

    }

}
