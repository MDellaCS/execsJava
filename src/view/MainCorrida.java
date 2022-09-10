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

	private JFrame frmDragRaceDe;
	private JTextField txtGanhador;
	private JTextField txtPerdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCorrida window = new MainCorrida();
					window.frmDragRaceDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCorrida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frmDragRaceDe = new JFrame();
		frmDragRaceDe.setResizable(false);
		frmDragRaceDe.setTitle("Drag Race de Threads");
		frmDragRaceDe.setBounds(100, 100, 1000, 304);
		frmDragRaceDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDragRaceDe.getContentPane().setLayout(null);

		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setBounds(33, 39, 46, 14);
		frmDragRaceDe.getContentPane().add(lblCarro1);

		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setBounds(33, 85, 46, 14);
		frmDragRaceDe.getContentPane().add(lblCarro2);

		JButton btnCorrer = new JButton("Iniciar Corrida");
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCorrer.setEnabled(false);
				txtGanhador.setText("");
				txtPerdedor.setText("");
				
				for (int i = 1; i <= 2; i++) {
					threadCarros tC = new threadCarros(i, btnCorrer, lblCarro1, lblCarro2, txtGanhador, txtPerdedor);
					tC.start();
				}

			}
		});
		btnCorrer.setBounds(10, 203, 159, 23);
		frmDragRaceDe.getContentPane().add(btnCorrer);

		txtGanhador = new JTextField();
		txtGanhador.setBounds(259, 176, 86, 20);
		frmDragRaceDe.getContentPane().add(txtGanhador);
		txtGanhador.setColumns(10);

		txtPerdedor = new JTextField();
		txtPerdedor.setBounds(259, 209, 86, 20);
		frmDragRaceDe.getContentPane().add(txtPerdedor);
		txtPerdedor.setColumns(10);

		JLabel lblGanhador = new JLabel("Ganhador:");
		lblGanhador.setBounds(189, 179, 84, 14);
		frmDragRaceDe.getContentPane().add(lblGanhador);

		JLabel lblPerdedor = new JLabel("Perdedor:");
		lblPerdedor.setBounds(189, 212, 84, 14);
		frmDragRaceDe.getContentPane().add(lblPerdedor);
	}

}
