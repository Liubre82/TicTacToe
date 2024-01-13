import java.util.Scanner;

public class LaunchGame {

    public static void main(String[] args)
    {
        boolean gameFinish = false;
        TicTacToe board = new TicTacToe();
        board.displayBoard();
        board.placeMark(1, 'X');
        board.displayBoard();
        board.placeMark(2, 'X');
        board.displayBoard();
        board.placeMark(3, 'X');
        board.displayBoard();
        board.placeMark(4, 'X');
        board.placeMark(7, 'X');
        board.displayBoard();


        System.out.println(board.checkWin());

        while(gameFinish) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a position: ");
            try {
                int pos = sc.nextInt();
            } catch(Exception e) {
                System.out.println("Not a valid type.");
            }
        }
    }
}
