/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import Events.*;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 *
 * @author BUE
 */
public class Config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(Power.class);
        engine.getEPAdministrator().getConfiguration().addEventType(NorthLightReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(SouthLightReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(EastLightReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WestLightReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(NorthVideoReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(SouthVideoReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(EastVideoReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WestVideoReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(NorthButtonReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(SouthButtonReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(EastButtonReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WestButtonReading.class);

        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }

}
