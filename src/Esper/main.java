/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import Model.TrafficLight;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Youssef Negm
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    try {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        // If Nimbus is not available, you can set the GUI to another look and feel.
    }
        Logger.getRootLogger().setLevel(Level.OFF);
        Config.registerEvents();

        final TrafficLight trafficLight = new TrafficLight();
                
        Config.createStatement("select state from Power")
                .setSubscriber(new Object() {
                    public void update(boolean state) {
                        trafficLight.setState(state);
                    }
                });
        
        Config.createStatement("select isPressed from NorthButtonReading")
                .setSubscriber(new Object() {
                    public void update(boolean isPressed) {
                        trafficLight.setState(isPressed);
                    }
                });
        
        Config.createStatement("select isPressed from SouthButtonReading")
                .setSubscriber(new Object() {
                    public void update(boolean isPressed) {
                        trafficLight.setState(isPressed);
                    }
                });
        
        Config.createStatement("select isPressed from EastButtonReading")
                .setSubscriber(new Object() {
                    public void update(boolean isPressed) {
                        trafficLight.setState(isPressed);
                    }
                });
        
        Config.createStatement("select isPressed from WestButtonReading")
                .setSubscriber(new Object() {
                    public void update(boolean isPressed) {
                        trafficLight.setState(isPressed);
                    }
                });
        
        Config.createStatement("select cars from NorthVideoReading")
                .setSubscriber(new Object() {
                    public void update(int Cars) throws InterruptedException {
                        trafficLight.DetectCarsNorth(Cars);
                    }
                });
        
        Config.createStatement("select cars from SouthVideoReading")
                .setSubscriber(new Object() {
                    public void update(int Cars) throws InterruptedException {
                        trafficLight.DetectCarsSouth(Cars);
                    }
                });
        
        Config.createStatement("select cars from EastVideoReading")
                .setSubscriber(new Object() {
                    public void update(int Cars) throws InterruptedException {
                        trafficLight.DetectCarsEast(Cars);
                    }
                });
        
        Config.createStatement("select cars from WestVideoReading")
                .setSubscriber(new Object() {
                    public void update(int Cars) throws InterruptedException {
                        trafficLight.DetectCarsWest(Cars);
                    }
                });     
    }
}