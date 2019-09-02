package controller;

public class rand extends Thread{
	private int num;
		
	public rand(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		MostraNum();
	}

	private void MostraNum () {
		System.out.println(num);
	}
}
