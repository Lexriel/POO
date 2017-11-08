/**
 * Main.java
 *
 */
package goosegame;

public class Main {

    public static void main(String[] args) {
	Board board = ClassicBoard.THE_BOARD;
	Game game = new Game(board);
	game.addPlayer("bilbo");
	game.addPlayer("frodo");
	game.addPlayer("sam");
	game.play();
    }

}// Main

