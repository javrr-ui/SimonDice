/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
  
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
    
    
    private Clip clip;
    
    private AudioInputStream audioInputStream;
    private String filePath;
    private URL file = ClassLoader.getSystemResource("soundEffects/click.wav");
    private URI uri;
    public Sound() throws UnsupportedAudioFileException,IOException, LineUnavailableException{
        
        try{
            uri = file.toURI();
        }catch(URISyntaxException e){
            System.out.println("URI Syntax Error: " + e.getMessage());
        }
        
        //create audioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(uri).getAbsoluteFile());
        
        //create clip reference
        clip = AudioSystem.getClip();
        
        //open audioInputStream to the clip
        clip.open(audioInputStream);
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        clip.open(audioInputStream);
        clip.start();
        resetAudioStream();
        clip.close();
    }
    
    public void resetAudioStream()throws UnsupportedAudioFileException,IOException, LineUnavailableException{
       
        audioInputStream = AudioSystem.getAudioInputStream(new File(uri).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
       // clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
}
