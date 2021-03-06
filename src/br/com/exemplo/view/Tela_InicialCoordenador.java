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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_InicialCoordenador extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JLabel lblJCadastrado;
	private JLabel lblAindaNoTem;
	private JLabel lblCodDoCoordenador;
	private JLabel lblSenha;
	private JTextField txtCodCoordenador;
	private JPasswordField passSenha;
	private JButton btnCadastreSe;
	private JButton btnEntrar;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JButton btnSair;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnNovo;
	private JSeparator separator_3;
	private JScrollPane scrollPane;
	private JTable tabCoordenador;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_InicialCoordenador frame = new Tela_InicialCoordenador();
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
	public Tela_InicialCoordenador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 434);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/info30.png")));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Cadastro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "======================================Coordenador(a)======================================"
						+ "\n Nesta �rea voc� poder�: "
						+ "\n\n 1. Fazer seu login"
						+ "\n 2. Se cadastrar"
						+ "\n 3. Alterar seu cadastro"
						+ "\n 4. Consultar seu cadastro"
						+ "\n\n=======================================Informa��es======================================="
						+ "\n O c�digo do coordenador que � solicitado no campo de login e de cadastro � o mesmo usado na faculdade"
						+ "\n========================================================================================", "Informa��es do Coordenador(a)", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/help30.png")));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
						+ "\n Instalado: " + osName + " e Vers�o: " + osVersion
						+ "\n Vers�o do Java: " + javaI + " e Vers�o da Runtime: " + javaRE
						+ "\n=====================================================", "Informa��es do Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
			}
		});
		
		mntmNewMenuItem_3 = new JMenuItem("Entrar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					String senha = String.valueOf(passSenha.getPassword());
					String status = "Ativo";
					
					CoordenadorDAO coordenadorDao = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDao.Login(codCoordenador, senha, status);
					
					if ((codCoordenador == coordenador.getCodCoordenador()) && (senha.equals(coordenador.getSenha())) && (status.equals(coordenador.getStatus()))) {
						String nome = coordenador.getNome();
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
						JOptionPane.showOptionDialog(null, "Seja Bem Vindo Coordenador(a): " + nome, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();			
						telaInicialCoordenador.setVisible (false);
						dispose();
						Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
						telaMenuCoordenador.setVisible(true);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						JOptionPane.showOptionDialog(null, "Coordenador n�o cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Fazer o Login!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se voc� realizou seu cadastro"
							+ "\n3. Caso realizado, verifique se os dados foram digitados corretamente."
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJCadastrado = new JLabel("J\u00E1 \u00E9 Cadastrado?");
		lblJCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblJCadastrado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblJCadastrado.setBounds(10, 11, 342, 30);
		contentPane.add(lblJCadastrado);
		
		lblAindaNoTem = new JLabel("Ainda N\u00E3o Tem Cadastro?");
		lblAindaNoTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAindaNoTem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAindaNoTem.setBounds(10, 254, 183, 30);
		contentPane.add(lblAindaNoTem);
		
		lblCodDoCoordenador = new JLabel("Cod do Coordenador");
		lblCodDoCoordenador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodDoCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCodDoCoordenador.setBounds(10, 50, 127, 30);
		contentPane.add(lblCodDoCoordenador);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSenha.setBounds(10, 91, 127, 30);
		contentPane.add(lblSenha);
		
		txtCodCoordenador = new JTextField();
		txtCodCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodCoordenador.setColumns(10);
		txtCodCoordenador.setBounds(147, 52, 143, 30);
		contentPane.add(txtCodCoordenador);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(147, 93, 143, 30);
		contentPane.add(passSenha);
		
		btnCadastreSe = new JButton("Cadastre-se Aqui");
		btnCadastreSe.setToolTipText("");
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(false);
				dispose();
				Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
				telaCadastroCoordenador.txtControle.setText("telaInicial");
				telaCadastroCoordenador.setVisible(true);
			}
		});
		btnCadastreSe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastreSe.setBounds(203, 255, 149, 30);
		contentPane.add(btnCadastreSe);
		
		btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/enter-2.png")));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					String senha = String.valueOf(passSenha.getPassword());
					String status = "Ativo";
					
					CoordenadorDAO coordenadorDao = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDao.Login(codCoordenador, senha, status);
					 
					if (codCoordenador == coordenador.getCodCoordenador() && senha.equals(coordenador.getSenha()) && status.equals(coordenador.getStatus())) {
						String nome = coordenador.getNome();
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
						JOptionPane.showOptionDialog(null, "Seja Bem Vindo Coordenador(a): " + nome, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();			
						telaInicialCoordenador.setVisible (false);
						dispose();
						Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
						telaMenuCoordenador.setVisible(true);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						JOptionPane.showOptionDialog(null, "Coordenador n�o cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Fazer o Login!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se voc� realizou seu cadastro"
							+ "\n3. Caso realizado, verifique se os dados foram digitados corretamente."
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnEntrar.setToolTipText("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntrar.setBounds(300, 67, 60, 43);
		contentPane.add(btnEntrar);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 134, 379, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 295, 379, 3);
		contentPane.add(separator_2);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(300, 309, 60, 43);
		contentPane.add(btnSair);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(false);
				dispose();
				Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
				telaCadastroCoordenador.txtControle.setText("telaInicial");
				telaCadastroCoordenador.setVisible(true);
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(228, 309, 60, 43);
		contentPane.add(btnAlterar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					
					CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDAO.Consultar(codCoordenador);
					 
					if (codCoordenador == coordenador.getCodCoordenador()) {
						List<Coordenador> lista = new ArrayList<Coordenador>();
						lista = coordenadorDAO.ListarTodos1(codCoordenador);
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
						passSenha.setText(coordenador.getSenha());
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
							+ "\n\n1. Para realizar uma consulta, informe o c�digo do professor"
							+ "\n2. Caso informado, verifique se os dados foram digitados corretamente"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(156, 309, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(false);
				dispose();
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(12, 309, 60, 43);
		contentPane.add(btnVoltar);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tabCoordenador.getModel()).removeRow(0);
				txtCodCoordenador.setText(null);
				passSenha.setText(null);
				((DefaultTableModel) tabCoordenador.getModel()).removeRow(0);
			}
		});
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(84, 309, 60, 43);
		contentPane.add(btnNovo);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 241, 379, 2);
		contentPane.add(separator_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 353, 86);
		contentPane.add(scrollPane);
		
		tabCoordenador = new JTable();
		tabCoordenador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Coordenador(a)", "C�d. Coordenador(a)", "Nome", "Senha", "Email", "Celular", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabCoordenador.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabCoordenador.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabCoordenador.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabCoordenador.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabCoordenador.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		scrollPane.setViewportView(tabCoordenador);
		tabCoordenador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}
