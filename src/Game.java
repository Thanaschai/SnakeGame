package src;

import java.util.*;

public class Game {

	public static void main(String[] args) {
		//TODO : ปรับชื่อตัวแปรตัวหน้าเป็นตัวเล็ก
		Scanner ScannerNumber = new Scanner(System.in);
		Board BoardForGame = new Board();
		int numberForMoveOrEnd;
		boolean PlayerIn1Turn = true;

		BoardForGame.display();
		System.out.println("Player1's Current Position = " + BoardForGame.player1.position);
		System.out.println("Player2's Current Position = " + BoardForGame.player2.position);

		//TODO : เปลี่ยนชื่อ "ทุกคนชนะหรือยังนะ"
		//TODO : แก้ส่วนที่เหมือนกัน
		while (!BoardForGame.WhoTheWinner()) {
			if (PlayerIn1Turn) {
				PlayerIn1Turn = false;
				System.out.println("Player1's Turn");
				System.out.println("To roll dice Enter 1\nTo quit game Enter 0\nnumberForMoveOrEnd ");
				numberForMoveOrEnd = ScannerNumber.nextInt();

				if (numberForMoveOrEnd == 1) {
					BoardForGame.display();
					BoardForGame.rollDice("player1");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!\nnumberForMoveOrEnd ");
					PlayerIn1Turn = true;
				}
			} else {
				PlayerIn1Turn = true;
				System.out.println("Player2's Turn");
				System.out.println("To roll dice Enter 1\nTo quit game Enter 0\nnumberForMoveOrEnd ");
				numberForMoveOrEnd = ScannerNumber.nextInt();

				if (numberForMoveOrEnd == 1) {
					BoardForGame.display();
					BoardForGame.rollDice("player2");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!");
					PlayerIn1Turn = false;
				}
			}
		}
	}
}