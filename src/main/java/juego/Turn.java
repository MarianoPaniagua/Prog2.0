package juego;

public class Turn {

    private Player playerWithTurn;
    private Player playerWithSecondTurn;

    public Turn(Player playerWithTurn) {
        this.playerWithTurn = playerWithTurn;
    }

    public Player getPlayerWithTurn() {
        return playerWithTurn;
    }

    public void setPlayerWithTurn(Player playerWithTurn) {
        this.playerWithTurn = playerWithTurn;
    }

    public Player getPlayerWithSecondTurn() {
        return playerWithSecondTurn;
    }

    public void setPlayerWithSecondTurn(Player playerWithSecondTurn) {
        this.playerWithSecondTurn = playerWithSecondTurn;
    }
}
