package src;

public class Board {

	private Tile[][] tile = new Tile[10][10];
	Player player1;
	Player player2;
	Dice dice;

	/**
	 * 
	 */
	public Board() // เป็นเมทอดที่ถูกเรียกเมื่อสร้างอ็อบเจกต์ของคลาส Board
					// โดยในเมทอดนี้จะมีการสร้างและกำหนดค่าเริ่มต้นให้กับกริดของกระดานเกม
					// รวมถึงสร้างและตั้งค่าตำแหน่งของงูและบันได
	{
		// loop เพื่อสร้างตาราง 100 - 90 --> มีแค่ 10 ตัวต่อแถว
		// กำหนด cell เป็นตัวเริ่ม ว่าให้เริ่มที่เท่าไหร่
		// null ว่างไว้เพราะไม่มีอะไร
		int cell = 100;

		for (int col = 0; col <= 9; col++) {
			tile[0][col] = new Tile(cell, null, null);
			cell = cell - 1;
		}

		cell = 81;

		for (int col = 0; col <= 9; col++) {
			tile[1][col] = new Tile(cell, null, null);
			cell = cell + 1;
		}

		cell = 80;

		for (int col = 0; col <= 9; col++) {
			tile[2][col] = new Tile(cell, null, null);
			cell = cell - 1;
		}

		cell = 61;

		for (int col = 0; col <= 9; col++) {
			tile[3][col] = new Tile(cell, null, null);
			cell = cell + 1;
		}

		cell = 60;

		for (int col = 0; col <= 9; col++) {
			tile[4][col] = new Tile(cell, null, null);
			cell = cell - 1;
		}

		cell = 41;

		for (int col = 0; col <= 9; col++) {
			tile[5][col] = new Tile(cell, null, null);
			cell = cell + 1;
		}

		cell = 40;

		for (int col = 0; col <= 9; col++) {
			tile[6][col] = new Tile(cell, null, null);
			cell = cell - 1;
		}

		cell = 21;

		for (int col = 0; col <= 9; col++) {
			tile[7][col] = new Tile(cell, null, null);
			cell = cell + 1;
		}

		cell = 20;

		for (int col = 0; col <= 9; col++) {
			tile[8][col] = new Tile(cell, null, null);
			cell = cell - 1;
		}

		cell = 1;

		for (int col = 0; col <= 9; col++) {
			tile[9][col] = new Tile(cell, null, null);
			cell = cell + 1;
		}

		// สร้าง player ซึ่งกำหนดไว้แค่ 2 คน
		Player player1 = new Player(1);
		this.player1 = player1;

		Player player2 = new Player(1);
		this.player2 = player2;

		// Snake สร้าง หัวกับหางงู ซึ่งเลขหัวจะมากกว่าเลขหาง
		Snake snake1 = new Snake(17, 7);
		tile[8][3].snake = snake1;

		Snake snake2 = new Snake(64, 60);
		tile[3][3].snake = snake2;

		Snake snake3 = new Snake(89, 26);
		tile[1][8].snake = snake3;

		Snake snake4 = new Snake(95, 75);
		tile[0][5].snake = snake4;

		Snake snake5 = new Snake(99, 78);
		tile[0][1].snake = snake5;

		// สร้างบรรได ซึ่งทางขึ้นจะมาก่อนทางโพล่
		Ladder ladder1 = new Ladder(4, 14);
		tile[9][3].ladder = ladder1;

		Ladder ladder2 = new Ladder(20, 38);
		tile[8][0].ladder = ladder2;

		Ladder ladder3 = new Ladder(28, 84);
		tile[7][7].ladder = ladder3;

		Ladder ladder4 = new Ladder(51, 67);
		tile[4][9].ladder = ladder4;

		Ladder ladder5 = new Ladder(63, 81);
		tile[3][2].ladder = ladder5;

		Dice dice = new Dice();
		this.dice = dice;
	}

