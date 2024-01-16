import java.util.Scanner;

public class LaunchGame
{

    public static void setTimeoutSync(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        TicTacToe board = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        Player p1, p2; //reference var to the 2 Players playing.
        int moves = 0; //count amount of moves, if at move 9 and no winner, it is a tie.

        System.out.println("What is your name player1?: ");
        String name = sc.next();
        p1 = new HumanPlayer('X', name);

        System.out.println("play against who? Type 'person' or 'computer': ");
        String playerType = sc.next().toLowerCase();
        while(!playerType.equals("person") && !playerType.equals("computer") ) {
            System.out.println("Invalid name, enter type of opponent, 'person' or 'computer': ");
            playerType = sc.next();
        }
        if (playerType.equals("computer")) {
            p2 = new PlayerFactory(playerType, 'O', "computer").getPlayer();
        }
        else {
            System.out.println("Name of opponent: ");
            String playerName = sc.next();
            p2 = new PlayerFactory(playerType, 'O', playerName).getPlayer();
        }

        System.out.println("Would you like to go 1st or 2nd? 1 for 1st, 2 for 2nd: ");
        int order = sc.nextInt();

        //reference variable to track which player's turn it is.
        Player currPlayer = (order == 1) ? p1 : p2;



        while(!TicTacToe.checkWin() && moves < 9) {
            board.displayBoard();
            System.out.println(currPlayer.getName() + "'s turn!\n");

            //set a delay if user is playing with the computer/ai.
            if(currPlayer == p2 && p2.getName().equals("computer") ) {
                setTimeoutSync(3000);
            }

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
