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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Tela_ConsultarProfessor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblProfessor;
	private JComboBox cmbProfessor;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JLabel lblCodDoProfessor;
	private JTextField txtCodProfessor;
	private JTable tabProfessor;
	private JSeparator separator_1;
	private JButton btnSair;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnDesativar;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ConsultarProfessor frame = new Tela_ConsultarProfessor();
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
	public Tela_ConsultarProfessor() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 509);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Professores");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProfessor = new JLabel("Professor");
		lblProfessor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblProfessor.setBounds(10, 11, 114, 30);
		contentPane.add(lblProfessor);
		
		cmbProfessor = new JComboBox();
		cmbProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor.setBounds(134, 17, 159, 21);
		contentPane.add(cmbProfessor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 455, 252);
		contentPane.add(scrollPane);
		
		tabProfessor = new JTable();
		scrollPane.setViewportView(tabProfessor);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(330, 37, 108, 30);
		contentPane.add(btnConsultar);
		
		lblCodDoProfessor = new JLabel("Cod do Professor");
		lblCodDoProfessor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodDoProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCodDoProfessor.setBounds(5, 62, 119, 30);
		contentPane.add(lblCodDoProfessor);
		
		txtCodProfessor = new JTextField();
		txtCodProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodProfessor.setColumns(10);
		txtCodProfessor.setBounds(134, 70, 159, 20);
		contentPane.add(txtCodProfessor);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 379, 476, 2);
		contentPane.add(separator_1);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(344, 392, 60, 43);
		contentPane.add(btnSair);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(64, 392, 60, 43);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(274, 392, 60, 43);
		contentPane.add(btnAlterar);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/desativar.png")));
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(204, 392, 60, 43);
		contentPane.add(btnDesativar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(134, 392, 60, 43);
		contentPane.add(btnVoltar);
	}
}
