
package stoplightsystem;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author starh
 */
public class PaintThread extends Thread{
    private Window W;
    
    public PaintThread(Window W){
        this.W = W;
    }
    
    public void run(){
        
        while(true){
            W.repaint();
            try {
                this.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(PaintThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
