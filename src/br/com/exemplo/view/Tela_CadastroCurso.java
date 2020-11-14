package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.CoordenadorDAO;
import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.DisciplinaDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.Disciplina;
import br.com.exemplo.model.Professores;
import br.com.exemplo.model.Turma;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Tela_CadastroCurso extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator_1;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnSair;
	private JButton btnAlterar;
	private JLabel lblBemVindoA_1;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JButton btnSalvar;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	private JTable tabCurso;
	private JButton btnNovo;
	private JButton btnAtivar;
	private JButton btnDesativar;
	private JSeparator separator_3;
	private JButton btnListarCoordenadoresAtivos;
	private JButton btnListarDesativados;
	private JButton btnListarTodos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroCurso frame = new Tela_CadastroCurso();
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
	public Tela_CadastroCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 493);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Cursos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "==============Cursos=============="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Cursos"
						+ "\n 2. Manter os Cursos ou Desativa-los"
						+ "\n==================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 355, 447, 2);
		contentPane.add(separator_1);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nomeCurso = txtCurso.getText();
					
					CursoDAO cursoDao = new CursoDAO();
					Curso curso = new Curso();
					curso = cursoDao.Consultar2(nomeCurso);
					 
					if (nomeCurso.equals(curso.getNomeCurso())) {
						List<Curso> lista = new ArrayList<Curso>();
						lista = cursoDao.ListarTodos3(nomeCurso);
						DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
						model.setNumRows(0);
						for (Curso curso1 : lista) {
							model.addRow (new Object[] {
									curso1.getIdCurso(),
									curso1.getNomeCurso(),
									curso1.getStatus(),
								});
						} 
						JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
					}
					else {
						JOptionPane.showMessageDialog (null, "Curso Não Cadastrado");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar Curso!!. "
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(339, 46, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_CadastroCurso telaCadastroCurso = new Tela_CadastroCurso();
				telaCadastroCurso.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(19, 368, 60, 43);
		contentPane.add(btnVoltar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(335, 368, 60, 43);
		contentPane.add(btnSair);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Curso curso = new Curso();
					curso.setNomeCurso(txtCurso.getText());
					curso.setStatus("Ativo");
					
					String nome = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 1));
					
					if (nome.equals(txtCurso.getText())) {
						JOptionPane.showMessageDialog (null, "Por Favor Digite Um Nome Diferente Do Que Já Está Cadastrado!!");
					}
					else {
						String teste = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 0));
						int idCurso = Integer.parseInt(teste);
						
						curso.setIdCurso(idCurso);
							
						CursoDAO cursoDao = new CursoDAO();
						// alterar
						cursoDao.Alterar(curso);
						
						List<Curso> lista = new ArrayList<Curso>();
						lista = cursoDao.ListarTodos1(idCurso);
						
						DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
						model.setNumRows(0);
						for (Curso curso1 : lista) {
							model.addRow (new Object[] {
									curso1.getIdCurso(),
									curso1.getNomeCurso(),
									curso1.getStatus(),
								});
						}
						
						JOptionPane.showMessageDialog (null, "Alterado com Sucesso!!");
					}
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!!. "
							+ "\n1. Verifique se Todos os Campos Foram Preenchidos ou Realize Uma Consulta Para Saber se Esse Curso Já Não Esta Cadastrado"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(256, 368, 60, 43);
		contentPane.add(btnAlterar);
		
		lblBemVindoA_1 = new JLabel("Bem Vindo a Tela de Cadastro de Curso");
		lblBemVindoA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA_1.setBounds(10, 11, 395, 30);
		contentPane.add(lblBemVindoA_1);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 52, 42, 30);
		contentPane.add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCurso.setColumns(10);
		txtCurso.setBounds(62, 52, 267, 30);
		contentPane.add(txtCurso);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					Curso curso = new Curso();
					curso.setNomeCurso(txtCurso.getText());
					curso.setStatus("Ativo");
					
					CursoDAO cursoDao = new CursoDAO();
					cursoDao.Salvar(curso);
					
					List<Curso> lista = new ArrayList<Curso>();
					lista = cursoDao.ListarTodos3(txtCurso.getText());
					DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
					model.setNumRows(0);
					for (Curso curso1 : lista) {
						model.addRow (new Object[] {
								curso1.getIdCurso(),
								curso1.getNomeCurso(),
								curso1.getStatus(),
							});
					} 
					JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
					txtCurso.setText(null);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!!. "
							+ "\n1. Verifique se o cadastro desse já foi feito"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(210, 101, 60, 43);
		contentPane.add(btnSalvar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 202, 447, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 389, 129);
		contentPane.add(scrollPane);
		
		tabCurso = new JTable();
		tabCurso.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabCurso.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Curso", "Curso", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
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
		tabCurso.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabCurso.getColumnModel().getColumn(1).setPreferredWidth(203);
		tabCurso.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrollPane.setViewportView(tabCurso);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCurso.setText(null);
				((DefaultTableModel) tabCurso.getModel()).setRowCount(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(140, 101, 60, 43);
		contentPane.add(btnNovo);
		
		btnAtivar = new JButton("");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Curso curso = new Curso();
					String status = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 2));
					if (status.equals("Ativo")) {
						JOptionPane.showMessageDialog(null, "O Curso Já Esta Ativo");
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 0));
						int idCurso = Integer.parseInt(teste);
						
						curso.setStatus("Ativo");
						curso.setIdCurso(idCurso);
						
						String nome = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 1));
						
						String resposta = JOptionPane.showInputDialog(null, "====================================================="
								+ "\nDeseja Mesmo Ativar O Curso " + nome
								+ "\n====================================================="
								+ "\n\n====================================================="
								+ "\nDigite 1 Para Confirmar"
								+ "\nDigite 2 Para Cancelar"
								+ "\n=====================================================");
							
						int decisao = Integer.parseInt(resposta);
						if (decisao == 1) {
							
							CursoDAO cursoDao = new CursoDAO();
							cursoDao.AtivarDesativar(curso);
								
							JOptionPane.showMessageDialog (null, "O Curso Já Foi Ativado");
							
							txtCurso.setText(null);
							
							String status1 = "Ativo";
							
							List<Curso> lista = new ArrayList<Curso>();
							lista = cursoDao.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
							model.setNumRows(0);
							for (Curso curso1 : lista) {
								model.addRow (new Object[] {
										curso1.getIdCurso(),
										curso1.getNomeCurso(),
										curso1.getStatus(),
									});
							}
						}
						else if (decisao == 2){
							
						}
						else {
							JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Ativar o Curso ou 2 Para Cancelar");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Ativar Curso!!. "
							+ "\n1. Verifique Se O Curso Já Esta Ativo"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(98, 368, 60, 43);
		contentPane.add(btnAtivar);
		
		btnDesativar = new JButton("");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Curso curso = new Curso();
					String status = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 2));
					if (status.equals("Desativado")) {
						JOptionPane.showMessageDialog(null, "O Curso Já Esta Desativado");
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 0));
						int idCurso = Integer.parseInt(teste);
						
						curso.setStatus("Desativado");
						curso.setIdCurso(idCurso);
						
						String nome = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 1));
						
						String resposta = JOptionPane.showInputDialog(null, "====================================================="
								+ "\nDeseja Mesmo Desativar O Curso " + nome
								+ "\n====================================================="
								+ "\n\n====================================================="
								+ "\nDigite 1 Para Confirmar"
								+ "\nDigite 2 Para Cancelar"
								+ "\n=====================================================");
							
						int decisao = Integer.parseInt(resposta);
						if (decisao == 1) {
							
							CursoDAO cursoDao = new CursoDAO();
							cursoDao.AtivarDesativar(curso);
								
							JOptionPane.showMessageDialog (null, "O Curso Já Foi Desativado");
							
							txtCurso.setText(null);
							
							String status1 = "Desativado";
							
							List<Curso> lista = new ArrayList<Curso>();
							lista = cursoDao.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
							model.setNumRows(0);
							for (Curso curso1 : lista) {
								model.addRow (new Object[] {
										curso1.getIdCurso(),
										curso1.getNomeCurso(),
										curso1.getStatus(),
									});
							}
						}
						else if (decisao == 2){
							
						}
						else {
							JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Desativar o Curso ou 2 Para Cancelar");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Desativar Curso!!. "
							+ "\n1. Verifique Se O Curso Já Esta Desativado"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Bot\u00E3o Desativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(177, 368, 60, 43);
		contentPane.add(btnDesativar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 155, 447, 2);
		contentPane.add(separator_3);
		
		btnListarCoordenadoresAtivos = new JButton("Listar Ativos");
		btnListarCoordenadoresAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Ativo";
					
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
					model.setNumRows(0);
					for (Curso curso : lista) {
						model.addRow (new Object[] {
								curso.getIdCurso(),
								curso.getNomeCurso(),
								curso.getStatus(),
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
		btnListarCoordenadoresAtivos.setToolTipText("Bot\u00E3o Listar Cursos Ativos");
		btnListarCoordenadoresAtivos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarCoordenadoresAtivos.setBounds(10, 168, 123, 23);
		contentPane.add(btnListarCoordenadoresAtivos);
		
		btnListarDesativados = new JButton("Listar Inativos");
		btnListarDesativados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Desativado";
					
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
					model.setNumRows(0);
					for (Curso curso : lista) {
						model.addRow (new Object[] {
								curso.getIdCurso(),
								curso.getNomeCurso(),
								curso.getStatus(),
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
		btnListarDesativados.setToolTipText("Bot\u00E3o Listar Cursos Inativos");
		btnListarDesativados.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDesativados.setBounds(143, 168, 123, 23);
		contentPane.add(btnListarDesativados);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos();
					
					DefaultTableModel model = (DefaultTableModel) tabCurso.getModel();
					model.setNumRows(0);
					for (Curso curso : lista) {
						model.addRow (new Object[] {
								curso.getIdCurso(),
								curso.getNomeCurso(),
								curso.getStatus(),
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
		btnListarTodos.setToolTipText("Bot\u00E3o Listar Todos os Cursos");
		btnListarTodos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarTodos.setBounds(276, 168, 123, 23);
		contentPane.add(btnListarTodos);
	}
}
