package services;

import domain.models.Cell;
import domain.models.Game;
import domain.models.Piece;

public interface GameService {

    Game setUp();

    Piece findPieceById(String token);

    Cell findCellById(String token);

    void movePieceToCell(Piece piece, Cell cell);
}
