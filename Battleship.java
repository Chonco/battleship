package battleship;

import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);
        userInterface.start();
    }
}
