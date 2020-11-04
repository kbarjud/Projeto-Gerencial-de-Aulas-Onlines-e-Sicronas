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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Tela_CadastroCurso extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblMateria;
	private JTextField txtDisciplina;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_2;
	private JButton btnCadastrar;
	private JButton btnNovoCurso;
	private JScrollPane scrollPane;
	private JTable tabCursosDisciplinas;
	private JSeparator separator_1;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnSair;
	private JButton btnAlterar;
	private JComboBox cmbCurso_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroCurso frame = new Tela_CadastroCurso();
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
	public Tela_CadastroCurso() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 446);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Cursos e Disciplinas");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Sobre o Sistema");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Sair");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 11, 56, 21);
		contentPane.add(lblCurso);
		
		cmbCurso = new JComboBox();
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(92, 13, 187, 21);
		contentPane.add(cmbCurso);
		
		lblMateria = new JLabel("Disciplina");
		lblMateria.setHorizontalAlignment(SwingConstants.LEFT);
		lblMateria.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMateria.setBounds(10, 54, 72, 21);
		contentPane.add(lblMateria);
		
		txtDisciplina = new JTextField();
		txtDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDisciplina.setColumns(10);
		txtDisciplina.setBounds(92, 55, 187, 20);
		contentPane.add(txtDisciplina);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrar.setBounds(307, 66, 108, 30);
		contentPane.add(btnCadastrar);
		
		btnNovoCurso = new JButton("Cursos");
		btnNovoCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovoCurso.setBounds(307, 23, 108, 30);
		contentPane.add(btnNovoCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 405, 178);
		contentPane.add(scrollPane);
		
		tabCursosDisciplinas = new JTable();
		scrollPane.setViewportView(tabCursosDisciplinas);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 317, 425, 2);
		contentPane.add(separator_1);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/excluir.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(114, 330, 60, 43);
		contentPane.add(btnExcluir);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(254, 330, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(44, 330, 60, 43);
		contentPane.add(btnVoltar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(324, 330, 60, 43);
		contentPane.add(btnSair);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(184, 330, 60, 43);
		contentPane.add(btnAlterar);
		
		cmbCurso_1 = new JComboBox();
		cmbCurso_1.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso_1.setBounds(92, 85, 187, 21);
		contentPane.add(cmbCurso_1);
	}
}
