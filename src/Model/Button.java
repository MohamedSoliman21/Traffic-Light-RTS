/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author BUE
 */
public class Button extends Thread {
    protected boolean Pressed;
    private TrafficLight TL;

    public Button(TrafficLight TL) {
        this.TL = TL;
    }

    public boolean IsPressed() {
        return Pressed;
    }
    
}
