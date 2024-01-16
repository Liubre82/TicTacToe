package com.players;

import com.tictactoeboard.TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player
{
    
    public HumanPlayer(char mark, String name)
    {
        super(mark, name);
    }

    //places the players mark onto the game board and ensures user input is valid before moving on.
    @Override
    public void makeMove()
    {
        int pos;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a position 1-9: ");
            pos = sc.nextInt();
        } while (!isValidMove(pos));
        TicTacToe.placeMark(pos, this.getMark());
    }

}
