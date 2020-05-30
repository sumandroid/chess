package domain.models;

import java.util.*;

public class Board {

    private static Board board;
    private HashMap<Cell, Piece> cellPieceHashMap;
    private HashMap<String, Piece> idToPieceMap;

    private Board(){
        cellPieceHashMap = new HashMap<>();
        idToPieceMap = new HashMap<>();
    }

    public static Board getInstance(){
        if(board == null){
            synchronized (Board.class) {
                if(board == null){
                    board = new Board();
                }
            }
        }
        return board;
    }

    public HashMap<Cell, Piece> getCellPieceHashMap() {
        return cellPieceHashMap;
    }

    public HashMap<String, Piece> getIdToPieceMap() {
        return idToPieceMap;
    }

    public void putToCellToHashMap(Cell cell, Piece piece){
        cellPieceHashMap.put(cell, piece);
    }

    public void putToIdToPieceMap(String id, Piece piece){
        idToPieceMap.put(id, piece);
    }
}
