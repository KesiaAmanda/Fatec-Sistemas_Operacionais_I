package controller;

public class SomaMat extends Thread {
	private int mat[][] = new int[3][5];
	private int i;
	
	public SomaMat (int i, int mat[][]) {
		this.i =i;
		this.mat = mat;
	}
	
	@Override
	public void run() {
		Soma();
	}
	
	public void Soma() {
		int soma = 0;
		
		for(int l=0;l<5;l++) {
			soma+=mat[i][l];
		}
		
		System.out.println("[" + i + "] - "+soma);
	}
}
