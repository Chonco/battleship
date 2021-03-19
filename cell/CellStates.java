package battleship.cell;

public enum CellStates {
    FOG(0, '~'),
    SHIP_FREE(1, 'O'),
    HIT(2, 'X'),
    MISS(3, 'M');

    private final char sign;
    private final int index;

    CellStates(int index, char sign) {
        this.sign = sign;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public char getSign() {
        return this.sign;
    }

    public static CellStates getState(char sign) {
        for (CellStates state: CellStates.values()) {
            if (state.getSign() == sign) {
                return state;
            }
        }

        return null;
    }

    public static CellStates getStatus(int index) {
        for (CellStates state: CellStates.values()) {
            if (state.getIndex() == index) {
                return state;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.sign + " ";
    }
}
