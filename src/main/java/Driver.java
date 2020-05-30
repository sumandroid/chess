import constants.PieceColor;
import controllers.GameController;
import controllers.GameControllerImpl;
import domain.models.Board;
import domain.models.Game;
import domain.models.Player;
import services.GameService;
import services.GameServiceImpl;

import java.util.Scanner;

public class Driver {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player one name");
        String playerOneName = scanner.nextLine();
        System.out.println("Enter player one choice, white or black");
        String playerOneChoice = scanner.nextLine();
        while(!isValidChoice(playerOneChoice)){
            System.out.println("wrong choice, enter valid color ");
            playerOneChoice = scanner.nextLine();
        }
        System.out.println("Enter player two name");
        String playerTwoName = scanner.nextLine();

        Player playerOne = new Player(playerOneName, PieceColor.fromString(playerOneChoice));

        PieceColor pieceColor = playerOne.getPieceColor().equals(PieceColor.BLACK) ?
                PieceColor.WHITE : PieceColor.BLACK;

        Player playerTwo = new Player(playerTwoName, pieceColor);

        System.out.println(playerOneName + " is " + playerOneChoice);
        System.out.println(playerTwoName + " is " + pieceColor.getValue());

        Board board = Board.getInstance();
        Game game = new Game(playerOne, playerTwo, board);

        GameService gameService = new GameServiceImpl(game);
        GameController gameController = new GameControllerImpl(gameService);
        gameController.initGame();

        boolean winnerFound = false;
        int i = 0;
        Player winner = null;
        while(!winnerFound){
            if( i % 2 == 0){
                System.out.println(playerOne.getName() + "turn");
            }else{
                System.out.println(playerTwo.getName() + "turn");
            }
            i++;
            String command = scanner.nextLine();
            gameController.executeCommand(command);
            if (game.getBlackKing().isKilled() || game.getWhiteKing().isKilled()){
                winnerFound = true;
                if(game.getBlackKing().isKilled()){
                    winner = playerOne.getPieceColor().equals(PieceColor.BLACK) ? playerOne : playerTwo;
                }else{
                    winner = playerOne.getPieceColor().equals(PieceColor.WHITE) ? playerOne : playerTwo;
                }
            }
        }

        System.out.println("winner is: " + winner.getName());
    }


    private static boolean isValidChoice(String colorChoice){
        return colorChoice.equalsIgnoreCase(PieceColor.BLACK.toString())
                || colorChoice.equalsIgnoreCase(PieceColor.WHITE.toString());
    }
}
