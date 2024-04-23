package Snake_Ladder;

import java.util.*;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Scanner เป็นคลาสที่ใช้ในการอ่านข้อมูลจากแหล่งต่างๆ เช่น คีย์บอร์ด (keyboard),
		// ไฟล์ข้อความ, หรือสตรีมข้อมูลอื่นๆ
		Board B = new Board();
		int n;
		// int n เป็นตัวแปรที่ใช้เก็บค่าที่ผู้เล่นป้อนผ่านทางคีย์บอร์ด
		// ซึ่งจะถูกใช้ในการเลือกทอยลูกเต๋าหรือออกจากเกมในแต่ละรอบของเกมงูและบันไดที่ระบบแสดงให้ผู้เล่น
		// โดยค่าที่เป็นไปได้สำหรับตัวแปรนี้มีคือ 0 และ 1 เมื่อผู้เล่นป้อนค่า 1
		// จะแสดงว่าผู้เล่นต้องการทอยลูกเต๋า และเมื่อผู้เล่นป้อนค่า 0
		// จะแสดงว่าผู้เล่นต้องการออกจากเกม

		boolean Player1Turn = true; // เพื่อระบุว่าเป็นตาของผู้เล่น 1 ในตอนแรก
		B.display();
		System.out.println("Player1's Current Position = " + B.player1.position);
		System.out.println("Player2's Current Position = " + B.player2.position);// แสดงบอร์ดเริ่มต้นของเกมและตำแหน่งปัจจุบันของทั้งสองผู้เล่น

		while (!B.gameOver()) {// เริ่มลูป while โดยตรวจสอบว่าเกมจบแล้วหรือไม่ ถ้ายังไม่จบก็ทำขั้นตอนด้านในลูป

			if (Player1Turn) {
				Player1Turn = false;
				System.out.println("Player1's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\n");
				n = sc.nextInt();
				if (n == 1) {// ตรวจสอบว่าเป็นตาของผู้เล่น 1 หรือไม่
								// ถ้าใช่ให้ให้ผู้เล่นทำการทอยลูกเต๋าและแสดงบอร์ด
								// หากผู้เล่นเลือกทอยลูกเต๋าให้เรียกเมธอด throwDice ของอ็อบเจ็กต์ B
								// และส่งพารามิเตอร์ "player1"

					B.display();
					B.throwDice("player1");
				} else if (n == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!\n");
					Player1Turn = true;
				}
			} else {
				Player1Turn = true;
				System.out.println("Player2's Turn");
				System.out.println("To throw dice Enter 1\nTo quit game Enter 0\n");
				n = sc.nextInt();
				if (n == 1) {
					B.display();
					B.throwDice("player2");
				} else if (n == 0) {
					System.exit(0);// .exit เพื่อออกจากเกม
				} else {
					System.out.println("Invalid Response!");
					Player1Turn = false;
				}
			}
		}
	}
}