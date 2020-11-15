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
				JOptionPane.showMessageDialog(null, "===========Turmas==========="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar as Turmas"
						+ "\n 2. Manter as Turmas"
						+ "\n============================");
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
				JOptionPane.showMessageDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================");
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
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
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
								
								JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
								
								cmbCurso.setSelectedIndex(0);
								cmbDisciplina.setSelectedIndex(0);
								txtTurma.setText(null);
								txtQtdAluno.setText(null);
								cmbPeriodo.setSelectedIndex(0);
								cmbSemestreLetivo.setSelectedIndex(0);
							}
							else {
								JOptionPane.showMessageDialog(null, "Erro ao pegar o ID do Semestre");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao pegar o ID Curso Disciplina");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Turma já Cadastrada no Sistema!!");
						
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
						
						cmbCurso.setSelectedIndex(0);
						cmbDisciplina.setSelectedIndex(0);
						txtTurma.setText(null);
						txtQtdAluno.setText(null);
						cmbPeriodo.setSelectedIndex(0);
						cmbSemestreLetivo.setSelectedIndex(0);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!!. "
							+ "\n1. Verifique os dados preenchidos e tente novamente"
							+ "\n2. Verifique se não falta preencher nenhum campo"
							+ "\n\nErro: " + e1);
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
		cmbSemestreLetivo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String status = "Ativo";
					
					List<SemestreLetivo> lista4 = new ArrayList<SemestreLetivo>();
					SemestreLetivoDAO semestreLetivoDAO = new SemestreLetivoDAO();
					lista4 = semestreLetivoDAO.ListarTodos4(status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbSemestreLetivo.setModel(model4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
		btnNovoSemestre.setToolTipText("Bot\u00E3o Novo Semestre");
		btnNovoSemestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String semestre = JOptionPane.showInputDialog("Semestre Letivo:");
					String status = "Ativo";
					
					SemestreLetivo semestreLetivo = new SemestreLetivo();
					SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
					semestreLetivo = semestreLetivoDao.Consultar3();
					
					if (semestre.equals("")) {
						JOptionPane.showMessageDialog(null, "Digite o Semestre para prosseguir");
					}
					else {
						if (semestreLetivo.getSemestre().equals("")) {
							semestreLetivo.setIdSemestre(1);
							semestreLetivo.setSemestre(semestre);
							semestreLetivo.setStatus("Ativo");
							
							semestreLetivoDao.Salvar(semestreLetivo);
							
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
						}
						else {
							semestreLetivo.setIdSemestre(1);
							semestreLetivo.setSemestre(semestre);
							semestreLetivo.setStatus("Ativo");
							
							semestreLetivoDao.Alterar(semestreLetivo);
							
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Semestre!!. "
							+ "\n\nErro: " + e1);
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
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
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
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(290, 416, 60, 43);
		contentPane.add(btnAlterar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] itens = {"Todos os Filtros", "Curso", "Curso e Disciplina", "Turma", "Periodo", "Listar Todas as Turmas"};
					Object selectedValue = JOptionPane.showInputDialog (null, "Escolha um Tipo de Consulta", "Consultar Turmas", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
					String opcao = selectedValue.toString();
					
					Turma turma = new Turma();
					TurmaDAO turmaDao = new TurmaDAO();
					
					if (opcao.equals("Todos os Filtros")) {
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
						}
						else {
							JOptionPane.showMessageDialog(null, "Essa turma não existe, verifique os dados preenchidos");
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
							cmbCurso.setSelectedItem(turma.getNomeCurso());
							cmbDisciplina.setSelectedItem(null);
							txtTurma.setText(null);
							txtQtdAluno.setText(null);
							cmbPeriodo.setSelectedItem(null);
							cmbSemestreLetivo.setSelectedItem(null);
							
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
							JOptionPane.showMessageDialog(null, "Essa turma não existe, verifique os dados preenchidos");
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
							cmbCurso.setSelectedItem(turma.getNomeCurso());
							cmbDisciplina.setSelectedItem(turma.getDisciplina());
							txtTurma.setText(null);
							txtQtdAluno.setText(null);
							cmbPeriodo.setSelectedItem(null);
							cmbSemestreLetivo.setSelectedItem(null);
							
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
							JOptionPane.showMessageDialog(null, "Essa turma não existe, verifique os dados preenchidos");
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
							cmbCurso.setSelectedItem(null);
							cmbDisciplina.setSelectedItem(null);
							txtTurma.setText(turma.getTurmaCod());
							txtQtdAluno.setText(null);
							cmbPeriodo.setSelectedItem(null);
							cmbSemestreLetivo.setSelectedItem(null);
							
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
							JOptionPane.showMessageDialog(null, "Essa turma não existe, verifique os dados preenchidos");
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
							cmbCurso.setSelectedItem(null);
							cmbDisciplina.setSelectedItem(null);
							txtTurma.setText(null);
							txtQtdAluno.setText(null);
							cmbPeriodo.setSelectedItem(turma.getPeriodo());
							cmbSemestreLetivo.setSelectedItem(null);
							
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
							JOptionPane.showMessageDialog(null, "Essa turma não existe, verifique os dados preenchidos");
						}
					}
					else if (opcao.equals("Listar Todas as Turmas")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String periodo = "%%";
						String semestreLetivo = "%%";
						String status = "%%";
					
						cmbCurso.setSelectedItem(null);
						cmbDisciplina.setSelectedItem(null);
						txtTurma.setText(turma.getTurmaCod());
						txtQtdAluno.setText(null);
						cmbPeriodo.setSelectedItem(null);
						cmbSemestreLetivo.setSelectedItem(null);
						
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
						JOptionPane.showMessageDialog(null, "Escolha uma opcao válida");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar!!. "
							+ "\nVerifique os Dados Preenchidos e Tente Novamente"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(360, 416, 60, 43);
		contentPane.add(btnConsultar);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Bot\u00E3o Sair");
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
				cmbCurso.setSelectedIndex(0);
				cmbDisciplina.setSelectedIndex(0);
				txtTurma.setText(null);
				txtQtdAluno.setText(null);
				cmbPeriodo.setSelectedIndex(0);
				cmbSemestreLetivo.setSelectedIndex(0);
				((DefaultTableModel) tabTurma.getModel()).setRowCount(0);
			}
		});
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 416, 60, 43);
		contentPane.add(btnNovo);
		
		btnDesativar = new JButton("");
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Bot\u00E3o Desativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(220, 416, 60, 43);
		contentPane.add(btnDesativar);
		
		btnAtivar = new JButton("");
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroTurma.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Bot\u00E3o Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(150, 416, 60, 43);
		contentPane.add(btnAtivar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 252, 505, 2);
		contentPane.add(separator_3);
	}
}
