package View;

import Controller.ThreadCalc;
import Controller.ThreadSeq;

public class Principal {
	public static void main(String[] args) {
		//**int a = 10;
		//int b = 2;
		//int op = 2;
		
		//for(int op = 0; op<4 ;op++ ) {
		//	Thread t = new ThreadCalc(a, b, op);
		//	t.start();
		//}
		//**
		
		for(int i = 0 ; i<9 ; i++) {
			Thread t = new ThreadSeq((int)(Math.random()*100000000)+100000000);
			t.start();
		}
		
	}
}
