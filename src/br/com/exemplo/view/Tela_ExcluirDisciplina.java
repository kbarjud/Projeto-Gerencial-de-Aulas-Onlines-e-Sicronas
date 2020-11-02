package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Tela_ExcluirDisciplina extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JList list;
	private JLabel lblCurso;
	private JComboBox comboBox;
	private JButton btnPesquisar;
	private JButton btnPdf;
	private JButton btnConsultar;
	private JButton btnSair;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ExcluirDisciplina frame = new Tela_ExcluirDisciplina();
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
	public Tela_ExcluirDisciplina() {
		setTitle("Tela de Excluir Disciplina. By: New Gen's");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Disciplinas");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setBounds(10, 57, 414, 152);
		contentPane.add(list);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 15, 56, 21);
		contentPane.add(lblCurso);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(82, 17, 197, 21);
		contentPane.add(comboBox);
		
		btnPesquisar = new JButton("Consultar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPesquisar.setBounds(307, 11, 108, 30);
		contentPane.add(btnPesquisar);
		
		btnPdf = new JButton("");
		btnPdf.setIcon(new ImageIcon(Tela_ExcluirDisciplina.class.getResource("/br/com/exemplo/view/images/excluir.png")));
		btnPdf.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPdf.setBounds(270, 258, 83, 73);
		contentPane.add(btnPdf);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_ExcluirDisciplina.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(84, 258, 83, 73);
		contentPane.add(btnConsultar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_ExcluirDisciplina.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(177, 258, 83, 73);
		contentPane.add(btnSair);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 235, 434, 2);
		contentPane.add(separator_1);
	}
}
