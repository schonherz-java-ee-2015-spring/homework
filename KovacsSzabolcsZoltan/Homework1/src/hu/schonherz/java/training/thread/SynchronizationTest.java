package hu.schonherz.java.training.thread;

public class SynchronizationTest extends Thread {

	private int number;
	private static SynchronizedObject synchronizedObject = new SynchronizedObject();

	public SynchronizationTest(int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		int i = 0;
		synchronized (synchronizedObject) {			//Biztos nem fér hozzá a másik thread amíg az első használja
			while (i < 5) {
				i++;
//				synchronized (synchronizedObject) { 			Közbe bele nyúlhat a kettes ha elég gyors
					System.out.println(number + " - " + synchronizedObject.getNum());
//				}
			}
		}
	}

	@Override
	public synchronized void start() {
		System.out.println(number + ". started");
		super.start();
	}

}
