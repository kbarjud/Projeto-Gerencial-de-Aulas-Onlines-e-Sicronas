package br.com.exemplo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import br.com.exemplo.model.Curso;
import br.com.exemplo.model.Professores;
import br.com.exemplo.model.Turma;
import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.dao.TurmaDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_InicialProfessor extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastrado;
	private JLabel lblAindaNoTem;
	private JLabel lblCdigoDoProfessor;
	private JLabel lblSenha;
	JTextField txtCodProfessor;
	JPasswordField passSenha;
	private JButton btnCadastreSe;
	private JButton btnConsultar;
	private JButton btnEntrar;
	private JButton btnAlterar;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnCadastro;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JButton btnSair;
	private JButton btnVoltar;
	private JSeparator separator_3;
	private JScrollPane scrollPane;
	private JTable tabProfessor;
	private JButton btnNovo;
	private JMenuItem mnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_InicialProfessor frame = new Tela_InicialProfessor();
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
	public Tela_InicialProfessor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 432);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mnCadastro = new JMenuItem("Professor(a)");
		mnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "======================================Professor(a)======================================"
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Fazer seu login"
						+ "\n 2. Se cadastrar"
						+ "\n 3. Alterar seu cadastro"
						+ "\n 4. Consultar seu cadastro"
						+ "\n\n======================================Informações======================================"
						+ "\n O código do professor que é solicitado no campo de login e de cadastro é o mesmo usado na faculdade"
						+ "\n======================================================================================", "Informações do Professor(a)", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu.add(mnCadastro);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_3 = new JMenuItem("Sair");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnEntrar = new JMenuItem("Entrar");
		mnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int codProfessor = Integer.parseInt(txtCodProfessor.getText());
					String senha = String.valueOf(passSenha.getPassword());
					String status = "Ativo";
					
					ProfessoresDAO professorDAO = new ProfessoresDAO();
					Professores professor = new Professores();
					professor = professorDAO.Login(codProfessor, senha, status);
					 
					if (codProfessor == professor.getCodProfessor() && senha.equals(professor.getSenha())) {
						String nome = professor.getNome();
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
						JOptionPane.showOptionDialog(null, "Seja Bem Vindo Professor(a): " + nome, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();			
						telaInicialProfessor.setVisible (false);
						dispose();
						Tela_CadastroAula telaCadastroAula = new Tela_CadastroAula();
						String codigoProf = Integer.toString(codProfessor);
						telaCadastroAula.txtCodProfessor.setText(codigoProf);
						telaCadastroAula.txtSenhaProf.setText(senha);
						telaCadastroAula.setVisible(true);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						JOptionPane.showOptionDialog(null, "Professor não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Fazer o Login!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se você realizou seu cadastro"
							+ "\n3. Caso realizado, verifique se os dados foram digitados corretamente."
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					
				}
			}
		});
		mnEntrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		mnNewMenu_1.add(mnEntrar);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCadastrado = new JLabel("J\u00E1 \u00E9 Cadastrado?");
		lblCadastrado.setForeground(Color.BLACK);
		lblCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblCadastrado.setBounds(10, 11, 342, 30);
		contentPane.add(lblCadastrado);
		
		lblAindaNoTem = new JLabel("Ainda N\u00E3o Tem Cadastro?");
		lblAindaNoTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAindaNoTem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAindaNoTem.setBounds(10, 254, 183, 30);
		contentPane.add(lblAindaNoTem);
		
		lblCdigoDoProfessor = new JLabel("Cod do Professor");
		lblCdigoDoProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDoProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCdigoDoProfessor.setBounds(10, 50, 116, 30);
		contentPane.add(lblCdigoDoProfessor);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSenha.setBounds(10, 91, 116, 30);
		contentPane.add(lblSenha);
		
		txtCodProfessor = new JTextField();
		txtCodProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodProfessor.setBounds(136, 52, 146, 30);
		contentPane.add(txtCodProfessor);
		txtCodProfessor.setColumns(10);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(136, 93, 146, 30);
		contentPane.add(passSenha);
		
		btnCadastreSe = new JButton("Cadastre-se Aqui");
		btnCadastreSe.setToolTipText("");
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
				telaCadastroProfessor.txtControle.setText("telaInicial");
				telaCadastroProfessor.setVisible(true);
			}
		});
		btnCadastreSe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastreSe.setBounds(203, 255, 149, 30);
		contentPane.add(btnCadastreSe);
		
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
							DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
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
							passSenha.setText(professor.getSenha());
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
								+ "\n\n1. Para realizar uma consulta, informe o código do professor"
								+ "\n2. Caso informado, verifique se os dados foram digitados corretamente"
								+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(150, 309, 60, 43);
		contentPane.add(btnConsultar);
		
		btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/enter-2.png")));
		btnEntrar.setToolTipText("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codProfessor = Integer.parseInt(txtCodProfessor.getText());
					String senha = String.valueOf(passSenha.getPassword());
					String status = "Ativo";
					
					ProfessoresDAO professorDAO = new ProfessoresDAO();
					Professores professor = new Professores();
					professor = professorDAO.Login(codProfessor, senha, status);
					 
					if (codProfessor == professor.getCodProfessor() && senha.equals(professor.getSenha()) && status.equals(professor.getStatus())) {
						String nome = professor.getNome();
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/gender-neutral-user--v1.png")));
						JOptionPane.showOptionDialog(null, "Seja Bem Vindo Professor(a): " + nome, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();			
						telaInicialProfessor.setVisible (false);
						dispose();
						Tela_CadastroAula telaCadastroAula = new Tela_CadastroAula();
						String codigoProf = Integer.toString(codProfessor);
						telaCadastroAula.txtCodProfessor.setText(codigoProf);
						telaCadastroAula.txtSenhaProf.setText(senha);
						telaCadastroAula.setVisible(true);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Professor não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Fazer o Login!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos"
							+ "\n2. Caso estejam preenchidos, verifique se você realizou seu cadastro"
							+ "\n3. Caso realizado, verifique se os dados foram digitados corretamente."
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntrar.setBounds(292, 67, 60, 43);
		contentPane.add(btnEntrar);
		
		btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
				telaCadastroProfessor.txtControle.setText("telaInicial");
				telaCadastroProfessor.setVisible(true);
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(220, 309, 60, 43);
		contentPane.add(btnAlterar);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 239, 365, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 296, 365, 2);
		contentPane.add(separator_2);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(290, 309, 60, 43);
		contentPane.add(btnSair);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 309, 60, 43);
		contentPane.add(btnVoltar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 139, 365, 2);
		contentPane.add(separator_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 345, 76);
		contentPane.add(scrollPane);
		
		tabProfessor = new JTable();
		tabProfessor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Professor(a)", "Cód. Professor(a)", "Nome", "Senha", "Email", "Celular", "Status"
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
		tabProfessor.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabProfessor.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabProfessor.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabProfessor.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabProfessor.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabProfessor.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabProfessor.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tabProfessor);
		
		btnNovo = new JButton("");
		btnNovo.setToolTipText("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel) tabProfessor.getModel()).removeRow(0);
				txtCodProfessor.setText(null);
				passSenha.setText(null);
				((DefaultTableModel) tabProfessor.getModel()).removeRow(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 309, 60, 43);
		contentPane.add(btnNovo);
	}
}
