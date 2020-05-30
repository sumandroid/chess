package domain.models;

import constants.PieceColor;
import exceptions.InvalidMoveException;

import java.util.HashMap;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor, Cell cell){
        super(pieceColor, cell);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pawn");
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
        if (isValidMove(coordinateX, coordinateY, currentX, currentY, board, cell)) {
            if (board.getCellPieceHashMap().get(cell) != null) {
                if (board.getCellPieceHashMap().get(cell).getPieceColor() != this.getPieceColor()) {
                    board.getCellPieceHashMap().get(cell).kill();
                } else {
                    throw new InvalidMoveException("Illegal Move");
                }
            }
            board.getCellPieceHashMap().put(cell, this);
            return;
        }
        throw new InvalidMoveException();
    }

    private boolean isValidMove(int coordinateX, int coordinateY, int currentX, int currentY, Board board, Cell cell) {
        //TODO consider color as well in the if else conditions
        if (currentX == 1 && coordinateX == currentX + 2 && coordinateY == currentY && board.getCellPieceHashMap().get(cell) == null) {
            return true;
        } else if (currentX == 6 && coordinateX == currentX - 2 && coordinateY == currentY && board.getCellPieceHashMap().get(cell) == null) {
            return true;
        } else if (coordinateX == currentX - 1 && coordinateY == currentY && board.getCellPieceHashMap().get(cell) == null) {
            return true;
        } else if (coordinateX == currentX + 1 && coordinateY == currentY && board.getCellPieceHashMap().get(cell) == null) {
            return true;
        } else if (coordinateX == currentX - 1 && coordinateY == currentY + 1 && board.getCellPieceHashMap().get(cell) != null) {
            return true;
        } else if (coordinateX == currentX - 1 && coordinateY == currentY - 1 && board.getCellPieceHashMap().get(cell) != null) {
            return true;
        } else if (coordinateX == currentX + 1 && coordinateY == currentY - 1 && board.getCellPieceHashMap().get(cell) != null) {
            return true;
        } else if (coordinateX == currentX + 1 && coordinateY == currentY + 1 && board.getCellPieceHashMap().get(cell) != null) {
            return true;
        } else {
            return false;
        }
    }
}
