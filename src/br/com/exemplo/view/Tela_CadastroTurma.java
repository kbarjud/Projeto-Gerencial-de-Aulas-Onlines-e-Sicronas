package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Tela_CadastroTurma extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblAlunosMatriculados;
	private JTextField txtQtdAluno;
	private JButton btnCadastrar;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JLabel lblSemestreLetivo;
	private JTable table;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JComboBox cmbSemestreLetivo;
	private JButton btnNovoSemestre;
	private JTextField txtTurma;
	private JLabel lblTurma;
	private JComboBox cmbDisciplina;
	private JLabel lblDisciplina;
	private JButton btnVoltar;
	private JButton btnExcluir;
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
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 360);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Turmas");
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
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 15, 56, 21);
		contentPane.add(lblCurso);
		
		cmbCurso = new JComboBox();
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(85, 17, 192, 21);
		contentPane.add(cmbCurso);
		
		lblAlunosMatriculados = new JLabel("Qtd. Alunos");
		lblAlunosMatriculados.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlunosMatriculados.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAlunosMatriculados.setBounds(139, 81, 81, 21);
		contentPane.add(lblAlunosMatriculados);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setColumns(10);
		txtQtdAluno.setBounds(230, 82, 47, 20);
		contentPane.add(txtQtdAluno);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrar.setBounds(154, 190, 123, 30);
		contentPane.add(btnCadastrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 15, 201, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		separator = new JSeparator();
		separator.setBounds(0, 237, 505, 2);
		contentPane.add(separator);
		
		lblSemestreLetivo = new JLabel("Semestre Letivo");
		lblSemestreLetivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestreLetivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSemestreLetivo.setBounds(38, 145, 118, 21);
		contentPane.add(lblSemestreLetivo);
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPeriodo.setBounds(64, 113, 56, 21);
		contentPane.add(lblPeriodo);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "Matutino", "Vespertino", "Noturno"}));
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo.setBounds(132, 113, 96, 21);
		contentPane.add(cmbPeriodo);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(166, 146, 81, 21);
		contentPane.add(cmbSemestreLetivo);
		
		btnNovoSemestre = new JButton("Novo Semestre");
		btnNovoSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovoSemestre.setBounds(10, 190, 134, 30);
		contentPane.add(btnNovoSemestre);
		
		txtTurma = new JTextField();
		txtTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTurma.setColumns(10);
		txtTurma.setBounds(76, 82, 53, 20);
		contentPane.add(txtTurma);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTurma.setBounds(10, 81, 56, 21);
		contentPane.add(lblTurma);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDisciplina.setBounds(85, 49, 192, 21);
		contentPane.add(cmbDisciplina);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(10, 47, 70, 21);
		contentPane.add(lblDisciplina);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(85, 250, 60, 43);
		contentPane.add(btnVoltar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/excluir.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(155, 250, 60, 43);
		contentPane.add(btnExcluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(225, 250, 60, 43);
		contentPane.add(btnAlterar);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(295, 250, 60, 43);
		contentPane.add(btnConsultar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(365, 250, 60, 43);
		contentPane.add(btnSair);
	}
}
