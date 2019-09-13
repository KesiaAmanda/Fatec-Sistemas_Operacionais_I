package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SapoController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel sapo1 = new JLabel("");
		Image cat1 = new ImageIcon(this.getClass().getResource("/cat1.gif")).getImage();
		sapo1.setIcon(new ImageIcon(cat1));
		sapo1.setBounds(10, 10, 116, 56);
		contentPane.add(sapo1);
		
		JLabel sapo2 = new JLabel("");
		Image cat2 = new ImageIcon(this.getClass().getResource("/cat2.gif")).getImage();
		sapo2.setIcon(new ImageIcon(cat2));
		sapo2.setBounds(10, 65, 116, 56);
		contentPane.add(sapo2);
		
		JLabel sapo3 = new JLabel("");
		Image cat3 = new ImageIcon(this.getClass().getResource("/cat3.gif")).getImage();
		sapo3.setIcon(new ImageIcon(cat3));
		sapo3.setBounds(10, 120, 116, 56);
		contentPane.add(sapo3);
		
		JLabel sapo4 = new JLabel("");
		Image cat4 = new ImageIcon(this.getClass().getResource("/cat4.gif")).getImage();
		sapo4.setIcon(new ImageIcon(cat4));
		sapo4.setBounds(10, 175, 116, 56);
		contentPane.add(sapo4);
		
		JLabel sapo5 = new JLabel("");
		Image cat5 = new ImageIcon(this.getClass().getResource("/cat5.gif")).getImage();
		sapo5.setIcon(new ImageIcon(cat5));
		sapo5.setBounds(10, 230, 116, 56);
		contentPane.add(sapo5);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(10, 386, 89, 23);
		contentPane.add(btnStart);
		
		JLabel label = new JLabel("");
		Image bg1 = new ImageIcon(this.getClass().getResource("/bg1.png")).getImage();
		label.setIcon(new ImageIcon(bg1));
		label.setBounds(0, 0, 619, 420);
		contentPane.add(label);		
		
		SapoController SapoController = new SapoController(sapo1, sapo2, sapo3, sapo4, sapo5, btnStart, label);
		btnStart.addActionListener(SapoController);
	}
}
