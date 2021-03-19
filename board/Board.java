package battleship.board;

import battleship.cell.Cell;
import battleship.cell.CellType;
import battleship.cell.CellStates;

import battleship.ships.Ship;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private final int X_SIZE = 10;
    private final int Y_SIZE = 10;

    private ArrayList<Ship> shipsInBoard;
    private Cell[][] board;

    public Board() {
        initBoard();
    }

    public ArrayList<Ship> getShipsInBoard() {
        return this.shipsInBoard;
    }

    private void initBoard() {
        board = new Cell[Y_SIZE][X_SIZE];

        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                board[i][j] = new Cell(j, i);
            }
        }

        this.shipsInBoard = new ArrayList<>();
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder("  ");

        for (int i = 1; i <= 10; i++) {
            sb.append(i + " ");
        }

        sb.append('\n');

        for (int i = 0; i < board.length; i++) {
            sb.append(((char) (65 + i)) + " ");
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    public void initShip(Ship shipModel, Scanner scanner) {
        Point start = new Point();
        Point end = new Point();
        ArrayList<Cell> possibleShipCells;

        System.out.printf("Enter the coordinates of the %s (%d cells)\n",
                shipModel.getName(), shipModel.getSize());

        do {
            readStartEndShip(scanner, start, end);
            possibleShipCells = Ship.getShipCells(start, end, board);
        } while (!validateShip(shipModel.getSize(), possibleShipCells));

        addShipToBoard(shipModel, possibleShipCells);
    }

    private void readStartEndShip(Scanner scanner, Point start, Point end) {
        String[] coordinates = scanner.nextLine().split("\\s+");
        start.setLocation(Board.parseInputToPoint(coordinates[0]));
        end.setLocation(Board.parseInputToPoint(coordinates[1]));
    }

    public static Point parseInputToPoint(String input) {
        int y = Character.toUpperCase(input.charAt(0)) - 'A';
        int x = Integer.parseInt(input.replaceAll("[a-zA-Z]+", "")) - 1;

        return new Point(x, y);
    }

    public boolean validateShip(int shipSize, ArrayList<Cell> possibleShip) {
        Point start = possibleShip.get(0).getCoordinates();
        Point end = possibleShip.get(possibleShip.size() - 1).getCoordinates();

        if (!Validator.isShipInsideBoard(start, end, board)) {
            System.out.println("Error! Wrong location! Try again:");
            return false;
        }

        if (!Validator.validateShipAlignment(start, end)) {
            System.out.println("Error! Wrong location! Try again:");
            return false;
        }

        if (!Validator.validateShipLength(shipSize, start, end)) {
            System.out.println("Error! Wrong length of the Submarine! Try again:");
            return false;
        }

        if (!Validator.isSpaceFree(possibleShip)) {
            System.out.println("Error! You placed it too close to another one! Try again:");
            return false;
        }

        if (Validator.touchesAnotherShip(possibleShip, board)) {
            System.out.println("Error! You placed it too close to another one! Try again:");
            return false;
        }

        return true;
    }

    public void addShipToBoard(Ship toAdd, ArrayList<Cell> shipCells) {
        toAdd.setCellsOfShip(shipCells);
        this.shipsInBoard.add(toAdd);
        registerShipInBoard(shipCells);
    }

    private void registerShipInBoard(ArrayList<Cell> cells) {
        for (Cell cell: cells) {
            cell.setType(CellType.SHIP);

            if (cell.getState() != CellStates.HIT) {
                cell.setState(CellStates.SHIP_FREE);
            }
        }
    }

    public void takeAShot(Scanner scanner) {
        Point coordinates;

        while (true) {
            coordinates = Board.parseInputToPoint(scanner.nextLine());

            if (Validator.isInBoard(coordinates, board)) {
                break;
            }

            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }

        Ship shipFired = registerShotInBoard(coordinates);

        if (lose()) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            return;
        }

        if (shipFired == null) {
            System.out.println("You missed!");
            return;
        }

        if (!shipFired.isAlive()) {
            System.out.println("You sank a ship!");
            return;
        }

        System.out.println("You hit a ship!");
    }

    public Ship registerShotInBoard(Point shot) {
        for (Ship ship: shipsInBoard) {
            if (ship.contains(shot)) {
                if (board[shot.y][shot.x].getState() != CellStates.HIT) {
                    ship.shipFired();
                    board[shot.y][shot.x].setState(CellStates.HIT);
                    return ship;
                }

                return null;
            }
        }

        board[shot.y][shot.x].setState(CellStates.MISS);
        return null;
    }

    public void showAllShips() {
        for (Ship ship: shipsInBoard) {
            registerShipInBoard(ship.getCellsOfShip());
        }
    }

    public void hideShips() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getState() == CellStates.SHIP_FREE) {
                    board[i][j].setState(CellStates.FOG);
                }
            }
        }
    }

    public boolean lose() {
        ArrayList<Ship> shipsInBoard = getShipsInBoard();

        for (Ship ship: shipsInBoard) {
            if (ship.isAlive()) {
                return false;
            }
        }

        return true;
    }


}
