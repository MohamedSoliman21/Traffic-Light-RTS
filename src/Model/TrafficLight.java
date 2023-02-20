/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Esper.Config;
import Events.*;
import View.TrafficView;
import java.awt.Color;

/**
 *
 * @author BUE
 */
public class TrafficLight {
    private PowerLight light;
    private TrafficView Gui;
    private boolean State = false;
    private NorthLight northLight;
    private SouthLight southLight;
    private EastLight eastLight;
    private WestLight westLight;
    private NorthVideoSensor NorthVDS;
    private SouthVideoSensor SouthVDS;
    private EastVideoSensor EastVDS;
    private WestVideoSensor WestVDS;
    private Button NorthBtn;
    private Button SouthBtn;
    private Button EastBtn;
    private Button WestBtn;
            
    
    public TrafficLight(){
        Gui = new TrafficView();
        Gui.setLocationRelativeTo(null);
        Gui.setVisible(true);
        
        light = new PowerLight(this);
        
        northLight = new NorthLight(this);
        southLight = new SouthLight(this);
        eastLight = new EastLight(this);
        westLight = new WestLight(this);
        
        NorthVDS = new NorthVideoSensor(this);
        SouthVDS = new SouthVideoSensor(this);
        EastVDS = new EastVideoSensor(this);
        WestVDS = new WestVideoSensor(this);
        
        NorthBtn = new Button(this);
        SouthBtn = new Button(this);
        EastBtn = new Button(this);
        WestBtn = new Button(this);
        
        northLight.start();
        southLight.start();
        eastLight.start();
        westLight.start();

        NorthVDS.start();
        SouthVDS.start();
        EastVDS.start();
        WestVDS.start();
        
        NorthBtn.start();
        SouthBtn.start();
        EastBtn.start();
        WestBtn.start();
    }
    
    public boolean IsTrafficLightOn(){
        return State;
    }

    public NorthVideoSensor getNorthVDS() {
        return NorthVDS;
    }

    public SouthVideoSensor getSouthVDS() {
        return SouthVDS;
    }

    public EastVideoSensor getEastVDS() {
        return EastVDS;
    }

    public WestVideoSensor getWestVDS() {
        return WestVDS;
    }

    public TrafficView getGui() {
        return Gui;
    }

    public PowerLight getLight() {
        return light;
    }

    public Button getNorthBtn() {
        return NorthBtn;
    }

    public Button getSouthBtn() {
        return SouthBtn;
    }

    public Button getEastBtn() {
        return EastBtn;
    }

    public Button getWestBtn() {
        return WestBtn;
    }

    public NorthLight getNorthLight() {
        return northLight;
    }

    public SouthLight getSouthLight() {
        return southLight;
    }

    public EastLight getEastLight() {
        return eastLight;
    }

    public WestLight getWestLight() {
        return westLight;
    }
    
    
    public void Shutdown(boolean State){
        Gui.getNorthBtn().setEnabled(State);
        Gui.getWestBtn().setEnabled(State);
        Gui.getEastBtn().setEnabled(State);
        Gui.getSouthBtn().setEnabled(State);
        if(!State){
            Gui.getNorthLight().setText("0");
            Gui.getWestLight().setText("0");
            Gui.getEastLight().setText("0");
            Gui.getSouthLight().setText("0");  

            while(!IsTrafficLightOn())
            {
                Gui.getNorthLight().setBackground(Color.red);
                Gui.getWestLight().setBackground(Color.yellow);
                Gui.getEastLight().setBackground(Color.yellow);
                Gui.getSouthLight().setBackground(Color.red);

                Gui.getNorthLight().setBackground(Color.yellow);
                Gui.getWestLight().setBackground(Color.red);
                Gui.getEastLight().setBackground(Color.red);
                Gui.getSouthLight().setBackground(Color.yellow);

                break;       
            } 
        }
    }
    
    public void setState(boolean State) {
        this.State = State;
        this.light.setState(State);
        Gui.getOnBtn().setEnabled(!State);
        Gui.getOffBtn().setEnabled(State);
        Shutdown(State);
    }
    
    public void PressButton(boolean press) {

        if(press){
            
           Config.sendEvent(new NorthButtonReading(press));
           Gui.getNorthBtn().setEnabled(false);
           Gui.getWestBtn().setEnabled(false);
           Gui.getEastBtn().setEnabled(false);
           Gui.getSouthBtn().setEnabled(false);
           for(int i = 0; i >= 35; i++)
           {
                System.out.println("Buttons Disabled for " + i + " seconds");
           }
           Gui.getNorthBtn().setEnabled(true);
           Gui.getWestBtn().setEnabled(true);
           Gui.getEastBtn().setEnabled(true);
           Gui.getSouthBtn().setEnabled(true);           
        }
    }
    
    public void DetectCarsNorth(int Cars) throws InterruptedException  {
        if(IsTrafficLightOn()){
            if (Cars <= 0){
                Cars = 0;
            }
            Gui.getCarsNorth().setText(Cars + "");
            if (Cars >= 100) {
                Config.sendEvent(new NorthVideoReading(Cars));
                NorthVDS.wait();
            }
        }
        else if(!IsTrafficLightOn()){
            Gui.getCarsNorth().setText("0");
        }
    }
     
    public void DetectCarsSouth(int Cars) throws InterruptedException  {
        if(IsTrafficLightOn()){
            if (Cars <= 0){
                Cars = 0;
            }
            Gui.getCarsSouth().setText(Cars + "");
            if (Cars >= 50) {
                Config.sendEvent(new SouthVideoReading(Cars));
                SouthVDS.wait();
            }
        }
        else if (!IsTrafficLightOn()){
            Gui.getCarsSouth().setText("0");
        }
    }
    
    public void DetectCarsEast(int Cars) throws InterruptedException {
        if(IsTrafficLightOn()){
            if (Cars <= 0){
                Cars = 0;
            }
            Gui.getCarsEast().setText(Cars + "");
            if (Cars >= 50) {
                Config.sendEvent(new EastVideoReading(Cars)); 
                EastVDS.wait();
            }
        }
        else if (!IsTrafficLightOn()){
            Gui.getCarsEast().setText("0");
        }
    }
    
    public void DetectCarsWest(int Cars) throws InterruptedException {
        if(IsTrafficLightOn()){
            if (Cars <= 0){
                Cars = 0;
            }
            Gui.getCarsWest().setText(Cars + "");
            if (Cars >= 50) {
                Config.sendEvent(new WestVideoReading(Cars));
                WestVDS.wait();
            }
        }
        else if (!IsTrafficLightOn()){
            Gui.getCarsWest().setText("0");
        }
    }
    
}