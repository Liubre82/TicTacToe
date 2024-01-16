package com.players;

public class PlayerFactory {

    private Player player;

    //instantiate an obj of Player depending on the playerType.(dynamic polymorphism)
    public PlayerFactory(String playerType, char mark, String name) {
        if (playerType.equals("person")) {
            player = new HumanPlayer(mark, name);
        } else if (playerType.equals("computer")) {
            player = new AIPlayer(mark, name);
        }
    }

    //returns the player obj reference.
    public Player getPlayer() {
        return player;
    }
}
