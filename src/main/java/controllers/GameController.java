package controllers;

import domain.models.Game;

public interface GameController {

    void initGame();

    void executeCommand(String command);
}
