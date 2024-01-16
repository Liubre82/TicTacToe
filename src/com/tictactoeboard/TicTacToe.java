package com.tictactoeboard;

import java.util.Map;

public class TicTacToe
{
    //2d array is [row][col]
    private static char[][] board;
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
    public void initBoard()
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

    public static char[][] getBoard() {
        return board;
    }

    //Displays our fancy looking tic-tac-toe board in the terminal.
    public void displayBoard()
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


/*  convert pos to the 2d array keys row and col,
    returns a hashMap with2 keys row and map.*/
    public static Map<String, Integer> convertPosition(int pos)
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

    //places a mark onto the game board.
    public static void placeMark(int pos, char mark)
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
    public static boolean checkColWin()
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
    public static boolean checkRowWin()
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
    public static boolean checkDiagonalWin()
    {
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        else if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }

    //checks each possible winning condition and if any of them are true, return true.
    //each checkWin condition function checks if ' ' exist, if it does, it returns false. this
    //prevents empty spaces from 'winning' the game.
    public static boolean checkWin()
    {
        if(checkColWin() || checkRowWin() || checkDiagonalWin()) {
            return true;
        }
        return false;
    }

}
