
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SapoController implements ActionListener{
	private JLabel sapo1, sapo2, sapo3, sapo4, sapo5, label;
	private JButton btnStart;
	private int loc;
	
	public SapoController(JLabel sapo1, JLabel sapo2, JLabel sapo3, JLabel sapo4, JLabel sapo5, JButton btnStart, JLabel label) {
		this.sapo1=sapo1;
		this.sapo2=sapo2;
		this.sapo3=sapo3;
		this.sapo4=sapo4;
		this.sapo5=sapo5;
		this.btnStart=btnStart;
		this.label = label;
	}

	public void BotaoSapo() {
		loc=10;
		Thread a = new ThreadSapo(sapo1, loc, btnStart, label);
		loc+=55;
		Thread b = new ThreadSapo(sapo2, loc, btnStart, label);
		loc+=55;
		Thread c = new ThreadSapo(sapo3, loc, btnStart, label);
		loc+=55;
		Thread d = new ThreadSapo(sapo4, loc, btnStart, label);
		loc+=55;
		Thread e = new ThreadSapo(sapo5, loc, btnStart, label);
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
	 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BotaoSapo();
	}
}
