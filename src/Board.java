package src;

public class Board {

	private final Tile[][] tile = new Tile[10][10];
	Player player1;
	Player player2;
	Dice dice;

	public Board() {//Snake , ladder , tile
		int[] cell = {100, 81, 80, 61, 60, 41, 40, 21, 20, 1};

		for (int ChasingIndexInCell = 0; ChasingIndexInCell <= 9; ChasingIndexInCell++) {
			for (int columns = 0; columns <= 9 ; columns++) {
				tile[ChasingIndexInCell][columns] = new Tile(cell[ChasingIndexInCell], null, null);

				if(ChasingIndexInCell % 2 == 0){
					cell[ChasingIndexInCell] -= 1;
				}
				else{cell[ChasingIndexInCell] += 1;}
			}
		}

		/*int cell = 100;

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
		}*/

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

	public void display() {
		System.out.println("'=' stands for Ladder's foot");
		System.out.println("'*' stands for Snake's Mouth");
		System.out.println("");

		for (int rows = 0; rows < 10; rows++) {

			for (int columns = 0; columns < 10; columns++) {

				if (tile[rows][columns].snake == null && tile[rows][columns].ladder == null) {
					if (tile[rows][columns].value == 100)
						System.out.print(tile[rows][columns].value + " ");
					else if (tile[rows][columns].value >= 11 && tile[rows][columns].value <= 99)
						System.out.print(tile[rows][columns].value + "  ");
					else if (tile[rows][0].value == 1)
						System.out.print(tile[rows][columns].value + "   ");
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

	public boolean WhoWillDefinitelyWin() {
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

	public void rollDice(String player) {
		//finish : DiceValue => DiceFace
		int diceFace = dice.getDiceFace();
		System.out.println("Random Dice Value generated = " + diceFace);
		System.out.println("");

		if (player.equals("player1")) {
			int current = this.player1.position ;

			if (this.player1.position + diceFace > 100) {
				current = this.player1.position;
			} else {
				current = this.player1.position + diceFace;
			}

			//finish: delete s because this not plural
			int row = RowIndexOfTile(current);
			int column = ColIndexOfTile(current);

			if ((tile[row][column].ladder == null) && (tile[row][column].snake == null)) {
				if ((this.player1.position + diceFace) <= 100)
				this.player1.position = this.player1.position + diceFace;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[row][column].ladder != null) && (tile[row][column].snake == null)) {
				System.out.println("Congrats Player1 You Got Ladder");
				this.player1.position = tile[row][column].ladder.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			} else if ((tile[row][column].ladder == null) && (tile[row][column].snake != null)) {
				System.out.println("Oops! Player1 You Got Snake Bite!");
				this.player1.position = tile[row][column].snake.finalPosition;
				System.out.println("Player1's Current Position = " + this.player1.position);
				System.out.println("Player2's Current Position = " + this.player2.position);
			}
		} else if (player.equals("player2")) {
			int current = this.player2.position;

			if (this.player2.position + diceFace > 100) {
				current = this.player2.position;
			} else {
				current = this.player2.position + diceFace;
			}

			int rows = RowIndexOfTile(current);
			int columns = ColIndexOfTile(current);

			if ((tile[rows][columns].ladder == null) && (tile[rows][columns].snake == null)) {
				if ((this.player2.position + diceFace) <= 100)
				this.player2.position = this.player2.position + diceFace;
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

	private int RowIndexOfTile(int getCurrentRow) {
		for (int rows = 0; rows < 10; rows++) {
			for (int columns = 0; columns < 10; columns++) {
				if (this.tile[rows][columns].value == getCurrentRow) {
					return rows;
				}
			}
		}

		return -1;
	}

	//O(n^2) => O(1)
	//finish : ตั้งชื่อ parameter ให้เหมือนกัน
	private int ColIndexOfTile(int getCurrentCol) {
		for (int rows = 0; rows < 10; rows++) {
			for (int columns = 0; columns < 10; columns++) {
				if (this.tile[rows][columns].value == getCurrentCol) {
					return columns;
				}
			}
		}

		return -1;
	}
}