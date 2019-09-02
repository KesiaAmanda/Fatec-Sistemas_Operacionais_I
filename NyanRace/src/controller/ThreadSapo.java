package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;


public class ThreadSapo extends Thread{
	private JLabel sapo;
	private JButton btnStart;
	
	public ThreadSapo(JLabel sapo, JButton btnStart) {
		this.sapo = sapo;
		this.btnStart = btnStart;
	}
	
	@Override
	public void run() {
		mexeSapo();
	}
	
	public void mexeSapo() {
		btnStart.setVisible(false);
		Rectangle posicao;
		posicao = sapo.getBounds();
		while (posicao.x < 500) {
			posicao.x = posicao.x + (int)(Math.random()*7);
			if (posicao.x>500) {
				posicao.x = 500;
			}
			sapo.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
