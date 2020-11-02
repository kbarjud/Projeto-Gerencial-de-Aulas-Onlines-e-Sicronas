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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Tela_Inicial extends JFrame {

	private JPanel contentPane;
	private JLabel lblBemVindo;
	private JLabel lblProfessorCoordenador;
	private JButton btnProfessor;
	private JButton btnCoordenador;
	private JMenuBar menuBar;
	private JMenu mnInformacoes;
	private JMenu mnAjuda;
	private JMenuItem mnCoordenador;
	private JMenuItem mnSobreSistema;
	private JMenuItem mnSair;
	private JSeparator separator;
	private JMenuItem mnProfessor;
	private JSeparator separator_1;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Inicial frame = new Tela_Inicial();
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
	public Tela_Inicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Inicial.class.getResource("/br/com/exemplo/view/images/icone2.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 273);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInformacoes = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnInformacoes);
		
		mnCoordenador = new JMenuItem("Coordenador(a)");
		mnCoordenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "====================Coordenador(a)===================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Cursos, Disciplinas e Turma"
						+ "\n 2. Consultar os Professores e os Coordenadores Cadastrados"
						+ "\n 3. Consultar os Dados das Aulas Que Já Foram Cadastradas"
						+ "\n 4. Criar o Seu Login"
						+ "\n=====================================================");
			}
		});
		mnInformacoes.add(mnCoordenador);
		
		mnProfessor = new JMenuItem("Professor(a)");
		mnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=======================Professor(a)======================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Dados da Aula"
						+ "\n 2. Criar o Seu Login"
						+ "\n========================================================");
			}
		});
		mnInformacoes.add(mnProfessor);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mnSobreSistema = new JMenuItem("Sobre o Sistema");
		mnSobreSistema.addActionListener(new ActionListener() {
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
		mnAjuda.add(mnSobreSistema);
		
		separator = new JSeparator();
		mnAjuda.add(separator);
		
		mnSair = new JMenuItem("Sair");
		mnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnAjuda.add(mnSair);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBemVindo = new JLabel("Seja Bem Vindo!");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindo.setBounds(10, 11, 294, 30);
		contentPane.add(lblBemVindo);
		
		lblProfessorCoordenador = new JLabel("Voc\u00EA \u00E9 Professor(a) ou Coordenador(a)?");
		lblProfessorCoordenador.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessorCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblProfessorCoordenador.setBounds(10, 52, 294, 30);
		contentPane.add(lblProfessorCoordenador);
		
		btnProfessor = new JButton("Professor(a)");
		btnProfessor.setToolTipText("Bot\u00E3o Professor(a)");
		btnProfessor.setForeground(Color.BLACK);
		btnProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(false);
				dispose();
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(true);
			}
		});
		btnProfessor.setBounds(10, 99, 146, 30);
		contentPane.add(btnProfessor);
		
		btnCoordenador = new JButton("Coordenador(a)");
		btnCoordenador.setToolTipText("Bot\u00E3o Coordenador(a)");
		btnCoordenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(false);
				dispose();
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(true);
			}
		});
		btnCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCoordenador.setBounds(158, 99, 146, 30);
		contentPane.add(btnCoordenador);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 140, 315, 2);
		contentPane.add(separator_1);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_Inicial.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(128, 159, 60, 43);
		contentPane.add(btnSair);
	}
}
