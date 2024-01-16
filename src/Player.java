public abstract class Player {

    private char mark;

    private String name;

    public Player(char mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    abstract void makeMove();

    abstract void isValidMove();

    public char getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }
}
