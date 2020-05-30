package domain.models;

import constants.PieceColor;

import java.util.HashMap;

public class Queen extends Piece{

    public Queen(PieceColor pieceColor, Cell cell){
        super(pieceColor, cell);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queen");
        stringBuilder.append(pieceColor.getValue());
        stringBuilder.append(cell.getCoordinateX());
        stringBuilder.append(cell.getCoordinateY());
        id = stringBuilder.toString();
    }

    @Override
    public void moveToCell(Board board, Cell cell) {
        //TODO implement move method;
    }
}
