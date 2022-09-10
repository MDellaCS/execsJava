package controller;

import java.awt.event.*;

import javax.swing.*;

public class threadCarros extends Thread implements ActionListener {

	private int carro;
	private JButton btnCorrer;
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JTextField txtGanhador;
	private JTextField txtPerdedor;

	public threadCarros(int carro, JButton btnCorrer, JLabel lblCarro1, JLabel lblCarro2, JTextField txtGanhador,
			JTextField txtPerdedor) {
		this.carro = carro;
		this.btnCorrer = btnCorrer;
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.txtGanhador = txtGanhador;
		this.txtPerdedor = txtPerdedor;
	}

	static int distMax = 920;
	static int arranqueMax = 25;
	static int i = 1;

	@Override
	public void run() {

		int arranqueCarro = 0;
		int localCarro = 33;
		int contArranque = 0;

		while (localCarro < distMax) {

			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			arranqueCarro = (int) (Math.random() * arranqueMax) + 0;
			localCarro += arranqueCarro;

			if (carro == 1) {
				lblCarro1.setBounds(localCarro, 39, 1000, 14);
			}
			if (carro == 2) {
				lblCarro2.setBounds(localCarro, 85, 1000, 14);
			}

			contArranque++;
			System.out.println("Carro " + carro + " deu um arranque de " + arranqueCarro + " metros.\n(" + localCarro
					+ "/" + distMax + ")\n");

		}

		System.err.println("Carro " + carro + " chegou em " + i + "o! Com " + contArranque + " arranques.\n");

		if (i == 1) {
			txtGanhador.setText("Carro " + carro);
			i++;
		} else {
			txtPerdedor.setText("Carro " + carro);
			btnCorrer.setText("Correr denovo");
			btnCorrer.setEnabled(true);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}