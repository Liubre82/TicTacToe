public class HumanPlayer extends Player {
    
    public HumanPlayer(char mark, String name) {
        super(mark, name);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public boolean isValidMove(int pos) {
        int row = TicTacToe.convertPosition(pos).get("row");
        int col = TicTacToe.convertPosition(pos).get("col");
        if(pos > 0 && pos < 10) {
            if(TicTacToe.board[row][col] != ' ') return true;
        }
        return false;
    }
}
