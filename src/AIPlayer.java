public class AIPlayer extends Player
{

    public AIPlayer(char mark, String name)
    {
        super(mark, name);
    }

    @Override
    public void makeMove() {
        int randomPos;
        do {
            randomPos = (int) (Math.random() * 9) + 1;
        } while(!isValidMove(randomPos));
        TicTacToe.placeMark(randomPos, this.getMark());
    }
}
