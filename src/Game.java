package src;

import java.util.*;

public class Game {
	public static void main(String[] args) {
		Scanner Scanner_ = new Scanner(System.in);
		Board BoardForGame = new Board();
		int numberForMoveOrEnd;

		boolean Player1Turn = true; // เพื่อระบุว่าเป็นตาของผู้เล่น 1 ในตอนแรก
		BoardForGame.display();
		System.out.println("Player1's Current Position = " + BoardForGame.player1.position);
		System.out.println("Player2's Current Position = " + BoardForGame.player2.position);

		while (!BoardForGame.gameOver()) {
			if (Player1Turn) {
				Player1Turn = false;
				System.out.println("Player1's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\numberForMoveOrEnd");
				numberForMoveOrEnd = Scanner_.nextInt();
				if (numberForMoveOrEnd == 1) {// ตรวจสอบว่าเป็นตาของผู้เล่น 1 หรือไม่
					// ถ้าใช่ให้ให้ผู้เล่นทำการทอยลูกเต๋าและแสดงบอร์ด
					// หากผู้เล่นเลือกทอยลูกเต๋าให้เรียกเมธอด throwDice ของอ็อบเจ็กต์ BoardForGame
					// และส่งพารามิเตอร์ "player1"

					BoardForGame.display();
					BoardForGame.rollDice("player1");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!\numberForMoveOrEnd");
					Player1Turn = true;
				}
			} else {
				Player1Turn = true;
				System.out.println("Player2's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\numberForMoveOrEnd");
				numberForMoveOrEnd = Scanner_.nextInt();
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