package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class Tela_Curso extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JTextField textField;
	private JButton btnCadastrar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JButton btnSair;
	private JButton btnNovo;
	private JList list;
	private JSeparator separator;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator_1;
	private JMenuItem mntmNewMenuItem_2;
	private JComboBox comboBox;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Curso frame = new Tela_Curso();
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
	public Tela_Curso() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Curso");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 25, 47, 21);
		contentPane.add(lblCurso);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(67, 12, 225, 20);
		contentPane.add(textField);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrar.setBounds(314, 23, 108, 30);
		contentPane.add(btnCadastrar);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(292, 264, 60, 43);
		contentPane.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(222, 264, 60, 43);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/excluir.png")));
		btnExcluir.setToolTipText("Bot\u00E3o Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(152, 264, 60, 43);
		contentPane.add(btnExcluir);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(82, 264, 60, 43);
		contentPane.add(btnVoltar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(362, 264, 60, 43);
		contentPane.add(btnSair);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_Curso.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(10, 264, 60, 43);
		contentPane.add(btnNovo);
		
		list = new JList();
		list.setBounds(10, 88, 414, 152);
		contentPane.add(list);
		
		separator = new JSeparator();
		separator.setBounds(0, 251, 434, 2);
		contentPane.add(separator);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(67, 40, 225, 21);
		contentPane.add(comboBox);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 75, 434, 2);
		contentPane.add(separator_2);
	}
}
