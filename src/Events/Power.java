/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

/**
 *
 * @author BUE
 */
public class Power {
    private boolean State;
    
    public Power(boolean state)
    {
        this.State = state;
    }
    
    public boolean getState() {
        return State;
    }
    
}
