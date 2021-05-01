import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeView extends JFrame {

	private static final long serialVersionUID = 1L;

	private final int PANEL_HEIGHT = 450; // define panel height
	private final int PANEL_WIDTH = 450; // define panel width
	public JFrame frame; // initialize frame

	private Toolkit toolkit; // initialize toolkit
	public JButton[] buttons;

	private int dialogInput = 0; // hold int for yes or no in showConfirmDialog

	public TicTacToeView() {
		super("Tic-Tac-Toe Game");

		frame = new JFrame(); // set up the window.
		setSize(PANEL_HEIGHT, PANEL_WIDTH);
		setResizable(false);

		toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize(); // get screen size
		setLocation((size.width - getWidth()) / 2, (size.height - getHeight()) / 2); // center the window in screen

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));

		buttons = new JButton[9]; // set up 9 buttons

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
		}
		for (int i = 0; i < 9; i++) {
			add(buttons[i]);
		}

		// setVisible(true);
	}

	// If buttons are clicked execute a method actionPerformed
	void addTTTListener(ActionListener listenForButtons) {
		for (int i = 0; i < 9; i++) {
			buttons[i].addActionListener(listenForButtons);
		}
	}

	public String showDialog(String message) {

		dialogInput = JOptionPane.showConfirmDialog(null, message, "Game Over!", dialogInput);
		if (dialogInput == JOptionPane.YES_OPTION) {
			return "YES";
		} else {
			return "NO";
		}
	}

	// method to mark buttons with relavent player number
	public void markButtons(ActionEvent e, String player) {

		if (e.getSource() == buttons[0]) {
			buttons[0].setText(player); // set button text to player number
			buttons[0].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[1]) {
			buttons[1].setText(player); // set button text to player number
			buttons[1].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[2]) {
			buttons[2].setText(player); // set button text to player number
			buttons[2].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[3]) {
			buttons[3].setText(player); // set button text to player number
			buttons[3].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[4]) {
			buttons[4].setText(player); // set button text to player number
			buttons[4].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[5]) {
			buttons[5].setText(player); // set button text to player number
			buttons[5].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[6]) {
			buttons[6].setText(player); // set button text to player number
			buttons[6].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[7]) {
			buttons[7].setText(player); // set button text to player number
			buttons[7].setEnabled(false); // deactivate the button
		} else if (e.getSource() == buttons[8]) {
			buttons[8].setText(player); // set button text to player number
			buttons[8].setEnabled(false); // deactivate the button
		}
	}

}