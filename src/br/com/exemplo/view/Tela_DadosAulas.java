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
	private JButton btnConsultar;
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
	private JComboBox cmbTurma;
	private JList listDadosAulas;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnPDF;
	private JButton btnSair;

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
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 621);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Consultas");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("PDF");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("Ajuda");
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
		lblCurso.setBounds(10, 11, 45, 30);
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(312, 11, 62, 30);
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDisciplina);
		
		lblDataDaAula = new JLabel("Data da Aula");
		lblDataDaAula.setBounds(10, 52, 92, 30);
		lblDataDaAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDaAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDataDaAula);
		
		lblNome_3 = new JLabel("Periodo");
		lblNome_3.setBounds(270, 52, 62, 30);
		lblNome_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblNome_3);
		
		cmbCurso = new JComboBox();
		cmbCurso.setBounds(65, 16, 237, 21);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbCurso);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setBounds(384, 16, 246, 23);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbDisciplina);
		
		dteDataAula = new JDateChooser();
		dteDataAula.setBounds(112, 52, 137, 30);
		contentPane.add(dteDataAula);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "Matutino", "Vespertino", "Noturno"}));
		cmbPeriodo.setBounds(342, 59, 132, 23);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbPeriodo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(265, 100, 108, 30);
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 620, 327);
		contentPane.add(scrollPane);
		
		listDadosAulas = new JList();
		scrollPane.setViewportView(listDadosAulas);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 484, 641, 2);
		contentPane.add(separator_1);
		
		lblNome = new JLabel("Turma");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(484, 52, 45, 30);
		contentPane.add(lblNome);
		
		cmbTurma = new JComboBox();
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(539, 59, 91, 23);
		contentPane.add(cmbTurma);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(183, 497, 60, 43);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(253, 497, 60, 43);
		contentPane.add(btnVoltar);
		
		btnPDF = new JButton("");
		btnPDF.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/pdf.png")));
		btnPDF.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPDF.setBounds(323, 497, 60, 43);
		contentPane.add(btnPDF);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(395, 497, 60, 43);
		contentPane.add(btnSair);
	}
}
