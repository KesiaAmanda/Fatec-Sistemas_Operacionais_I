package controller;

import java.util.concurrent.Semaphore;

public class BankThread extends Thread{
	private int id, value;
	private Semaphore TransationType, Transations;
	
	public BankThread(int id, int value, Semaphore TransationType, Semaphore Transations) {
		this.id=id;
		this.value=value;
		this.TransationType=TransationType;
		this.Transations=Transations;
	}
	
	@Override
	public void run() {
		try {
			Transations.acquire();
			TransationType.acquire();
			Transation();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			TransationType.release();
			Transations.release();
		}
	}
	
	public void Transation() {
		if(value<0) {
			System.out.println("ID:"+id+" withdraw $" + value);
		}else{
			System.out.println("ID:"+id+" deposit $" + value);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
