public class AIPlayer extends Player{

    public AIPlayer(char mark, String name) {
        super(mark, name);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public boolean isValidMove(int pos) {
        return false;
    }
}
