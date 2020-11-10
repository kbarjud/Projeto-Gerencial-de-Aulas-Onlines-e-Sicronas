package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class Tela_CadastroTurma extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblAlunosMatriculados;
	private JTextField txtQtdAluno;
	private JButton btnSalvar;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JLabel lblSemestreLetivo;
	private JTable tabTurma;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JComboBox cmbSemestreLetivo;
	private JButton btnNovoSemestre;
	private JLabel lblTurma;
	private JComboBox cmbDisciplina;
	private JLabel lblDisciplina;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnSair;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblBemVindoA_1;
	private JTextField txtTurma;
	private JButton btnNovo;
	private JButton btnDesativar;
	private JButton btnAtivar;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroTurma frame = new Tela_CadastroTurma();
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
	public Tela_CadastroTurma() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 533);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Turmas");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(41, 52, 56, 21);
		contentPane.add(lblCurso);
		
		cmbCurso = new JComboBox();
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(137, 52, 331, 21);
		contentPane.add(cmbCurso);
		
		lblAlunosMatriculados = new JLabel("Qtd. Alunos");
		lblAlunosMatriculados.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlunosMatriculados.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAlunosMatriculados.setBounds(330, 119, 81, 21);
		contentPane.add(lblAlunosMatriculados);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setColumns(10);
		txtQtdAluno.setBounds(419, 119, 49, 20);
		contentPane.add(txtQtdAluno);
		
		btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(220, 196, 60, 43);
		contentPane.add(btnSalvar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 263, 485, 121);
		contentPane.add(scrollPane);
		
		tabTurma = new JTable();
		tabTurma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabTurma.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Turma", "Curso", "Disciplina", "Qtd Alunos", "Periodo", "Semestre", "Status", "Id Turma"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabTurma.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabTurma.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabTurma.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabTurma.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabTurma.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(7).setPreferredWidth(70);
		scrollPane.setViewportView(tabTurma);
		
		separator = new JSeparator();
		separator.setBounds(0, 395, 505, 2);
		contentPane.add(separator);
		
		lblSemestreLetivo = new JLabel("Semestre Letivo");
		lblSemestreLetivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestreLetivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSemestreLetivo.setBounds(265, 151, 112, 23);
		contentPane.add(lblSemestreLetivo);
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPeriodo.setBounds(46, 152, 56, 21);
		contentPane.add(lblPeriodo);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Vespertino", "Noturno"}));
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo.setBounds(137, 152, 112, 21);
		contentPane.add(cmbPeriodo);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.setModel(new DefaultComboBoxModel(new String[] {"2020/02"}));
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(387, 151, 81, 22);
		contentPane.add(cmbSemestreLetivo);
		
		btnNovoSemestre = new JButton("Novo Semestre");
		btnNovoSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovoSemestre.setBounds(334, 202, 134, 30);
		contentPane.add(btnNovoSemestre);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTurma.setBounds(45, 119, 56, 21);
		contentPane.add(lblTurma);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDisciplina.setBounds(137, 85, 331, 21);
		contentPane.add(cmbDisciplina);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(37, 85, 70, 21);
		contentPane.add(lblDisciplina);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 408, 60, 43);
		contentPane.add(btnVoltar);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(290, 408, 60, 43);
		contentPane.add(btnAlterar);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(360, 408, 60, 43);
		contentPane.add(btnConsultar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(430, 408, 60, 43);
		contentPane.add(btnSair);
		
		lblBemVindoA_1 = new JLabel("Bem Vindo a Tela de Cadastro de Turma");
		lblBemVindoA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA_1.setBounds(10, 11, 485, 30);
		contentPane.add(lblBemVindoA_1);
		
		txtTurma = new JTextField();
		txtTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTurma.setColumns(10);
		txtTurma.setBounds(137, 121, 90, 20);
		contentPane.add(txtTurma);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 408, 60, 43);
		contentPane.add(btnNovo);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("btnDesativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(220, 408, 60, 43);
		contentPane.add(btnDesativar);
		
		btnAtivar = new JButton("");
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(150, 408, 60, 43);
		contentPane.add(btnAtivar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 250, 505, 2);
		contentPane.add(separator_2);
	}
}
