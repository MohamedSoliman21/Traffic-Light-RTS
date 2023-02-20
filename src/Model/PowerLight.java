/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;

/**
 *
 * @author BUE
 */
public class PowerLight {

    private boolean State;
    private TrafficLight TL;

    public PowerLight(TrafficLight TL) {
        this.State = false;
        this.TL = TL;
    }
    
    public void setState(boolean state) {
        this.State = state;
        if (state) {
            TL.getGui().getTrafficLightStatus().setText("ON");
            TL.getGui().getTrafficLightStatus().setBackground(Color.green);

        } else {
            TL.getGui().getTrafficLightStatus().setText("OFF");
            TL.getGui().getTrafficLightStatus().setBackground(Color.red);
        }
    }    
}