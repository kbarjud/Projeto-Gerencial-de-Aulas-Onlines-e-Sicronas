package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.model.Professores;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_CadastroProfessor extends JFrame {

	private JPanel contentPane;
	private JLabel lblCdigoDoProfessor;
	private JTextField txtCodProfessor;
	private JPasswordField passSenha;
	private JLabel lblSenha;
	private JLabel lblNome;
	private JTextField txtNomeProfessor;
	private JLabel lblBemVindoA;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnVoltar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSair;
	private JLabel lblEmail;
	private JLabel lblCelular;
	private JTextField txtEmail;
	private JFormattedTextField ftfCelular;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	private JTable tabCadastroProfessor;
	JTextField txtControle;

	
	private void formatarCampo() {
		try {
			MaskFormatter formatarCelular = new MaskFormatter ("(##) #####-####");
			formatarCelular.install(ftfCelular);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar o campo: Erro: " + e.getMessage());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroProfessor frame = new Tela_CadastroProfessor();
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
	public Tela_CadastroProfessor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 558);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Cadastro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "======================================Cadastro======================================"
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Se cadastrar"
						+ "\n 2. Alterar seu cadastro"
						+ "\n 3. Consultar seu cadastro"
						+ "\n\n=====================================Informações===================================="
						+ "\n* O código do professor que é solicitado no campo login e cadastro é o mesmo usado na faculdade"
						+ "\n** O ID do professor é diferente do código do professor, se necessário realize primeiro uma consulta"
						+ "\n===================================================================================", "Informações do Professor(a)", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String javaI = System.getProperty("java.version");
				String javaRE = System.getProperty("java.runtime.version");
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================", "Informações do Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			};
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigoDoProfessor = new JLabel("Cod do Professor");
		lblCdigoDoProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDoProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCdigoDoProfessor.setBounds(39, 96, 116, 30);
		contentPane.add(lblCdigoDoProfessor);
		
		txtCodProfessor = new JTextField();
		txtCodProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodProfessor.setColumns(10);
		txtCodProfessor.setBounds(182, 96, 155, 30);
		contentPane.add(txtCodProfessor);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(182, 137, 155, 30);
		contentPane.add(passSenha);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSenha.setBounds(39, 137, 116, 30);
		contentPane.add(lblSenha);
		
		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(39, 52, 116, 30);
		contentPane.add(lblNome);
		
		txtNomeProfessor = new JTextField();
		txtNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNomeProfessor.setColumns(10);
		txtNomeProfessor.setBounds(182, 52, 155, 30);
		contentPane.add(txtNomeProfessor);
		
		lblBemVindoA = new JLabel("Bem Vindo a Tela de Cadastro e Altera\u00E7\u00E3o");
		lblBemVindoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA.setBounds(10, 11, 365, 30);
		contentPane.add(lblBemVindoA);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 423, 385, 2);
		contentPane.add(separator_1);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtControle.getText().equals("telaInicial")) {
					Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
					telaCadastroProfessor.setVisible(false);
					dispose();
					Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
					telaInicialProfessor.setVisible(true);
				}
				else if (txtControle.getText().equals("telaConsultaProfessor")) {
					Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
					telaCadastroProfessor.setVisible(false);
					dispose();
					Tela_ConsultarProfessor telaConsultarProfessor = new Tela_ConsultarProfessor();
					telaConsultarProfessor.setVisible(true);
				}
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 436, 60, 43);
		contentPane.add(btnVoltar);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codProfessor = Integer.parseInt(txtCodProfessor.getText());
					
					ProfessoresDAO professorDAO = new ProfessoresDAO();
					Professores professor = new Professores();
					professor = professorDAO.Consultar(codProfessor);
					 
					if (codProfessor == professor.getCodProfessor()) {
						List<Professores> lista = new ArrayList<Professores>();
						ProfessoresDAO professorDao = new ProfessoresDAO();
						lista = professorDAO.ListarTodos1(codProfessor);
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
							txtCodProfessor.setText(String.valueOf(professor.getCodProfessor()));
							txtNomeProfessor.setText(professor.getNome());
							passSenha.setText(professor.getSenha());
							txtEmail.setText(professor.getEmail());
							ftfCelular.setText(professor.getCelular());
						} 
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Professor não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar!!. "
							+ "\n\n1. Para fazer uma consulta, informe o código do professor"
							+ "\n2. Verifique se os dados foram digitados corretamente"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(156, 436, 60, 43);
		contentPane.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Professores professor = new Professores();
					professor.setCodProfessor(Integer.parseInt(txtCodProfessor.getText()));
					professor.setNome(txtNomeProfessor.getText());
					professor.setSenha(String.valueOf(passSenha.getPassword()));
					professor.setEmail(txtEmail.getText());
					professor.setCelular(ftfCelular.getText());
					professor.setStatus("Ativo");
					
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
					String id = (String) JOptionPane.showInputDialog(null, "Informe o ID do Professor: ", "ID Professor", JOptionPane.OK_CANCEL_OPTION, icon, null, null);
					int idProfessor = Integer.parseInt(id);
					
					professor.setIdProfessor(idProfessor);
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					
					// alterar
					professoresDao.Alterar(professor);
					
					int codProfessor = Integer.parseInt(txtCodProfessor.getText());
					
					List<Professores> lista = new ArrayList<Professores>();
					ProfessoresDAO professorDao = new ProfessoresDAO();
					lista = professorDao.ListarTodos1(codProfessor);
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
					Object[] options1 = {"OK"};
					ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Alterado com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
				} catch(Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Alterar!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Verifique se o ID foi informado corretamente"
							+ "\n3. Caso não saiba o ID  , realize primeiro uma consulta"
							+ "\n\n=====================================Informações====================================" 
							+ "\n* O código do professor que é solicitado no campo login e cadastro é o mesmo usado na faculdade" 
							+ "\n** O ID do professor é diferente do código do professor, se necessário realize primeiro uma consulta"
							+ "\n==================================================================================="
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(229, 436, 60, 43);
		contentPane.add(btnAlterar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(302, 436, 60, 43);
		contentPane.add(btnSair);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblEmail.setBounds(39, 178, 116, 30);
		contentPane.add(lblEmail);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCelular.setBounds(39, 219, 116, 30);
		contentPane.add(lblCelular);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(182, 178, 155, 30);
		contentPane.add(txtEmail);
		
		ftfCelular = new JFormattedTextField();
		ftfCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		ftfCelular.setBounds(182, 221, 155, 30);
		formatarCampo();
		contentPane.add(ftfCelular);
		
		btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					Professores professor = new Professores();
					professor.setNome(txtNomeProfessor.getText());
					professor.setCodProfessor(Integer.parseInt(txtCodProfessor.getText()));
					professor.setSenha(String.valueOf(passSenha.getPassword()));
					professor.setEmail(txtEmail.getText());
					professor.setCelular(ftfCelular.getText());
					professor.setStatus("Ativo");
					
					ProfessoresDAO professorDao = new ProfessoresDAO();
					professorDao.Salvar(professor);
					
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
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Fazer o Cadastro!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se você realizou seu cadastro"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(160, 262, 60, 43);
		contentPane.add(btnSalvar);
		
		btnNovo = new JButton("");
		btnNovo.setToolTipText("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tabCadastroProfessor.getModel()).setRowCount(0);
				txtCodProfessor.setText(null);
				passSenha.setText(null);
				txtNomeProfessor.setText(null);
				txtEmail.setText(null);
				ftfCelular.setText(null);
				((DefaultTableModel) tabCadastroProfessor.getModel()).setRowCount(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_CadastroProfessor.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(83, 436, 60, 43);
		contentPane.add(btnNovo);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 316, 385, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 365, 83);
		contentPane.add(scrollPane);
		
		tabCadastroProfessor = new JTable();
		tabCadastroProfessor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabCadastroProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Professor(a)", "Cód. do(a) Professor(a)", "Nome", "Senha", "Email", "Celular", "Status"
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
		tabCadastroProfessor.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabCadastroProfessor.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabCadastroProfessor.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabCadastroProfessor.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabCadastroProfessor.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabCadastroProfessor.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabCadastroProfessor.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tabCadastroProfessor);
		
		txtControle = new JTextField();
		txtControle.setVisible(false);
		txtControle.setFont(new Font("Arial", Font.PLAIN, 14));
		txtControle.setColumns(10);
		txtControle.setBounds(10, 275, 140, 30);
		contentPane.add(txtControle);
	}
}

