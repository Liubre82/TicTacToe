public class PlayerFactory {

    private Player player;

    public PlayerFactory(){};
    public PlayerFactory(String playerType, char mark, String name) {
        if (playerType.equals("person")) {
            player = new HumanPlayer(mark, name);
        } else if (playerType.equals("computer")) {
            player = new AIPlayer(mark, name);
        }
    }

    public Player getPlayer() {
        return player;
    }
}
