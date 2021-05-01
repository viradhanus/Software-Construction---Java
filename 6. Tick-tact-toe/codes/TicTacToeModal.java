import javax.swing.JButton;

public class TicTacToeModal {

	public int turn; // integer to count play turns

	public String findPlayer() {

		turn++;
		if (turn % 2 != 0) {
			return "1";
		} else if (turn % 2 == 0) {
			return "2";
		}
		return "";

	}

	// method to return true if a player wins
	public boolean winState(JButton[] buttons) {
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

}