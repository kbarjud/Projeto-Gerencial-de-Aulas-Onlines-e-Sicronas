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
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.CoordenadorDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Professores;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

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
	private JTable tabCoordenador;
	JTextField txtControle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroCoordenador frame = new Tela_CadastroCoordenador();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void formatarCampo() {
		try {
			MaskFormatter formatarCelular = new MaskFormatter ("(##) #####-####");
			formatarCelular.install(ftfCelular);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar o campo: Erro: " + e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public Tela_CadastroCoordenador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 561);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Cadastro");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "========================================Cadastro========================================"
						+ "\n Nesta �rea voc� poder�: "
						+ "\n\n 1. Se cadastrar"
						+ "\n 2. Alterar seu cadastro"
						+ "\n 3. Consultar seu cadastro"
						+ "\n\n=======================================Informa��es======================================"
						+ "\n* O c�digo do coordenador que � solicitado no campo login e cadastro � o mesmo usado na faculdade"
						+ "\n** O ID do coordenador � diferente do c�digo do coordenador, se necess�rio realize primeiro uma consulta"
						+ "\n=======================================================================================", "Informa��es do Coordenador(a)", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String javaI = System.getProperty("java.version");
				String javaRE = System.getProperty("java.runtime.version");
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Vers�o: " + osVersion
						+ "\n Vers�o do Java: " + javaI + " e Vers�o da Runtime: " + javaRE
						+ "\n=====================================================", "Informa��es do Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBemVindoA = new JLabel("Bem Vindo a Tela de Cadastro e Altera\u00E7\u00E3o");
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
		formatarCampo();
		ftfCelular.setBounds(182, 221, 155, 30);
		contentPane.add(ftfCelular);
		
		btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
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
					
					List<Coordenador> lista = new ArrayList<Coordenador>();
					CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
					lista = coordenadorDAO.ListarTodos1(Integer.parseInt(txtCodCoordenador.getText()));
					DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
					model.setNumRows(0);
					for (Coordenador coordenador1 : lista) {
						model.addRow (new Object[] {
								coordenador1.getIdCoordenador(),
								coordenador1.getCodCoordenador(),
								coordenador1.getNome(),
								coordenador1.getSenha(),
								coordenador1.getEmail(),
								coordenador1.getCelular(),
								coordenador1.getStatus(),
							});
					} 
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					txtCodCoordenador.setText(null);
					passSenha.setText(null);
					txtNomeCoordenador.setText(null);
					txtEmail.setText(null);
					ftfCelular.setText(null);
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao fazer cadastro!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se voc� realizou seu cadastro"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(161, 262, 60, 43);
		contentPane.add(btnSalvar);
		
		btnNovo = new JButton("");
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodCoordenador.setText(null);
				passSenha.setText(null);
				txtNomeCoordenador.setText(null);
				txtEmail.setText(null);
				ftfCelular.setText(null);
				((DefaultTableModel) tabCoordenador.getModel()).setRowCount(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(88, 437, 60, 43);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtControle.getText().equals("telaInicial")) {
					Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
					telaCadastroCoordenador.setVisible(false);
					dispose();
					Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
					telaInicialCoordenador.setVisible(true);
				}
				else if (txtControle.getText().equals("telaConsultarCoordenador")) {
					Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
					telaCadastroCoordenador.setVisible(false);
					dispose();
					Tela_ConsultarCoordenador telaConsultarCoordenador = new Tela_ConsultarCoordenador();
					telaConsultarCoordenador.setVisible(true);
				}
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(14, 437, 60, 43);
		contentPane.add(btnVoltar);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					
					CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDAO.Consultar(codCoordenador);
					 
					if (codCoordenador == coordenador.getCodCoordenador()) {
						List<Coordenador> lista = new ArrayList<Coordenador>();
						CoordenadorDAO coordenadorDao = new CoordenadorDAO();
						lista = coordenadorDao.ListarTodos1(codCoordenador);
						DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
						model.setNumRows(0);
						for (Coordenador coordenador1 : lista) {
							model.addRow (new Object[] {
									coordenador1.getIdCoordenador(),
									coordenador1.getCodCoordenador(),
									coordenador1.getNome(),
									coordenador1.getSenha(),
									coordenador1.getEmail(),
									coordenador1.getCelular(),
									coordenador1.getStatus(),
								});
							txtCodCoordenador.setText(String.valueOf(coordenador.getCodCoordenador()));
							txtNomeCoordenador.setText(coordenador.getNome());
							passSenha.setText(coordenador.getSenha());
							txtEmail.setText(coordenador.getEmail());
							ftfCelular.setText(coordenador.getCelular());
						} 
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Coordenador n�o cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar!!. "
							+ "\n\n1. Para fazer uma consulta, informe o c�digo do professor"
							+ "\n2. Verifique se os dados foram digitados corretamente"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(162, 437, 60, 43);
		contentPane.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coordenador coordenador = new Coordenador();
					coordenador.setCodCoordenador(Integer.parseInt(txtCodCoordenador.getText()));
					coordenador.setNome(txtNomeCoordenador.getText());
					coordenador.setSenha(String.valueOf(passSenha.getPassword()));
					coordenador.setEmail(txtEmail.getText());
					coordenador.setCelular(ftfCelular.getText());
					coordenador.setStatus("Ativo");
					
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
					String id = (String) JOptionPane.showInputDialog(null, "Informe o ID do Coordenador: ", "ID Coordenador", JOptionPane.OK_CANCEL_OPTION, icon, null, null);
					int idCoordenador = Integer.parseInt(id);
					coordenador.setIdCoordenador(idCoordenador);
						
					CoordenadorDAO coordenadorDao = new CoordenadorDAO();
					// alterar
					coordenadorDao.Alterar(coordenador);
					
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					
					List<Coordenador> lista = new ArrayList<Coordenador>();
					lista = coordenadorDao.ListarTodos1(codCoordenador);
					DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
					model.setNumRows(0);
					for (Coordenador coordenador1 : lista) {
						model.addRow (new Object[] {
								coordenador1.getIdCoordenador(),
								coordenador1.getCodCoordenador(),
								coordenador1.getNome(),
								coordenador1.getSenha(),
								coordenador1.getEmail(),
								coordenador1.getCelular(),
								coordenador1.getStatus(),
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
							+ "\n3. Caso n�o saiba o ID  , realize primeiro uma consulta"
							+ "\n\n======================================Informa��es=====================================" 
							+ "\n* O c�digo do coordenador que � solicitado no campo login e cadastro � o mesmo usado na faculdade" 
							+ "\n** O ID do coordenador � diferente do c�digo do professor, se necess�rio realize primeiro uma consulta"
							+ "\n====================================================================================="
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(236, 437, 60, 43);
		contentPane.add(btnAlterar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroCoordenador.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(310, 437, 60, 43);
		contentPane.add(btnSair);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 316, 385, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 366, 84);
		contentPane.add(scrollPane);
		
		tabCoordenador = new JTable();
		tabCoordenador.setModel(new DefaultTableModel(
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
		tabCoordenador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabCoordenador.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabCoordenador.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabCoordenador.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabCoordenador.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabCoordenador.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tabCoordenador);
		
		txtControle = new JTextField();
		txtControle.setVisible(false);
		txtControle.setFont(new Font("Arial", Font.PLAIN, 14));
		txtControle.setColumns(10);
		txtControle.setBounds(10, 275, 135, 30);
		contentPane.add(txtControle);
	}
}
