package domain.models;

public class Game {

    private Player playerOne;
    private Player playerTwo;
    private Board board;
    private Player winner;
    private Piece BlackKing;
    private Piece WhiteKing;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Piece getBlackKing() {
        return BlackKing;
    }

    public void setBlackKing(Piece blackKing) {
        BlackKing = blackKing;
    }

    public Piece getWhiteKing() {
        return WhiteKing;
    }

    public void setWhiteKing(Piece whiteKing) {
        WhiteKing = whiteKing;
    }

    public Game(Player playerOne, Player playerTwo, Board board) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
    }
}
