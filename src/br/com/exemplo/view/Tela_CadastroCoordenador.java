package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.exemplo.dao.CoordenadorDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Professores;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Tela_CadastroCoordenador extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblBemVindoA;
	private JSeparator separator_1;
	private JLabel lblNome;
	private JTextField txtNomeCoordenador;
	private JLabel lblCodDoCoordenador;
	private JTextField txtCodCoordenador;
	private JLabel lblSenha;
	private JPasswordField passSenha;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblCelular;
	private JFormattedTextField ftfCelular;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSair;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	private JTable tabCadastroCoordenador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroCoordenador frame = new Tela_CadastroCoordenador();
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
	public Tela_CadastroCoordenador() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 551);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Cadastro");
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
		
		lblBemVindoA = new JLabel("Bem Vindo a Tela de Cadastro");
		lblBemVindoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA.setBounds(10, 11, 365, 30);
		contentPane.add(lblBemVindoA);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 424, 385, 2);
		contentPane.add(separator_1);
		
		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(39, 52, 116, 30);
		contentPane.add(lblNome);
		
		txtNomeCoordenador = new JTextField();
		txtNomeCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNomeCoordenador.setColumns(10);
		txtNomeCoordenador.setBounds(182, 52, 155, 30);
		contentPane.add(txtNomeCoordenador);
		
		lblCodDoCoordenador = new JLabel("Cod do Coordenador");
		lblCodDoCoordenador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodDoCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCodDoCoordenador.setBounds(20, 96, 135, 30);
		contentPane.add(lblCodDoCoordenador);
		
		txtCodCoordenador = new JTextField();
		txtCodCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodCoordenador.setColumns(10);
		txtCodCoordenador.setBounds(182, 96, 155, 30);
		contentPane.add(txtCodCoordenador);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSenha.setBounds(39, 137, 116, 30);
		contentPane.add(lblSenha);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(182, 137, 155, 30);
		contentPane.add(passSenha);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEmail.setBounds(39, 178, 116, 30);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(182, 178, 155, 30);
		contentPane.add(txtEmail);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCelular.setBounds(39, 219, 116, 30);
		contentPane.add(lblCelular);
		
		ftfCelular = new JFormattedTextField();
		ftfCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		ftfCelular.setBounds(182, 221, 155, 30);
		contentPane.add(ftfCelular);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					Coordenador coordenador = new Coordenador();
					coordenador.setNome(txtNomeCoordenador.getText());
					coordenador.setCodCoordenador(Integer.parseInt(txtCodCoordenador.getText()));
					coordenador.setSenha(String.valueOf(passSenha.getPassword()));
					coordenador.setEmail(txtEmail.getText());
					coordenador.setCelular(ftfCelular.getText());
					coordenador.setStatus("Ativo");
					
					CoordenadorDAO coordenadorDao = new CoordenadorDAO();
					coordenadorDao.Salvar(coordenador);
					
					List<Professores> lista = new ArrayList<Professores>();
					ProfessoresDAO professorDao1 = new ProfessoresDAO();
					lista = professorDao1.ListarTodos1(Integer.parseInt(txtCodProfessor.getText()));
					DefaultTableModel model = (DefaultTableModel) tabCadastroProfessor.getModel();
					model.setNumRows(0);
					for (Professores professor1 : lista) {
						model.addRow (new Object[] {
								professor1.getIdProfessor(),
								professor1.getCodProfessor(),
								professor1.getNome(),
								professor1.getSenha(),
								professor1.getEmail(),
								professor1.getCelular(),
								professor1.getStatus(),
							});
					} 
					JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Fazer o Cadastro!!. "
							+ "\n1. Verifique se Todos os Campos Foram Preenchidos"
							+ "\n2. Caso Todos Estejam Preenchidos. Verifique se Você Fez Seu Cadastro"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/salvar2.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(161, 262, 60, 43);
		contentPane.add(btnSalvar);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(20, 437, 60, 43);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(90, 437, 60, 43);
		contentPane.add(btnVoltar);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(160, 437, 60, 43);
		contentPane.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(230, 437, 60, 43);
		contentPane.add(btnAlterar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(302, 437, 60, 43);
		contentPane.add(btnSair);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 316, 385, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 366, 84);
		contentPane.add(scrollPane);
		
		tabCadastroCoordenador = new JTable();
		tabCadastroCoordenador.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID Coordenador(a)", "C\u00F3digo do(a) Coordenador(a)", "Nome", "Senha", "Email", "Celular", "Status"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		tabCadastroCoordenador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabCadastroCoordenador.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabCadastroCoordenador.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabCadastroCoordenador.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabCadastroCoordenador.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabCadastroCoordenador.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabCadastroCoordenador.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabCadastroCoordenador.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tabCadastroCoordenador);
	}
}
