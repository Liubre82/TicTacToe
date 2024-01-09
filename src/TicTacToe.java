import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        char[][] boardPosition = {{'1', '2', '3'},
                                  {'4', '5', '6'},
                                  {'7', '8', '9'}};

        printBoard(board, boardPosition);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Where would you like to play? ");
        String userInput = scanner.nextLine();
        System.out.println(userInput);
    }

    //Printing out our board in the terminal.
    private static void printBoard(char[][] board, char[][] boardPosition) {
        System.out.print("Game Board" + "   " + "Board Position");
        System.out.println();
        System.out.print("  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "        ");
        System.out.print("  " + boardPosition[0][0] + "|" + boardPosition[0][1] + "|" + boardPosition[0][2]);
        System.out.println();
        System.out.print("  -+-+-" + "        ");
        System.out.print("  -+-+-");
        System.out.println();
        System.out.print("  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "        ");
        System.out.print("  " + boardPosition[1][0] + "|" + boardPosition[1][1] + "|" + boardPosition[1][2]);
        System.out.println();
        System.out.print("  -+-+-" + "        ");
        System.out.print("  -+-+-");
        System.out.println();
        System.out.print("  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "        ");
        System.out.print("  " + boardPosition[2][0] + "|" + boardPosition[2][1] + "|" + boardPosition[2][2]);
        System.out.println();
    }
}
