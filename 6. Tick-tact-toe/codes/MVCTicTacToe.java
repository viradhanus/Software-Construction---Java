public class MVCTicTacToe{
    
    public static void main(String[] args) {
    	
    	TicTacToeView TTTView = new TicTacToeView();
    	TicTacToeModal TTTModel = new TicTacToeModal();
        new TicTacToeController(TTTView,TTTModel);
        
        TTTView.setVisible(true);
        
    }
}