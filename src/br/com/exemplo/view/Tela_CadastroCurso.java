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
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "==============Cursos=============="
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Cadastrar os cursos"
						+ "\n 2. Manter os cursos ou desativá-los"
						+ "\n==================================", "Informações dos Cursos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================", "Informações do Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Curso não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar Curso!!. "
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(339, 46, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
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
		btnSair.setToolTipText("Sair");
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
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Por favor, digite um nome diferente do que esta cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
						
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Alterado com Sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch(Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Alterar!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos ou realize uma consulta para saber se esse curso está cadastrado" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAlterar.setToolTipText("Alterar");
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
					if (txtCurso.getText().equals("")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Informe o curso antes de prosseguir", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else {
						Curso curso = new Curso();
						
						if (txtCurso.getText().equals(null)) {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Digite o nome do curso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
						else {
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
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							txtCurso.setText(null);
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao fazer cadastro!!. "
							+ "\n\n1. Verifique se o curso já foi cadastrado"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setToolTipText("Salvar");
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
		btnNovo.setToolTipText("Novo");
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
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "O curso já está ativo!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 0));
						int idCurso = Integer.parseInt(teste);
						
						curso.setStatus("Ativo");
						curso.setIdCurso(idCurso);
						
						String nome = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 1));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "====================================================="
								+ "\nDeseja mesmo ativar o curso" + nome + "?"
								+ "\n=====================================================", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						if (resposta == JOptionPane.YES_OPTION) {
							CursoDAO cursoDao = new CursoDAO();
							cursoDao.AtivarDesativar(curso);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "O curso foi ativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
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
						else if (resposta == JOptionPane.NO_OPTION) {
						
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Ativar Curso!!. "
							+ "\n\n1. Verifique se o curso já esta ativo" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Ativar");
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
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "O curso já está desativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 0));
						int idCurso = Integer.parseInt(teste);
						
						curso.setStatus("Desativado");
						curso.setIdCurso(idCurso);
						
						String nome = String.valueOf(tabCurso.getValueAt(tabCurso.getSelectedRow(), 1));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "====================================================="
								+ "\nDeseja mesmo desativar o curso" + nome + "?"
								+ "\n=====================================================", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
							
						if (resposta == JOptionPane.YES_OPTION) {
							
							CursoDAO cursoDao = new CursoDAO();
							cursoDao.AtivarDesativar(curso);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "O curso foi desativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
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
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Desativar Curso!!. "
							+ "\n\n1. Verifique se o curso já esta desativado" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroCurso.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Desativar");
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
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Listar ativos com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao listar ativos!!. "
						+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnListarCoordenadoresAtivos.setToolTipText("");
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
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Listar inativos com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao listar inativos!!. "
						+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnListarDesativados.setToolTipText("");
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
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					JOptionPane.showOptionDialog(null, "Listar todos com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao listar todos!!. "
						+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnListarTodos.setToolTipText("");
		btnListarTodos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarTodos.setBounds(276, 168, 123, 23);
		contentPane.add(btnListarTodos);
	}
}
