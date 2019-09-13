package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTrack;

public class CarRace {
	public static void main(String[] args){
		Semaphore limCar = new Semaphore(5);
		
		for(int team=0;team<7;team++) {
			Semaphore semaphore = new Semaphore(1);
			Thread car1 = new ThreadTrack(semaphore, limCar, 0, team);
			Thread car2 = new ThreadTrack(semaphore, limCar, 1, team);
			car1.start();
			car2.start();
		}
	}
}
