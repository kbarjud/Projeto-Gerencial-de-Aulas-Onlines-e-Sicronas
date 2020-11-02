package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Tela_ConsultarCoordenador extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JLabel lblCoordenador;
	private JComboBox cmbCoordenador;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JLabel lblCodDoCoordenador;
	private JTextField txtCodCoordenador;
	private JSeparator separator_1;
	private JButton btnSair;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnDesativar;
	private JButton btnVoltar;
	private JTable tabCoordenador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ConsultarCoordenador frame = new Tela_ConsultarCoordenador();
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
	public Tela_ConsultarCoordenador() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 509);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Coordenador");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCoordenador = new JLabel("Coordenador");
		lblCoordenador.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCoordenador.setBounds(10, 11, 109, 30);
		contentPane.add(lblCoordenador);
		
		cmbCoordenador = new JComboBox();
		cmbCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCoordenador.setBounds(129, 17, 159, 21);
		contentPane.add(cmbCoordenador);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 456, 252);
		contentPane.add(scrollPane);
		
		tabCoordenador = new JTable();
		scrollPane.setViewportView(tabCoordenador);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(325, 37, 108, 30);
		contentPane.add(btnConsultar);
		
		lblCodDoCoordenador = new JLabel("Cod do Coordenador");
		lblCodDoCoordenador.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodDoCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCodDoCoordenador.setBounds(10, 65, 127, 30);
		contentPane.add(lblCodDoCoordenador);
		
		txtCodCoordenador = new JTextField();
		txtCodCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodCoordenador.setColumns(10);
		txtCodCoordenador.setBounds(155, 70, 133, 20);
		contentPane.add(txtCodCoordenador);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 379, 476, 2);
		contentPane.add(separator_1);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(339, 392, 60, 43);
		contentPane.add(btnSair);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(59, 392, 60, 43);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(269, 392, 60, 43);
		contentPane.add(btnAlterar);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/desativar.png")));
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(199, 392, 60, 43);
		contentPane.add(btnDesativar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(129, 392, 60, 43);
		contentPane.add(btnVoltar);
	}
}
