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
public class SouthLightReading {

    private final int CurrentLight;
    
    public SouthLightReading(int currentlight) {
        this.CurrentLight = currentlight;
    }

    public int getCurrentLight() {
        return CurrentLight;
    }

    
}
