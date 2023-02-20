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
public class EastLight extends Light{

    public EastLight(TrafficLight TL) {
        super(TL);
        CurrentLight = 1;
    }

    @Override
    public void run() {
        while(true){
            if(TL.IsTrafficLightOn()){
                if(getCurrentLight() != 1){
                    CurrentLight= 1;
                }
                
                switch (getCurrentLight()) {
                    case 1:
                        try {
                            Red(getCurrentLight(), TL.getGui().getEastLight(), TL.getEastVDS(), TL.getGui().getEastBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 3;
                        break;
                    case 2:
                        try {
                            Yellow(getCurrentLight(), TL.getGui().getEastLight(), TL.getEastVDS(), TL.getGui().getEastBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 1;
                        break;
                    case 3:
                        try {
                            Green(getCurrentLight(), TL.getGui().getEastLight(), TL.getEastVDS(), TL.getGui().getEastBtn(), TL.getEastBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
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
                            Red(CurrentLight, TL.getGui().getEastLight(), TL.getEastVDS(), TL.getGui().getEastBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 2;
                        break;
                    case 2:
                        try {
                            Yellow(CurrentLight, TL.getGui().getEastLight(), TL.getEastVDS(), TL.getGui().getEastBtn());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
                        }   CurrentLight = 1;
                        break;
                    default:
                        CurrentLight = 1;
                        break;
                }
            }
            try {
            EastLight.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(EastLight.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
}
