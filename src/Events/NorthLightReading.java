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
public class NorthLightReading {

    private final int CurrentLight;
    
    public NorthLightReading(int currentlight) {
        this.CurrentLight = currentlight;
    }

    public int getCurrentLight() {
        return CurrentLight;
    }

    
}
