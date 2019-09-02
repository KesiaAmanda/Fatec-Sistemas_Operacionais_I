
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SapoController implements ActionListener{
	private JLabel sapo1, sapo2, sapo3, sapo4, sapo5, cat1, cat2, cat3, label;
	private JButton btnStart;
	
	public SapoController(JLabel sapo1, JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5, JButton btnStart, JLabel cat1, 
			JLabel cat2, JLabel cat3, JLabel label) {
		this.sapo1=sapo1;
		this.sapo2=sapo2;
		this.sapo3=sapo3;
		this.sapo4=sapo4;
		this.sapo5=sapo5;
		this.btnStart=btnStart;
		this.cat1 = cat1;
		this.cat2 = cat2;
		this.cat3 = cat3;
		this.label = label;
	}

	public void BotaoSapo() {
		Thread a = new ThreadSapo(sapo1, btnStart);
		Thread b = new ThreadSapo(sapo2, btnStart);
		Thread c = new ThreadSapo(sapo3, btnStart);
		Thread d = new ThreadSapo(sapo4, btnStart);
		Thread e = new ThreadSapo(sapo5, btnStart);
		Thread f = new FinalTime(a,b,c,d,e,cat1,cat2,cat3, label, sapo1, sapo2, sapo3, sapo4, sapo5);
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();
	}
	 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BotaoSapo();
	}
	
	public void teste (Thread a) {
		
	}
}
