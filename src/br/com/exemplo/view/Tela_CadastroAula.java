package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;

public class Tela_CadastroAula extends JFrame {

	private JPanel panel;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroAula frame = new Tela_CadastroAula();
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
	public Tela_CadastroAula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 460);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		btnNovo = new JButton("");
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(70, 367, 60, 43);
		panel.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(140, 367, 60, 43);
		panel.add(btnVoltar);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(210, 367, 60, 43);
		panel.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(280, 367, 60, 43);
		panel.add(btnAlterar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(352, 367, 60, 43);
		panel.add(btnSair);
	}

}
