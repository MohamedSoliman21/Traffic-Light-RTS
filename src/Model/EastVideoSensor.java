/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Esper.Config;
import Events.EastVideoReading;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BUE
 */
public class EastVideoSensor extends VideoSensor {
            
    public EastVideoSensor(TrafficLight trafficLight) {
        super(trafficLight);
        this.Cars = random(5,25);
    }

    @Override
    public void run() {
        while (true) { 
            try {
                EastVideoSensor.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EastVideoSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            Config.sendEvent(new EastVideoReading(Cars));
        }
    }


}
