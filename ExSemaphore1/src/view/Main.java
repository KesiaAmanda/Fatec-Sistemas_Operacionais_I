package view;

import java.util.concurrent.Semaphore;

import controller.ThreadDoor;

public class Main {
	public static void main(String[] args) {
		Semaphore door = new Semaphore(1);
		
		for(int person=1;person<5;person++) {
			Thread OutTheDoor = new ThreadDoor(person, door);
			OutTheDoor.start();
		}
	}
}
