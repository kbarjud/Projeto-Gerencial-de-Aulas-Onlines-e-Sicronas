package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;

import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.DadosAulaDAO;
import br.com.exemplo.dao.ProfessoresDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.DadosAula;
import br.com.exemplo.model.Professores;
import br.com.exemplo.model.Turma;

import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Tela_CadastroAulaProfessor extends JFrame {

	private JPanel contentPane;
	private JLabel lblTeveAula;
	private JRadioButton btnNaoAula;
	private JTabbedPane tabbedPane;
	private JPanel curso;
	private JLabel lblPeriodo;
	private JLabel lblTurma;
	private JPanel dados;
	private JLabel lblSemestre;
	private JComboBox cmbSemestreLetivo;
	private JLabel lblConteudoMinistrado;
	private JTextField txtAssunto;
	private JLabel lblMateriaisDisponibilizados;
	private JTextField txtMateriaisDisponibilizados;
	private JLabel lblLinkSesso;
	private JTextField txtLinkSessao;
	private JTextField txtLinkGravacao;
	private JLabel lblLinkSessoE;
	private JLabel lblQuantidadeDeAlunos;
	private JTextField txtQtdAluno;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JSeparator separator;
	private JComboBox cmbPeriodo;
	private JPanel atividade;
	private JLabel lblAtividadesSolicitadas_1;
	private JRadioButton btnSimAtividade;
	private JRadioButton btnNaoAtividade;
	private JLabel lblDataDeEntrega_1;
	private JDateChooser dteDataEntregaAtividade;
	private JLabel lblDescrio;
	private JLabel lblObs;
	private JLabel lblCurso_1;
	private JComboBox cmbCurso;
	private JLabel lblDisciplina_1;
	private JComboBox cmbDisciplina;
	private JLabel lblDataDaAula_1;
	private JDateChooser dteDataAula;
	private JRadioButton btnGrupo;
	private JRadioButton btnIndividual;
	private JLabel lblJustificativa;
	private JTextArea txtJustificativa;
	private JComboBox cmbTurma;
	private JLabel lblInicio;
	private JLabel lblTermino;
	private JComboBox cmbHorarioInicio;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSair;
	private JButton btnSalvar;
	private JButton btnSalvar2;
	private JButton btnAvancar;
	private JButton btnAvancar2;
	private JComboBox cmbHorarioTermino;
	private JRadioButton btnSimAula;
	private JTextArea txtObs;
	private JTextArea txtDescricao;
	JTextField txtCodProfessor;
	JTextField txtSenhaProf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroAulaProfessor frame = new Tela_CadastroAulaProfessor();
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
	public Tela_CadastroAulaProfessor() {
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 459);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Cadastro");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=======================================================================Cadastro======================================================================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Dados Referente ao Curso"
						+ "\n 2. Se Caso Não Tenha Tido Aula, Será Necessario Preencher Somente a aba de Cursos, Disciplina e Turma"
						+ "\n 3. Caso a Aula Tenha Ocorrido, Será Necessario Preencher a aba dos Dados da Aula e Atividades Também"
						+ "\n======================================================================================================================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
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
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 469, 321);
		contentPane.add(tabbedPane);
		
		curso = new JPanel();
		tabbedPane.addTab("Curso, Disciplina e Turma", null, curso, null);
		curso.setFont(new Font("Arial", Font.PLAIN, 14));
		curso.setLayout(null);
		
		lblTeveAula = new JLabel("Teve Aula?");
		lblTeveAula.setBounds(116, 135, 80, 30);
		curso.add(lblTeveAula);
		lblTeveAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeveAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		btnSimAula = new JRadioButton("Sim");
		btnSimAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnSimAula.isSelected()) {
					btnNaoAula.setSelected(false);
					txtJustificativa.setText(null);
					lblJustificativa.setVisible(false);
					txtJustificativa.setVisible(false);
					btnSalvar.setVisible(false);
					cmbHorarioInicio.setEnabled(true);
					cmbHorarioTermino.setEnabled(true);
					txtAssunto.setEnabled(true);
					txtQtdAluno.setEnabled(true);
					txtMateriaisDisponibilizados.setEnabled(true);
					txtLinkSessao.setEnabled(true);
					txtLinkGravacao.setEnabled(true);
					txtObs.setEnabled(true);
					btnSimAtividade.setEnabled(true);
					btnNaoAtividade.setEnabled(true);
					dteDataEntregaAtividade.setEnabled(true);
					btnGrupo.setEnabled(true);
					btnIndividual.setEnabled(true);
					txtDescricao.setEnabled(true);
					btnSalvar2.setEnabled(true);
				}
			}
		});
		btnSimAula.setBounds(202, 136, 54, 30);
		curso.add(btnSimAula);
		btnSimAula.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnNaoAula = new JRadioButton("N\u00E3o");
		btnNaoAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnNaoAula.isSelected()) {
					btnSimAula.setSelected(false);
					lblJustificativa.setVisible(true);
					txtJustificativa.setVisible(true);
					btnSalvar.setVisible(true);
					cmbHorarioInicio.setEnabled(false);
					cmbHorarioTermino.setEnabled(false);
					txtAssunto.setEnabled(false);
					txtQtdAluno.setEnabled(false);
					txtMateriaisDisponibilizados.setEnabled(false);
					txtLinkSessao.setEnabled(false);
					txtLinkGravacao.setEnabled(false);
					txtObs.setEnabled(false);
					btnSimAtividade.setEnabled(false);
					btnNaoAtividade.setEnabled(false);
					dteDataEntregaAtividade.setEnabled(false);
					btnGrupo.setEnabled(false);
					btnIndividual.setEnabled(false);
					txtDescricao.setEnabled(false);
					btnSalvar2.setEnabled(false);
				}
			}
		});
		btnNaoAula.setBounds(258, 136, 54, 30);
		curso.add(btnNaoAula);
		btnNaoAula.setFont(new Font("Arial", Font.PLAIN, 14));
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setForeground(Color.BLACK);
		cmbDisciplina.setBounds(267, 13, 187, 21);
		curso.add(cmbDisciplina);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setBounds(198, 12, 67, 21);
		curso.add(lblDisciplina_1);
		lblDisciplina_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		cmbCurso = new JComboBox();
		cmbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					
					List<Curso> lista1 = new ArrayList<Curso>();
					CursoDAO cursoDao1 = new CursoDAO();
					lista1 = cursoDao1.ListarTodos3(nomeCurso);
					DefaultComboBoxModel model1 = new DefaultComboBoxModel(lista1.toArray());
					cmbDisciplina.setModel(model1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cmbCurso.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos2();
					DefaultComboBoxModel model = new DefaultComboBoxModel(lista.toArray());
					cmbCurso.setModel(model);

					String nomeCurso = cmbCurso.getSelectedItem().toString();
					
					List<Curso> lista1 = new ArrayList<Curso>();
					CursoDAO cursoDao1 = new CursoDAO();
					lista1 = cursoDao1.ListarTodos3(nomeCurso);
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
		cmbCurso.setForeground(Color.BLACK);
		cmbCurso.setBounds(56, 13, 135, 21);
		curso.add(cmbCurso);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setBounds(10, 11, 36, 21);
		curso.add(lblCurso_1);
		lblCurso_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		lblTurma = new JLabel("Turma");
		lblTurma.setBounds(68, 58, 48, 21);
		curso.add(lblTurma);
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(232, 58, 48, 21);
		curso.add(lblPeriodo);
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					List<Turma> lista3 = new ArrayList<Turma>();
					TurmaDAO turmaDao2 = new TurmaDAO();
					lista3 = turmaDao2.ListarTodos3();
					DefaultComboBoxModel model3 = new DefaultComboBoxModel(lista3.toArray());
					cmbSemestreLetivo.setModel(model3);
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
		cmbPeriodo.setForeground(Color.BLACK);
		cmbPeriodo.setBounds(290, 60, 95, 21);
		curso.add(cmbPeriodo);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblSemestre = new JLabel("Semestre Letivo");
		lblSemestre.setBounds(10, 103, 119, 21);
		curso.add(lblSemestre);
		lblSemestre.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					List<Turma> lista4 = new ArrayList<Turma>();
					TurmaDAO turmaDao3 = new TurmaDAO();
					lista4 = turmaDao3.ListarTodos4();
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
		cmbSemestreLetivo.setForeground(Color.BLACK);
		cmbSemestreLetivo.setBounds(139, 104, 105, 21);
		curso.add(cmbSemestreLetivo);
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblDataDaAula_1 = new JLabel("Data da Aula");
		lblDataDaAula_1.setBounds(254, 103, 88, 21);
		curso.add(lblDataDaAula_1);
		lblDataDaAula_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDaAula_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		dteDataAula = new JDateChooser();
		dteDataAula.setBounds(346, 104, 108, 20);
		curso.add(dteDataAula);
		
		lblJustificativa = new JLabel("Justificativa");
		lblJustificativa.setVisible(false);
		lblJustificativa.setHorizontalAlignment(SwingConstants.CENTER);
		lblJustificativa.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblJustificativa.setBounds(10, 187, 95, 21);
		curso.add(lblJustificativa);
		
		txtJustificativa = new JTextArea();
		txtJustificativa.setVisible(false);
		txtJustificativa.setFont(new Font("Arial", Font.PLAIN, 14));
		txtJustificativa.setBounds(128, 177, 326, 43);
		curso.add(txtJustificativa);
		
		cmbTurma = new JComboBox();
		cmbTurma.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2();
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
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
		cmbTurma.setForeground(Color.BLACK);
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(128, 60, 94, 21);
		curso.add(cmbTurma);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					SimpleDateFormat formatarData = new SimpleDateFormat("EEE dd/MM/yyyy");
					String data;
					data = formatarData.format(dteDataAula.getDate());
					data.toString();
					
					DadosAula dadosAula = new DadosAula();
					dadosAula.setCurso(cmbCurso.getSelectedItem().toString());
					dadosAula.setDisciplina(cmbDisciplina.getSelectedItem().toString());
					dadosAula.setTurma(cmbTurma.getSelectedItem().toString());
					dadosAula.setPeriodo(cmbPeriodo.getSelectedItem().toString());
					dadosAula.setSemestreLetivo(cmbSemestreLetivo.getSelectedItem().toString());
					dadosAula.setDataAula(data);
					dadosAula.setTeveAula(false);
					dadosAula.setJustificativa(txtJustificativa.getText());
					
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String disciplina = cmbDisciplina.getSelectedItem().toString();
					
					CursoDAO cursoDao = new CursoDAO();
					Curso curso = new Curso();
					curso = cursoDao.Consultar1(nomeCurso, disciplina);
					 
					if (nomeCurso.equals(curso.getNomeCurso()) && disciplina.equals(curso.getDisciplina())) {
						int idCursoDisciplina = curso.getIdCursoDisciplina();
						dadosAula.setIdCursoDisciplina(idCursoDisciplina);	
						
						int codProf = Integer.parseInt(txtCodProfessor.getText());
						String senha = txtSenhaProf.getText();
						
						ProfessoresDAO professoresDao = new ProfessoresDAO();
						Professores professores = new Professores();
						professores = professoresDao.Login(codProf, senha);
						 
						if (codProf == professores.getCodProfessor() && senha.equals(professores.getSenha())) {
							int idProfessor = professores.getIdProfessor();
							dadosAula.setIdProfessor(idProfessor);
							
							String turmaCod = cmbTurma.getSelectedItem().toString();
							String periodo = cmbPeriodo.getSelectedItem().toString();
							String semestreLetivo = cmbSemestreLetivo.getSelectedItem().toString();
							String status = "Ativo";
							
							TurmaDAO turmaDao = new TurmaDAO();
							Turma turma = new Turma();
							turma = turmaDao.Consultar1(nomeCurso, disciplina, turmaCod, periodo, semestreLetivo, status);
							
							if (nomeCurso.equals(turma.getNomeCurso()) && disciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
								int idTurma = turma.getIdTurma();
								dadosAula.setIdTurma(idTurma);
							
								String resposta = JOptionPane.showInputDialog(null, "============Confira os Dados da Aula============"
										+ "\nCurso: " + cmbCurso.getSelectedItem().toString()
										+ "\nDisciplina: " + cmbDisciplina.getSelectedItem().toString() 
										+ "\nTurma: " + cmbTurma.getSelectedItem().toString()
										+ "\nPeriodo: " + cmbPeriodo.getSelectedItem().toString()
										+ "\nSemestre Letivo: " + cmbSemestreLetivo.getSelectedItem().toString()
										+ "\nData da Aula: " + data
										+ "\nTeve Aula?: Não"
										+ "\nJustificativa: " + txtJustificativa.getText()
										+ "\n====================================================="
										+ "\n\n====================================================="
										+ "\nDigite 1 Para Salvar"
										+ "\nDigite 2 Para Alterar Alguma Informação"
										+ "\n=====================================================");
									
								int decisao = Integer.parseInt(resposta);
								if (decisao == 1) {
									DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
									dadosAulaDao.Salvar1(dadosAula);
										
									JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
								}
								else if (decisao == 2) {
									JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
								}
								else {
									JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
								}
							}
							else {
								JOptionPane.showMessageDialog (null, "Verifique o Curso, a Disciplina, a Turma, o Periodo e o Semestre Letivo, Pois Não Existe Nenhuma Turma Cadastrada Com Essas Informações");
							}
						}
						else {
							JOptionPane.showMessageDialog (null, "Erro ao Pegar o ID do Professor");
						}
					}
					else {
						JOptionPane.showMessageDialog (null, "Verifique o Curso e a Disciplina e veja se essa Disciplina pertence mesmo a esse Curso.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Fazer o Cadastro da Aula!!. "
							+ "\n1. Verifique se Todos os Campos Foram Preenchidos"
							+ "\n2. Caso Todos Estejam Preenchidos. Verifique se Foram Preenchidos Corretamente"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnSalvar.setVisible(false);
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/salvar2.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(196, 233, 60, 43);
		curso.add(btnSalvar);
		
		btnAvancar = new JButton("");
		btnAvancar.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/avan\u00E7ar.png")));
		btnAvancar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAvancar.setBounds(394, 239, 60, 43);
		curso.add(btnAvancar);
		
		txtCodProfessor = new JTextField();
		txtCodProfessor.setVisible(false);
		txtCodProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodProfessor.setColumns(10);
		txtCodProfessor.setBounds(10, 231, 157, 20);
		curso.add(txtCodProfessor);
		
		txtSenhaProf = new JTextField();
		txtSenhaProf.setVisible(false);
		txtSenhaProf.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSenhaProf.setColumns(10);
		txtSenhaProf.setBounds(10, 262, 157, 20);
		curso.add(txtSenhaProf);
		
		dados = new JPanel();
		tabbedPane.addTab("Dados da Aula", null, dados, null);
		dados.setLayout(null);
		
		lblConteudoMinistrado = new JLabel("Assunto");
		lblConteudoMinistrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblConteudoMinistrado.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblConteudoMinistrado.setBounds(10, 40, 56, 21);
		dados.add(lblConteudoMinistrado);
		
		txtAssunto = new JTextField();
		txtAssunto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAssunto.setColumns(10);
		txtAssunto.setBounds(76, 39, 157, 20);
		dados.add(txtAssunto);
		
		lblMateriaisDisponibilizados = new JLabel("Materiais Disponibilizados");
		lblMateriaisDisponibilizados.setHorizontalAlignment(SwingConstants.LEFT);
		lblMateriaisDisponibilizados.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMateriaisDisponibilizados.setBounds(10, 70, 175, 21);
		dados.add(lblMateriaisDisponibilizados);
		
		txtMateriaisDisponibilizados = new JTextField();
		txtMateriaisDisponibilizados.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMateriaisDisponibilizados.setColumns(10);
		txtMateriaisDisponibilizados.setBounds(195, 72, 259, 20);
		dados.add(txtMateriaisDisponibilizados);
		
		lblLinkSesso = new JLabel("Link Sess\u00E3o");
		lblLinkSesso.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinkSesso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLinkSesso.setBounds(10, 103, 82, 21);
		dados.add(lblLinkSesso);
		
		txtLinkSessao = new JTextField();
		txtLinkSessao.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLinkSessao.setColumns(10);
		txtLinkSessao.setBounds(102, 105, 352, 20);
		dados.add(txtLinkSessao);
		
		txtLinkGravacao = new JTextField();
		txtLinkGravacao.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLinkGravacao.setColumns(10);
		txtLinkGravacao.setBounds(158, 137, 296, 20);
		dados.add(txtLinkGravacao);
		
		lblLinkSessoE = new JLabel("Link da Aula Gravada");
		lblLinkSessoE.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinkSessoE.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLinkSessoE.setBounds(10, 135, 157, 21);
		dados.add(lblLinkSessoE);
		
		lblQuantidadeDeAlunos = new JLabel("Qtd. Alunos");
		lblQuantidadeDeAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantidadeDeAlunos.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblQuantidadeDeAlunos.setBounds(282, 40, 93, 21);
		dados.add(lblQuantidadeDeAlunos);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setColumns(10);
		txtQtdAluno.setBounds(385, 41, 36, 20);
		dados.add(txtQtdAluno);
		
		lblObs = new JLabel("OBS");
		lblObs.setHorizontalAlignment(SwingConstants.LEFT);
		lblObs.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblObs.setBounds(10, 178, 36, 21);
		dados.add(lblObs);
		
		lblInicio = new JLabel("Hor\u00E1rio de In\u00EDcio");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblInicio.setBounds(10, 8, 118, 21);
		dados.add(lblInicio);
		
		lblTermino = new JLabel("Hor\u00E1rio de T\u00E9rmino");
		lblTermino.setHorizontalAlignment(SwingConstants.LEFT);
		lblTermino.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTermino.setBounds(240, 7, 135, 21);
		dados.add(lblTermino);
		
		cmbHorarioInicio = new JComboBox();
		cmbHorarioInicio.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbHorarioInicio.setModel(new DefaultComboBoxModel(new String[] {"", "08:30", "09:55", "14:00", "15:25", "19:10", "20:35"}));
		cmbHorarioInicio.setBounds(138, 10, 69, 20);
		dados.add(cmbHorarioInicio);
		
		btnAvancar2 = new JButton("");
		btnAvancar2.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/avan\u00E7ar.png")));
		btnAvancar2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAvancar2.setBounds(394, 239, 60, 43);
		dados.add(btnAvancar2);
		
		cmbHorarioTermino = new JComboBox();
		cmbHorarioTermino.setModel(new DefaultComboBoxModel(new String[] {"", "09:45", "11:10", "15:15", "16:40", "20:25", "21:50"}));
		cmbHorarioTermino.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbHorarioTermino.setBounds(385, 8, 69, 20);
		dados.add(cmbHorarioTermino);
		
		txtObs = new JTextArea();
		txtObs.setBounds(56, 167, 398, 49);
		dados.add(txtObs);
		
		atividade = new JPanel();
		tabbedPane.addTab("Atividades", null, atividade, null);
		atividade.setLayout(null);
		
		lblAtividadesSolicitadas_1 = new JLabel("Atividades Solicitadas Durante a Aula?");
		lblAtividadesSolicitadas_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtividadesSolicitadas_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAtividadesSolicitadas_1.setBounds(23, 11, 269, 21);
		atividade.add(lblAtividadesSolicitadas_1);
		
		btnSimAtividade = new JRadioButton("Sim");
		btnSimAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSimAtividade.isSelected()) {
					btnNaoAtividade.setSelected(false);
					dteDataEntregaAtividade.setEnabled(true);
					btnGrupo.setEnabled(true);
					btnIndividual.setEnabled(true);
					txtDescricao.setEnabled(true);
				}
			}
		});
		btnSimAtividade.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSimAtividade.setBounds(298, 7, 69, 30);
		atividade.add(btnSimAtividade);
		
		btnNaoAtividade = new JRadioButton("N\u00E3o");
		btnNaoAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNaoAtividade.isSelected()) {
					btnSimAtividade.setSelected(false);
					dteDataEntregaAtividade.setDate(null);
					btnGrupo.setSelected(false);
					btnIndividual.setSelected(false);
					txtDescricao.setText(null);
					dteDataEntregaAtividade.setEnabled(false);
					btnGrupo.setEnabled(false);
					btnIndividual.setEnabled(false);
					txtDescricao.setEnabled(false);
				}
			}
		});
		btnNaoAtividade.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNaoAtividade.setBounds(369, 8, 69, 30);
		atividade.add(btnNaoAtividade);
		
		lblDataDeEntrega_1 = new JLabel("Data de Entrega");
		lblDataDeEntrega_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeEntrega_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataDeEntrega_1.setBounds(11, 59, 120, 21);
		atividade.add(lblDataDeEntrega_1);
		
		dteDataEntregaAtividade = new JDateChooser();
		dteDataEntregaAtividade.setEnabled(false);
		dteDataEntregaAtividade.setBounds(131, 60, 108, 20);
		atividade.add(dteDataEntregaAtividade);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o ");
		lblDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 123, 69, 21);
		atividade.add(lblDescrio);
		
		btnGrupo = new JRadioButton("Grupo");
		btnGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnGrupo.isSelected()) {
					btnIndividual.setSelected(false);
				}
			}
		});
		btnGrupo.setEnabled(false);
		btnGrupo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrupo.setBounds(289, 55, 69, 30);
		atividade.add(btnGrupo);
		
		btnIndividual = new JRadioButton("Individual");
		btnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnIndividual.isSelected()) {
					btnGrupo.setSelected(false);
				}
			}
		});
		btnIndividual.setEnabled(false);
		btnIndividual.setFont(new Font("Arial", Font.PLAIN, 14));
		btnIndividual.setBounds(360, 55, 85, 30);
		atividade.add(btnIndividual);
		
		btnSalvar2 = new JButton("");
		btnSalvar2.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/salvar2.png")));
		btnSalvar2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar2.setBounds(201, 208, 60, 43);
		atividade.add(btnSalvar2);
		
		txtDescricao = new JTextArea();
		txtDescricao.setEnabled(false);
		txtDescricao.setBounds(89, 109, 365, 54);
		atividade.add(txtDescricao);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(352, 343, 60, 43);
		contentPane.add(btnSair);
		btnSair.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/sair.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnAlterar = new JButton("");
		btnAlterar.setBounds(280, 343, 60, 43);
		contentPane.add(btnAlterar);
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/atualizar.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnConsultar = new JButton("");
		btnConsultar.setBounds(210, 343, 60, 43);
		contentPane.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/consultar2.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando!!");
				Tela_CadastroAulaProfessor telaCadastroAula = new Tela_CadastroAulaProfessor();
				telaCadastroAula.setVisible(false);
				dispose();
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(true);
			}
		});
		btnVoltar.setBounds(140, 343, 60, 43);
		contentPane.add(btnVoltar);
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCurso.setSelectedIndex(0);
				cmbDisciplina.setSelectedIndex(0);
				cmbTurma.setSelectedIndex(0);
				cmbPeriodo.setSelectedIndex(0);
				cmbSemestreLetivo.setSelectedIndex(0);
				dteDataAula.setDate(null);
				btnSimAula.setSelected(false);
				btnNaoAula.setSelected(false);
				txtJustificativa.setText(null);
				cmbHorarioInicio.setSelectedIndex(0);
				cmbHorarioTermino.setSelectedIndex(0);
				txtAssunto.setText(null);
				txtQtdAluno.setText(null);
				txtMateriaisDisponibilizados.setText(null);
				txtLinkSessao.setText(null);
				txtLinkGravacao.setText(null);
				txtObs.setText(null);
				btnSimAtividade.setSelected(false);
				btnNaoAtividade.setSelected(false);
				dteDataEntregaAtividade.setDate(null);
				btnGrupo.setSelected(false);
				btnIndividual.setSelected(false);
				txtDescricao.setText(null);
				lblJustificativa.setVisible(false);
				txtJustificativa.setVisible(false);
				btnSalvar.setVisible(false);
			}
		});
		btnNovo.setBounds(70, 343, 60, 43);
		contentPane.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(Tela_CadastroAulaProfessor.class.getResource("/br/com/exemplo/view/images/novo.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
	}
}
