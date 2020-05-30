package domain.models;

import constants.PieceColor;
import exceptions.InvalidMoveException;

public class Bishop extends Piece {

    public Bishop(PieceColor pieceColor, Cell cell) {
        super(pieceColor, cell);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bishop");
        stringBuilder.append(pieceColor.getValue());
        stringBuilder.append(cell.getCoordinateX());
        stringBuilder.append(cell.getCoordinateY());
        id = stringBuilder.toString();
    }

    @Override
    public void moveToCell(Board board, Cell cell) {
        Cell currentCell = getCurrentCell();
        Integer coordinateX = cell.getCoordinateX();
        Integer coordinateY = cell.getCoordinateY();
        Integer currentX = currentCell.getCoordinateX();
        Integer currentY = currentCell.getCoordinateY();

        if (coordinateX == currentX + 1 || coordinateX == currentX - 1) {
            if (coordinateY == currentY + 1 || coordinateY == currentY - 1) {
                if(board.getCellPieceHashMap().get(cell) != null){
                    if(board.getCellPieceHashMap().get(cell).getPieceColor() != this.getPieceColor()){
                        board.getCellPieceHashMap().get(cell).kill();
                    }else{
                        throw new InvalidMoveException("Illegal Move");
                    }
                }
                board.getCellPieceHashMap().put(cell, this);
                return;
            }
        }
        throw new InvalidMoveException("Illegal Move");
    }
}
