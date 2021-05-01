import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.Timer; //for timer

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Treadmill extends JPanel { // handle the view 

    JButton add;
    JButton sub; 
    JButton speed; 

    JButton time; 
    JButton dist; 

    JPanel speedPanel; 
    JPanel timePanel; 

    public Treadmill() {
        super(new BorderLayout());

	/* for each button, add an action listener and add 
	 * to view 
	 */
	// add button
	speed = new JButton(Model.get_speed() + "Km/h"); // current speed

        add = new JButton("+");
	add.addActionListener(new SpeedController(speed, Model.step_up()));
	
	sub = new JButton("-");
	sub.addActionListener(new SpeedController(speed, Model.step_down()));

        add.setPreferredSize(new Dimension(50, 50));
	sub.setPreferredSize(new Dimension(50, 50));
	speed.setPreferredSize(new Dimension(100, 50));
	
	speedPanel = new JPanel(); 
	speedPanel.setPreferredSize(new Dimension(250, 50));

	speedPanel.add(add, BorderLayout.WEST); 
	speedPanel.add(speed, BorderLayout.CENTER); 
	speedPanel.add(sub, BorderLayout.EAST); 

	timePanel = new JPanel(); 
	timePanel.setPreferredSize(new Dimension(250, 50));

	time = new JButton(Model.get_start_timer());
	time.setPreferredSize(new Dimension(100, 50));
	TimerControler timeCont = 
	    new TimerControler(time, Model.get_timer());
	/* do not put the TimerControler as actionListner for 
	 * button since then it would be called on clicks as well 
	 */

	dist = new JButton("0.0Km"); 
	dist.setPreferredSize(new Dimension(100, 50));
	DistanceControler distCont = 
	    new DistanceControler(dist, Model.get_timer());

	timePanel.add(time, BorderLayout.EAST); 
	timePanel.add(dist, BorderLayout.WEST); 
    
	add(speedPanel, BorderLayout.SOUTH);
	add(timePanel, BorderLayout.NORTH);
	
    }  

    public static void main(String [] args) {
        JFrame frame = new JFrame("Treadmill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Treadmill();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}

