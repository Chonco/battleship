package battleship.ships;

import battleship.cell.Cell;

import java.awt.Point;
import java.util.ArrayList;

public class Ship {
    private final ShipsTypes shipType;
    private boolean alive;
    private ArrayList<Cell> cellsOfShip;

    private int impactsReceived;

    public Ship(ShipsTypes shipType) {
        this.shipType = shipType;

        this.cellsOfShip = null;
        this.impactsReceived = 0;
        this.alive = true;
    }

    public String getName() {
        return this.shipType.getName();
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getSize() {
        return this.shipType.getSize();
    }

    public void setCellsOfShip(ArrayList<Cell> cellsOfShip) {
        this.cellsOfShip = cellsOfShip;
    }

    public ArrayList<Cell> getCellsOfShip() {
        return this.cellsOfShip;
    }

    public boolean contains(Point coordinates) {
        for (Cell cell: cellsOfShip) {
            if (cell.getCoordinates().equals(coordinates)) {
                return true;
            }
        }

        return false;
    }

    public void shipFired() {
        impactsReceived++;

        if (impactsReceived == this.shipType.getSize()) {
            alive = false;
        }
    }

    public static ArrayList<Cell> getShipCells(Point start, Point end, Cell[][] board) {
        ArrayList<Cell> shipCells = new ArrayList<>();
        if (start.x == end.x) {
            if (start.y < end.y) {
                for (int i = start.y; i <= end.y; i++) {
                    shipCells.add(board[i][start.x]);
                }
            } else {
                for (int i = end.y; i <= start.y; i++) {
                    shipCells.add(board[i][start.x]);
                }
            }
        } else {
            if (start.x < end.x) {
                for (int i = start.x; i <= end.x; i++) {
                    shipCells.add(board[start.y][i]);
                }
            } else {
                for (int i = end.x; i <= start.x; i++) {
                    shipCells.add(board[start.y][i]);
                }
            }
        }

        return shipCells;
    }

}
