package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.threadCarros;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainCorrida {

	private JFrame frmTela;
	private JTextField txtGanhador;
	private JTextField txtPerdedor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCorrida window = new MainCorrida();
					window.frmTela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainCorrida() {
		initialize();
	}

	private void initialize() {
		frmTela = new JFrame();
		frmTela.setResizable(false);
		frmTela.setTitle("Corrida de Threads");
		frmTela.setBounds(100, 100, 1000, 304);
		frmTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTela.getContentPane().setLayout(null);

		txtGanhador = new JTextField();
		txtGanhador.setBounds(472, 176, 86, 20);
		txtGanhador.setVisible(false);
		frmTela.getContentPane().add(txtGanhador);
		txtGanhador.setColumns(10);

		txtPerdedor = new JTextField();
		txtPerdedor.setBounds(472, 209, 86, 20);
		txtPerdedor.setVisible(false);
		frmTela.getContentPane().add(txtPerdedor);
		txtPerdedor.setColumns(10);

		JLabel lblGanhador = new JLabel("Ganhador:");
		lblGanhador.setBounds(402, 179, 84, 14);
		lblGanhador.setVisible(false);
		frmTela.getContentPane().add(lblGanhador);

		JLabel lblPerdedor = new JLabel("Perdedor:");
		lblPerdedor.setBounds(402, 212, 84, 14);
		lblPerdedor.setVisible(false);
		frmTela.getContentPane().add(lblPerdedor);

		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setBounds(33, 39, 46, 14);
		frmTela.getContentPane().add(lblCarro1);

		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setBounds(33, 85, 46, 14);
		frmTela.getContentPane().add(lblCarro2);

		JButton btnCorrer = new JButton("Iniciar Corrida");
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCorrer.setVisible(false);
				lblGanhador.setVisible(true);
				txtGanhador.setVisible(true);
				lblPerdedor.setVisible(true);
				txtPerdedor.setVisible(true);

				for (int i = 1; i <= 2; i++) {
					threadCarros tC = new threadCarros(i, btnCorrer, lblCarro1, lblCarro2, txtGanhador, txtPerdedor);
					tC.start();
				}

			}
		});
		btnCorrer.setBounds(402, 206, 159, 23);
		frmTela.getContentPane().add(btnCorrer);

	}

}
