package domain.models;

import constants.PieceColor;
import exceptions.InvalidMoveException;

import java.util.HashMap;

public class Horse extends Piece {

    public Horse(PieceColor pieceColor, Cell cell) {
        super(pieceColor, cell);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Horse");
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
        if (isValidMove(coordinateX, coordinateY, currentX, currentY)) {
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
        throw new InvalidMoveException();
    }

    private boolean isValidMove(int coordinateX, int coordinateY, int currentX, int currentY) {
        if (coordinateX == currentX - 2 && coordinateY == currentY + 1) {
            return true;
        } else if (coordinateX == currentX - 1 && coordinateY == currentY + 2) {
            return true;
        } else if (coordinateX == currentX + 1 && coordinateY == currentY + 2){
            return true;
        } else if (coordinateX == currentX - 2 && coordinateY == currentY -1){
            return true;
        } else if (coordinateX == currentX - 1 && coordinateY == currentY - 2){
            return  true;
        } else if (coordinateX == currentX + 1 && coordinateY == currentY - 2){
            return true;
        } else if (coordinateX == currentX + 2 && coordinateY == currentY - 1){
            return true;
        } else if (coordinateX == currentX + 2 && coordinateY == currentY + 1){
            return true;
        } else{
            return false;
        }
    }
}
