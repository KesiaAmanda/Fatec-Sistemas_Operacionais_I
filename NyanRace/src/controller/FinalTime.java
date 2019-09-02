package controller;

import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FinalTime extends Thread{
	private Thread a, b, c, d, e;
	private JLabel sapo1, sapo2, sapo3, sapo4, sapo5, cat1, cat2, cat3, label;
	
	public FinalTime(Thread a, Thread b, 
			Thread c, Thread d, Thread e, JLabel cat1, JLabel cat2, JLabel cat3, JLabel label, JLabel sapo1, 
			JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5) {
		this.sapo1=sapo1;
		this.sapo2=sapo2;
		this.sapo3=sapo3;
		this.sapo4=sapo4;
		this.sapo5=sapo5;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.cat1 = cat1;
		this.cat2 = cat2;
		this.cat3 = cat3;
		this.label = label;
	}
	
	@Override
	public void run() {
		controlaTempo();
	}
	
	public void controlaTempo() {
		int col[] = new int[]{0,0,0,0,0};
		String cat[] = new String[] {"/cat1.gif","/cat2.gif","/cat3.gif","/cat4.gif","/cat5.gif"};
		int aux = 1;
		
		while(a.isAlive()||b.isAlive()||c.isAlive()||d.isAlive()||e.isAlive()) {
			if (a.isAlive()==false&&col[0]==0) {
				col[0]=aux;
				aux++;
			}
			if (b.isAlive()==false&&col[1]==0) {
				col[1]=aux;
				aux++;
			}
			if (c.isAlive()==false&&col[2]==0) {
				col[2]=aux;
				aux++;
			}
			if (d.isAlive()==false&&col[3]==0) {
				col[3]=aux;
				aux++;
			}
			if (e.isAlive()==false&&col[4]==0) {
				col[4]=aux;
				aux++;
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sapo1.setVisible(false);
		sapo2.setVisible(false);
		sapo3.setVisible(false);
		sapo4.setVisible(false);
		sapo5.setVisible(false);
				
		Image bg1 = new ImageIcon(this.getClass().getResource("/bg2.png")).getImage();
		label.setIcon(new ImageIcon(bg1));
		
		for(int i=0;i<5;i++) {
			if (col[i]==1) {
				Image pri = new ImageIcon(this.getClass().getResource(cat[i])).getImage();
				cat1.setIcon(new ImageIcon(pri));
				cat1.setVisible(true);
			}
			if (col[i]==2) {
				Image seg = new ImageIcon(this.getClass().getResource(cat[i])).getImage();
				cat2.setIcon(new ImageIcon(seg));
				cat2.setVisible(true);
			}
			if (col[i]==3) {
				Image ter = new ImageIcon(this.getClass().getResource(cat[i])).getImage();
				cat3.setIcon(new ImageIcon(ter));
				cat3.setVisible(true);
			}
		}
	}
}
