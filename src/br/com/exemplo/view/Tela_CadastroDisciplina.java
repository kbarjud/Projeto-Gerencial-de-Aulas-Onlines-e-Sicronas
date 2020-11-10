package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.DadosAulaDAO;
import br.com.exemplo.dao.DisciplinaDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.Disciplina;
import br.com.exemplo.model.Professores;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.model.Turma;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Tela_CadastroDisciplina extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnSair;
	private JButton btnAlterar;
	private JLabel lblBemVindoA;
	private JLabel lblCurso;
	private JTextField txtDisciplina;
	private JButton btnSalvar;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	private JButton btnNovo;
	private JButton btnAtivar;
	private JButton btnDesativar;
	private JSeparator separator_3;
	private JButton btnListarCoordenadoresAtivos;
	private JButton btnListarDesativados;
	private JButton btnListarTodos;
	private JTable tabDisciplina;
	private JComboBox cmbCurso;
	private JLabel lblDisciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroDisciplina frame = new Tela_CadastroDisciplina();
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
	public Tela_CadastroDisciplina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 524);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Disciplina");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=============Disciplinas============="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar as Disciplinas"
						+ "\n 2. Manter as Disciplinas ou Desativa-las"
						+ "\n==================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 388, 447, 2);
		contentPane.add(separator_1);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					
					if (txtDisciplina.getText().equals("")) {
						cursoDisciplina = cursoDisciplinaDao.Consultar2(nomeCurso);
						
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso())) {
							List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
							lista = cursoDisciplinaDao.ListarTodos4(nomeCurso);
							DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
							model.setNumRows(0);
							for (CursoDisciplina cursoDisciplina1 : lista) {
								model.addRow (new Object[] {
										cursoDisciplina1.getNomeCurso(),
										cursoDisciplina1.getNomeDisciplina(),
										cursoDisciplina1.getStatus(),
										cursoDisciplina1.getIdCursoDisciplina(),
									});
							} 
							JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
						}
						else {
							JOptionPane.showMessageDialog (null, "Curso Não Cadastrado!!");
						}
					}
					else {
						String nomeDisciplina = txtDisciplina.getText();
						
						cursoDisciplina = cursoDisciplinaDao.Consultar3(nomeCurso, nomeDisciplina);
						
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso())) {
							List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
							lista = cursoDisciplinaDao.ListarTodos5(nomeCurso, nomeDisciplina);
							DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
							model.setNumRows(0);
							for (CursoDisciplina cursoDisciplina1 : lista) {
								model.addRow (new Object[] {
										cursoDisciplina1.getNomeCurso(),
										cursoDisciplina1.getNomeDisciplina(),
										cursoDisciplina1.getStatus(),
										cursoDisciplina1.getIdCursoDisciplina(),
									});
							} 
							JOptionPane.showMessageDialog (null, "Consulta Realizada com Sucesso!!");
						}
						else {
							JOptionPane.showMessageDialog (null, "Curso Não Cadastrado!!");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar!!. "
							+ "\nVerifique o Curso e a Disciplina, pois essa disciplina não está cadastrada nesse curso"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(246, 134, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_CadastroDisciplina telaCadastroDisciplina = new Tela_CadastroDisciplina();
				telaCadastroDisciplina.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(19, 401, 60, 43);
		contentPane.add(btnVoltar);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(335, 401, 60, 43);
		contentPane.add(btnSair);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(256, 401, 60, 43);
		contentPane.add(btnAlterar);
		
		lblBemVindoA = new JLabel("Bem Vindo a Tela de Cadastro de Disciplina");
		lblBemVindoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA.setBounds(10, 11, 395, 30);
		contentPane.add(lblBemVindoA);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 52, 69, 30);
		contentPane.add(lblCurso);
		
		txtDisciplina = new JTextField();
		txtDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDisciplina.setColumns(10);
		txtDisciplina.setBounds(90, 93, 315, 30);
		contentPane.add(txtDisciplina);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					String nomeDisciplina = txtDisciplina.getText();
					String status = "Ativo";
					
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					
					Disciplina disciplina = new Disciplina();
					DisciplinaDAO disciplinaDao = new DisciplinaDAO();
					disciplina = disciplinaDao.Consultar2(nomeDisciplina, status);
					
					if (disciplina.getNomeDisciplina().equals("")) {
						disciplina.setNomeDisciplina(nomeDisciplina);
						disciplina.setStatus("Ativo");
						
						disciplinaDao.Salvar(disciplina);
						
						disciplina = disciplinaDao.Consultar2(nomeDisciplina, status);
						
						if (nomeDisciplina.equals(disciplina.getNomeDisciplina())) {
							int idDisciplina = disciplina.getIdDisciplina();
							cursoDisciplina.setIdDisciplina(idDisciplina);
							
							cursoDisciplina.setNomeCurso(cmbCurso.getSelectedItem().toString());
							cursoDisciplina.setNomeDisciplina(txtDisciplina.getText());
							
							String nomeCurso = cmbCurso.getSelectedItem().toString();
		
							CursoDAO cursoDao = new CursoDAO();
							Curso curso = new Curso();
							curso = cursoDao.Consultar1(nomeCurso, status);
							 
							if (nomeCurso.equals(curso.getNomeCurso())) {
								int idCurso = curso.getIdCurso();
								cursoDisciplina.setIdCurso(idCurso);	
								
								cursoDisciplina.setStatus("Ativo");
								
								CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
								cursoDisciplinaDao.Salvar(cursoDisciplina);
													
								JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
								
								List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
								lista = cursoDisciplinaDao.ListarTodos5(nomeCurso, nomeDisciplina);
								DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
								model.setNumRows(0);
								for (CursoDisciplina cursoDisciplina1 : lista) {
									model.addRow (new Object[] {
											cursoDisciplina1.getNomeCurso(),
											cursoDisciplina1.getNomeDisciplina(),
											cursoDisciplina1.getStatus(),
											cursoDisciplina1.getIdCursoDisciplina(),
										});
								} 
							}
							else {
								JOptionPane.showMessageDialog (null, "Erro ao Pegar o ID do Curso");
							}
						}
					}
					else if (nomeDisciplina.equals(disciplina.getNomeDisciplina())){
						int idDisciplina = disciplina.getIdDisciplina();
						cursoDisciplina.setIdDisciplina(idDisciplina);
						
						cursoDisciplina.setNomeCurso(cmbCurso.getSelectedItem().toString());
						cursoDisciplina.setNomeDisciplina(txtDisciplina.getText());
						
						String nomeCurso = cmbCurso.getSelectedItem().toString();
	
						CursoDAO cursoDao = new CursoDAO();
						Curso curso = new Curso();
						curso = cursoDao.Consultar1(nomeCurso, status);
						 
						if (nomeCurso.equals(curso.getNomeCurso())) {
							int idCurso = curso.getIdCurso();
							cursoDisciplina.setIdCurso(idCurso);	
							cursoDisciplina.setStatus("Ativo");
							
							CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
							cursoDisciplinaDao.Salvar(cursoDisciplina);
												
							JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
							
							List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
							lista = cursoDisciplinaDao.ListarTodos5(nomeCurso, nomeDisciplina);
							DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
							model.setNumRows(0);
							for (CursoDisciplina cursoDisciplina1 : lista) {
								model.addRow (new Object[] {
										cursoDisciplina1.getNomeCurso(),
										cursoDisciplina1.getNomeDisciplina(),
										cursoDisciplina1.getStatus(),
										cursoDisciplina1.getIdCursoDisciplina(),
									});
							} 
						}
						else {
							JOptionPane.showMessageDialog (null, "Erro ao Pegar o ID do Curso");
						}
					}
					txtDisciplina.setText(null);
					cmbCurso.setSelectedIndex(0);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!!. "
							+ "\n1. Verifique se a Disciplina foi preenchida corretamente e se o cadastro da mesma já foi feito"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(176, 134, 60, 43);
		contentPane.add(btnSalvar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 235, 447, 2);
		contentPane.add(separator_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 395, 129);
		contentPane.add(scrollPane);
		
		tabDisciplina = new JTable();
		tabDisciplina.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabDisciplina.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Disciplina", "Status", "ID Curso Disciplina"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabDisciplina.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabDisciplina.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabDisciplina.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabDisciplina.getColumnModel().getColumn(3).setPreferredWidth(150);
		scrollPane.setViewportView(tabDisciplina);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCurso.setSelectedIndex(0);
				txtDisciplina.setText(null);
				((DefaultTableModel) tabDisciplina.getModel()).setRowCount(0);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(106, 134, 60, 43);
		contentPane.add(btnNovo);
		
		btnAtivar = new JButton("");
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(98, 401, 60, 43);
		contentPane.add(btnAtivar);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("btnDesativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(177, 401, 60, 43);
		contentPane.add(btnDesativar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 188, 447, 2);
		contentPane.add(separator_3);
		
		btnListarCoordenadoresAtivos = new JButton("Listar Ativos");
		btnListarCoordenadoresAtivos.setToolTipText("Bot\u00E3o Listar Coordenadores Ativos");
		btnListarCoordenadoresAtivos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarCoordenadoresAtivos.setBounds(11, 201, 123, 23);
		contentPane.add(btnListarCoordenadoresAtivos);
		
		btnListarDesativados = new JButton("Listar Inativos");
		btnListarDesativados.setToolTipText("Bot\u00E3o Listar Coordenadores Inativos");
		btnListarDesativados.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDesativados.setBounds(145, 201, 123, 23);
		contentPane.add(btnListarDesativados);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setToolTipText("Bot\u00E3o Listar Todos os Coordenadores");
		btnListarTodos.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarTodos.setBounds(279, 201, 123, 23);
		contentPane.add(btnListarTodos);
		
		cmbCurso = new JComboBox();
		cmbCurso.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					String status = "Ativo";
					
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos2(status);
					DefaultComboBoxModel model = new DefaultComboBoxModel(lista.toArray());
					cmbCurso.setModel(model);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		cmbCurso.setBounds(90, 52, 315, 30);
		contentPane.add(cmbCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(10, 93, 69, 30);
		contentPane.add(lblDisciplina);
	}
}
