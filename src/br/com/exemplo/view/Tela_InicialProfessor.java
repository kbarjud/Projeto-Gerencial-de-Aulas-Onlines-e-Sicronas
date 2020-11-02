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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_InicialProfessor frame = new Tela_InicialProfessor();
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
	public Tela_InicialProfessor() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 423);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		mnCadastro = new JMenuItem("Cadastro");
		mnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "==============================================Cadastro=============================================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Fazer Seu Login"
						+ "\n 2. Se Cadastrar Caso Ainda Não Tenha Feito isso"
						+ "\n 3. Alterar Seu Cadastro"
						+ "\n 4. Consultar Seu Cadastro"
						+ "\n\n=============================================Informações============================================"
						+ "\n O Código do Professor Que é Solicitado no Campo de Login e de Cadastro é o Mesmo que o Professor Usa na Faculdade"
						+ "\n===================================================================================================");
			}
		});
		mnNewMenu.add(mnCadastro);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_3 = new JMenuItem("Sair");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
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
		txtCodProfessor.setBounds(136, 52, 127, 30);
		contentPane.add(txtCodProfessor);
		txtCodProfessor.setColumns(10);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(136, 93, 127, 30);
		contentPane.add(passSenha);
		
		btnCadastreSe = new JButton("Cadastre-se Aqui");
		btnCadastreSe.setToolTipText("Bot\u00E3o Cadastre-se Aqui");
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
				telaCadastroProfessor.setVisible(true);
			}
		});
		btnCadastreSe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastreSe.setBounds(203, 255, 149, 30);
		contentPane.add(btnCadastreSe);
		
		btnConsultar = new JButton("");
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
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
							JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
						}
						else {
							JOptionPane.showMessageDialog (null, "Professor Não Cadastrado");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao Consultar!!. "
								+ "\n1. Para Fazer Uma Consulta Informe o Código do Professor"
								+ "\n2. Caso Tenha Feito, Verifique Se Os Dados Foram Digitados Corretamente."
								+ "\n\nErro: " + e1);
					}
				}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(150, 309, 60, 43);
		contentPane.add(btnConsultar);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setToolTipText("Bot\u00E3o Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codProfessor = Integer.parseInt(txtCodProfessor.getText());
					String senha = String.valueOf(passSenha.getPassword());
					
					ProfessoresDAO professorDAO = new ProfessoresDAO();
					Professores professor = new Professores();
					professor = professorDAO.Login(codProfessor, senha);
					 
					if (codProfessor == professor.getCodProfessor() && senha.equals(professor.getSenha())) {
						String nome = professor.getNome();
						JOptionPane.showMessageDialog (null, "Seja Bem Vindo Professor(a): " + nome);
						Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();			
						telaInicialProfessor.setVisible (false);
						dispose();
						Tela_CadastroAulaProfessor telaCadastroAula = new Tela_CadastroAulaProfessor();
						String codigoProf = Integer.toString(codProfessor);
						telaCadastroAula.txtCodProfessor.setText(codigoProf);
						telaCadastroAula.txtSenhaProf.setText(senha);
						telaCadastroAula.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog (null, "Professor Não Cadastrado");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Fazer o Login!!. "
						+ "\n1. Verifique se Todos os Campos Foram Preenchidos"
						+ "\n2. Caso Todos Estejam Preenchidos. Verifique se Você Fez Seu Cadastro"
						+ "\n3. Caso Tenha Feito, Verifique Se Os Dados Foram Digitados Corretamente."
						+ "\n\nErro: " + e1);
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntrar.setBounds(271, 77, 81, 30);
		contentPane.add(btnEntrar);
		
		btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
				telaCadastroProfessor.setVisible(true);
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
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
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(292, 309, 60, 43);
		contentPane.add(btnSair);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando!!");
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(false);
				dispose();
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(80, 309, 60, 43);
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
				"ID Professor(a)", "C\u00F3digo do(a) Professor(a)", "Nome", "Senha", "Email", "Celular", "Status"
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
		tabProfessor.getColumnModel().getColumn(1).setPreferredWidth(160);
		tabProfessor.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabProfessor.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabProfessor.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabProfessor.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabProfessor.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(tabProfessor);
		
		btnNovo = new JButton("");
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodProfessor.setText(null);
				passSenha.setText(null);
				((DefaultTableModel) tabProfessor.getModel()).removeRow(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_InicialProfessor.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(10, 309, 60, 43);
		contentPane.add(btnNovo);
	}
}
