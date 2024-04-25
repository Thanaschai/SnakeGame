package src;

import java.util.*;

public class Game {

	public static void main(String[] args) {
		//finish : change name front name variable to lowercase follow convention java
		//finish : change variable numberForMoveOrEnd => move1_exit0
		Scanner enterYourNumber = new Scanner(System.in);
		Board boardForGame = new Board();
		int move1_exit0;

		Player whoPlay = new Player();

		boardForGame.display();
		System.out.println("Player1's Current Position = " + boardForGame.player1.position);
		System.out.println("Player2's Current Position = " + boardForGame.player2.position);

		//finish : change name function who the winner => Who will definitely win
		//TODO : edit identical parts methods

		while (!boardForGame.WhoWillDefinitelyWin()) {
			move1_exit0 = enterYourNumber.nextInt();
			whoPlay.playRound(move1_exit0);
		}
		/*//boolean PlayerIn1Turn = true;
		while (!boardForGame.WhoWillDefinitelyWin()) {
			if (PlayerIn1Turn) {
				PlayerIn1Turn = false;

				numberForMoveOrEnd = scannerNumber.nextInt();
				whoPlayer.WhoPlayer(numberForMoveOrEnd);
				//System.out.println("Player1's Turn");
				//System.out.println("To roll dice Enter 1\nTo quit game Enter 0\nnumberForMoveOrEnd ");


				if (numberForMoveOrEnd == 1) {
					boardForGame.display();
					boardForGame.rollDice("player1");
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
				numberForMoveOrEnd = scannerNumber.nextInt();

				if (numberForMoveOrEnd == 1) {
					boardForGame.display();
					boardForGame.rollDice("player2");
				} else if (numberForMoveOrEnd == 0) {
					System.exit(0);
				} else {
					System.out.println("Invalid Response!");
					PlayerIn1Turn = false;
				}
			}
		}*/
	}
}