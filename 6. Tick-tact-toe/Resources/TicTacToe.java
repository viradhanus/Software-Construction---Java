import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

	// ensure that a loaded class is compatible with the serialized object
	private static final long serialVersionUID = 1L;

	private final int PANEL_HEIGHT = 500; // define panel height
	private final int PANEL_WIDTH = 500; // define panel width
	private JFrame frame; // initialize frame

	private Toolkit toolkit; // initialize toolkit
	private JButton[] buttons;

	private String player = ""; // string to hold player number
	private int turn = 0; // integer to count play turns
	private boolean isWin = false; // var to detect a win

	private int dialogInput = 0; // hold int for yes or no in showConfirmDialog

	public TicTacToe() {
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
		for (int i = 0; i < 9; i++) {
			buttons[i].addActionListener(this);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new TicTacToe();

	}

	public void actionPerformed(ActionEvent e) {

		turn++;
		if (turn % 2 != 0) {
			player = "1";
		} else if (turn % 2 == 0) {
			player = "2";
		}

		markButtons(e); // mark buttons with player number
		isWin = winState(); // detects a win
		showDialog(isWin); // show game over msg

	}

	// method to mark buttons with relavent player number
	public void markButtons(ActionEvent e) {

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

	// method to return true if a player wins
	public boolean winState() {
		if ((buttons[0].getText() == buttons[1].getText()) && (buttons[1].getText() == buttons[2].getText())
				&& !buttons[1].getText().isEmpty()) {
			return true;
		} else if ((buttons[3].getText() == buttons[4].getText()) && (buttons[4].getText() == buttons[5].getText())
				&& !buttons[3].getText().isEmpty()) {
			return true;
		} else if ((buttons[6].getText() == buttons[7].getText()) && (buttons[7].getText() == buttons[8].getText())
				&& !buttons[6].getText().isEmpty()) {
			return true;
		} else if ((buttons[0].getText() == buttons[3].getText()) && (buttons[3].getText() == buttons[6].getText())
				&& !buttons[0].getText().isEmpty()) {
			return true;
		} else if ((buttons[1].getText() == buttons[4].getText()) && (buttons[4].getText() == buttons[7].getText())
				&& !buttons[1].getText().isEmpty()) {
			return true;
		} else if ((buttons[2].getText() == buttons[5].getText()) && (buttons[5].getText() == buttons[8].getText())
				&& !buttons[2].getText().isEmpty()) {
			return true;
		} else if ((buttons[0].getText() == buttons[4].getText()) && (buttons[4].getText() == buttons[8].getText())
				&& !buttons[0].getText().isEmpty()) {
			return true;
		} else if ((buttons[2].getText() == buttons[4].getText()) && (buttons[4].getText() == buttons[6].getText())
				&& !buttons[2].getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void showDialog(boolean isWin) {

		if (isWin) { // one player has won
			dialogInput = JOptionPane.showConfirmDialog(null, "WINNER: Player " + player + "\nWanna Play Again?",
					"Game Over!", dialogInput);
			if (dialogInput == JOptionPane.YES_OPTION) {
				// let user to play again
				setVisible(false);
				frame.dispose();
				new TicTacToe();
			} else {
				// close the window and exit
				dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				System.exit(0);
			}
		} else if (turn == 9 && isWin == false) { // no winners
			dialogInput = JOptionPane.showConfirmDialog(null, "Game Tied!\nWanna Play Again?", "Game Over!",
					dialogInput);
			if (dialogInput == JOptionPane.YES_OPTION) {
				// let user to play again
				setVisible(false);
				frame.dispose();
				new TicTacToe();
			} else {
				// close the window and exit
				dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				System.exit(0);
			}
		}
	}

}