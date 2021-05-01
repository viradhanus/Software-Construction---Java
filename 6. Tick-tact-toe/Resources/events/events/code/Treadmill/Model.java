import javax.swing.JButton;

public class Model { 
    
    /* some constants 
     * These are used to setup initial values 
     */ 
    static int timer = 1000;  // check every 1s 
    static double step = 0.1; // step to increase or decrease 
    static String timerStartString = "0 : 00"; 
    
    /* Global parameters 
     * These will be modified by contollers 
     */
    static int min = 0; // current run time 
    static int sec = 0; 

    static double speed = 1.0; // current speed
    static double oldspeed = 1.0; // previous speed
    static double distance = 0; // how long did you run 

    private static double get_step() { return step; }
    public static double step_up() { return get_step(); }
    public static double step_down() { return -get_step(); }

    public static double get_speed() { return speed; } 
    public static double get_oldspeed() { return oldspeed; } 
    public static void updatespeeds(double newspeed) { 
	oldspeed = speed; 
	speed = newspeed; 
    }

    public static String get_start_timer() { return timerStartString; }
    public static int get_runtime_sec() { return sec; } 
    public static int get_runtime_min() { return min; } 
    public static void set_runtime(int new_min, int new_sec) { 
	min = new_min; 
	sec = new_sec; 
    }
    
    public static int get_timer() { return timer; }

    public static double get_distance() { return distance; }
    public static void set_distance(double newdistance) { 
	distance = newdistance; 
    }

    public Model() {}    

}
	
    

    
    