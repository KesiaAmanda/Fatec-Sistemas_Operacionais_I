package view;

import java.util.concurrent.Semaphore;

import controller.BankThread;

public class MainBank {
	public static void main(String[] args) {
		Semaphore Deposit = new Semaphore(1);
		Semaphore Withdraw = new Semaphore(1);
		Semaphore Transations = new Semaphore(2);
		
		for(int i=0;i<20;i++) {
			int id=(int)(Math.random()*50)+150;
			int value=(int)(Math.random()*-5000)+3000;
			
			if (value<0) {
				Thread AccountMovement = new BankThread(id, value, Withdraw, Transations);
				AccountMovement.start();
			}else {
				Thread AccountMovement = new BankThread(id, value, Deposit, Transations);
				AccountMovement.start();
			}
		}
	}
}
