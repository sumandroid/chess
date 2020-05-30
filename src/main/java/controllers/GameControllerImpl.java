package controllers;

import domain.models.Cell;
import domain.models.Game;
import domain.models.Piece;
import exceptions.PieceNotFoundException;
import services.GameService;

public class GameControllerImpl implements GameController {

    private GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void initGame() {
        gameService.setUp();
    }

    @Override
    public void executeCommand(String command) {
        String[] tokens = command.split(" ");
        Piece piece = gameService.findPieceById(tokens[0]);
        if (piece == null) {
            throw new PieceNotFoundException("Piece not found with id" + tokens[0]);
        }
        Cell cell = gameService.findCellById(tokens[1]);
        if (cell == null) {
            throw new RuntimeException("Invalid cell");
        }
        gameService.movePieceToCell(piece, cell);
    }
}
