package view;

import controller.SomaMat;

public class Principal2 {
	public static void main(String[] args) {
		int mat[][] = new int[3][5];
		for (int i=0;i<3;i++) {
			for(int c=0;c<5;c++) {
				mat[i][c]=(int)(Math.random()*10);
			}
		}
		
		
		for (int i=0;i<3;i++) {
			Thread p = new SomaMat(i,mat);
			p.start();
		}		
	}
}
