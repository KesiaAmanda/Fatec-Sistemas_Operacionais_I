package controller;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ThreadSapo extends Thread{
	private static int ven;
	private JLabel sapo, label;
	private JButton btnStart;
	private int loc;
	
	public ThreadSapo(JLabel sapo, int loc, JButton btnStart, JLabel label) {
		this.sapo = sapo;
		this.btnStart = btnStart;
		this.loc = loc;
		this.label = label;
	}
	
	@Override
	public void run() {
		mexeSapo();
	}
	
	public void mexeSapo() {
		ven = 1;
		sapo.setBounds(10, loc, 116, 56);
		btnStart.setEnabled(false);
		Image bg1 = new ImageIcon(this.getClass().getResource("/bg1.png")).getImage();
		label.setIcon(new ImageIcon(bg1));
		sapo.setVisible(true);
		Rectangle posicao;
		posicao = sapo.getBounds();
		while (posicao.x < 500) {
			posicao.x = posicao.x + (int)(Math.random()*7)+1;
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
		sapoVencedor();
	}
	
	public synchronized void sapoVencedor() {
		if (ven==1) {
			ven++;
			try {
				Thread.sleep(700*6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sapo.setBounds(262, 196, 127, 73);
		}else if (ven==2) {
			ven++;
			try {
				Thread.sleep(700*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sapo.setBounds(116, 236, 127, 73);
		}else if (ven==3) {
			ven++;
			try {
				Thread.sleep(700*4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sapo.setBounds(418, 277, 127, 73);
		}else{
			try {
				Thread.sleep(700*3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sapo.setVisible(false);
		}
		Image bg1 = new ImageIcon(this.getClass().getResource("/bg2.png")).getImage();
		label.setIcon(new ImageIcon(bg1));
		btnStart.setEnabled(true);
	}
}
