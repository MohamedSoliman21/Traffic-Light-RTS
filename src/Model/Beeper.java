/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author BUE
 */
public class Beeper {
       
        public void beep() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audio/Beep.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch(IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
                        System.out.println("Error with playing sound.");
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Beeper.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }).start();
    }
}