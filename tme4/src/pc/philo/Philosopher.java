package pc.philo;

public class Philosopher implements Runnable {
	private Fork left;
	private Fork right;

	public Philosopher(Fork left, Fork right) {
		this.left = left;
		this.right = right;
	}

	public void run() {
		// TODO
		
		// System.out.println(Thread.currentThread().getName() + " has one fork");
	}

	private void eat() {
		System.out.println(Thread.currentThread().getName() + " is eating");
	}

	private void think() {
		System.out.println(Thread.currentThread().getName() + " is thinking");
	}
}
