package src;

public class Dice {

	int value;

	public Dice() {
		this.value = 0;
	}

	public int getDiceValue() {
		double rand = Math.random();
		this.value = (int) (1 + rand * 6);
		return this.value;
	}

}
