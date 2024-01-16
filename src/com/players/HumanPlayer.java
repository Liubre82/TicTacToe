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

    //human player places a mark on the game board.
    @Override
    public void makeMove()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a position '1-9': ");
        int pos = sc.nextInt();
        while(!isValidMove(pos)) {
            System.out.print("Invalid position, re-enter position '1-9': ");
            pos = sc.nextInt();
        }
        TicTacToe.placeMark(pos, this.getMark());
    }

}
