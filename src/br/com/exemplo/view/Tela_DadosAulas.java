package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.DadosAulaDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.DadosAula;
import br.com.exemplo.model.Professores;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.model.Turma;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputEvent;
import javax.swing.AbstractListModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tela_DadosAulas extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JLabel lblDisciplina;
	private JLabel lblDataDaAula;
	private JLabel lblNome_3;
	private JComboBox cmbCurso;
	private JComboBox cmbDisciplina;
	private JDateChooser dteDataAula;
	private JComboBox cmbPeriodo;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNome;
	private JComboBox cmbProfessor;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnPDF;
	private JButton btnSair;
	private JLabel lblNome_1;
	private JComboBox cmbTurma;
	private JLabel lblNome_2;
	private JComboBox cmbSemestreLetivo;
	private JComboBox cmbData;
	private JLabel lblNome_4;
	private JDateChooser dteDataAula2;
	private JSeparator separator_2;
	private JLabel lblNome_5;
	private JRadioButton btnSimAula;
	private JRadioButton btnNaoAula;
	private JTextField txtQtdAluno;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JComboBox cmbAlunos;
	private JLabel lblNome_6;
	private JRadioButton btnSimAtividade;
	private JRadioButton btnNaoAtividade;
	private JSeparator separator_5;
	private JButton btnConsultar;
	private JButton btnGrafico;
	private JTable tabDadosAulas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_DadosAulas frame = new Tela_DadosAulas();
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
	public Tela_DadosAulas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 621);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Consultas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "=====================Dados e Relatorios====================="
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Consultar os cadastros das aulas com base nos seguintes filtros:"
						+ "\n\n * Curso"
						+ "\n * Disciplina"
						+ "\n * Turma"
						+ "\n * Professor"
						+ "\n * Periodo"
						+ "\n * Semestre letivo"
						+ "\n * Data da aula ou intervalo de datas"
						+ "\n * Aula realizada"
						+ "\n * Quantidade de alunos"
						+ "\n * Atividade solicitada"
						+ "\n\n 2. Você poderá também gerar seu PDF e Gráfico"
						+ "\n==========================================================", "Informações", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 12, 45, 30);
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 49, 62, 30);
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDisciplina);
		
		lblDataDaAula = new JLabel("Data");
		lblDataDaAula.setBounds(226, 129, 31, 21);
		lblDataDaAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDaAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblDataDaAula);
		
		lblNome_3 = new JLabel("Periodo");
		lblNome_3.setBounds(404, 94, 48, 21);
		lblNome_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblNome_3);
		
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
					
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos5(nomeCurso, disciplina, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos6(nomeCurso, disciplina, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
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
					
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos5(nomeCurso, disciplina, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos6(nomeCurso, disciplina, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cmbCurso.setBounds(82, 17, 502, 21);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbCurso);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					String status = "Ativo";
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos5(nomeCurso, disciplina, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos6(nomeCurso, disciplina, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cmbDisciplina.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					String status = "Ativo";
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos5(nomeCurso, disciplina, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos6(nomeCurso, disciplina, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cmbDisciplina.setBounds(82, 53, 353, 23);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbDisciplina);
		
		dteDataAula = new JDateChooser();
		dteDataAula.setBounds(375, 126, 101, 26);
		contentPane.add(dteDataAula);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setBounds(462, 94, 122, 23);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(cmbPeriodo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 574, 208);
		contentPane.add(scrollPane);
		
		tabDadosAulas = new JTable();
		tabDadosAulas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabDadosAulas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Disciplina", "Turma", "Periodo", "Semestre", "Data da Aula", "Teve Aula", "Justificativa", "Horario Inicio", "Horario Termino", "Assunto", "Quantidade de Alunos", "Materiais Disponibilizados", "Link Sessão", "Link Gravação", "Observação", "Atividade Solicitada", "Data de Entrega", "Quantidade de Pessoas", "Descrição", "Id Aula"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabDadosAulas.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabDadosAulas.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabDadosAulas.getColumnModel().getColumn(4).setPreferredWidth(70);
		tabDadosAulas.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabDadosAulas.getColumnModel().getColumn(7).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(8).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(9).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(10).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(11).setPreferredWidth(150);
		tabDadosAulas.getColumnModel().getColumn(12).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(13).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(14).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(15).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(16).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(17).setPreferredWidth(100);
		tabDadosAulas.getColumnModel().getColumn(18).setPreferredWidth(150);
		tabDadosAulas.getColumnModel().getColumn(19).setPreferredWidth(180);
		tabDadosAulas.getColumnModel().getColumn(20).setPreferredWidth(70);
		scrollPane.setViewportView(tabDadosAulas);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 484, 641, 2);
		contentPane.add(separator_1);
		
		lblNome = new JLabel("Professor");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(10, 87, 77, 30);
		contentPane.add(lblNome);
		
		cmbProfessor = new JComboBox();
		cmbProfessor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					String status = "Ativo";
					
					List<Professores> lista4 = new ArrayList<Professores>();
					ProfessoresDAO professoresDao = new ProfessoresDAO();
					lista4 = professoresDao.ListarTodos2(status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbProfessor.setModel(model4);
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
		cmbProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbProfessor.setBounds(82, 92, 312, 23);
		contentPane.add(cmbProfessor);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCurso.setSelectedIndex(0);
				cmbDisciplina.setSelectedIndex(0);
				cmbTurma.setSelectedIndex(0);
				cmbProfessor.setSelectedIndex(0);
				cmbPeriodo.setSelectedIndex(0);
				cmbSemestreLetivo.setSelectedIndex(0);
				cmbData.setSelectedIndex(0);
				dteDataAula.setDate(null);
				dteDataAula2.setDate(null);
				btnSimAula.setSelected(false);
				btnNaoAula.setSelected(false);
				cmbAlunos.setSelectedIndex(0);
				txtQtdAluno.setText(null);
				btnSimAtividade.setSelected(false);
				btnNaoAtividade.setSelected(false);
				((DefaultTableModel) tabDadosAulas.getModel()).setRowCount(0);
			}
		});
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(126, 497, 60, 43);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_DadosAulas telaDadosAulas = new Tela_DadosAulas();
				telaDadosAulas.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(33, 497, 60, 43);
		contentPane.add(btnVoltar);
		
		btnPDF = new JButton("");
		btnPDF.setToolTipText("PDF");
		btnPDF.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/pdf-2.png")));
		btnPDF.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPDF.setBounds(312, 497, 60, 43);
		contentPane.add(btnPDF);
		
		btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(498, 497, 60, 43);
		contentPane.add(btnSair);
		
		lblNome_1 = new JLabel("Turma");
		lblNome_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_1.setBounds(445, 49, 45, 30);
		contentPane.add(lblNome_1);
		
		cmbTurma = new JComboBox();
		cmbTurma.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					String turmaCod = cmbTurma.getSelectedItem().toString();
					String status = "Ativo";
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos3(nomeCurso, disciplina, turmaCod, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos4(nomeCurso, disciplina, turmaCod, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
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
		cmbTurma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					String turmaCod = cmbTurma.getSelectedItem().toString();
					String status = "Ativo";
					
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista3 = turmaDao3.ListarTodos3(nomeCurso, disciplina, turmaCod, status);
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
					
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao4 = new TurmaDAO();
					lista4 = turmaDao4.ListarTodos4(nomeCurso, disciplina, turmaCod, status);
					DefaultComboBoxModel model4 = new DefaultComboBoxModel(lista4.toArray());
					cmbPeriodo.setModel(model4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(495, 54, 89, 23);
		contentPane.add(cmbTurma);
		
		lblNome_2 = new JLabel("Semestre Letivo");
		lblNome_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_2.setBounds(10, 129, 111, 21);
		contentPane.add(lblNome_2);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(131, 128, 85, 23);
		contentPane.add(cmbSemestreLetivo);
		
		cmbData = new JComboBox();
		cmbData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbData.getSelectedItem().toString().equals("Especifica")) {
					dteDataAula2.setEnabled(false);
				}
				else if (cmbData.getSelectedItem().toString().equals("Intervalo")) {
					dteDataAula2.setEnabled(true);
				}
			}
		});
		cmbData.setModel(new DefaultComboBoxModel(new String[] {"Especifica", "Intervalo"}));
		cmbData.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbData.setBounds(267, 128, 98, 23);
		contentPane.add(cmbData);
		
		lblNome_4 = new JLabel("Qtd de Alunos");
		lblNome_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_4.setBounds(308, 175, 92, 21);
		contentPane.add(lblNome_4);
		
		dteDataAula2 = new JDateChooser();
		dteDataAula2.setEnabled(false);
		dteDataAula2.setBounds(483, 126, 101, 26);
		contentPane.add(dteDataAula2);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(-18, 161, 641, 2);
		contentPane.add(separator_2);
		
		lblNome_5 = new JLabel("Aula Realizada?");
		lblNome_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_5.setBounds(28, 175, 112, 21);
		contentPane.add(lblNome_5);
		
		btnSimAula = new JRadioButton("Sim");
		btnSimAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSimAula.isSelected()) {
					btnNaoAula.setSelected(false);
				}
			}
		});
		btnSimAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnSimAula.setBounds(155, 171, 51, 29);
		contentPane.add(btnSimAula);
		
		btnNaoAula = new JRadioButton("N\u00E3o");
		btnNaoAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNaoAula.isSelected()) {
					btnSimAula.setSelected(false);
				}
			}
		});
		btnNaoAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNaoAula.setBounds(221, 171, 51, 29);
		contentPane.add(btnNaoAula);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setBounds(528, 174, 56, 23);
		contentPane.add(txtQtdAluno);
		txtQtdAluno.setColumns(10);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(-18, 207, 641, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(296, 161, 2, 48);
		contentPane.add(separator_4);
		
		cmbAlunos = new JComboBox();
		cmbAlunos.setModel(new DefaultComboBoxModel(new String[] {"Igual a", "Maior que", "Menor que"}));
		cmbAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbAlunos.setBounds(415, 174, 98, 23);
		contentPane.add(cmbAlunos);
		
		lblNome_6 = new JLabel("Atividade Solicitada?");
		lblNome_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome_6.setBounds(155, 220, 150, 21);
		contentPane.add(lblNome_6);
		
		btnSimAtividade = new JRadioButton("Sim");
		btnSimAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSimAtividade.isSelected()) {
					btnNaoAtividade.setSelected(false);
				}
			}
		});
		btnSimAtividade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnSimAtividade.setBounds(311, 216, 51, 29);
		contentPane.add(btnSimAtividade);
		
		btnNaoAtividade = new JRadioButton("N\u00E3o");
		btnNaoAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNaoAtividade.isSelected()) {
					btnSimAtividade.setSelected(false);
				}
			}
		});
		btnNaoAtividade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNaoAtividade.setBounds(372, 216, 51, 29);
		contentPane.add(btnNaoAtividade);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(-18, 252, 641, 2);
		contentPane.add(separator_5);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] itens = {"Aula Especifica", "Listar Todas as Aulas", "Curso", "Curso e Periodo", "Curso e Disciplina", "Curso, Disciplina e Periodo", "Turma", "Professor", "Periodo", "Semestre", "Data", "Aula Realizada", "Atividade Solicitada", "Quantidade de Alunos"};
					Object selectedValue = JOptionPane.showInputDialog (null, "Escolha um Tipo de Consulta", "Consultar Dados da Aula", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
					String opcao = selectedValue.toString();
					
					DadosAula dadosAula = new DadosAula();
					DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
					
					SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
					String data1, data2;
					
					if (opcao.equals("Aula Especifica")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = cmbTurma.getSelectedItem().toString();
						String nomeProfessor = cmbProfessor.getSelectedItem().toString();
						int idProfessor;
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = cmbSemestreLetivo.getSelectedItem().toString();
						String data = cmbData.getSelectedItem().toString();
						data1 = formatarData.format(dteDataAula.getDate());
						data1.toString();
						String dataAula1 = data1;
						
						Professores professores = new Professores();
						ProfessoresDAO professoresDao = new ProfessoresDAO();
						professores = professoresDao.Consultar2(nomeProfessor);
						
						if (nomeProfessor.equals(professores.getNome())) {
							idProfessor = professores.getIdProfessor();
							
							dadosAula = dadosAulaDao.Consultar2(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1, idProfessor);
							if (nomeCurso.equals(dadosAula.getCurso()) && disciplina.equals(dadosAula.getDisciplina()) && turmaCod.equals(dadosAula.getTurma()) && periodo.equals(dadosAula.getPeriodo()) && semestreLetivo.equals(dadosAula.getSemestreLetivo()) && dataAula1.equals(dadosAula.getDataAula()) && idProfessor == dadosAula.getIdProfessor()) {
								int idAula = dadosAula.getIdAula();
								
								List<DadosAula> lista = new ArrayList<DadosAula>();
								lista = dadosAulaDao.ListarTodos1(idAula);
								DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
								model.setNumRows(0);
								for (DadosAula dadosAula1 : lista) {
									model.addRow (new Object[] {
											dadosAula1.getCurso(),
											dadosAula1.getDisciplina(),
											dadosAula1.getTurma(),
											dadosAula1.getPeriodo(),
											dadosAula1.getSemestreLetivo(),
											dadosAula1.getDataAula(),
											dadosAula1.isTeveAula() == false ? "Não" : "Sim",
											dadosAula1.getJustificativa(),
											dadosAula1.getHorarioInicio(),
											dadosAula1.getHorarioTermino(),
											dadosAula1.getAssunto(),
											dadosAula1.getQtdAlunos(),
											dadosAula1.getMateriaisDisponibilizados(),
											dadosAula1.getLinkSessao(),
											dadosAula1.getLinkGravacao(),
											dadosAula1.getObs(),
											dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
											dadosAula1.getDataEntrega(),
											dadosAula1.getQtdPessoas(),
											dadosAula1.getDescricao(),
											dadosAula1.getIdAula(),
										});
								} 
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								dteDataAula2.setDate(null);
								btnSimAula.setSelected(false);
								btnNaoAula.setSelected(false);
								cmbAlunos.setSelectedIndex(0);
								txtQtdAluno.setText(null);
								btnSimAtividade.setSelected(false);
								btnNaoAtividade.setSelected(false);
							}
							else {
								Object[] options1 = {"OK"};
								ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao consultar aula", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
								
							}
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao buscar ID do professor!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
						}
					}
					else if (opcao.equals("Curso")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = "%%";
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = "%%";
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (nomeCurso.equals(dadosAula.getCurso())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
						}
					}
					else if (opcao.equals("Curso e Periodo")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = "%%";
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (nomeCurso.equals(dadosAula.getCurso()) && periodo.equals(dadosAula.getPeriodo())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
						}
					}
					else if (opcao.equals("Curso e Disciplina")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = "%%";
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (nomeCurso.equals(dadosAula.getCurso()) && disciplina.equals(dadosAula.getDisciplina())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Curso, Disciplina e Periodo")) {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String disciplina = cmbDisciplina.getSelectedItem().toString();
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (nomeCurso.equals(dadosAula.getCurso()) && disciplina.equals(dadosAula.getDisciplina()) && periodo.equals(dadosAula.getPeriodo())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Turma")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = cmbTurma.getSelectedItem().toString();
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = "%%";
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (turmaCod.equals(dadosAula.getTurma())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Professor")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String nomeProfessor = cmbProfessor.getSelectedItem().toString();
						int idProfessor;
						String periodo = "%%";
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						Professores professores = new Professores();
						ProfessoresDAO professoresDao = new ProfessoresDAO();
						professores = professoresDao.Consultar2(nomeProfessor);
						
						if (nomeProfessor.equals(professores.getNome())) {
							idProfessor = professores.getIdProfessor();
							
							dadosAula = dadosAulaDao.Consultar2(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1, idProfessor);
							if (idProfessor == dadosAula.getIdProfessor()) {
								
								List<DadosAula> lista = new ArrayList<DadosAula>();
								lista = dadosAulaDao.ListarTodos2(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1, idProfessor);
								DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
								model.setNumRows(0);
								for (DadosAula dadosAula1 : lista) {
									model.addRow (new Object[] {
											dadosAula1.getCurso(),
											dadosAula1.getDisciplina(),
											dadosAula1.getTurma(),
											dadosAula1.getPeriodo(),
											dadosAula1.getSemestreLetivo(),
											dadosAula1.getDataAula(),
											dadosAula1.isTeveAula() == false ? "Não" : "Sim",
											dadosAula1.getJustificativa(),
											dadosAula1.getHorarioInicio(),
											dadosAula1.getHorarioTermino(),
											dadosAula1.getAssunto(),
											dadosAula1.getQtdAlunos(),
											dadosAula1.getMateriaisDisponibilizados(),
											dadosAula1.getLinkSessao(),
											dadosAula1.getLinkGravacao(),
											dadosAula1.getObs(),
											dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
											dadosAula1.getDataEntrega(),
											dadosAula1.getQtdPessoas(),
											dadosAula1.getDescricao(),
											dadosAula1.getIdAula(),
										});
									} 
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								cmbCurso.setSelectedIndex(0);
								cmbDisciplina.setSelectedIndex(0);
								cmbTurma.setSelectedIndex(0);
								cmbPeriodo.setSelectedIndex(0);
								cmbSemestreLetivo.setSelectedIndex(0);
								cmbData.setSelectedIndex(0);
								dteDataAula.setDate(null);
								dteDataAula2.setDate(null);
								btnSimAula.setSelected(false);
								btnNaoAula.setSelected(false);
								cmbAlunos.setSelectedIndex(0);
								txtQtdAluno.setText(null);
								btnSimAtividade.setSelected(false);
								btnNaoAtividade.setSelected(false);
							}
							else {
								Object[] options1 = {"OK"};
								ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							}
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao buscar ID do professor!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Periodo")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = cmbPeriodo.getSelectedItem().toString();
						String semestreLetivo = "%%";
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (periodo.equals(dadosAula.getPeriodo())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Semestre")) {
						String nomeCurso = "%%";
						String disciplina = "%%";
						String turmaCod = "%%";
						String nomeProfessor = "%%";
						int idProfessor = 0;
						String periodo = "%%";
						String semestreLetivo = cmbSemestreLetivo.getSelectedItem().toString();
						String data = "%%";
						String dataAula1 = "%%";
						
						dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
						if (semestreLetivo.equals(dadosAula.getSemestreLetivo())) {
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
									});
								} 
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao consultar aula!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Data")) {
						if (cmbData.getSelectedItem().toString().equals("Especifica")) {
							String nomeCurso = "%%";
							String disciplina = "%%";
							String turmaCod = "%%";
							String nomeProfessor = "%%";
							int idProfessor = 0;
							String periodo = "%%";
							String semestreLetivo = "%%";
							String data = "%%";
							data1 = formatarData.format(dteDataAula.getDate());
							data1.toString();
							String dataAula1 = data1;
							
							dadosAula = dadosAulaDao.Consultar3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
							if (dataAula1.equals(dadosAula.getDataAula())) {
								
								List<DadosAula> lista = new ArrayList<DadosAula>();
								lista = dadosAulaDao.ListarTodos3(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, dataAula1);
								DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
								model.setNumRows(0);
								for (DadosAula dadosAula1 : lista) {
									model.addRow (new Object[] {
											dadosAula1.getCurso(),
											dadosAula1.getDisciplina(),
											dadosAula1.getTurma(),
											dadosAula1.getPeriodo(),
											dadosAula1.getSemestreLetivo(),
											dadosAula1.getDataAula(),
											dadosAula1.isTeveAula() == false ? "Não" : "Sim",
											dadosAula1.getJustificativa(),
											dadosAula1.getHorarioInicio(),
											dadosAula1.getHorarioTermino(),
											dadosAula1.getAssunto(),
											dadosAula1.getQtdAlunos(),
											dadosAula1.getMateriaisDisponibilizados(),
											dadosAula1.getLinkSessao(),
											dadosAula1.getLinkGravacao(),
											dadosAula1.getObs(),
											dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
											dadosAula1.getDataEntrega(),
											dadosAula1.getQtdPessoas(),
											dadosAula1.getDescricao(),
											dadosAula1.getIdAula(),
									});
								} 
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								cmbCurso.setSelectedIndex(0);
								cmbDisciplina.setSelectedIndex(0);
								cmbTurma.setSelectedIndex(0);
								cmbProfessor.setSelectedIndex(0);
								cmbPeriodo.setSelectedIndex(0);
								cmbSemestreLetivo.setSelectedIndex(0);
								dteDataAula2.setDate(null);
								btnSimAula.setSelected(false);
								btnNaoAula.setSelected(false);
								cmbAlunos.setSelectedIndex(0);
								txtQtdAluno.setText(null);
								btnSimAtividade.setSelected(false);
								btnNaoAtividade.setSelected(false);
							}
						}
						else if (cmbData.getSelectedItem().toString().equals("Intervalo")) {
							data1 = formatarData.format(dteDataAula.getDate());
							//data1.toString();
							data2 = formatarData.format(dteDataAula2.getDate());
							//data2.toString();
							JOptionPane.showMessageDialog(null, dteDataAula2.getDate() + " | " + dteDataAula.getDate() + " | " + data1 + " | " + data2);
							String dataAula1 = data1;
							String dataAula2 = data2;
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos3(data1, data2);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
					}
					else if (opcao.equals("Aula Realizada")) {
						if (btnSimAula.isSelected()) {
							boolean teveAula = true;
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos4(teveAula);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else if (btnNaoAula.isSelected()) {
							boolean teveAula = false;
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos4(teveAula);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Escolha se teve aula ou não", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Atividade Solicitada")) {
						if (btnSimAtividade.isSelected()) {
							boolean atividadeSolicitada = true;
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos5(atividadeSolicitada);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnNaoAtividade.setSelected(false);
						}
						else if (btnNaoAtividade.isSelected()) {
							boolean atividadeSolicitada = false;
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos5(atividadeSolicitada);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							cmbAlunos.setSelectedIndex(0);
							txtQtdAluno.setText(null);
							btnSimAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Escolha se foi solicitada atividade ou não", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Quantidade de Alunos")) {
						int qtdAlunos = Integer.parseInt(txtQtdAluno.getText());
						if (cmbAlunos.getSelectedItem().toString().equals("Igual a")) {
							String parametro = "Igual a";
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos6(parametro, qtdAlunos);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else if (cmbAlunos.getSelectedItem().toString().equals("Maior que")) {
							String parametro = "Maior que";
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos6(parametro, qtdAlunos);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else if (cmbAlunos.getSelectedItem().toString().equals("Menor que")) {
							String parametro = "Menor que";
							
							List<DadosAula> lista = new ArrayList<DadosAula>();
							lista = dadosAulaDao.ListarTodos6(parametro, qtdAlunos);
							DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
							model.setNumRows(0);
							for (DadosAula dadosAula1 : lista) {
								model.addRow (new Object[] {
										dadosAula1.getCurso(),
										dadosAula1.getDisciplina(),
										dadosAula1.getTurma(),
										dadosAula1.getPeriodo(),
										dadosAula1.getSemestreLetivo(),
										dadosAula1.getDataAula(),
										dadosAula1.isTeveAula() == false ? "Não" : "Sim",
										dadosAula1.getJustificativa(),
										dadosAula1.getHorarioInicio(),
										dadosAula1.getHorarioTermino(),
										dadosAula1.getAssunto(),
										dadosAula1.getQtdAlunos(),
										dadosAula1.getMateriaisDisponibilizados(),
										dadosAula1.getLinkSessao(),
										dadosAula1.getLinkGravacao(),
										dadosAula1.getObs(),
										dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
										dadosAula1.getDataEntrega(),
										dadosAula1.getQtdPessoas(),
										dadosAula1.getDescricao(),
										dadosAula1.getIdAula(),
								});
							}
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							cmbCurso.setSelectedIndex(0);
							cmbDisciplina.setSelectedIndex(0);
							cmbTurma.setSelectedIndex(0);
							cmbProfessor.setSelectedIndex(0);
							cmbPeriodo.setSelectedIndex(0);
							cmbSemestreLetivo.setSelectedIndex(0);
							cmbData.setSelectedIndex(0);
							dteDataAula.setDate(null);
							dteDataAula2.setDate(null);
							btnSimAula.setSelected(false);
							btnNaoAula.setSelected(false);
							btnSimAtividade.setSelected(false);
							btnNaoAtividade.setSelected(false);
						}
						else {
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Digite a quantidade de alunos e selecione um dos parâmetros: igual a, maior que, menor que!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
						}
					}
					else if (opcao.equals("Listar Todas as Aulas")) {
						List<DadosAula> lista = new ArrayList<DadosAula>();
						lista = dadosAulaDao.ListarTodos();
						DefaultTableModel model = (DefaultTableModel) tabDadosAulas.getModel();
						model.setNumRows(0);
						for (DadosAula dadosAula1 : lista) {
							model.addRow (new Object[] {
									dadosAula1.getCurso(),
									dadosAula1.getDisciplina(),
									dadosAula1.getTurma(),
									dadosAula1.getPeriodo(),
									dadosAula1.getSemestreLetivo(),
									dadosAula1.getDataAula(),
									dadosAula1.isTeveAula() == false ? "Não" : "Sim",
									dadosAula1.getJustificativa(),
									dadosAula1.getHorarioInicio(),
									dadosAula1.getHorarioTermino(),
									dadosAula1.getAssunto(),
									dadosAula1.getQtdAlunos(),
									dadosAula1.getMateriaisDisponibilizados(),
									dadosAula1.getLinkSessao(),
									dadosAula1.getLinkGravacao(),
									dadosAula1.getObs(),
									dadosAula1.isAtividadeSolicitada() == false ? "Não" : "Sim",
									dadosAula1.getDataEntrega(),
									dadosAula1.getQtdPessoas(),
									dadosAula1.getDescricao(),
									dadosAula1.getIdAula(),
								});
							} 
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						cmbCurso.setSelectedIndex(0);
						cmbDisciplina.setSelectedIndex(0);
						cmbTurma.setSelectedIndex(0);
						cmbProfessor.setSelectedIndex(0);
						cmbPeriodo.setSelectedIndex(0);
						cmbSemestreLetivo.setSelectedIndex(0);
						cmbData.setSelectedIndex(0);
						dteDataAula.setDate(null);
						dteDataAula2.setDate(null);
						btnSimAula.setSelected(false);
						btnNaoAula.setSelected(false);
						cmbAlunos.setSelectedIndex(0);
						txtQtdAluno.setText(null);
						btnSimAtividade.setSelected(false);
						btnNaoAtividade.setSelected(false);
					}
					else {
						Object[] options1 = {"OK"};
						ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Escolha uma opção valida!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar!!."
							+ "\n\n Verifique os dados preenchidos e tente novamente"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(219, 497, 60, 43);
		contentPane.add(btnConsultar);
		
		btnGrafico = new JButton("");
		btnGrafico.setToolTipText("Gr\u00E1fico");
		btnGrafico.setIcon(new ImageIcon(Tela_DadosAulas.class.getResource("/br/com/exemplo/view/images/positive-dynamic--v1.png")));
		btnGrafico.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrafico.setBounds(405, 497, 60, 43);
		contentPane.add(btnGrafico);
	}
}
