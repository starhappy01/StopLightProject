
package stoplightsystem;

import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


/**
 *
 * @author Khushi
 */
public class StopLightSystem {

    public int NS = 1;
    public int SN = 2;
    public int EW = 3;
    public int WE = 4;
    
    public int NSL = 10;
    public int SNL = 20;
    public int EWL = 30;
    public int WEL = 40;
    
    private Road NSroad = new Road("NS");
    private Road SNroad = new Road("SN");
    private Road EWroad = new Road("EW");
    private Road WEroad = new Road("WE");

    private FSM NSLight = new FSM("NorthSouth", FSM.REDSTATE);
    private FSM EWLight = new FSM("EastWest", FSM.GREENSTATE);
    
    public void run(Window panel) throws InterruptedException {
           
        Random rand = new Random();
        Thread thread = new Thread();
             
        int x = 0;
        
        while(x<100){
            
            thread.sleep(rand.nextInt(1000));

            
            x++;
            int randState = rand.nextInt(4) + 1;
            //System.out.println("Adding car to : " + randState);
            if(randState == 1){
                NSroad.addCar();
                // If the light is GREEN or YELLOW, let cars go.
                if (NSLight.getCurrentState() == FSM.GREENSTATE || NSLight.getCurrentState() == FSM.YELLOWSTATE) NSroad.removeAllCars();
            }
            if(randState == 2){
                SNroad.addCar();
                if (NSLight.getCurrentState() == FSM.GREENSTATE || NSLight.getCurrentState() == FSM.YELLOWSTATE) SNroad.removeAllCars();
            }
            if(randState == 3){
                EWroad.addCar();
                if (EWLight.getCurrentState() == FSM.GREENSTATE || EWLight.getCurrentState() == FSM.YELLOWSTATE) EWroad.removeAllCars();
            }
            if(randState == 4){
                WEroad.addCar();
                if (EWLight.getCurrentState() == FSM.GREENSTATE || EWLight.getCurrentState() == FSM.YELLOWSTATE) WEroad.removeAllCars();
            }
            
            
            Event NSE = new Event(EWLight.getCurrentState(),NSroad, EWLight);
            Event EWE = new Event(NSLight.getCurrentState(),EWroad, NSLight);
            Event SNE = new Event(EWLight.getCurrentState(), SNroad, EWLight);
            Event WEE = new Event(NSLight.getCurrentState(),WEroad, NSLight);
            
            NSLight.transition(NSE);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>light on NS is " + NSLight.getCurrentState());
            EWLight.transition(EWE);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>light on EW is " + EWLight.getCurrentState());
            NSLight.transition(SNE);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>light on SN is " + NSLight.getCurrentState());
            EWLight.transition(WEE);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>light on WE is " + EWLight.getCurrentState());

            // both start at red, right now at 5 cars, both change to other light, 
            // then when another car comes, both change back
            
            //System.out.println("Number of cars in " + NSroad.getName() + " is " + NSroad.getNumCars());
            //System.out.println("Number of cars in " + EWroad.getName() + " is " + EWroad.getNumCars());
            //System.out.println("Number of cars in " + SNroad.getName() + " is " + SNroad.getNumCars());
            //System.out.println("Number of cars in " + WEroad.getName() + " is " + WEroad.getNumCars());

        }  
        
    }
    

    public FSM getFSM (int direction){
        if(direction == 10 || direction == 20){
            return NSLight;
        }
        else{
            return EWLight;
        }
    }
    
    public Road getRoad(int direction){
        if(direction == this.NS){
            return NSroad;
        }
        else if (direction == this.SN){
            return SNroad;
        }
        else if(direction == this.EW){
            return EWroad;
        }
        else{
            return WEroad;
        }
    }
    
}
