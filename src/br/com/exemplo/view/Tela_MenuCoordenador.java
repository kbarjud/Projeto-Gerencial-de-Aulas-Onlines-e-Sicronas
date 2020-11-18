package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_MenuCoordenador extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblOQueGostaria;
	private JButton btnDados;
	private JButton btnCursos;
	private JButton btnProfessores;
	private JLabel lblVerificarDadosE;
	private JLabel lblCadastrarCursosE;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnVoltar;
	private JButton btnTurmas;
	private JButton btnCoordenadores;
	private JButton btnSair;
	private JMenuItem mntmNewMenuItem_5;
	private JSeparator separator_6;
	private JMenuItem mntmNewMenuItem_6;
	private JButton btnDisciplina;
	private JSeparator separator_2;
	private JMenuItem mntmNewMenuItem_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_MenuCoordenador frame = new Tela_MenuCoordenador();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_MenuCoordenador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 479);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Dados e Relatorios");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=====================Dados e Relatorios====================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Consultar os Cadastros das Aulas Com Base Nos Seguintes Filtros:"
						+ "\n * Curso"
						+ "\n * Disciplina"
						+ "\n * Turma"
						+ "\n * Professor"
						+ "\n * Periodo"
						+ "\n * Semestre Letivo"
						+ "\n * Data da Aula ou Intervalo de Datas"
						+ "\n * Aula Realizada"
						+ "\n * Quantidade de Alunos"
						+ "\n * Atividade Solicitada"
						+ "\n\n 2. Você Poderá Também Gerar Seu PDF e Gráfico"
						+ "\n==========================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Cursos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "==============Cursos=============="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Cursos"
						+ "\n 2. Manter os Cursos ou Desativa-los"
						+ "\n==================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_6 = new JMenuItem("Turmas");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "===========Turmas==========="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar as Turmas"
						+ "\n 2. Manter as Turmas"
						+ "\n============================");
			}
		});
		
		mntmNewMenuItem_7 = new JMenuItem("Disciplinas");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=============Disciplinas============="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar as Disciplinas"
						+ "\n 2. Manter as Disciplinas ou Desativa-las"
						+ "\n==================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		mnNewMenu.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_2 = new JMenuItem("Professores");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "======================Professores======================"
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Verificar os Professores Cadastrados"
						+ "\n 2. Manter os Professores Ativos no Sistema ou Desativa-los"
						+ "\n======================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_5 = new JMenuItem("Coordenadores");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "======================Coordenadores======================"
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Verificar o Cadastro do Coordenador"
						+ "\n 2. Manter o Coordenador Ativo no Sistema ou Desativa-lo"
						+ "\n========================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String javaI = System.getProperty("java.version");
				String javaRE = System.getProperty("java.runtime.version");
				JOptionPane.showMessageDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Seja Bem Vindo!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 343, 30);
		contentPane.add(lblNewLabel);
		
		lblOQueGostaria = new JLabel("O que Gostaria de Fazer?");
		lblOQueGostaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblOQueGostaria.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblOQueGostaria.setBounds(10, 52, 343, 30);
		contentPane.add(lblOQueGostaria);
		
		btnDados = new JButton("Dados das Aulas");
		btnDados.setToolTipText("Bot\u00E3o Dados e Relatorios");
		btnDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_DadosAulas telaDadosAulas = new Tela_DadosAulas();
				telaDadosAulas.setVisible(true);
			}
		});
		btnDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDados.setBounds(16, 252, 149, 30);
		contentPane.add(btnDados);
		
		btnCursos = new JButton("Cursos");
		btnCursos.setToolTipText("Bot\u00E3o Cadastrar Cursos");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_CadastroCurso telaCadastroCurso = new Tela_CadastroCurso();
				telaCadastroCurso.setVisible(true);
			}
		});
		btnCursos.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCursos.setBounds(9, 147, 103, 30);
		contentPane.add(btnCursos);
		
		btnProfessores = new JButton("Professores");
		btnProfessores.setToolTipText("Bot\u00E3o Professores");
		btnProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_ConsultarProfessor telaConsultarProfessor = new Tela_ConsultarProfessor();
				telaConsultarProfessor.setVisible(true);
			}
		});
		btnProfessores.setFont(new Font("Arial", Font.PLAIN, 12));
		btnProfessores.setBounds(181, 252, 149, 30);
		contentPane.add(btnProfessores);
		
		lblVerificarDadosE = new JLabel("Verificar");
		lblVerificarDadosE.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificarDadosE.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblVerificarDadosE.setBounds(10, 211, 329, 30);
		contentPane.add(lblVerificarDadosE);
		
		lblCadastrarCursosE = new JLabel("Cadastrar");
		lblCadastrarCursosE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCursosE.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblCadastrarCursosE.setBounds(10, 106, 329, 30);
		contentPane.add(lblCadastrarCursosE);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 342, 372, 2);
		contentPane.add(separator_1);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(114, 355, 60, 43);
		contentPane.add(btnVoltar);
		
		btnTurmas = new JButton("Turmas");
		btnTurmas.setToolTipText("Bot\u00E3o Cadastrar Turmas");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_CadastroTurma telaCadastroTurma = new Tela_CadastroTurma();
				telaCadastroTurma.setVisible(true);
			}
		});
		btnTurmas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTurmas.setBounds(233, 147, 103, 30);
		contentPane.add(btnTurmas);
		
		btnCoordenadores = new JButton("Coordenador");
		btnCoordenadores.setToolTipText("Bot\u00E3o Coordenador");
		btnCoordenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_ConsultarCoordenador telaConsultarCoordenador = new Tela_ConsultarCoordenador();
				telaConsultarCoordenador.setVisible(true);
			}
		});
		btnCoordenadores.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCoordenadores.setBounds(99, 293, 149, 30);
		contentPane.add(btnCoordenadores);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(184, 355, 60, 43);
		contentPane.add(btnSair);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(0, 93, 372, 2);
		contentPane.add(separator_6);
		
		btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(false);
				dispose();
				Tela_CadastroDisciplina telaCadastroDisciplina = new Tela_CadastroDisciplina();
				telaCadastroDisciplina.setVisible(true);
			}
		});
		btnDisciplina.setToolTipText("Bot\u00E3o Cadastrar Disciplinas");
		btnDisciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDisciplina.setBounds(121, 147, 103, 30);
		contentPane.add(btnDisciplina);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 198, 372, 2);
		contentPane.add(separator_2);
	}
}
