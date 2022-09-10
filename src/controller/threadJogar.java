package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class threadJogar extends Thread implements ActionListener {

	private int id;
	private JButton btnJogar;
	private JTextField slot1;
	private JTextField slot2;
	private JTextField slot3;

	public threadJogar(int id, JButton btnJogar, JTextField slot1, JTextField slot2, JTextField slot3) {
		this.id = id;
		this.btnJogar = btnJogar;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
	}
	
	static int prontos = 0;
	
	@Override
	public void run() {

		
		int giros = (int) (Math.random() * 150) + 1;
		int giro = 0;

		while (giro < giros) {

			try {
				sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (id == 1) {
				slot1.setText(Integer.toString((int) (Math.random() * 7) + 1));
			}
			if (id == 2) {
				slot2.setText(Integer.toString((int) (Math.random() * 7) + 1));
			}
			if (id == 3) {
				slot3.setText(Integer.toString((int) (Math.random() * 7) + 1));
			}

			giro++;

		}

		prontos++;

		if (prontos % 3 == 0) {
			btnJogar.setEnabled(true);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
