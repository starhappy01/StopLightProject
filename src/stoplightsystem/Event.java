
package stoplightsystem;

import java.util.Queue;

/**
 *
 * @author starh
 */
public class Event {
    private int otherLight;
    private Road road;
    private FSM otherMachine;
    
    public Event(int otherLight, Road theRoad, FSM otherMach){

        this.otherLight= otherLight;
        this.road = theRoad;
        this.otherMachine = otherMach;
  
    }
    
    public FSM getOtherMach(){
        return otherMachine;
    }
    public Road getRoad(){
        return road;
    }

    public int getOtherLight() {
        return otherLight;
    }

    public int getCarsOnRoad() {
        return road.getNumCars();
    }

    public void setOtherLight(int otherLight) {
        this.otherLight = otherLight;
    }
    
}
