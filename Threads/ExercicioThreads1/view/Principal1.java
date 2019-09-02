package view;

import controller.rand;

public class Principal1 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 5 ; i ++ ) {
			Thread p = new rand((int)(Math.random()*10)+1);
			p.start();
		}
		
	}
}
