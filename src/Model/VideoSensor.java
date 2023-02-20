/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author BUE
 */
public class VideoSensor extends Thread {
    
    protected int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
        
    private TrafficLight TL;
    int Cars;

    VideoSensor(TrafficLight trafficLight) {
        this.TL = trafficLight;
    }

    public int getCars() {
        return Cars;
    }
    
    public void IncresaeCars() {
        Cars += random(0, 3);
    }
    
    public void DecreaseCars() {
       
        Cars -= random(1, 3);
        
    }
}