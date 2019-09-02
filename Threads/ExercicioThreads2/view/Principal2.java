package view;

import controller.SomaVet;

public class Principal2 {
	public static void main(String[] args) {
		int mat[][] = new int[3][5];
		for (int i=0;i<3;i++) {
			for(int c=0;c<5;c++) {
				mat[i][c]=(int)(Math.random()*10);
			}
		}
		
		for(int i=0;i<3;i++) {
			int vet[] = new int[5];
			for(int c=0;c<5;c++) {
				vet[c] = mat[i][c];
			}
			
			Thread p = new SomaVet(i,vet);
			p.start();
		}
		
	}
}
