import java.awt.*;
import javax.swing.JButton;
import javax.swing.Timer; //for timer
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerControler extends Model 
    implements ActionListener { 

    protected JButton my_button; //accessible from subclasses 
    private Timer timer; 

    static int time_step; // in ms

    public TimerControler(JButton button, int time) { 
	super(); 
	my_button = button;
	time_step = time; 

	// start a timer 
	timer = new Timer(time, this); 
	timer.start(); 
    }

    private boolean isMyEvent(ActionEvent e) { 
	return e.getSource() == this.timer;
    }

    public void actionPerformed(ActionEvent e) {
	/* since I have buttons, action performed will also be 
	 * called for a click. Check to see if this was called for 
	 * a timer event
	 */
	if(isMyEvent(e)) { // do not react to clicks 	    
	    int sec = get_runtime_sec(); 
	    int min = get_runtime_min(); 
	    
	    sec += time_step/1000; 

	    if(sec == 60) { 
		min ++;
		sec = 0;
	    }
	    if(sec < 10) 
		my_button.setText(min + " : 0" + sec);
	    else 
		my_button.setText(min + " : " + sec);
	    
	    set_runtime(min, sec); 
	}
    }	
}