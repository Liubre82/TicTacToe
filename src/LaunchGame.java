public class LaunchGame {

    public static void main(String[] args)
    {
        TicTacToe board = new TicTacToe();
        Player p1 = new HumanPlayer('X', "Brent");
        Player p2 = new HumanPlayer('O', "Jiajin");
        Player currPlayer = p1;

        System.out.println(currPlayer.getName() + "'s turn!");



    }
}
