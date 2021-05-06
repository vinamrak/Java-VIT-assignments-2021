package java_vit;
class Bike extends Thread {
	private int stage = 1;
	public int bike_ID;
	String name;

	Bike(int id) {
		bike_ID = id;
		this.name = "Bike -" + bike_ID;
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			try {
				System.out.println(name + " stage-" + stage);
				stage++;
				Thread.sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BikeRace {
	public static void main(String args[]) {

		Bike b1 = new Bike(1);
		Bike b2 = new Bike(2);
		Bike b3 = new Bike(3);
		Bike b4 = new Bike(4);
		Bike b5 = new Bike(5);

		try {
			b1.start();
			b2.start();
			b3.start();
			b4.start();
			b5.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}