import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TicTacToeController {

	private TicTacToeView TTTView;
	private TicTacToeModal TTTModel;

	private String player = ""; // string to hold player number
	private boolean isWin = false; // var to detect a win

	private String dialogInput = ""; // hold int for yes or no in showConfirmDialog

	public TicTacToeController(TicTacToeView TTTView, TicTacToeModal TTTModel) {

		this.TTTView = TTTView;

		this.TTTModel = TTTModel;

		this.TTTView.addTTTListener(new TTTListener());

	}

	class TTTListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			player = TTTModel.findPlayer();
			TTTView.markButtons(e, player); // mark buttons with player number
			isWin = TTTModel.winState(TTTView.buttons); // detects a win

			if (isWin) { // one player has won
				dialogInput = TTTView.showDialog("WINNER: Player " + player + "\nWanna Play Again?"); // show game over msg
				if (dialogInput == "YES") {
					// let user to play again
					TTTView.setVisible(false);
					TTTView.frame.dispose();
					//new frame
					TicTacToeView NewView = new TicTacToeView();
					TicTacToeModal NewModel = new TicTacToeModal();
					new TicTacToeController(NewView,NewModel);

					NewView.setVisible(true);
				} else {
					// close the window and exit
					TTTView.dispatchEvent(new WindowEvent(TTTView.frame, WindowEvent.WINDOW_CLOSING));
					System.exit(0);
				}
			} else if (TTTModel.turn == 9 && isWin == false) { // no winners
				dialogInput = TTTView.showDialog("Game Tied!\nWanna Play Again?"); // show game tied msg
				if (dialogInput ==  "YES") {
					// let user to play again
					TTTView.setVisible(false);
					TTTView.frame.dispose();
					//new frame
					TicTacToeView NewView = new TicTacToeView();
					TicTacToeModal NewModel = new TicTacToeModal();
					new TicTacToeController(NewView,NewModel);

					NewView.setVisible(true);
				} else {
					// close the window and exit
					TTTView.dispatchEvent(new WindowEvent(TTTView.frame, WindowEvent.WINDOW_CLOSING));
					System.exit(0);
				}
			}

		}
	}
}