import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SpeedController extends Model 
    implements ActionListener { 
    private static JButton speedButton = null;  
    private double my_step;
 
    public SpeedController(JButton button, double step) { 	
	super(); 
	this.my_step = step; 
	if(speedButton == null) speedButton = button; // on button
    }

    public static void update_view() { 
	int a, b; 
	double speed = get_speed(); 
	a = (int) speed; 
	b = (int) ((speed - a) * 10); 
	speedButton.setText(a + "." + b + "Km/h");
    }

    public void actionPerformed(ActionEvent e) { 
	updatespeeds(get_speed() + my_step); 
	update_view(); 
    }
}

    