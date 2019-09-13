package controller;

import javax.swing.JLabel;

public class ThreadNum extends Thread {
	private JLabel janela;
	
	public ThreadNum(JLabel janela) {
		this.janela = janela;
	}
	
	@Override
	public void run() {
		LancaNum();
	}
	
	public void LancaNum() {
		int fim = (int)(Math.random()*150);
		for(int i=0;i<fim;i++) {
			String texto = Integer.toString((int)(Math.random()*6)+1);
			janela.setText(texto);
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
