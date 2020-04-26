
package stoplightsystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author starh
 */
public class Road {
    public int CAR = 1;
    public Queue<Integer> roadQueue;
    public String name;

    
    public Road(String nm){
        this.name = nm;
        this.roadQueue = new LinkedList();
    }
    
    
    public void addCar() throws InterruptedException{
        this.roadQueue.add(CAR);
        
    }
    
    public void removeAllCars() throws InterruptedException{
        Thread thread = new Thread();    
        int size = this.roadQueue.size();
        thread.sleep(500);
        for(int i = 0; i < size; i++){
            
            this.roadQueue.remove();
        }
    }
    
    public int getNumCars(){
        return this.roadQueue.size();
    }
    
    public String getName(){
        return this.name;
    }
    
    
}
