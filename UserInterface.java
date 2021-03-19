package battleship;

import battleship.board.Board;
import battleship.ships.Ship;
import battleship.ships.ShipsTypes;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Board player_1;
    private final Board player_2;

    UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.player_1 = new Board();
        this.player_2 = new Board();
    }

    public void start() {
        prepareGame();
        game();
    }

    private void prepareGame() {
        player_1.printBoard();
        initShipsOfPlayer(player_1);
        changeTurn();

        player_2.printBoard();
        initShipsOfPlayer(player_2);
        changeTurn();
    }

    private void initShipsOfPlayer(Board player) {
        for(ShipsTypes shipType: ShipsTypes.values()) {
            player.initShip(new Ship(shipType), scanner);
            player.printBoard();
        }

        player.hideShips();
    }

    private void changeTurn() {
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
    }

    private void game() {
        int turn = 0;
        while (!player_1.lose() && !player_2.lose()) {
            if (turn % 2 == 0) {
                printBothBoards(player_2, player_1);
                System.out.println("Player 1, it's your turn:");
                player_2.takeAShot(scanner);
            } else {
                printBothBoards(player_1, player_2);
                System.out.println("Player 2, it's your turn:");
                player_1.takeAShot(scanner);
            }

            changeTurn();
            turn++;
        }
    }
    
    private void printBothBoards(Board above, Board under) {
        printBoardWithoutShips(above);
        System.out.println("---------------------");
        printBoardWithShips(under);
    }

    private void printBoardWithoutShips(Board player) {
        player.hideShips();
        player.printBoard();
    }

    private void printBoardWithShips(Board player) {
        player.showAllShips();
        player.printBoard();
    }
}
