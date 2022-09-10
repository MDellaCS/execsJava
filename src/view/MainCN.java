package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.threadJogar;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainCN {

	private JFrame frmGame;
	private JTextField slot2;
	private JTextField slot1;
	private JTextField slot3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCN window = new MainCN();
					window.frmGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainCN() {
		initialize();
	}

	private void initialize() {
		frmGame = new JFrame();
		frmGame.setTitle("Caça-Níquel");
		frmGame.getContentPane().setBackground(Color.DARK_GRAY);
		frmGame.setBounds(100, 100, 312, 116);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);

		slot2 = new JTextField();
		slot2.setHorizontalAlignment(SwingConstants.CENTER);
		slot2.setFont(new Font("Unispace", Font.PLAIN, 26));
		slot2.setForeground(Color.BLACK);
		slot2.setBackground(Color.WHITE);
		slot2.setEditable(false);
		slot2.setBounds(70, 11, 50, 50);
		frmGame.getContentPane().add(slot2);
		slot2.setColumns(10);

		slot1 = new JTextField();
		slot1.setHorizontalAlignment(SwingConstants.CENTER);
		slot1.setFont(new Font("Unispace", Font.PLAIN, 26));
		slot1.setForeground(Color.BLACK);
		slot1.setBackground(Color.WHITE);
		slot1.setEditable(false);
		slot1.setBounds(10, 11, 50, 50);
		frmGame.getContentPane().add(slot1);
		slot1.setColumns(10);

		slot3 = new JTextField();
		slot3.setHorizontalAlignment(SwingConstants.CENTER);
		slot3.setFont(new Font("Unispace", Font.PLAIN, 26));
		slot3.setForeground(Color.BLACK);
		slot3.setBackground(Color.WHITE);
		slot3.setEditable(false);
		slot3.setBounds(130, 11, 50, 50);
		frmGame.getContentPane().add(slot3);
		slot3.setColumns(10);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnJogar.setEnabled(false);

				for (int i = 1; i <= 3; i++) {
					threadJogar tJ = new threadJogar(i, btnJogar, slot1, slot2, slot3);
					tJ.start();
				}

			}
		});
		btnJogar.setForeground(Color.BLACK);
		btnJogar.setBackground(Color.WHITE);
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJogar.setBounds(197, 18, 89, 36);
		frmGame.getContentPane().add(btnJogar);
	}

}
