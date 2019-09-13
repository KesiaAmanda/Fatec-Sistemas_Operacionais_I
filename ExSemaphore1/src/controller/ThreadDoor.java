package controller;

import java.util.concurrent.Semaphore;

public class ThreadDoor extends Thread {
	
	private int person;
	private Semaphore door;
	
	public ThreadDoor(int person, Semaphore door) {
		this.door = door;
		this.person = person;
	}
	
	@Override
	public void run() {
		walk();
		try {
			System.out.println("Person #"+person+" arrived at the door");
			door.acquire();
			Thread.sleep((int)(Math.random()*1000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			door.release();
			System.out.println("Person #"+person+" went out the door");
		}
	}
	
	public void walk() {
		int distance = 0;
		System.out.println("Person #"+person+" started walking");
		while (distance<200) {
			distance+=(int)(Math.random()*2)+4;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
