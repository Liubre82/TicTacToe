import java.util.Map;
import java.util.Scanner;

public class TicTacToe
{
    //2d array is [row][col]
    static char[][] board;
    private final static char[][] boardPosition = {{'1', '2', '3'},
                                            {'4', '5', '6'},
                                            {'7', '8', '9'}};


    /*initialize our board 2d array then invoke the initBoard method that sets a
    default char to our board.*/
    public TicTacToe()
    {
        board = new char[3][3];
        initBoard();
    }

    //sets each
    void initBoard()
    {
        //int pos = 1;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                /* Since our board is of type char, if we want to input a 'char' as a number,
                * we convert the int to a string, then use the charAt to convert the String
                * to a char, & since we only have 1 element in the String, it is at index 0
                * board[row][col] = Integer.toString(pos++).charAt(0);
                */
                board[row][col] = ' ';

            }
        }
    }


    //Displays our fancy looking tic-tac-toe board in the terminal.
    void displayBoard()
    {
        System.out.println("--GameBoard--     --Positions--");
        System.out.println("-------------     -------------");
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print("| " +  board[row][col] + " ");
            }
            System.out.print("|");
            System.out.print("     ");
            for(int col = 0; col < boardPosition[row].length; col++) {
                System.out.print("| " +  boardPosition[row][col] + " ");
            }
            System.out.println("|");
            System.out.println("-------------     -------------");
        }
        System.out.println("\n===============================\n");
    }


/*    convert pos to the 2d array keys row and col,
      returns a hashMap with2 keys row and map.*/
    static Map<String, Integer> convertPosition(int pos)
    {
        int row = 0, col = 0;
        switch(pos) {
            case 1:
                row = 0;
                col = 0;
                break;
            case 2:
                row = 0;
                col = 1;
                break;
            case 3:
                row = 0;
                col = 2;
                break;
            case 4:
                row = 1;
                col = 0;
                break;
            case 5:
                row = 1;
                col = 1;
                break;
            case 6:
                row = 1;
                col = 2;
                break;
            case 7:
                row = 2;
                col = 0;
                break;
            case 8:
                row = 2;
                col = 1;
                break;
            case 9:
                row = 2;
                col = 2;
                break;

        }
        Map<String, Integer> position = Map.of(
                "row", row,
                "col", col
        );
        return position;
    }

    static void placeMark(int pos, char mark)
    {
        int row = TicTacToe.convertPosition(pos).get("row");
        int col = TicTacToe.convertPosition(pos).get("col");

        if(pos > 0 && pos < 10) {
            if(board[row][col] != ' ') {
                System.out.println("Position has already been taken!!\n");
            }
            else {
                board[row][col] = mark;
                System.out.println(mark + " placed on position " + pos);
            }
        }
        else {
            System.out.println("Invalid Position!!\n");
        }
    }

    //checks for only the boards Column winning conditions.
    static boolean checkColWin()
    {
        for(int col = 0; col < 3; col++) {
            if(board[0][col] != ' ' &&
               board[0][col] == board[1][col] &&
               board[1][col] == board[2][col])
            { return true; }
        }
        return false;
    }

    //checks for only the boards Row winning conditions.
    static boolean checkRowWin()
    {
        for(int row = 0; row < 3; row++) {
            if(board[row][0] != ' ' &&
               board[row][0] == board[row][1] &&
               board[row][1] == board[row][2])
            { return true; }
        }
        return false;
    }

    //checks for only the boards diagonal winning conditions.
    static boolean checkDiagonalWin()
    {
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        else if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }

    //checks each possible winning condition and if any of them are true, return true.
    //each checkWin condition function checks if ' ' exist, if it does, it returns false. this
    //prevents empty spaces from 'winning' the game.
    static boolean checkWin()
    {
        if(checkColWin() || checkRowWin() || checkDiagonalWin()) {
            return true;
        }
        return false;
    }

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





//        char[][] board = {{' ', ' ', ' '},
//                          {' ', ' ', ' '},
//                          {' ', ' ', ' '}};
//
//        char[][] boardPosition = {{'1', '2', '3'},
//                                  {'4', '5', '6'},
//                                  {'7', '8', '9'}};
//
//        printBoard(board, boardPosition);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Where would you like to play? ");
//        String userInput = scanner.nextLine();
//        System.out.println(userInput);
//    }
//
//    //Printing out our board in the terminal.
//    private static void printBoard(char[][] board, char[][] boardPosition) {
//        System.out.print("Game Board" + "   " + "Board Position");
//        System.out.println();
//        System.out.print("  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "        ");
//        System.out.print("  " + boardPosition[0][0] + "|" + boardPosition[0][1] + "|" + boardPosition[0][2]);
//        System.out.println();
//        System.out.print("  -+-+-" + "        ");
//        System.out.print("  -+-+-");
//        System.out.println();
//        System.out.print("  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "        ");
//        System.out.print("  " + boardPosition[1][0] + "|" + boardPosition[1][1] + "|" + boardPosition[1][2]);
//        System.out.println();
//        System.out.print("  -+-+-" + "        ");
//        System.out.print("  -+-+-");
//        System.out.println();
//        System.out.print("  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "        ");
//        System.out.print("  " + boardPosition[2][0] + "|" + boardPosition[2][1] + "|" + boardPosition[2][2]);
//        System.out.println();
    }
}
