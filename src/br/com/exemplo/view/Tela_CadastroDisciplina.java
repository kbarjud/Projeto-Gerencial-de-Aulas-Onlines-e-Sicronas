package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Tela_CadastroDisciplina extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnSair;
	private JButton btnAlterar;
	private JLabel lblBemVindoA;
	private JLabel lblCurso;
	private JTextField txtDisciplina;
	private JButton btnSalvar;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	private JButton btnNovo;
	private JButton btnAtivar;
	private JButton btnDesativar;
	private JSeparator separator_3;
	private JButton btnListarCoordenadoresAtivos;
	private JButton btnListarDesativados;
	private JButton btnListarTodos;
	private JTable tabDisciplina;
	private JComboBox cmbCurso;
	private JLabel lblDisciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroDisciplina frame = new Tela_CadastroDisciplina();
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
	public Tela_CadastroDisciplina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 517);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Disciplina");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 388, 447, 2);
		contentPane.add(separator_1);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(246, 134, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(19, 401, 60, 43);
		contentPane.add(btnVoltar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(335, 401, 60, 43);
		contentPane.add(btnSair);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(256, 401, 60, 43);
		contentPane.add(btnAlterar);
		
		lblBemVindoA = new JLabel("Bem Vindo a Tela de Cadastro de Disciplina");
		lblBemVindoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA.setBounds(10, 11, 395, 30);
		contentPane.add(lblBemVindoA);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 52, 69, 30);
		contentPane.add(lblCurso);
		
		txtDisciplina = new JTextField();
		txtDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDisciplina.setColumns(10);
		txtDisciplina.setBounds(90, 93, 315, 30);
		contentPane.add(txtDisciplina);
		
		btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/salvar2.png")));
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(176, 134, 60, 43);
		contentPane.add(btnSalvar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 235, 447, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 395, 129);
		contentPane.add(scrollPane);
		
		tabDisciplina = new JTable();
		tabDisciplina.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabDisciplina.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Disciplina", "Status", "ID Curso Disciplina"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabDisciplina.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabDisciplina.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabDisciplina.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabDisciplina.getColumnModel().getColumn(3).setPreferredWidth(150);
		scrollPane.setViewportView(tabDisciplina);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(106, 134, 60, 43);
		contentPane.add(btnNovo);
		
		btnAtivar = new JButton("");
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/ativar.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(98, 401, 60, 43);
		contentPane.add(btnAtivar);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/desativar.png")));
		btnDesativar.setToolTipText("btnDesativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(177, 401, 60, 43);
		contentPane.add(btnDesativar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 188, 447, 2);
		contentPane.add(separator_3);
		
		btnListarCoordenadoresAtivos = new JButton("Listar Ativos");
		btnListarCoordenadoresAtivos.setToolTipText("Bot\u00E3o Listar Coordenadores Ativos");
		btnListarCoordenadoresAtivos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarCoordenadoresAtivos.setBounds(11, 201, 123, 23);
		contentPane.add(btnListarCoordenadoresAtivos);
		
		btnListarDesativados = new JButton("Listar Inativos");
		btnListarDesativados.setToolTipText("Bot\u00E3o Listar Coordenadores Inativos");
		btnListarDesativados.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDesativados.setBounds(145, 201, 123, 23);
		contentPane.add(btnListarDesativados);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setToolTipText("Bot\u00E3o Listar Todos os Coordenadores");
		btnListarTodos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarTodos.setBounds(279, 201, 123, 23);
		contentPane.add(btnListarTodos);
		
		cmbCurso = new JComboBox();
		cmbCurso.setBounds(90, 52, 315, 30);
		contentPane.add(cmbCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(10, 93, 69, 30);
		contentPane.add(lblDisciplina);
	}
}
