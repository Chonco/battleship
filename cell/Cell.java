package battleship.cell;

import java.awt.*;

public class Cell {
    private CellType type;
    private CellStates state;
    private Point coordinates;

    public Cell(Point coordinates) {
        this.coordinates = coordinates;
        this.type = CellType.SEA;
        this.state = CellStates.FOG;
    }

    public Cell(int x, int y) {
        this(new Point(x, y));
    }

    public CellType getType() {
        return this.type;
    }
    public void setType(CellType type) {
        this.type = type;
    }

    public CellStates getState() {
        return this.state;
    }
    public void setState(CellStates state) {
        this.state = state;
    }

    public Point getCoordinates() {
        return this.coordinates;
    }
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
