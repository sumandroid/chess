package domain.models;

import constants.PieceColor;

public abstract class Piece {

    private PieceColor pieceColor;
    private boolean killed;
    private Cell cell;
    protected String id;

    public Piece(PieceColor pieceColor, Cell cell) {
        this.cell = cell;
        this.pieceColor = pieceColor;

    }

    public String getId() {
        return id;
    }

    public void kill(){
        this.killed = true;
    }

    public boolean isKilled(){
        return killed;
    }

    public Cell getCurrentCell(){
        return cell;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public abstract void moveToCell(Board board, Cell cell);
}
