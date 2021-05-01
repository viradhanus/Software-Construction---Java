import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class Swing{

	public static void main(String args[] ){
		
		JFrame frame=new JFrame("Swing");
	 	
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		
		frame.setVisible(true);
		
		JPanel panel=new JPanel();
		panel.setVisible(true);
		
		
		frame.add(panel);
		placeComponents(panel);
		
		
	}
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		

		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		JTextField username=new JTextField(25);
		username.setBounds(100,10,160,25);
		panel.add(username);
		
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,40, 80, 25);
		panel.add(passwordLabel);
		
		JPasswordField password=new JPasswordField(25);
		password.setBounds(100,40,160,25);
		panel.add(password);
	
		
		JButton loginbutton=new JButton("Login");
		loginbutton.setBounds(10, 80, 80, 25);		
		loginbutton.addActionListener(new Action());
		panel.add(loginbutton);
		
		
		
	} 
	
	static class Action implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame2=new JFrame("Login ");
		 	frame2.setVisible(true);
		 	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}