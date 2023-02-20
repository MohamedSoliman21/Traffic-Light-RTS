/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BUE
 */
public class SouthLight extends Light{

    public SouthLight(TrafficLight TL) {
        super(TL);
        CurrentLight = 3;
    }

    @Override
    public void run() {
        while(true){
            if(TL.IsTrafficLightOn()){
                if (getCurrentLight() != 3){
                    CurrentLight = 3;
                }
                
                switch (getCurrentLight()) {
                    case 1:
                        try {
                            Red(getCurrentLight(), TL.getGui().getSouthLight(), TL.getSouthVDS(), TL.getGui().getSouthBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 3;
                        break;
                    case 2:
                        try {
                            Yellow(getCurrentLight(), TL.getGui().getSouthLight(), TL.getSouthVDS(), TL.getGui().getSouthBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 1;
                        break;
                    case 3:
                        try {
                            Green(getCurrentLight(), TL.getGui().getSouthLight(), TL.getSouthVDS(), TL.getGui().getSouthBtn(), TL.getSouthBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 2;
                        break;
                    default:
                        break;
                }
            }
            else if (!TL.IsTrafficLightOn()){
                
                switch (getCurrentLight()) {
                    case 1:
                        try {
                            Red(getCurrentLight(), TL.getGui().getSouthLight(), TL.getSouthVDS(), TL.getGui().getSouthBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 2;
                        break;
                    case 2:
                        try {
                            Yellow(getCurrentLight(), TL.getGui().getSouthLight(), TL.getSouthVDS(), TL.getGui().getSouthBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 1;
                        break;
                    default:
                        CurrentLight = 2;
                        break;
                }
            }
            try {
            SouthLight.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SouthLight.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
    
}
