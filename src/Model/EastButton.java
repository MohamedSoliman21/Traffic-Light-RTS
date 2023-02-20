/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Esper.Config;
import Events.EastButtonReading;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BUE
 */
public class EastButton extends Button{
    
    public EastButton(TrafficLight TL) {
        super(TL);
        this.Pressed = false;
    }
        
    @Override
    public void run() {
        while (true) { 
            try {
                if(IsPressed() == true){
                }
                EastButton.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EastButton.class.getName()).log(Level.SEVERE, null, ex);
            }
            Config.sendEvent(new EastButtonReading(true));
        }
    }
}
