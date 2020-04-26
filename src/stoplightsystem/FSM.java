
package stoplightsystem;

/**
 *
 * @author starh
 */
public class FSM {
    
    public static int GREENSTATE = 1;
    public static int REDSTATE = 0;
    public static int YELLOWSTATE = 2;
    private int currentState;
    private String name;
    
    public FSM (String lightName, int State){
        this.name = lightName;
        this.currentState = State;
    }
    
    public void setState(int State) {
        // If I am told to turn RED, 
        // spawn a new thread, turn light YELLOW, sleep 0.5 sec and then turn RED
        if(State == FSM.REDSTATE){
            //System.out.println(this.name + " : Setting state to RED ....");
            StopLightThread ST = new StopLightThread(this);
            ST.start();
        }
        else if (State == FSM.GREENSTATE){
            //System.out.println(this.name + " : Settign state to GREEN");
            this.currentState = State;
        }
    }

    public void setStateSync(int State) {
            // Just change the state of the FSM.
            this.currentState = State;
       
    }
        
    public int getCurrentState() {
        return this.currentState;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void transition(Event e) throws InterruptedException{
        // If self state is RED
        // AND
        // If number of cars is >= 5
        // Turn GREEN (and turn the other light RED)
        
        if(this.getCurrentState() == REDSTATE && e.getCarsOnRoad() == 5){
            this.setState(GREENSTATE);
            e.getOtherMach().setState(REDSTATE);
            //System.out.println("Setting state to Green");
            // Flush all cars on this road now.
            e.getRoad().removeAllCars();
        }
        // If self is GREEN
        // Check if other light is GREEN
        // Turn RED
//        else if(this.currentState == GREENSTATE){
//            if(e.getOtherLight() == GREENSTATE){
//                // The other road has turned Green, so tuen REd.
//                this.currentState = REDSTATE;
//                System.out.println("Setting state to RED");
//            }
//
//        }
        

    }
    
}
