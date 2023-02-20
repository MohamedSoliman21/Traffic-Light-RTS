/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author BUE
 */
public class Light extends Thread{
    protected TrafficLight TL;
    private final Beeper beeper;
    protected int RedDuration;
    protected int YellowDuration;
    protected int GreenDuration;
    protected int CurrentLight;
    protected boolean Power;
    
    public Light(TrafficLight TL) {
        this.TL = TL;
        this.GreenDuration = 30;
        this.RedDuration = 35;
        this.YellowDuration = 5;
        
        beeper = new Beeper();
    }

    public int getCurrentLight() {
        return CurrentLight;
    }
    
    protected void Red(int CurrentLight, JTextField LightField, VideoSensor vds, JButton Btn) throws InterruptedException{
        if(TL.IsTrafficLightOn()){
            for(int i = RedDuration; i >= 0; i--){
                Btn.setEnabled(false);
                LightField.setBackground(Color.red);
                LightField.setText(i+ "");
                vds.IncresaeCars();
                if(i <= 5){
                    beeper.beep();
                }
                if(vds.getCars() >= 50 && i > 5){
                    i = 5;
                }
                TimeUnit.SECONDS.sleep(1); 
                if(!TL.IsTrafficLightOn()){
                    i = 0;
                }
            }
        }
        else if(!TL.IsTrafficLightOn()) {
            LightField.setBackground(Color.red);
            LightField.setText("0");
            TimeUnit.SECONDS.sleep(1);
            CurrentLight = 2;
        }
        CurrentLight = 3;
    }
        
    protected void Yellow(int CurrentLight, JTextField LightField, VideoSensor vds, JButton Btn) throws InterruptedException{
        if(TL.IsTrafficLightOn()){
            for(int i = YellowDuration; i >= 0; i--){
                Btn.setEnabled(false);
                LightField.setBackground(Color.yellow);
                LightField.setText(i + "");
                vds.DecreaseCars();
                if(i <= 5){
                    beeper.beep();
                }
                TimeUnit.SECONDS.sleep(1);
                
                if(!TL.IsTrafficLightOn()){
                    i = 0;
                }
            }
        }
        else if(!TL.IsTrafficLightOn()) {
            LightField.setBackground(Color.yellow);
            LightField.setText("0");
            TimeUnit.SECONDS.sleep(1);
            CurrentLight = 1;
        }
        CurrentLight = 3;
    }

    protected void Green(int CurrentLight, JTextField LightField, VideoSensor vds, JButton Btn, Button B) throws InterruptedException{
        if(TL.IsTrafficLightOn()){
            for(int i = GreenDuration; i >= 0; i--){
                if(i <= 20 && i >= 10){
                    Btn.setEnabled(true);
                }
                else{
                    Btn.setEnabled(false);
                }
                LightField.setBackground(Color.green);
                LightField.setText(i + "");
                vds.DecreaseCars();
                if(i <= 5){
                    beeper.beep();
                }
                TimeUnit.SECONDS.sleep(1);
                if(!TL.IsTrafficLightOn()){
                    i = 0;
                }
            }
        }
        else {
            TimeUnit.SECONDS.sleep(1);
            CurrentLight = 1;
        }
        CurrentLight = 1;
    }    
}
