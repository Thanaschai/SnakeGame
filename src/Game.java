package src;

import java.util.*;

public class Game {
	public static void main(String[] args) {
		Scanner ScannerNumber = new Scanner(System.in);
		Board BoardForGame = new Board();
		int numberForMoveOrEnd;

		boolean Player1Turn = true;
		BoardForGame.display();
		System.out.println("Player1's Current Position = " + BoardForGame.player1.position);
		System.out.println("Player2's Current Position = " + BoardForGame.player2.position);

		while (!BoardForGame.WhoTheWinner()) {

			if (Player1Turn) {
				Player1Turn = false;
				System.out.println("Player1's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\nnumberForMoveOrEnd ");
				numberForMoveOrEnd = ScannerNumber.nextInt();

				if (numberForMoveOrEnd == 1) {
					BoardForGame.display();
					BoardForGame.rollDice("player1");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!\nnumberForMoveOrEnd ");
					Player1Turn = true;
				}
			} else {
				Player1Turn = true;
				System.out.println("Player2's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\nnumberForMoveOrEnd ");
				numberForMoveOrEnd = ScannerNumber.nextInt();

				if (numberForMoveOrEnd == 1) {
					BoardForGame.display();
					BoardForGame.rollDice("player2");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);// .exit เพื่อออกจากเกม
				} else {
					System.out.println("Invalid Response!");
					Player1Turn = false;
				}
			}
		}
	}
}