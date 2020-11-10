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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class Tela_DadosAulas extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JLabel lblDisciplina;
	private JLabel lblDataDaAula;
	private JLabel lblNome_3;
	private JComboBox cmbCurso;
	private JComboBox cmbDisciplina;
	private JDateChooser dteDataAula;
	private JComboBox cmbPeriodo;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNome;
	private JComboBox cmbProfessor;
	private JList listDadosAulas;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnPDF;
	private JButton btnSair;
	private JLabel lblNome_1;
	private JComboBox cmbTurma;
	private JLabel lblNome_2;
	private JComboBox cmbPeriodo_1;
	private JComboBox cmbProfessor_1;
	private JLabel lblNome_4;
	private JDateChooser dteDataAula_1;
	private JSeparator separator_2;
	private JLabel lblNome_5;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNo;
	private JTextField textField;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JComboBox cmbProfessor_2;
	private JLabel lblNome_6;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNo_1;
	private JSeparator separator_5;
	private JButton btnConsultar;
	private JButton btnGrafico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_DadosAulas frame = new Tela_DadosAulas();
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
	public Tela_DadosAulas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 621);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Consultas");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("PDF");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_3 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 12, 45, 30);
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 49, 62, 30);
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDisciplina);
		
		lblDataDaAula = new JLabel("Data");
		lblDataDaAula.setBounds(226, 129, 31, 21);
		lblDataDaAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDaAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDataDaAula);
		
		lblNome_3 = new JLabel("Periodo");
		lblNome_3.setBounds(404, 94, 48, 21);
		lblNome_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblNome_3);
		
		cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Analise e Desenvolvimento de Sistemas"}));
		cmbCurso.setBounds(82, 17, 502, 21);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbCurso);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Tecnicas de Desenvolvimento de Algoritmos"}));
		cmbDisciplina.setBounds(82, 53, 353, 23);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbDisciplina);
		
		dteDataAula = new JDateChooser();
		dteDataAula.setBounds(375, 126, 101, 26);
		contentPane.add(dteDataAula);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Vespertino", "Noturno"}));
		cmbPeriodo.setBounds(462, 94, 122, 23);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbPeriodo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 574, 208);
		contentPane.add(scrollPane);
		
		listDadosAulas = new JList();
		scrollPane.setViewportView(listDadosAulas);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 484, 641, 2);
		contentPane.add(separator_1);
		
		lblNome = new JLabel("Professor");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(10, 87, 77, 30);
		contentPane.add(lblNome);
		
		cmbProfessor = new JComboBox();
		cmbProfessor.setModel(new DefaultComboBoxModel(new String[] {"Camila Elias Barjud Romero Futura Reis"}));
		cmbProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor.setBounds(82, 92, 312, 23);
		contentPane.add(cmbProfessor);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(126, 497, 60, 43);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 497, 60, 43);
		contentPane.add(btnVoltar);
		
		btnPDF = new JButton("");
		btnPDF.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/pdf-2.png")));
		btnPDF.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPDF.setBounds(312, 497, 60, 43);
		contentPane.add(btnPDF);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(498, 497, 60, 43);
		contentPane.add(btnSair);
		
		lblNome_1 = new JLabel("Turma");
		lblNome_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_1.setBounds(445, 49, 45, 30);
		contentPane.add(lblNome_1);
		
		cmbTurma = new JComboBox();
		cmbTurma.setModel(new DefaultComboBoxModel(new String[] {"2bv/3db"}));
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(495, 54, 89, 23);
		contentPane.add(cmbTurma);
		
		lblNome_2 = new JLabel("Semestre Letivo");
		lblNome_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_2.setBounds(10, 129, 111, 21);
		contentPane.add(lblNome_2);
		
		cmbPeriodo_1 = new JComboBox();
		cmbPeriodo_1.setModel(new DefaultComboBoxModel(new String[] {"2020/02"}));
		cmbPeriodo_1.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo_1.setBounds(131, 128, 85, 23);
		contentPane.add(cmbPeriodo_1);
		
		cmbProfessor_1 = new JComboBox();
		cmbProfessor_1.setModel(new DefaultComboBoxModel(new String[] {"Especifica", "Intervalo"}));
		cmbProfessor_1.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor_1.setBounds(267, 128, 98, 23);
		contentPane.add(cmbProfessor_1);
		
		lblNome_4 = new JLabel("Qtd de Alunos");
		lblNome_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_4.setBounds(308, 175, 92, 21);
		contentPane.add(lblNome_4);
		
		dteDataAula_1 = new JDateChooser();
		dteDataAula_1.setBounds(483, 126, 101, 26);
		contentPane.add(dteDataAula_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(-18, 161, 641, 2);
		contentPane.add(separator_2);
		
		lblNome_5 = new JLabel("Aula Realizada?");
		lblNome_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_5.setBounds(28, 175, 112, 21);
		contentPane.add(lblNome_5);
		
		rdbtnNewRadioButton = new JRadioButton("Sim");
		rdbtnNewRadioButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(155, 171, 51, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnNo.setBounds(221, 171, 51, 29);
		contentPane.add(rdbtnNo);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(528, 174, 56, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(-18, 207, 641, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(296, 161, 2, 48);
		contentPane.add(separator_4);
		
		cmbProfessor_2 = new JComboBox();
		cmbProfessor_2.setModel(new DefaultComboBoxModel(new String[] {"Igual a", "Maior que", "Menor que"}));
		cmbProfessor_2.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor_2.setBounds(415, 174, 98, 23);
		contentPane.add(cmbProfessor_2);
		
		lblNome_6 = new JLabel("Atividade Solicitada?");
		lblNome_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_6.setBounds(163, 220, 131, 21);
		contentPane.add(lblNome_6);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Sim");
		rdbtnNewRadioButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(304, 216, 51, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNo_1 = new JRadioButton("N\u00E3o");
		rdbtnNo_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnNo_1.setBounds(363, 216, 51, 29);
		contentPane.add(rdbtnNo_1);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(-18, 252, 641, 2);
		contentPane.add(separator_5);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(219, 497, 60, 43);
		contentPane.add(btnConsultar);
		
		btnGrafico = new JButton("");
		btnGrafico.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/positive-dynamic--v1.png")));
		btnGrafico.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrafico.setBounds(405, 497, 60, 43);
		contentPane.add(btnGrafico);
	}
}
