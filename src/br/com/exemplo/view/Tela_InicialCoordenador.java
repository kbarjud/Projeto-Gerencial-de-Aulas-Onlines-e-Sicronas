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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_InicialCoordenador frame = new Tela_InicialCoordenador();
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
	public Tela_InicialCoordenador() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 423);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Cadastro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "================================================Cadastro================================================"
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Fazer Seu Login"
						+ "\n 2. Se Cadastrar Caso Ainda Não Tenha Feito isso"
						+ "\n 3. Alterar Seu Cadastro"
						+ "\n 4. Consultar Seu Cadastro"
						+ "\n\n===============================================Informações=============================================="
						+ "\n O Código do Coordenador Que é Solicitado no Campo de Login e de Cadastro é o Mesmo que o Coordenador Usa na Faculdade"
						+ "\n=======================================================================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
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
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		txtCodCoordenador.setBounds(147, 52, 129, 30);
		contentPane.add(txtCodCoordenador);
		
		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passSenha.setBounds(147, 93, 129, 30);
		contentPane.add(passSenha);
		
		btnCadastreSe = new JButton("Cadastre-se Aqui");
		btnCadastreSe.setToolTipText("Bot\u00E3o Cadastre-se Aqui");
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(false);
				dispose();
				Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
				telaCadastroCoordenador.setVisible(true);
			}
		});
		btnCadastreSe.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastreSe.setBounds(203, 255, 149, 30);
		contentPane.add(btnCadastreSe);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codCoordenador = Integer.parseInt(txtCodCoordenador.getText());
					String senha = String.valueOf(passSenha.getPassword());
					
					CoordenadorDAO coordenadorDao = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDao.Login(codCoordenador, senha);
					 
					if (codCoordenador == coordenador.getCodCoordenador() && senha.equals(coordenador.getSenha())) {
						String nome = coordenador.getNome();
						JOptionPane.showMessageDialog (null, "Seja Bem Vindo(a) Coordenador(a): " + nome);
						Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();			
						telaInicialCoordenador.setVisible (false);
						dispose();
						Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
						//String codigoProf = Integer.toString(codProfessor);
						//telaCadastroAula.txtCodProfessor.setText(codigoProf);
						//telaCadastroAula.txtSenhaProf.setText(senha);
						telaMenuCoordenador.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog (null, "Coordenador Não Cadastrado");
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
		btnEntrar.setToolTipText("Bot\u00E3o Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntrar.setBounds(285, 75, 80, 30);
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
		btnSair.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setToolTipText("Bot\u00E3o Sair");
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
				telaCadastroCoordenador.setVisible(true);
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(230, 309, 60, 43);
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
						JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
					}
					else {
						JOptionPane.showMessageDialog (null, "Coordenador Não Cadastrado");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar!!. "
							+ "\n1. Para Fazer Uma Consulta Informe o Código do Coordenador"
							+ "\n2. Caso Tenha Feito, Verifique Se Os Dados Foram Digitados Corretamente."
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(160, 309, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando!!");
				Tela_InicialCoordenador telaInicialCoordenador = new Tela_InicialCoordenador();
				telaInicialCoordenador.setVisible(false);
				dispose();
				Tela_Inicial telaInicial = new Tela_Inicial();
				telaInicial.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(90, 309, 60, 43);
		contentPane.add(btnVoltar);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodCoordenador.setText(null);
				passSenha.setText(null);
				((DefaultTableModel) tabCoordenador.getModel()).removeRow(0);
			}
		});
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setIcon(new ImageIcon(Tela_InicialCoordenador.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(20, 309, 60, 43);
		contentPane.add(btnNovo);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 241, 379, 2);
		contentPane.add(separator_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 359, 86);
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
				Object.class, Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabCoordenador.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabCoordenador.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabCoordenador.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabCoordenador.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabCoordenador.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		scrollPane.setViewportView(tabCoordenador);
		tabCoordenador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}
