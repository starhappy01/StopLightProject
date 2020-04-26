
package stoplightsystem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author starh
 */
public class Window extends JPanel{
    
    public static JFrame f;
    public static StopLightSystem sls;


    public static void main(String[] args) throws InterruptedException {
        f = new JFrame();
        f.setVisible(true);
        f.setTitle("Four Way Stoplight");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Window panel = new Window();
        panel.setBackground(Color.GREEN);
        panel.revalidate();
        
        f.getContentPane().add(new JPanel());
        f.add(panel);
        
        PaintThread PT = new PaintThread(panel);
        PT.start();
        
        sls = new StopLightSystem();
        sls.run(panel);
        

    }
    
        
    public void paint(Graphics g) 
    {
        super.paint(g);
        //System.out.println("In Paint");
        g.setColor(Color.BLACK);

        
        
        g.fillRect(150, 0, 100, 400);
        g.fillRect(0, 150, 400, 100);
        
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(sls.getRoad(1).getNumCars()), 200, 50);
        g.drawString(Integer.toString(sls.getRoad(4).getNumCars()), 50, 200);
        g.drawString(Integer.toString(sls.getRoad(3).getNumCars()), 350, 200);
        g.drawString(Integer.toString(sls.getRoad(2).getNumCars()), 200, 350);
        
        g.setColor(Color.YELLOW);
        g.drawLine(200, 0, 200, 400);
        g.drawLine(0, 200, 400, 200);           
        
        g.setColor(Color.GRAY);
        g.fillOval(151, 111, 13, 13);
        g.fillOval(151, 125, 13, 13);
        g.fillOval(151, 139, 13, 13);

        g.fillOval(236, 250, 13, 13);
        g.fillOval(236, 264, 13, 13);
        g.fillOval(236, 278, 13, 13);

        g.fillOval(251, 150, 13, 13);
        g.fillOval(265, 150, 13, 13);
        g.fillOval(279, 150, 13, 13);

        g.fillOval(111, 235, 13, 13);
        g.fillOval(125, 235, 13, 13);
        g.fillOval(139, 235, 13, 13);

                
        if(sls.getFSM(10).getCurrentState() == 1){
            try {
                changeLightColor(g, 1, 2, 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(sls.getFSM(30).getCurrentState() == 1){
            try {
                changeLightColor(g, 3, 4, 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(sls.getFSM(10).getCurrentState() == 0){
            try {
                changeLightColor(g, 1, 2, 0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(sls.getFSM(30).getCurrentState() == 0){
            try {
                changeLightColor(g, 3, 4, 0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(sls.getFSM(10).getCurrentState() == 2){
            try {
                changeLightColor(g, 1, 2, 2);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(sls.getFSM(30).getCurrentState() == 2){
            try {
                changeLightColor(g, 3, 4, 2);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    // CHanges color of the lights
    // Args:
    // Road1 = either NS or EW
    // Road2 = either SN or WE
    // Color = color of light to paint
    public void changeLightColor(Graphics g, int road1, int road2, int color) throws InterruptedException{
        
        if(color == FSM.GREENSTATE){ 
            switch(road1){
                case 1:
                    g.setColor(Color.GREEN);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 125, 13, 13);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 264, 13, 13);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GREEN);
                    g.fillOval(251, 150, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(265, 150, 13, 13);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GREEN);
                    g.fillOval(111, 235, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(125, 235, 13, 13);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
       
            switch(road2){
                case 1:
                    g.setColor(Color.GREEN);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 125, 13, 13);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 264, 13, 13);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GREEN);
                    g.fillOval(251, 150, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(265, 150, 13, 13);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GREEN);
                    g.fillOval(111, 235, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(125, 235, 13, 13);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
            
        }
        else if(color == FSM.REDSTATE){
            switch(road1){
                case 1:
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(151, 125, 13, 13);
                    g.fillOval(151, 139, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.fillOval(151, 125, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(236, 264, 13, 13);
                    g.fillOval(236, 278, 13, 13);                   
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.fillOval(236, 264, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GRAY);
                    g.fillOval(251, 150, 13, 13);
                    g.fillOval(265, 150, 13, 13);                    
                    g.setColor(Color.RED);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GRAY);
                    g.fillOval(111, 235, 13, 13);
                    g.fillOval(125, 235, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
            
            
            
            switch(road2){
                case 1:
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(151, 125, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 139, 13, 13);                   
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.fillOval(151, 125, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(236, 264, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 278, 13, 13);                   
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.fillOval(236, 264, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GRAY);
                    g.fillOval(251, 150, 13, 13);
                    g.fillOval(265, 150, 13, 13);                    
                    g.setColor(Color.RED);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GRAY);
                    g.fillOval(111, 235, 13, 13);
                    g.fillOval(125, 235, 13, 13);
                    g.setColor(Color.RED);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
        }
        else if(color == FSM.YELLOWSTATE){ 
            switch(road1){
                case 1:
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(151, 125, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(236, 264, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GRAY);
                    g.fillOval(251, 150, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(265, 150, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GRAY);
                    g.fillOval(111, 235, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(125, 235, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
       
            switch(road2){
                case 1:
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 111, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(151, 125, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(151, 139, 13, 13);
                    break;
                case 2:
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 250, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(236, 264, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(236, 278, 13, 13);
                    break;
                case 3:
                    g.setColor(Color.GRAY);
                    g.fillOval(251, 150, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(265, 150, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(279, 150, 13, 13);
                    break;
                case 4:
                    g.setColor(Color.GRAY);
                    g.fillOval(111, 235, 13, 13);
                    g.setColor(Color.YELLOW);
                    g.fillOval(125, 235, 13, 13);
                    g.setColor(Color.GRAY);
                    g.fillOval(139, 235, 13, 13);
                    break;
  
            }
            
        }
    }
    

    

    public void update(Graphics g){
        super.update(g);
        System.out.println("In Update");

    }
    
    
   
    
    
     
    
}
