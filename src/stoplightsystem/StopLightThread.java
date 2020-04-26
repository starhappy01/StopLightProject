/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stoplightsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author starh
 */
public class StopLightThread extends Thread{
    
    private FSM stoplight;
    
    public StopLightThread(FSM light){
        this.stoplight = light;   
    }
    
    
    public void run(){
        // Turn the FSM to YELLOW, sleep for 0.5 secs and then turn it RED
        this.stoplight.setStateSync(FSM.YELLOWSTATE);
        
        try {
            this.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StopLightThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.stoplight.setStateSync(FSM.REDSTATE);
    }
    
}
