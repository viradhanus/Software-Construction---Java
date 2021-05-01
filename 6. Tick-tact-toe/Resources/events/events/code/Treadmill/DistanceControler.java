import java.awt.*;
import javax.swing.JButton;
import javax.swing.Timer; //for timer
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DistanceControler extends TimerControler { 

    public DistanceControler(JButton button, int time) { 
	super(button, time); 
    }

    public void actionPerformed(ActionEvent e) {
	// called every second 
	double distance = get_distance(); 
	double speed = get_speed(); 
	double oldspeed = get_oldspeed(); 

	distance += ((speed + oldspeed)/2) / 3600 * (time_step/1000); 
	set_distance(distance); 

	// now update display
	int a, b; 
	a = (int)distance; 
	b = (int)Math.round((double)(distance - a) * 10);
	my_button.setText(a + "." + b + "Km");


    }    	
}