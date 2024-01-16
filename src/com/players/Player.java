package com.players;
import com.tictactoeboard.TicTacToe;

public abstract class Player
{

    private char mark;

    private String name;

    public Player(char mark, String name)
    {
        this.mark = mark;
        this.name = name;
    }

    public abstract void makeMove();

    //checks if the position to place the mark is valid, returns a boolean based on that result.
    public boolean isValidMove(int pos)
    {
        int row = TicTacToe.convertPosition(pos).get("row");
        int col = TicTacToe.convertPosition(pos).get("col");
        if(pos > 0 && pos < 10) {
            if(TicTacToe.getBoard()[row][col] == ' ') return true;
        }
        return false;
    }

    public char getMark()
    {
        return mark;
    }

    public String getName()
    {
        return name;
    }
}
