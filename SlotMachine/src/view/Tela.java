package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerNum;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Tela extends JFrame {

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
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image bg = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 11));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBounds(194, 283, 89, 23);
		contentPane.add(btnStart);
		
		JLabel label = new JLabel("7");
		label.setFont(new Font("OCR A Extended", Font.PLAIN, 29));
		label.setBounds(136, 134, 33, 41);
		contentPane.add(label);
		
		JLabel label3 = new JLabel("7");
		label3.setFont(new Font("OCR A Extended", Font.PLAIN, 29));
		label3.setBounds(330, 134, 33, 41);
		contentPane.add(label3);
		
		JLabel label2 = new JLabel("7");
		label2.setFont(new Font("OCR A Extended", Font.PLAIN, 29));
		label2.setBounds(232, 134, 33, 41);
		contentPane.add(label2);
		lblNewLabel.setIcon(new ImageIcon(bg));
		lblNewLabel.setBounds(0, 0, 481, 318);
		contentPane.add(lblNewLabel);
		
		ControllerNum p = new ControllerNum(label, label2, label3, btnStart);
		btnStart.addActionListener(p);
	}
}
