package battleship.ships;

public enum ShipsTypes {
    AIRCRAFT("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    private final String name;
    private final int size;

    ShipsTypes(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public ShipsTypes getShip(int size) {
        for (ShipsTypes ship: ShipsTypes.values()) {
            if (ship.getSize() == size) {
                return ship;
            }
        }

        return null;
    }

    public ShipsTypes getShip(String name) {
        for (ShipsTypes ship: ShipsTypes.values()) {
            if (ship.getName().equals(name)) {
                return ship;
            }
        }

        return null;
    }
}
