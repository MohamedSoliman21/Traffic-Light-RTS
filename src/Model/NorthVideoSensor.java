/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Esper.Config;
import Events.NorthVideoReading;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BUE
 */
public class NorthVideoSensor extends VideoSensor {
    
    public NorthVideoSensor(TrafficLight trafficLight) {
        super(trafficLight);
        this.Cars = random(5,25);
    }

    @Override
    public void run() {
        while (true) { 
            try {
                NorthVideoSensor.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NorthVideoSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            Config.sendEvent(new NorthVideoReading(Cars));
        }
    }
}