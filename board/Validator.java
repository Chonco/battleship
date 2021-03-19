package battleship.board;

import battleship.cell.CellStates;
import battleship.cell.Cell;

import java.awt.Point;
import java.util.ArrayList;

public class Validator {

    public static boolean validateShipAlignment(Point start, Point end) {
        if (start.getX() == end.getX()) {
            return start.getY() != end.getY();
        }

        return start.getY() == end.getY();
    }

    public static boolean validateShipLength(int shipSize, Point start, Point end) {
        return start.distance(end) + 1 == shipSize;
    }

    public static boolean isShipInsideBoard(Point start, Point end, Cell[][] board) {
        return isInBoard(start, board) && isInBoard(end, board);
    }

    public static boolean isInBoard(Point coordinates, Cell[][] board) {
        if (coordinates.x < 0 || coordinates.y < 0) {
            return false;
        }

        if (coordinates.x >= board[0].length || coordinates.y >= board.length) {
            return false;
        }

        return true;
    }

    public static boolean isSpaceFree(ArrayList<Cell> shipCells) {
        for (Cell cell: shipCells) {
            if (cell.getState() != CellStates.FOG) {
                return false;
            }
        }

        return true;
    }

    public static boolean touchesAnotherShip(ArrayList<Cell> shipCells, Cell[][] board) {
        for (Cell cell: shipCells) {
            if (shipCellTouchesAnotherShipCell(cell, board)) {
                return true;
            }
        }

        return false;
    }

    private static boolean shipCellTouchesAnotherShipCell(Cell cell, Cell[][] board) {
        int y = cell.getCoordinates().y;
        int x = cell.getCoordinates().x;

        try {
            if (board[y - 1][x - 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y - 1][x].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y - 1][x + 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y][x + 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y + 1][x + 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y + 1][x].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y + 1][x - 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        try {
            if (board[y][x - 1].getState() != CellStates.FOG) {
                return true;
            }
        } catch (IndexOutOfBoundsException ignored) { }

        return false;
    }
}
