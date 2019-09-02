package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ControllerNum  implements ActionListener {
	private JLabel label, label1, label2;
	private JButton btnStart;
	
	public ControllerNum(JLabel label, JLabel label1, JLabel label2, JButton btnStart) {
		this.label = label;
		this.label1 = label1;
		this.label2 = label2;
		this.btnStart = btnStart;
	}
	
	public void BotaoStart() {
		Thread a = new ThreadNum(label);
		Thread b = new ThreadNum(label1);
		Thread c = new ThreadNum(label2);
		a.start();
		b.start();
		c.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BotaoStart();
	}
}