	public void display() { // ทำหน้าที่แสดงกระดานเกมในรูปแบบของตาราง โดยแสดงตำแหน่งของบันไดด้วยเครื่องหมาย
							// '=' และตำแหน่งของงูด้วยเครื่องหมาย '*' และแสดงตำแหน่งต่าง ๆ ของเกมบนกระดาน
		System.out.println("'=' stands for Ladder's foot");
		System.out.println("'*' stands for Snake's Mouth");
		System.out.println("");

		for (int rows = 0; rows < 10; rows++) {
			for (int columns = 0; columns < 10; columns++) {
				if (tile[rows][columns].snake == null && tile[rows][columns].ladder == null) {
					if (tile[rows][columns].value == 100)
						System.out.print(tile[rows][columns].value + " "); // 100 99
					else if (tile[rows][columns].value >= 11 && tile[rows][columns].value <= 99)
						System.out.print(tile[rows][columns].value + "  ");// 99 98
					else if (tile[rows][0].value == 1)
						System.out.print(tile[rows][columns].value + "   ");// 1 2 3
				} else if (tile[rows][columns].snake == null && tile[rows][columns].ladder != null) {
					System.out.print("=   "); // print ladder
				} else if (tile[rows][columns].snake != null && tile[rows][columns].ladder == null) {
					System.out.print("*   "); // print Snake
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public boolean gameOver() { // ทำหน้าที่ตรวจสอบว่าเกมจบแล้วหรือไม่ โดยเช็คว่าตำแหน่งปัจจุบันของผู้เล่น 1
								// หรือ 2 มีค่าเท่ากับ 100 หรือไม่
								// ถ้าใช่ก็จะแสดงข้อความแจ้งเตือนว่าผู้เล่นที่ชนะเกมคือใคร
		if (this.player1.position == 100) {
			System.out.println("Congrats! Player1 won!");
			return true;
		} else if (this.player2.position == 100) {
			System.out.println("Congrats! Player2 won!");
			return true;
		} else {
			return false;
		}
	}

	public void rollDice(String player) {// ทำหน้าที่สุ่มค่าลูกเต๋า และเลื่อนตำแหน่งของผู้เล่นที่ระบุ (player1 หรือ
											// player2) ตามค่าที่สุ่มได้
											// และตรวจสอบว่าตำแหน่งใหม่ของผู้เล่นนั้นต้องการให้ย้ายไปยังบันไดหรืองูหรือไม่
											// และแสดงข้อความตามผลลัพธ์ของการเคลื่อนที่
		int d_value = dice.getDiceValue();
		System.out.println("Random Dice Value generated = " + d_value);
		System.out.println("");

		if (player.equals("player1")) {
			int temp = this.player1.position; // temp ให้เป็นตำแหน่งปัจจุบัน
			if (this.player1.position + d_value > 100) { // move position dice มากกว่า 100 ให้อยู่ในตำแหน่งเดิมครับ
				temp = this.player1.position; // ตำแหน่งเดิม
			} else {
				temp = this.player1.position + d_value; // ถ้าไม่เกินก็สามารถเดินตามที่ dice ได้
			}

			int rows = iIndexOfTile(temp); // แถว row
			int columns = jIndexOfTile(temp); // หลัก col
			if ((tile[rows][columns].ladder == null) && (tile[rows][columns].snake == null)) {
				if ((this.player1.position + d_value) <= 100)
					this.player1.position = this.player1.position + d_value; // ถ้ามากกว่า 100 ให้อยู่ตำแหน่งเดิม
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[rows][columns].ladder != null) && (tile[rows][columns].snake == null)) { // ขึ้นบันได
				System.out.println("Congrats Player1 You Got Ladder");
				this.player1.position = tile[rows][columns].ladder.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[rows][columns].ladder == null) && (tile[rows][columns].snake != null)) { // โดนงู
				System.out.println("Oops! Player1 You Got Snake Bite!");
				this.player1.position = tile[rows][columns].snake.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position); // ปริ้นตำแหน่ง
				System.out.println("Player2's Current Position = " + this.player2.position); // ปริ้นตำแหน่ง
			}
		} else if (player.equals("player2")) {
			int temp = this.player2.position;
			if (this.player2.position + d_value > 100) { // ตรวจสอบว่า player 2 ถ้ามีการเคลื่อนที่จะเกินตำแหน่งที่ 100
															// หรือไม่
				temp = this.player2.position;
			} else {
				temp = this.player2.position + d_value;
			}

			int rows = iIndexOfTile(temp);
			int columns = jIndexOfTile(temp);
			if ((tile[rows][columns].ladder == null) && (tile[rows][columns].snake == null)) {
				// ไม่มีบันไดหรืองูที่อยู่ใน tile นั้น ๆ ดังนั้นเราใช้ "null"
				// เพื่อบ่งบอกว่าไม่มีบันไดหรืองูในตำแหน่งนั้น ๆ
				if ((this.player2.position + d_value) <= 100)
					this.player2.position = this.player2.position + d_value;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[rows][columns].ladder != null) && (tile[rows][columns].snake == null)) {
				System.out.println("Congrats Player2 You Got Ladder");
				this.player2.position = tile[rows][columns].ladder.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[rows][columns].ladder == null) && (tile[rows][columns].snake != null)) {
				System.out.println("Oops! Player2 You Got Snake Bite!");
				this.player2.position = tile[rows][columns].snake.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			}
		}
	}

	private int iIndexOfTile(int x) {
		for (int rows = 0; rows < 10; rows++) {
			for (int columns = 0; columns < 10; columns++) {
				if (this.tile[rows][columns].value == x) {

					return rows;
				}
			}
		}
		return -1;// ถ้าหากไม่พบค่า x ใน tile array ฟังก์ชันจะคืนค่า -1 เพื่อบ่งบอกว่าค่า x
		// ไม่พบในอาร์เรย์
	}

	private int jIndexOfTile(int y) {
		for (int rows = 0; rows < 10; rows++) {
			for (int columns = 0; columns < 10; columns++) {
				if (this.tile[rows][columns].value == y) {
					return columns;
				}
			}
		}
		return -1;//

	}

}