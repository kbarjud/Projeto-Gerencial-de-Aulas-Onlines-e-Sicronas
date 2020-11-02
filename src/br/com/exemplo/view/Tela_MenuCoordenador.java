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
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Tela_MenuCoordenador extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblOQueGostaria;
	private JButton btnDados;
	private JButton btnCursos;
	private JButton btnProfessores;
	private JLabel lblVerificarDadosE;
	private JLabel lblCadastrarCursosE;
	private JLabel lblVerificarDadosE_2;
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
	private JLabel lblCadastrarCursosE_1;
	private JButton btnCoordenadores;
	private JLabel lblVerificarDadosE_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JButton btnSair;
	private JMenuItem mntmNewMenuItem_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_MenuCoordenador frame = new Tela_MenuCoordenador();
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
	public Tela_MenuCoordenador() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 457);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Dados e Relatorios");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Cursos e Disciplinas");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Professores");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_5 = new JMenuItem("Coordenadores");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_4 = new JMenuItem("Sair");
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
		
		btnDados = new JButton("Clique Aqui!");
		btnDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDados.setBounds(250, 102, 103, 30);
		contentPane.add(btnDados);
		
		btnCursos = new JButton("Clique Aqui!");
		btnCursos.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCursos.setBounds(250, 144, 103, 30);
		contentPane.add(btnCursos);
		
		btnProfessores = new JButton("Clique Aqui!");
		btnProfessores.setFont(new Font("Arial", Font.PLAIN, 12));
		btnProfessores.setBounds(250, 226, 103, 30);
		contentPane.add(btnProfessores);
		
		lblVerificarDadosE = new JLabel("Verificar Dados e Gerar Relatorios");
		lblVerificarDadosE.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificarDadosE.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblVerificarDadosE.setBounds(10, 102, 230, 30);
		contentPane.add(lblVerificarDadosE);
		
		lblCadastrarCursosE = new JLabel("Cadastrar Cursos e Disciplinas");
		lblCadastrarCursosE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCursosE.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCadastrarCursosE.setBounds(10, 144, 230, 30);
		contentPane.add(lblCadastrarCursosE);
		
		lblVerificarDadosE_2 = new JLabel("Verificar Cadastro dos Professores");
		lblVerificarDadosE_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificarDadosE_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblVerificarDadosE_2.setBounds(10, 226, 230, 30);
		contentPane.add(lblVerificarDadosE_2);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 322, 372, 2);
		contentPane.add(separator_1);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(125, 335, 60, 43);
		contentPane.add(btnVoltar);
		
		btnTurmas = new JButton("Clique Aqui!");
		btnTurmas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTurmas.setBounds(250, 185, 103, 30);
		contentPane.add(btnTurmas);
		
		lblCadastrarCursosE_1 = new JLabel("Cadastrar Turmas");
		lblCadastrarCursosE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCursosE_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCadastrarCursosE_1.setBounds(10, 185, 230, 30);
		contentPane.add(lblCadastrarCursosE_1);
		
		btnCoordenadores = new JButton("Clique Aqui!");
		btnCoordenadores.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCoordenadores.setBounds(250, 267, 103, 30);
		contentPane.add(btnCoordenadores);
		
		lblVerificarDadosE_1 = new JLabel("Verificar Cadastro do Coordenador");
		lblVerificarDadosE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificarDadosE_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblVerificarDadosE_1.setBounds(10, 267, 234, 30);
		contentPane.add(lblVerificarDadosE_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 137, 372, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 178, 372, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(0, 220, 372, 2);
		contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(0, 262, 372, 2);
		contentPane.add(separator_5);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_MenuCoordenador.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(195, 335, 60, 43);
		contentPane.add(btnSair);
	}
}
