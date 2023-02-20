/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Esper.Config;
import Events.NorthButtonReading;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BUE
 */
public class NorthButton extends Button {
    
    public NorthButton(TrafficLight TL) {
        super(TL);
        this.Pressed = false;
    }
    
        @Override
    public void run() {
        while (true) { 
            try {

                NorthButton.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NorthButton.class.getName()).log(Level.SEVERE, null, ex);
            }
            Config.sendEvent(new NorthButtonReading(true));
        }
    }
}
