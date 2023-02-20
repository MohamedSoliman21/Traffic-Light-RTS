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
public class SouthButtonReading {
    private final boolean isPressed;
    
    public SouthButtonReading(boolean press) {
        this.isPressed = press;
    }

    public boolean isIsPressed() {
        return isPressed;
    }
}