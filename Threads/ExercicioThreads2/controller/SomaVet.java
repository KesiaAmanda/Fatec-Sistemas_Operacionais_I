package controller;

public class SomaVet extends Thread {
	private int vet[] = new int[5];
	private int i;
	
	public SomaVet (int i, int vet[]) {
		this.i =i;
		this.vet = vet;
	}
	
	@Override
	public void run() {
		SomaVetor();
	}
	
	public void SomaVetor() {
		int aux = 0;
		
		for(int i=0;i<5;i++) {
			aux+=vet[i];
		}
		
		System.out.println("[" + i + "] - "+aux);
	}
}
