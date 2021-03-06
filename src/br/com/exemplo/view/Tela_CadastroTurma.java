package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.DisciplinaDAO;
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.Disciplina;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.model.Turma;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tela_CadastroTurma extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblAlunosMatriculados;
	private JTextField txtQtdAluno;
	private JButton btnSalvar;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JLabel lblSemestreLetivo;
	private JTable tabTurma;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JComboBox cmbSemestreLetivo;
	private JButton btnNovoSemestre;
	private JLabel lblTurma;
	private JComboBox cmbDisciplina;
	private JLabel lblDisciplina;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnSair;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblBemVindoA_1;
	private JTextField txtTurma;
	private JButton btnNovo;
	private JButton btnDesativar;
	private JButton btnAtivar;
	private JSeparator separator_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroTurma frame = new Tela_CadastroTurma();
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
	public Tela_CadastroTurma() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 541);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Turmas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "===========Turmas==========="
						+ "\n Nesta �rea voc� poder�: "
						+ "\n\n 1. Cadastrar turmas"
						+ "\n 2. Manter turmas"
						+ "\n============================", "Informa��es das Turmas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		
		separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
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
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(41, 52, 56, 21);
		contentPane.add(lblCurso);
		
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

					String nomeCurso = cmbCurso.getSelectedItem().toString();
					
					List<CursoDisciplina> lista1 = new ArrayList<CursoDisciplina>();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					lista1 = cursoDisciplinaDao.ListarTodos3(nomeCurso, status);
					DefaultComboBoxModel model1 = new DefaultComboBoxModel(lista1.toArray());
					cmbDisciplina.setModel(model1);
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
		cmbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String status = "Ativo";
					
					List<CursoDisciplina> lista1 = new ArrayList<CursoDisciplina>();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					lista1 = cursoDisciplinaDao.ListarTodos3(nomeCurso, status);
					DefaultComboBoxModel model1 = new DefaultComboBoxModel(lista1.toArray());
					cmbDisciplina.setModel(model1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(137, 52, 331, 21);
		contentPane.add(cmbCurso);
		
		lblAlunosMatriculados = new JLabel("Qtd. Alunos");
		lblAlunosMatriculados.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlunosMatriculados.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAlunosMatriculados.setBounds(330, 119, 81, 21);
		contentPane.add(lblAlunosMatriculados);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setColumns(10);
		txtQtdAluno.setBounds(419, 119, 49, 20);
		contentPane.add(txtQtdAluno);
		
		btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
					String semestre = cmbSemestreLetivo.getSelectedItem().toString();
					String turmaCod = txtTurma.getText();
					String periodo = cmbPeriodo.getSelectedItem().toString();
					String status = "Ativo";
					
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
					
					SemestreLetivo semestreLetivo = new SemestreLetivo();
					SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
					semestreLetivo = semestreLetivoDao.Consultar2(semestre, status);
					
					Turma turma = new Turma();
					TurmaDAO turmaDao = new TurmaDAO();
					turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestre, status);
					
					if (turma.getIdTurma() == 0) {
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina())) {
							turma.setIdCursoDisciplina(cursoDisciplina.getIdCursoDisciplina());
							turma.setNomeCurso(nomeCurso);
							turma.setDisciplina(nomeDisciplina);
							
							if (semestre.equals(semestreLetivo.getSemestre())) {
								turma.setIdSemestre(semestreLetivo.getIdSemestre());
								turma.setSemestreLetivo(semestre);
								
								turma.setTurmaCod(txtTurma.getText());
								turma.setAlunosMatriculados(Integer.parseInt(txtQtdAluno.getText()));
								turma.setPeriodo(cmbPeriodo.getSelectedItem().toString());
								turma.setStatus (status);
								
								turmaDao.Salvar(turma);
								
								List<Turma> lista = new ArrayList<Turma>();
								lista = turmaDao.ListarTodos7(nomeCurso, nomeDisciplina, turmaCod, semestre, periodo, status);
								DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
								model.setNumRows(0);
								for (Turma turma1 : lista) {
									model.addRow (new Object[] {
											turma1.getTurmaCod(),
											turma1.getNomeCurso(),
											turma1.getDisciplina(),
											turma1.getAlunosMatriculados(),
											turma1.getPeriodo(),
											turma1.getSemestreLetivo(),
											turma1.getStatus(),
											turma1.getIdTurma(),
										});
								} 
								
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
							}
							else {
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao pegar ID do semestre", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
							}
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao pegar ID curso disciplina!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
						}
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Turma j� cadastrada no sistema!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						
						int idTurma = turma.getIdTurma();
						
						List<Turma> lista = new ArrayList<Turma>();
						lista = turmaDao.ListarTodos1(idTurma);
						DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
						model.setNumRows(0);
						for (Turma turma1 : lista) {
							model.addRow (new Object[] {
									turma1.getTurmaCod(),
									turma1.getNomeCurso(),
									turma1.getDisciplina(),
									turma1.getAlunosMatriculados(),
									turma1.getPeriodo(),
									turma1.getSemestreLetivo(),
									turma1.getStatus(),
									turma1.getIdTurma(),
								});
						} 
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao salvar!!. "
							+ "\n\n1. Verifique os dados preenchidos e tente novamente"
							+ "\n2. Verifique se n�o falta preencher nenhum campo"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(220, 196, 60, 43);
		contentPane.add(btnSalvar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 485, 121);
		contentPane.add(scrollPane);
		
		tabTurma = new JTable();
		tabTurma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabTurma.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Turma", "Curso", "Disciplina", "Qtd Alunos", "Periodo", "Semestre", "Status", "Id Turma"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabTurma.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabTurma.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabTurma.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabTurma.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabTurma.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabTurma.getColumnModel().getColumn(7).setPreferredWidth(70);
		scrollPane.setViewportView(tabTurma);
		
		separator = new JSeparator();
		separator.setBounds(0, 397, 505, 2);
		contentPane.add(separator);
		
		lblSemestreLetivo = new JLabel("Semestre Letivo");
		lblSemestreLetivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestreLetivo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSemestreLetivo.setBounds(265, 151, 112, 23);
		contentPane.add(lblSemestreLetivo);
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPeriodo.setBounds(46, 152, 56, 21);
		contentPane.add(lblPeriodo);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino", "Noturno"}));
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo.setBounds(137, 152, 112, 21);
		contentPane.add(cmbPeriodo);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					String status = "Ativo";
					
					List<SemestreLetivo> lista4 = new ArrayList<SemestreLetivo>();
					SemestreLetivoDAO semestreLetivoDAO = new SemestreLetivoDAO();
					lista4 = semestreLetivoDAO.ListarTodos4(status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbSemestreLetivo.setModel(model4);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(387, 151, 81, 22);
		contentPane.add(cmbSemestreLetivo);
		
		btnNovoSemestre = new JButton("Novo Semestre");
		btnNovoSemestre.setToolTipText("");
		btnNovoSemestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					String semestre = (String) JOptionPane.showInputDialog(null, "Informe o Semestre Letivo: ", "Semestre Letivo", JOptionPane.OK_CANCEL_OPTION, icon1, null, null);
				
					String status = "Ativo";
					String status1 = "Desativado";
					String semestre1 = "%%";
					
					SemestreLetivo semestreLetivo = new SemestreLetivo();
					SemestreLetivo semestreLetivo1 = new SemestreLetivo();
					SemestreLetivo semestreLetivo2 = new SemestreLetivo();
					SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
					semestreLetivo = semestreLetivoDao.Consultar2(semestre, status);
					semestreLetivo1 = semestreLetivoDao.Consultar2(semestre, status1);
					semestreLetivo2 = semestreLetivoDao.Consultar4(status);
					
					if (semestre.equals("")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Digite o semestre para prosseguir!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
					else {
						if (semestre.equals(semestreLetivo.getSemestre())) {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Esse semestre j� existe no banco e esta ativo", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						} 
						else {
							if (semestre.equals(semestreLetivo1.getSemestre())) {
								int idSemestre = semestreLetivo1.getIdSemestre();
								semestreLetivo1.setStatus("Ativo");
								semestreLetivo1.setSemestre(semestre);
								semestreLetivo1.setIdSemestre(idSemestre);
								
								semestreLetivoDao.Alterar(semestreLetivo1);
								
								int idSemestreAntigo = semestreLetivo2.getIdSemestre();
								String semestreAntigo = semestreLetivo2.getSemestre();
								
								semestreLetivo2.setStatus("Desativado");
								semestreLetivo2.setSemestre(semestreAntigo);
								semestreLetivo2.setIdSemestre(idSemestreAntigo);
								
								semestreLetivoDao.Alterar(semestreLetivo2);
								
								List<SemestreLetivo> lista4 = new ArrayList<SemestreLetivo>();
								SemestreLetivoDAO semestreLetivoDAO = new SemestreLetivoDAO();
								lista4 = semestreLetivoDAO.ListarTodos4(status);
								DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
								cmbSemestreLetivo.setModel(model4);
								
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			
							}
							else {
								int idSemestre = semestreLetivo2.getIdSemestre();
								String semestreAntigo = semestreLetivo2.getSemestre();
								
								semestreLetivo2.setStatus("Desativado");
								semestreLetivo2.setSemestre(semestreAntigo);
								semestreLetivo2.setIdSemestre(idSemestre);
								
								semestreLetivoDao.Alterar(semestreLetivo2);
								
								semestreLetivo.setSemestre(semestre);
								semestreLetivo.setStatus("Ativo");
								
								semestreLetivoDao.Salvar(semestreLetivo);
								
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			
								List<SemestreLetivo> lista4 = new ArrayList<SemestreLetivo>();
								SemestreLetivoDAO semestreLetivoDAO = new SemestreLetivoDAO();
								lista4 = semestreLetivoDAO.ListarTodos4(status);
								DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
								cmbSemestreLetivo.setModel(model4);
							}
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao cadastrar semestre!!. "
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnNovoSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovoSemestre.setBounds(334, 202, 134, 30);
		contentPane.add(btnNovoSemestre);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTurma.setBounds(45, 119, 56, 21);
		contentPane.add(lblTurma);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDisciplina.setBounds(137, 85, 331, 21);
		contentPane.add(cmbDisciplina);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(37, 85, 70, 21);
		contentPane.add(lblDisciplina);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_CadastroTurma telaCadastroTurma = new Tela_CadastroTurma();
				telaCadastroTurma.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 416, 60, 43);
		contentPane.add(btnVoltar);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cursoNome = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 1));
					String disciplinaNome = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 2));
					String codTurma = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 0));
					String alunos = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 3));
					String periodoo = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 4));
					String semestree = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 5));
					String id = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 7));
					
					int idTurma = Integer.parseInt(id);
					
					if (cursoNome.equals(cmbCurso.getSelectedItem().toString()) && disciplinaNome.equals(cmbDisciplina.getSelectedItem().toString()) && codTurma.equals(txtTurma.getText()) && alunos.equals(txtQtdAluno.getText()) && periodoo.equals(cmbPeriodo.getSelectedItem().toString()) && semestree.equals(cmbSemestreLetivo.getSelectedItem().toString())) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Por favor altere alguma informa��o antes de prosseguir!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					
					}
					else {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = txtTurma.getText();
						int qtdAlunos = Integer.parseInt(txtQtdAluno.getText());
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestre = cmbSemestreLetivo.getSelectedItem().toString();
						String status = "Ativo";
						
						Turma turma = new Turma();
						TurmaDAO turmaDao = new TurmaDAO();
						turma = turmaDao.Consultar1(cursoNome, disciplinaNome, codTurma, periodoo, semestree, status);
						
						SemestreLetivo semestreLetivo = new SemestreLetivo();
						SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
						semestreLetivo = semestreLetivoDao.Consultar2(semestre, status);
						
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
						
						if (turma.getTurmaCod().equals("")) {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
						
						else if (codTurma.equals(turma.getTurmaCod())) {
							turma.setIdTurma(idTurma);
							turma.setTurmaCod(txtTurma.getText());
							
							if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina())) {
								turma.setIdCursoDisciplina(cursoDisciplina.getIdCursoDisciplina());
								turma.setNomeCurso(cmbCurso.getSelectedItem().toString());
								turma.setDisciplina(cmbDisciplina.getSelectedItem().toString());
								
								if (semestre.equals(semestreLetivo.getSemestre())) {
									turma.setIdSemestre(semestreLetivo.getIdSemestre());
									turma.setSemestreLetivo(cmbSemestreLetivo.getSelectedItem().toString());
									turma.setAlunosMatriculados(Integer.parseInt(txtQtdAluno.getText()));
									turma.setPeriodo(cmbPeriodo.getSelectedItem().toString());
									turma.setStatus("Ativo");
									
									turmaDao.Alterar(turma);
									
									List<Turma> lista = new ArrayList<Turma>();
									lista = turmaDao.ListarTodos1(idTurma);
									
									DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
									model.setNumRows(0);
									for (Turma turma1 : lista) {
										model.addRow (new Object[] {
												turma1.getTurmaCod(),
												turma1.getNomeCurso(),
												turma1.getDisciplina(),
												turma1.getAlunosMatriculados(),
												turma1.getPeriodo(),
												turma1.getSemestreLetivo(),
												turma1.getStatus(),
												turma1.getIdTurma(),
											});
									}
									
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Alterado com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								}
								else {
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Erro ao pegar ID do semestre!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								}
							}
							else {
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao pegar ID do curso e da disciplina, verifique se essa disciplina pertence mesmo a esse curso", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							}
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao pegar ID da turma!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
				} catch(Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Alterar!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos ou realize uma consulta para saber se esse curso e disciplina j� est� cadastrado" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(290, 416, 60, 43);
		contentPane.add(btnAlterar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] itens = {"Turma Especifica", "Curso", "Curso e Disciplina", "Turma", "Periodo", "Listar Todas as Turmas"};
					ImageIcon icon2 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
					Object selectedValue = JOptionPane.showInputDialog (null, "Escolha um Tipo de Consulta", "Consultar Turmas", JOptionPane.INFORMATION_MESSAGE, icon2, itens, itens[0]);
					String opcao = selectedValue.toString();
					
					Turma turma = new Turma();
					TurmaDAO turmaDao = new TurmaDAO();
					
					if (opcao.equals("Turma Especifica")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = txtTurma.getText();
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = cmbSemestreLetivo.getSelectedItem().toString();
						String status = "Ativo";
						
						turma = turmaDao.Consultar1 (nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
						
						if (nomeCurso.equals(turma.getNomeCurso()) && disciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
							cmbCurso.setSelectedItem(turma.getNomeCurso());
							cmbDisciplina.setSelectedItem(turma.getDisciplina());
							txtTurma.setText(turma.getTurmaCod());
							txtQtdAluno.setText(String.valueOf(turma.getAlunosMatriculados()));
							cmbPeriodo.setSelectedItem(turma.getPeriodo());
							cmbSemestreLetivo.setSelectedItem(turma.getSemestreLetivo());
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe, verifique os dados preenchidos", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
					}
					else if (opcao.equals("Curso")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = "%%";
						String turmaCod = "%%";
						String periodo = "%%";
						String semestreLetivo = "%%";
						String status = "Ativo";
						
						turma = turmaDao.Consultar1 (nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
						if (nomeCurso.equals(turma.getNomeCurso())) {
							
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							} 
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe, verifique os dados preenchidos", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
					else if (opcao.equals("Curso e Disciplina")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = "%%";
						String periodo = "%%";
						String semestreLetivo = "%%";
						String status = "Ativo";
						
						turma = turmaDao.Consultar1 (nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
						if (nomeCurso.equals(turma.getNomeCurso()) && disciplina.equals(disciplina)) {
							
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							} 
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe, verifique os dados preenchidos", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
					else if (opcao.equals("Turma")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = txtTurma.getText();
						String periodo = "%%";
						String semestreLetivo = "%%";
						String status = "Ativo";
						
						turma = turmaDao.Consultar1 (nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
						if (turmaCod.equals(turma.getTurmaCod())) {
							
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							} 
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe, verifique os dados preenchidos", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
					else if (opcao.equals("Periodo")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = "%%";
						String status = "Ativo";
						
						turma = turmaDao.Consultar1 (nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
						if (periodo.equals(turma.getPeriodo())) {
							
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							} 
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Essa turma n�o existe, verifique os dados preenchidos", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
					else if (opcao.equals("Listar Todas as Turmas")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String periodo = "%%";
						String semestreLetivo = "%%";
						String status = "%%";
					
						List<Turma> lista = new ArrayList<Turma>();
						lista = turmaDao.ListarTodos7(nomeCurso, disciplina, turmaCod, semestreLetivo, periodo, status);
						DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
						model.setNumRows(0);
						for (Turma turma1 : lista) {
							model.addRow (new Object[] {
									turma1.getTurmaCod(),
									turma1.getNomeCurso(),
									turma1.getDisciplina(),
									turma1.getAlunosMatriculados(),
									turma1.getPeriodo(),
									turma1.getSemestreLetivo(),
									turma1.getStatus(),
									turma1.getIdTurma(),
								});
						} 
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Escolha uma op��o valida", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar!!. "
							+ "\n\nVerifique os dados preenchidos e tente novamente"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(360, 416, 60, 43);
		contentPane.add(btnConsultar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(430, 416, 60, 43);
		contentPane.add(btnSair);
		
		lblBemVindoA_1 = new JLabel("Bem Vindo a Tela de Cadastro de Turma");
		lblBemVindoA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoA_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBemVindoA_1.setBounds(10, 11, 485, 30);
		contentPane.add(lblBemVindoA_1);
		
		txtTurma = new JTextField();
		txtTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTurma.setColumns(10);
		txtTurma.setBounds(137, 121, 90, 20);
		contentPane.add(txtTurma);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tabTurma.getModel()).setRowCount(0);
				txtTurma.setText(null);
				txtQtdAluno.setText(null);
				cmbCurso.setSelectedIndex(0);
				cmbDisciplina.setSelectedIndex(0);
				txtTurma.setText(null);
				txtQtdAluno.setText(null);
				cmbPeriodo.setSelectedIndex(0);
				cmbSemestreLetivo.setSelectedIndex(0);
				((DefaultTableModel) tabTurma.getModel()).setRowCount(0);
			}
		});
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 416, 60, 43);
		contentPane.add(btnNovo);
		
		btnDesativar = new JButton("");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Turma turma = new Turma();
					TurmaDAO turmaDao = new TurmaDAO();
					String status = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 6));
					if (status.equals("Desativado")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "A turma j� est� desativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 7));
						int idTurma = Integer.parseInt(teste);
						
						turma.setStatus("Desativado");
						turma.setIdTurma(idTurma);
						
						String nomeCurso = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 1));
						String nomeDisciplina = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 2));
						String turmaCod = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 0));
						String periodo = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 4));
						String semestre = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 5));
						
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "Deseja mesmo ativar a turma " + turmaCod + ", do curso " + nomeCurso + ", disciplina " + nomeDisciplina + ", periodo " + periodo + ", semestre " + semestre, "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
							
						if (resposta == JOptionPane.YES_OPTION) {
							turmaDao.AtivarDesativar(turma);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "A turma foi desativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							
							String cursoNome = "%%";
							String disciplina = "%%";
							String codTurma = "%%";
							String semestreLetivo = "%%";
							String periodoo = "%%";
							String status1 = "Desativado";
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(cursoNome, disciplina, codTurma, semestreLetivo, periodoo, status1);
							
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							}
						}
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Desativar Turma!!. "
							+ "\n\n1. Verifique se a turma j� esta desativada" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Desativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(220, 416, 60, 43);
		contentPane.add(btnDesativar);
		
		btnAtivar = new JButton("");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Turma turma = new Turma();
					TurmaDAO turmaDao = new TurmaDAO();
					String status = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 6));
					if (status.equals("Ativo")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "A turma j� est� ativa!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 7));
						int idTurma = Integer.parseInt(teste);
						
						turma.setStatus("Ativo");
						turma.setIdTurma(idTurma);
						
						String nomeCurso = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 1));
						String nomeDisciplina = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 2));
						String turmaCod = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 0));
						String periodo = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 4));
						String semestre = String.valueOf(tabTurma.getValueAt(tabTurma.getSelectedRow(), 5));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "Deseja mesmo ativar a turma " + turmaCod + " do curso " + nomeCurso + ", disciplina " + nomeDisciplina + ", periodo " + periodo + ", semestre " + semestre, "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						if (resposta == JOptionPane.YES_OPTION) {
							turmaDao.AtivarDesativar(turma);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "A turma foi ativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							String cursoNome = "%%";
							String disciplina = "%%";
							String codTurma = "%%";
							String semestreLetivo = "%%";
							String periodoo = "%%";
							String status1 = "Ativo";
							
							List<Turma> lista = new ArrayList<Turma>();
							lista = turmaDao.ListarTodos7(cursoNome, disciplina, codTurma, semestreLetivo, periodoo, status1);
							
							DefaultTableModel model = (DefaultTableModel) tabTurma.getModel();
							model.setNumRows(0);
							for (Turma turma1 : lista) {
								model.addRow (new Object[] {
										turma1.getTurmaCod(),
										turma1.getNomeCurso(),
										turma1.getDisciplina(),
										turma1.getAlunosMatriculados(),
										turma1.getPeriodo(),
										turma1.getSemestreLetivo(),
										turma1.getStatus(),
										turma1.getIdTurma(),
									});
							}
						}
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Ativar turma!!. "
							+ "\n\n1. Verifique se a turma j� esta ativa" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(150, 416, 60, 43);
		contentPane.add(btnAtivar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 252, 505, 2);
		contentPane.add(separator_3);
	}
}
