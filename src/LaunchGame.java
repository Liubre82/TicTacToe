public class LaunchGame {

    public static void main(String[] args)
    {
        TicTacToe board = new TicTacToe();
        Player p1 = new HumanPlayer('X', "Brent");
        Player p2 = new HumanPlayer('O', "Jiajin");
        //reference variable to track which player turn it is.
        Player currPlayer = p1;
        int moves = 0;


        while(!TicTacToe.checkWin() && moves < 9) {
            board.displayBoard();
            System.out.println(currPlayer.getName() + "'s turn!");
            currPlayer.makeMove();
            moves++;
            if(TicTacToe.checkWin()) {
                System.out.println(currPlayer.getName() + " has won!\n");
                break;
            }
            if(moves >= 9) System.out.println("Its a draw.\n");

            //condition changes the player on each iteration.
            if(currPlayer == p1) currPlayer = p2;
            else currPlayer = p1;
        }
        board.displayBoard();

    }
}
