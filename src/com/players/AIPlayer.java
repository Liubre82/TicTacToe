package com.players;
import com.tictactoeboard.TicTacToe;

public class AIPlayer extends Player
{

    public AIPlayer(char mark, String name)
    {
        super(mark, name);
    }

    //program randomly selects a valid spot on the board to place its mark.
    @Override
    public void makeMove() {
        int randomPos;
        do {
            randomPos = (int) (Math.random() * 9) + 1;
        } while(!isValidMove(randomPos));
        TicTacToe.placeMark(randomPos, this.getMark());
    }
}
