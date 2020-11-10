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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import br.com.exemplo.dao.CoordenadorDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Professores;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_ConsultarProfessor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblProfessor;
	private JComboBox cmbProfessor;
	private JSeparator separator_1;
	private JButton btnSair;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnDesativar;
	private JButton btnVoltar;
	private JSeparator separator_2;
	private JButton btnAtivar;
	private JButton btnListarTodos;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JSeparator separator_3;
	private JButton btnListarCoordenadoresAtivos;
	private JButton btnListarDesativados;
	private JTable tabProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ConsultarProfessor frame = new Tela_ConsultarProfessor();
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
	public Tela_ConsultarProfessor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 389);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Professores");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "======================Professores======================"
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Verificar os Professores Cadastrados"
						+ "\n 2. Manter os Professores Ativos no Sistema ou Desativa-los"
						+ "\n======================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/help30.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Sobre o Sistema");
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mnNewMenu_1.add(mntmNewMenuItem);
		
		separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProfessor = new JLabel("Professor");
		lblProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblProfessor.setBounds(10, 17, 78, 30);
		contentPane.add(lblProfessor);
		
		cmbProfessor = new JComboBox();
		cmbProfessor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					String status = "Ativo";
					
					List<Professores> lista1 = new ArrayList<Professores>();
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					lista1 = professoresDao.ListarTodos2(status);
					DefaultComboBoxModel model1 = new DefaultComboBoxModel(lista1.toArray());
					cmbProfessor.setModel(model1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		cmbProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor.setBounds(98, 22, 252, 21);
		contentPane.add(cmbProfessor);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 250, 476, 2);
		contentPane.add(separator_1);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(360, 266, 60, 43);
		contentPane.add(btnSair);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbProfessor.setSelectedIndex(0);
				((DefaultTableModel) tabProfessor.getModel()).setRowCount(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 266, 60, 43);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_ConsultarProfessor telaConsultarProfessor = new Tela_ConsultarProfessor();
				telaConsultarProfessor.setVisible(false);
				dispose();
				Tela_CadastroProfessor telaCadastroProfessor = new Tela_CadastroProfessor();
				telaCadastroProfessor.txtControle.setText("telaConsultaProfessor");
				telaCadastroProfessor.setVisible(true);
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setToolTipText("Bot\u00E3o Alterar ");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(290, 266, 60, 43);
		contentPane.add(btnAlterar);
		
		btnDesativar = new JButton("");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Professores professores = new Professores();
					String status = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 0));
					if (status.equals("Desativado")) {
						JOptionPane.showMessageDialog(null, "O Coordenador Já Esta Desativado");
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 1));
						int idProfessor = Integer.parseInt(teste);
						
						professores.setStatus("Desativado");
						professores.setIdProfessor(idProfessor);
						
						String nome = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 3));
						
						String resposta = JOptionPane.showInputDialog(null, "====================================================="
								+ "\nDeseja Mesmo Desativar O Professor " + nome
								+ "\n====================================================="
								+ "\n\n====================================================="
								+ "\nDigite 1 Para Confirmar"
								+ "\nDigite 2 Para Cancelar"
								+ "\n=====================================================");
							
						int decisao = Integer.parseInt(resposta);
						if (decisao == 1) {
							
							ProfessoresDAO professoresDao = new ProfessoresDAO();
							professoresDao.AtivarDesativar(professores);
								
							JOptionPane.showMessageDialog (null, "O Professor Já Foi Desativado");
							
							cmbProfessor.setSelectedIndex(0);
							
							String status1 = "Desativado";
							
							List<Professores> lista = new ArrayList<Professores>();
							ProfessoresDAO professoresDao1 = new ProfessoresDAO();
							lista = professoresDao1.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
							model.setNumRows(0);
							for (Professores professores1 : lista) {
								model.addRow (new Object[] {
										professores1.getStatus(),
										professores1.getIdProfessor(),
										professores1.getCodProfessor(),
										professores1.getNome(),
										professores1.getSenha(),
										professores1.getEmail(),
										professores1.getCelular(),
									});
							}
						}
						else if (decisao == 2){
							
						}
						else {
							JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Desativar o Professor ou 2 Para Cancelar");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Desativar Professor!!. "
							+ "\n1. Verifique Se O Professor Já Esta Desativado"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnDesativar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Bot\u00E3o Desativar Professor");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(220, 266, 60, 43);
		contentPane.add(btnDesativar);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aguarde um Momento!!");
				Tela_ConsultarProfessor telaConsultarProfessor = new Tela_ConsultarProfessor();
				telaConsultarProfessor.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 266, 60, 43);
		contentPane.add(btnVoltar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 112, 476, 2);
		contentPane.add(separator_2);
		
		btnAtivar = new JButton("");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Professores professores = new Professores();
					String status = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 0));
					if (status.equals("Ativo")) {
						JOptionPane.showMessageDialog(null, "O Coordenador Já Esta Ativo");
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 1));
						int idProfessor = Integer.parseInt(teste);
						
						professores.setStatus("Ativo");
						professores.setIdProfessor(idProfessor);
						
						String nome = String.valueOf(tabProfessor.getValueAt(tabProfessor.getSelectedRow(), 3));
						
						String resposta = JOptionPane.showInputDialog(null, "====================================================="
								+ "\nDeseja Mesmo Ativar O Professor " + nome
								+ "\n====================================================="
								+ "\n\n====================================================="
								+ "\nDigite 1 Para Confirmar"
								+ "\nDigite 2 Para Cancelar"
								+ "\n=====================================================");
							
						int decisao = Integer.parseInt(resposta);
						if (decisao == 1) {
							
							ProfessoresDAO professoresDao = new ProfessoresDAO();
							professoresDao.AtivarDesativar(professores);
								
							JOptionPane.showMessageDialog (null, "O Professor Já Foi Ativado");
							
							cmbProfessor.setSelectedIndex(0);
							
							String status1 = "Ativo";
							
							List<Professores> lista = new ArrayList<Professores>();
							ProfessoresDAO professoresDao1 = new ProfessoresDAO();
							lista = professoresDao1.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
							model.setNumRows(0);
							for (Professores professores1 : lista) {
								model.addRow (new Object[] {
										professores1.getStatus(),
										professores1.getIdProfessor(),
										professores1.getCodProfessor(),
										professores1.getNome(),
										professores1.getSenha(),
										professores1.getEmail(),
										professores1.getCelular(),
									});
							}
						}
						else if (decisao == 2){
							
						}
						else {
							JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Ativar o Professor ou 2 Para Cancelar");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Ativar Professor!!. "
							+ "\n1. Verifique Se O Professor Já Esta Ativo"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnAtivar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar Professor");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(150, 266, 60, 43);
		contentPane.add(btnAtivar);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Professores> lista = new ArrayList<Professores>();
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					lista = professoresDao.ListarTodos();
					
					DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
					model.setNumRows(0);
					for (Professores professor : lista) {
						model.addRow (new Object[] {
								professor.getStatus(),
								professor.getIdProfessor(),
								professor.getCodProfessor(),
								professor.getNome(),
								professor.getSenha(),
								professor.getEmail(),
								professor.getCelular(),
							});
					}
					JOptionPane.showMessageDialog(null, "Listar Todos Com Sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Listar Todos os Coordenadores Cadastrados no Banco!!. "
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnListarTodos.setToolTipText("Bot\u00E3o Listar Todos os Professores");
		btnListarTodos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarTodos.setBounds(291, 78, 123, 23);
		contentPane.add(btnListarTodos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 410, 114);
		contentPane.add(scrollPane);
		
		tabProfessor = new JTable();
		tabProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Status", "ID Professor(a)", "C\u00F3digo do(a) Professor(a)", "Nome", "Senha", "Email", "Celular"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, int.class, int.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabProfessor.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabProfessor.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabProfessor.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabProfessor.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabProfessor.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabProfessor.getColumnModel().getColumn(5).setPreferredWidth(120);
		tabProfessor.getColumnModel().getColumn(6).setPreferredWidth(110);
		
		scrollPane.setViewportView(tabProfessor);
		tabProfessor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeProfessor = cmbProfessor.getSelectedItem().toString();
					
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					Professores professores = new Professores();
					professores = professoresDao.Consultar2(nomeProfessor);
					 
					if (nomeProfessor.equals(professores.getNome())) {
						List<Professores> lista = new ArrayList<Professores>();
						lista = professoresDao.ListarTodos3(nomeProfessor);
						DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
						model.setNumRows(0);
						for (Professores professor : lista) {
							model.addRow (new Object[] {
									professor.getStatus(),
									professor.getIdProfessor(),
									professor.getCodProfessor(),
									professor.getNome(),
									professor.getSenha(),
									professor.getEmail(),
									professor.getCelular(),
								});
						} 
						JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
					}
					else {
						JOptionPane.showMessageDialog (null, "Coordenador Não Cadastrado");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar Coordenador!!. "
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_ConsultarProfessor.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(360, 11, 60, 43);
		contentPane.add(btnConsultar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 65, 476, 2);
		contentPane.add(separator_3);
		
		btnListarCoordenadoresAtivos = new JButton("Listar Ativos");
		btnListarCoordenadoresAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Ativo";
					
					List<Professores> lista = new ArrayList<Professores>();
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					lista = professoresDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
					model.setNumRows(0);
					for (Professores professor : lista) {
						model.addRow (new Object[] {
								professor.getStatus(),
								professor.getIdProfessor(),
								professor.getCodProfessor(),
								professor.getNome(),
								professor.getSenha(),
								professor.getEmail(),
								professor.getCelular(),
							});
					}
					JOptionPane.showMessageDialog(null, "Listar Ativos Com Sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Listar Todos os Coordenadores Cadastrados no Banco!!. "
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnListarCoordenadoresAtivos.setToolTipText("Bot\u00E3o Listar Professores Ativos");
		btnListarCoordenadoresAtivos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarCoordenadoresAtivos.setBounds(15, 78, 123, 23);
		contentPane.add(btnListarCoordenadoresAtivos);
		
		btnListarDesativados = new JButton("Listar Inativos");
		btnListarDesativados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Desativado";
					
					List<Professores> lista = new ArrayList<Professores>();
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					lista = professoresDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabProfessor.getModel();
					model.setNumRows(0);
					for (Professores professor : lista) {
						model.addRow (new Object[] {
								professor.getStatus(),
								professor.getIdProfessor(),
								professor.getCodProfessor(),
								professor.getNome(),
								professor.getSenha(),
								professor.getEmail(),
								professor.getCelular(),
							});
					}
					JOptionPane.showMessageDialog(null, "Listar Inativos Com Sucesso");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Listar Todos os Coordenadores Cadastrados no Banco!!. "
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnListarDesativados.setToolTipText("Bot\u00E3o Listar Professores Inativos");
		btnListarDesativados.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDesativados.setBounds(153, 78, 123, 23);
		contentPane.add(btnListarDesativados);
	}
}
