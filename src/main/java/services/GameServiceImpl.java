package services;

import constants.PieceColor;
import domain.models.*;

import java.util.Optional;

public class GameServiceImpl implements GameService {

    private Game game;

    public GameServiceImpl(Game game){
        this.game = game;
    }

    @Override
    public Game setUp() {
        Board board = game.getBoard();
        setUpPawns(board);
        setUpBishop(board);
        setUpCamels(board);
        setUpHorses(board);
        setUpKings(board);
        setUpQueens(board);
        setUpEmptyCells(board);
        return game;
    }

    @Override
    public Piece findPieceById(String id){
        Board board = game.getBoard();
        return board.getIdToPieceMap().get(id);
    }

    @Override
    public Cell findCellById(String cellId) {
       Optional<Cell> optionalCell =  game.getBoard().getCellPieceHashMap().keySet()
                .stream().filter(c -> c.getId().equals(cellId)).findFirst();
       return optionalCell.get();
    }

    @Override
    public void movePieceToCell(Piece piece, Cell cell) {
        piece.moveToCell(game.getBoard(), cell);
    }

    private void setUpPawns(Board board){
        for(int i = 0; i <= 7; i++){
            Cell cell = new Cell(1, i);
            Pawn pawn = new Pawn(PieceColor.BLACK, cell);
            board.putToCellToHashMap(cell, pawn);
            board.putToIdToPieceMap(pawn.getId(), pawn);
        }
        for(int i = 0; i <= 7; i++){
            Cell cell = new Cell(6, i);
            Pawn pawn = new Pawn(PieceColor.WHITE, cell);
            board.putToCellToHashMap(cell, pawn);
            board.putToIdToPieceMap(pawn.getId(), pawn);
        }
    }

    private void setUpBishop(Board board){

        Cell topLeft = new Cell(0,0);
        Cell topRight = new Cell(0, 7);
        Bishop leftBlackBishop = new Bishop(PieceColor.BLACK, topLeft);
        Bishop rightBlackBishop = new Bishop(PieceColor.BLACK, topRight);
        board.putToCellToHashMap(topLeft, leftBlackBishop);
        board.putToCellToHashMap(topRight, rightBlackBishop);
        board.putToIdToPieceMap(leftBlackBishop.getId(), leftBlackBishop);
        board.putToIdToPieceMap(rightBlackBishop.getId(), rightBlackBishop);

        Cell bottomLeft = new Cell(7,0);
        Cell bottomRight = new Cell(7, 7);
        Bishop leftWhiteBishop = new Bishop(PieceColor.WHITE, bottomLeft);
        Bishop rightWhiteBishop = new Bishop(PieceColor.WHITE, bottomRight);
        board.putToCellToHashMap(bottomLeft, leftWhiteBishop);
        board.putToCellToHashMap(bottomRight, rightWhiteBishop);
        board.putToIdToPieceMap(leftWhiteBishop.getId(), leftWhiteBishop);
        board.putToIdToPieceMap(rightWhiteBishop.getId(), rightWhiteBishop);

    }

    private void setUpHorses(Board board){
        Cell topLeft = new Cell(0,1);
        Cell topRight = new Cell(0, 6);
        Horse leftBlackHorse = new Horse(PieceColor.BLACK, topLeft);
        Horse rightBlackHorse = new Horse(PieceColor.BLACK, topRight);
        board.putToCellToHashMap(topLeft, leftBlackHorse);
        board.putToCellToHashMap(topRight, rightBlackHorse);
        board.putToIdToPieceMap(leftBlackHorse.getId(), leftBlackHorse);
        board.putToIdToPieceMap(rightBlackHorse.getId(), rightBlackHorse);

        Cell bottomLeft = new Cell(7,1);
        Cell bottomRight = new Cell(7, 6);
        Horse leftWhiteHorse = new Horse(PieceColor.WHITE, bottomLeft);
        Horse rightWhiteHorse = new Horse(PieceColor.WHITE, bottomRight);
        board.putToCellToHashMap(bottomLeft, leftWhiteHorse);
        board.putToCellToHashMap(bottomRight, rightWhiteHorse);
        board.putToIdToPieceMap(leftWhiteHorse.getId(), leftWhiteHorse);
        board.putToIdToPieceMap(rightWhiteHorse.getId(), rightWhiteHorse);
    }

    private void setUpCamels(Board board){
        Cell topLeft = new Cell(0,2);
        Cell topRight = new Cell(0, 5);
        Camel leftBlackCamel = new Camel(PieceColor.BLACK, topLeft);
        Camel rightBlackCamel = new Camel(PieceColor.BLACK, topRight);
        board.putToCellToHashMap(topLeft, leftBlackCamel);
        board.putToCellToHashMap(topRight, rightBlackCamel);
        board.putToIdToPieceMap(leftBlackCamel.getId(), leftBlackCamel);
        board.putToIdToPieceMap(rightBlackCamel.getId(), rightBlackCamel);

        Cell bottomLeft = new Cell(7,2);
        Cell bottomRight = new Cell(7, 5);
        Camel leftWhiteCamel = new Camel(PieceColor.WHITE, bottomLeft);
        Camel rightWhiteCamel = new Camel(PieceColor.WHITE, bottomRight);
        board.putToCellToHashMap(bottomLeft, leftWhiteCamel);
        board.putToCellToHashMap(bottomRight, rightWhiteCamel);
        board.putToIdToPieceMap(leftWhiteCamel.getId(), leftWhiteCamel);
        board.putToIdToPieceMap(leftWhiteCamel.getId(), leftWhiteCamel);
    }

    private void setUpKings(Board board){
        Cell topKingCell = new Cell(0, 3);
        King blackKing = new King(PieceColor.BLACK, topKingCell);
        board.putToCellToHashMap(topKingCell, blackKing);
        board.putToIdToPieceMap(blackKing.getId(), blackKing);
        game.setBlackKing(blackKing);

        Cell bottomKingCell = new Cell(7, 3);
        King whiteKing = new King(PieceColor.WHITE, bottomKingCell);
        board.putToCellToHashMap(bottomKingCell, whiteKing);
        board.putToIdToPieceMap(whiteKing.getId(), whiteKing);
        game.setWhiteKing(whiteKing);
    }

    private void setUpQueens(Board board){
        Cell blackQueenCell = new Cell(0, 4);
        Queen blackQueen = new Queen(PieceColor.BLACK, blackQueenCell);
        board.putToCellToHashMap(blackQueenCell, blackQueen);
        board.putToIdToPieceMap(blackQueen.getId(), blackQueen);

        Cell whiteQueenCell = new Cell(7, 4);
        Queen whiteQueen = new Queen(PieceColor.WHITE, whiteQueenCell);
        board.putToCellToHashMap(whiteQueenCell, whiteQueen);
        board.putToIdToPieceMap(whiteQueen.getId(), whiteQueen);
    }

    private void setUpEmptyCells(Board board){
        for(int i = 2; i <= 5; i++){
            for(int j = 0; j <= 7; j++){
                Cell cell = new Cell(i, j);
                board.putToCellToHashMap(cell, null);
            }
        }
    }




}
