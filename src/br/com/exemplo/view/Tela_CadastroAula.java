package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Tela_CadastroAula extends JFrame {

	private JPanel panel;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSair;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JPanel contentPane;
	private JTabbedPane tabCurso;
	private JTabbedPane tabDados;
	private JTabbedPane tabAtividade;
	private JPanel curso;
	private JPanel dados;
	private JPanel atividade;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblDisciplina;
	private JComboBox cmbDisciplina;
	private JLabel lblTurma;
	private JComboBox cmbTurma;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JLabel lblSemestre;
	private JComboBox cmbSemestreLetivo;
	private JLabel lblDataDaAula;
	private JDateChooser dteDataAula;
	private JLabel lblTeveAula;
	private JRadioButton btnSimAula;
	private JRadioButton btnNaoAula;
	private JLabel lblJustificativa;
	private JTextArea txtJustificativa;
	private JButton btnConsultar_1;
	private JButton btnSalvar;
	JTextField txtSenhaProf;
	JTextField txtCodProfessor;
	private JLabel lblInicio;
	private JComboBox cmbHorarioInicio;
	private JLabel lblTermino;
	private JComboBox cmbHorarioTermino;
	private JTextField txtAssunto;
	private JLabel lblConteudoMinistrado;
	private JLabel lblQuantidadeDeAlunos;
	private JTextField txtQtdAluno;
	private JLabel lblMateriaisDisponibilizados;
	private JTextField txtMateriaisDisponibilizados;
	private JLabel lblLinkSesso;
	private JTextField txtLinkSessao;
	private JLabel lblLinkSessoE;
	private JTextField txtLinkGravacao;
	private JLabel lblObs;
	private JButton btnVoltar2;
	private JButton btnAvancar2;
	private JTextArea txtObs;
	private JLabel lblAtividadesSolicitadas;
	private JRadioButton btnSimAtividade;
	private JRadioButton btnNaoAtividade;
	private JLabel lblDataDeEntrega;
	private JDateChooser dteDataAtividade;
	private JRadioButton btnGrupo;
	private JRadioButton btnIndividual;
	private JLabel lblDescrio;
	private JTextArea txtDescricao;
	private JButton btnSalvar2;
	private JButton btnVoltar3;
	private JTextField txtQtdPessoas;
	private JTextField txtDataAula;
	private JTextField txtDataAtividade;
	private JTextField txtIdAula;
	private JScrollPane scrJustificativa;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroAula frame = new Tela_CadastroAula();
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
	public Tela_CadastroAula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 472);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_2 = new JMenuItem("Cadastro");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "=========================================Cadastro========================================="
						+ "\n Nesta Área Você Poderá: "
						+ "\n 1. Cadastrar os Dados Referente ao Curso"
						+ "\n 2. Se Caso Não Tenha Tido Aula, Será Necessario Preencher Somente a aba de Cursos, Disciplina e Turma"
						+ "\n 3. Caso a Aula Tenha Ocorrido, Será Necessario Preencher a aba dos Dados da Aula e Atividades Também"
						+ "\n==========================================================================================");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(panel);
		panel.setLayout(null);
		
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
				dteDataAtividade.setDate(null);
				btnGrupo.setSelected(false);
				btnIndividual.setSelected(false);
				txtDescricao.setText(null);
				lblJustificativa.setVisible(false);
				txtJustificativa.setVisible(false);
				btnSalvar.setVisible(false);
				dteDataAula.setVisible(true);
				txtDataAula.setVisible(false);
				dteDataAtividade.setVisible(true);
				txtDataAtividade.setVisible(false);
				scrJustificativa.setVisible(false);
			}
		});
		btnNovo.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setToolTipText("Bot\u00E3o Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(122, 346, 60, 43);
		panel.add(btnNovo);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando!!");
				Tela_CadastroAula telaCadastroAula = new Tela_CadastroAula();
				telaCadastroAula.setVisible(false);
				dispose();
				Tela_InicialProfessor telaInicialProfessor = new Tela_InicialProfessor();
				telaInicialProfessor.setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(31, 346, 60, 43);
		panel.add(btnVoltar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
					dteDataAtividade.setDate(null);
					btnGrupo.setSelected(false);
					btnIndividual.setSelected(false);
					txtDescricao.setText(null);
					lblJustificativa.setVisible(false);
					txtJustificativa.setVisible(false);
					btnSalvar.setVisible(false);
					btnSalvar2.setVisible(false);
					
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
					String turma = cmbTurma.getSelectedItem().toString();
					String periodo = cmbPeriodo.getSelectedItem().toString();
					String semestreLetivo = cmbSemestreLetivo.getSelectedItem().toString();
					
					SimpleDateFormat formatarData = new SimpleDateFormat("EEE dd/MM/yyyy");
					String data;
					data = formatarData.format(dteDataAula.getDate());
					data.toString();
					
					DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
					DadosAula dadosAula = new DadosAula();
					dadosAula = dadosAulaDao.Consultar(nomeCurso, nomeDisciplina, turma, periodo, semestreLetivo, data);
					
					if (nomeCurso.equals(dadosAula.getCurso()) && nomeDisciplina.equals(dadosAula.getDisciplina()) && turma.equals(dadosAula.getTurma()) && periodo.equals(dadosAula.getPeriodo()) && semestreLetivo.equals(dadosAula.getSemestreLetivo()) && data.equals(dadosAula.getDataAula())) {
						txtIdAula.setText(String.valueOf(dadosAula.getIdAula()));
						cmbCurso.setSelectedItem (dadosAula.getCurso());
						cmbDisciplina.setSelectedItem (dadosAula.getDisciplina());
						cmbTurma.setSelectedItem (dadosAula.getTurma());
						cmbPeriodo.setSelectedItem (dadosAula.getPeriodo());
						cmbSemestreLetivo.setSelectedItem (dadosAula.getSemestreLetivo());
						txtDataAula.setText (dadosAula.getDataAula());
						if (dadosAula.isTeveAula() == true) {
							btnSimAula.setSelected(true);
							txtJustificativa.setText(dadosAula.getJustificativa());
							cmbHorarioInicio.setSelectedItem (dadosAula.getHorarioInicio());
							cmbHorarioTermino.setSelectedItem (dadosAula.getHorarioTermino());
							txtAssunto.setText (dadosAula.getAssunto());
							txtQtdAluno.setText (String.valueOf(dadosAula.getQtdAlunos()));
							txtMateriaisDisponibilizados.setText (dadosAula.getMateriaisDisponibilizados());
							txtLinkSessao.setText (dadosAula.getLinkSessao());
							txtLinkGravacao.setText (dadosAula.getLinkGravacao());
							txtObs.setText (dadosAula.getObs());
							
							if (dadosAula.isAtividadeSolicitada() == true) {
								btnSimAtividade.setSelected(true);
								dteDataAtividade.setVisible(false);
								txtDataAtividade.setVisible(true);
								btnGrupo.setEnabled(true);
								btnIndividual.setEnabled(true);
								txtDescricao.setEnabled(true);
								txtDataAtividade.setText(dadosAula.getDataEntrega());
								if (dadosAula.getQtdPessoas().equals("Grupo")) {
									btnGrupo.setSelected(true);
								}
								else if (dadosAula.getQtdPessoas().equals("Individual")) {
									btnIndividual.setSelected(true);
								}
								else {
									btnGrupo.setSelected(false);
									btnIndividual.setSelected(false);
								}
								txtDescricao.setText(dadosAula.getDescricao());
							}
							else if (dadosAula.isAtividadeSolicitada() == false) {
								btnNaoAtividade.setSelected(true);
							}
						}
						else if (dadosAula.isTeveAula() == false) {
							btnNaoAula.setSelected(true);
							lblJustificativa.setVisible(true);
							txtJustificativa.setVisible(true);
							txtJustificativa.setText(dadosAula.getJustificativa());
							btnGrupo.setEnabled(true);
							btnIndividual.setEnabled(true);
							txtDescricao.setEnabled(true);
							dteDataAtividade.setEnabled(true);
						}
					}
					dteDataAula.setVisible(false);
					txtDataAula.setVisible(true);
					scrJustificativa.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Consultar Aula!!. "
							+ "\n1. Verifique se Todos os Campos Abaixo Foram Preenchidos Corretamente"
							+ "\n* CURSO"
							+ "\n* DISCIPLINA"
							+ "\n* TURMA"
							+ "\n* PERIODO"
							+ "\n* SEMESTRE LETIVO"
							+ "\n* DATA DA AULA"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setToolTipText("Bot\u00E3o Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(213, 346, 60, 43);
		panel.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat formatarData = new SimpleDateFormat("EEE dd/MM/yyyy");
					String data, dataAtividade;
					data = formatarData.format(dteDataAula.getDate());
					data.toString();
					
					DadosAula dadosAula = new DadosAula();
					dadosAula.setIdAula(Integer.parseInt(txtIdAula.getText()));
					dadosAula.setCurso(cmbCurso.getSelectedItem().toString());
					dadosAula.setDisciplina(cmbDisciplina.getSelectedItem().toString());
					dadosAula.setTurma(cmbTurma.getSelectedItem().toString());
					dadosAula.setPeriodo(cmbPeriodo.getSelectedItem().toString());
					dadosAula.setSemestreLetivo(cmbSemestreLetivo.getSelectedItem().toString());
					dadosAula.setDataAula(data);
					if (btnSimAula.isSelected()) {
						dadosAula.setTeveAula(true);
						dadosAula.setJustificativa(null);
						dadosAula.setHorarioInicio(cmbHorarioInicio.getSelectedItem().toString());
						dadosAula.setHorarioTermino(cmbHorarioTermino.getSelectedItem().toString());
						dadosAula.setAssunto(txtAssunto.getText());
						dadosAula.setQtdAlunos(Integer.parseInt(txtQtdAluno.getText()));
						dadosAula.setMateriaisDisponibilizados(txtMateriaisDisponibilizados.getText());
						dadosAula.setLinkSessao(txtLinkSessao.getText());
						dadosAula.setLinkGravacao(txtLinkGravacao.getText());
						dadosAula.setObs(txtObs.getText());
						
						if (btnSimAtividade.isSelected()) {
							dadosAula.setAtividadeSolicitada(true);
							dataAtividade = formatarData.format(dteDataAtividade.getDate());
							dataAtividade.toString();
							dadosAula.setDataEntrega(dataAtividade);
							if (btnGrupo.isSelected()) {
								dadosAula.setQtdPessoas("Grupo");
								txtQtdPessoas.setText("Grupo");
							}
							else if (btnIndividual.isSelected()) {
								dadosAula.setQtdPessoas("Individual");
								txtQtdPessoas.setText("Individual");
							}
							dadosAula.setDescricao(txtDescricao.getText());
							
							String nomeCurso = cmbCurso.getSelectedItem().toString();
							String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
							String status = "Ativo";
							
							CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
							CursoDisciplina cursoDisciplina = new CursoDisciplina();
							cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
							 
							if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
								int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
									
									TurmaDAO turmaDao = new TurmaDAO();
									Turma turma = new Turma();
									turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
									
									if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
										int idTurma = turma.getIdTurma();
										dadosAula.setIdTurma(idTurma);
									
										SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
										SemestreLetivo semestreLetivo1 = new SemestreLetivo();
										semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
										
										if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
											int idSemestre = semestreLetivo1.getIdSemestre();
											dadosAula.setIdSemestre(idSemestre);
											
											String resposta = JOptionPane.showInputDialog(null, "============Confira os Dados da Aula============"
													+ "\nCurso: " + cmbCurso.getSelectedItem().toString()
													+ "\nDisciplina: " + cmbDisciplina.getSelectedItem().toString() 
													+ "\nTurma: " + cmbTurma.getSelectedItem().toString()
													+ "\nPeriodo: " + cmbPeriodo.getSelectedItem().toString()
													+ "\nSemestre Letivo: " + cmbSemestreLetivo.getSelectedItem().toString()
													+ "\nData da Aula: " + data
													+ "\nTeve Aula?: Sim"
													+ "\nHorario Inicio: " + cmbHorarioInicio.getSelectedItem().toString()
													+ "\nHorario Termino: " + cmbHorarioTermino.getSelectedItem().toString()
													+ "\nAssunto: " + txtAssunto.getText()
													+ "\nQuantidade de Alunos: " + txtQtdAluno.getText()
													+ "\nMateriais Disponibilizados: " + txtMateriaisDisponibilizados.getText()
													+ "\nLink da Sessão: " + txtLinkSessao.getText()
													+ "\nLink da Gravação: " + txtLinkGravacao.getText()
													+ "\nObs: " + txtObs.getText()
													+ "\nAtividade Solicitada: Sim"
													+ "\nData de Entrega: " + dataAtividade
													+ "\nQuantidade de Pessoas: " + txtQtdPessoas.getText()
													+ "\nDescrição: " + txtDescricao.getText()
													+ "\n====================================================="
													+ "\n\n====================================================="
													+ "\nDigite 1 Para Salvar"
													+ "\nDigite 2 Para Alterar Alguma Informação"
													+ "\n=====================================================");
												
											int decisao = Integer.parseInt(resposta);
											if (decisao == 1) {
												DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
												// alterar
												dadosAulaDao.Alterar(dadosAula);
													
												JOptionPane.showMessageDialog (null, "Alterado com Sucesso!!");
												
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
												dteDataAtividade.setDate(null);
												btnGrupo.setSelected(false);
												btnIndividual.setSelected(false);
												txtDescricao.setText(null);
												lblJustificativa.setVisible(false);
												txtJustificativa.setVisible(false);
												btnSalvar.setVisible(false);
												scrJustificativa.setVisible(false);
											}
											else if (decisao == 2) {
												JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
											}
											else {
												JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
											}
										}
										else {
											JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
						}
						else if (btnNaoAtividade.isSelected()) {
							dadosAula.setAtividadeSolicitada(false);
							dadosAula.setDataEntrega(null);
							dadosAula.setQtdPessoas(null);
							dadosAula.setDescricao(null);
							
							String nomeCurso = cmbCurso.getSelectedItem().toString();
							String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
							String status = "Ativo";
							
							CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
							CursoDisciplina cursoDisciplina = new CursoDisciplina();
							cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
							 
							if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
								int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
									
									TurmaDAO turmaDao = new TurmaDAO();
									Turma turma = new Turma();
									turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
									
									if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
										int idTurma = turma.getIdTurma();
										dadosAula.setIdTurma(idTurma);
									
										SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
										SemestreLetivo semestreLetivo1 = new SemestreLetivo();
										semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
										
										if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
											int idSemestre = semestreLetivo1.getIdSemestre();
											dadosAula.setIdSemestre(idSemestre);
											
											String resposta = JOptionPane.showInputDialog(null, "============Confira os Dados da Aula============"
													+ "\nCurso: " + cmbCurso.getSelectedItem().toString()
													+ "\nDisciplina: " + cmbDisciplina.getSelectedItem().toString() 
													+ "\nTurma: " + cmbTurma.getSelectedItem().toString()
													+ "\nPeriodo: " + cmbPeriodo.getSelectedItem().toString()
													+ "\nSemestre Letivo: " + cmbSemestreLetivo.getSelectedItem().toString()
													+ "\nData da Aula: " + data
													+ "\nTeve Aula?: Sim"
													+ "\nHorario Inicio: " + cmbHorarioInicio.getSelectedItem().toString()
													+ "\nHorario Termino: " + cmbHorarioTermino.getSelectedItem().toString()
													+ "\nAssunto: " + txtAssunto.getText()
													+ "\nQuantidade de Alunos: " + txtQtdAluno.getText()
													+ "\nMateriais Disponibilizados: " + txtMateriaisDisponibilizados.getText()
													+ "\nLink da Sessão: " + txtLinkSessao.getText()
													+ "\nLink da Gravação: " + txtLinkGravacao.getText()
													+ "\nObs: " + txtObs.getText()
													+ "\nAtividade Solicitada: Não"
													+ "\n====================================================="
													+ "\n\n====================================================="
													+ "\nDigite 1 Para Salvar"
													+ "\nDigite 2 Para Alterar Alguma Informação"
													+ "\n=====================================================");
												
											int decisao = Integer.parseInt(resposta);
											if (decisao == 1) {
												DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
												// alterar
												dadosAulaDao.Alterar(dadosAula);
													
												JOptionPane.showMessageDialog (null, "Alterado com Sucesso!!");
												
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
												dteDataAtividade.setDate(null);
												btnGrupo.setSelected(false);
												btnIndividual.setSelected(false);
												txtDescricao.setText(null);
												lblJustificativa.setVisible(false);
												txtJustificativa.setVisible(false);
												btnSalvar.setVisible(false);
												scrJustificativa.setVisible(false);
											}
											else if (decisao == 2) {
												JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
											}
											else {
												JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
											}
										}
										else {
											JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
						}
					}
					else if (btnNaoAula.isSelected()) {
						dadosAula.setTeveAula(false);
						dadosAula.setJustificativa(txtJustificativa.getText());
						
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
						String status = "Ativo";
						
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
						 
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
							int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
								
								TurmaDAO turmaDao = new TurmaDAO();
								Turma turma = new Turma();
								turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
								
								if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
									int idTurma = turma.getIdTurma();
									dadosAula.setIdTurma(idTurma);
								
									SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
									SemestreLetivo semestreLetivo1 = new SemestreLetivo();
									semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
									
									if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
										int idSemestre = semestreLetivo1.getIdSemestre();
										dadosAula.setIdSemestre(idSemestre);
										
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
											// alterar
											dadosAulaDao.Alterar1(dadosAula);
												
											JOptionPane.showMessageDialog (null, "Alterado com Sucesso!!");
											
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
											dteDataAtividade.setDate(null);
											btnGrupo.setSelected(false);
											btnIndividual.setSelected(false);
											txtDescricao.setText(null);
											lblJustificativa.setVisible(false);
											txtJustificativa.setVisible(false);
											btnSalvar.setVisible(false);
											scrJustificativa.setVisible(false);
										}
										else if (decisao == 2) {
											JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
										}
										else {
											JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
										}
									}
									else {
										JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar Aula!!. "
							+ "\n1. Primeiro Faça Uma Consulta Com os Seguintes Dados: "
							+ "\n* CURSO"
							+ "\n* DISCIPLINA"
							+ "\n* TURMA"
							+ "\n* PERIODO"
							+ "\n* SEMESTRE LETIVO"
							+ "\n* DATA DA AULA"
							+ "\n\n2. Após a Consulta Com Esses Dados, Altere Os Dados Necessarios"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setToolTipText("Bot\u00E3o Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(304, 346, 60, 43);
		panel.add(btnAlterar);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo!!");
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setToolTipText("Bot\u00E3o Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(395, 346, 60, 43);
		panel.add(btnSair);
		
		contentPane = new JPanel();
		contentPane.setBounds(10, 11, 469, 324);
		panel.add(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		tabCurso = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabCurso, "curso");
		
		curso = new JPanel();
		tabCurso.addTab("Curso, Disciplina e Turma", null, curso, null);
		curso.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 11, 36, 21);
		curso.add(lblCurso);
		
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
		cmbCurso.setForeground(Color.BLACK);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(56, 13, 135, 21);
		curso.add(cmbCurso);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(198, 12, 67, 21);
		curso.add(lblDisciplina);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
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
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		cmbDisciplina.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
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
		cmbDisciplina.setForeground(Color.BLACK);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDisciplina.setBounds(267, 13, 187, 21);
		curso.add(cmbDisciplina);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTurma.setBounds(68, 58, 48, 21);
		curso.add(lblTurma);
		
		cmbTurma = new JComboBox();
		cmbTurma.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
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
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		cmbTurma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
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
		cmbTurma.setForeground(Color.BLACK);
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(128, 60, 94, 21);
		curso.add(cmbTurma);
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPeriodo.setBounds(232, 58, 48, 21);
		curso.add(lblPeriodo);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setForeground(Color.BLACK);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo.setBounds(290, 60, 95, 21);
		curso.add(cmbPeriodo);
		
		lblSemestre = new JLabel("Semestre Letivo");
		lblSemestre.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSemestre.setBounds(10, 109, 119, 21);
		curso.add(lblSemestre);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.setForeground(Color.BLACK);
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(139, 110, 105, 21);
		curso.add(cmbSemestreLetivo);
		
		lblDataDaAula = new JLabel("Data da Aula");
		lblDataDaAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDaAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataDaAula.setBounds(254, 109, 88, 21);
		curso.add(lblDataDaAula);
		
		dteDataAula = new JDateChooser();
		dteDataAula.setBounds(346, 110, 108, 21);
		curso.add(dteDataAula);
		
		lblTeveAula = new JLabel("Teve Aula?");
		lblTeveAula.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeveAula.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTeveAula.setBounds(139, 141, 80, 30);
		curso.add(lblTeveAula);
		
		btnSimAula = new JRadioButton("Sim");
		btnSimAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					dteDataAtividade.setEnabled(true);
					btnGrupo.setEnabled(true);
					btnIndividual.setEnabled(true);
					txtDescricao.setEnabled(true);
					btnSalvar2.setEnabled(true);
					scrJustificativa.setVisible(false);
				}
			}
		});
		btnSimAula.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSimAula.setBounds(225, 142, 54, 30);
		curso.add(btnSimAula);
		
		btnNaoAula = new JRadioButton("N\u00E3o");
		btnNaoAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					dteDataAtividade.setEnabled(false);
					btnGrupo.setEnabled(false);
					btnIndividual.setEnabled(false);
					txtDescricao.setEnabled(false);
					btnSalvar2.setEnabled(false);
					scrJustificativa.setVisible(true);
				}
			}
		});
		btnNaoAula.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNaoAula.setBounds(281, 142, 54, 30);
		curso.add(btnNaoAula);
		
		lblJustificativa = new JLabel("Justificativa");
		lblJustificativa.setVisible(false);
		lblJustificativa.setHorizontalAlignment(SwingConstants.LEFT);
		lblJustificativa.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblJustificativa.setBounds(10, 196, 94, 21);
		curso.add(lblJustificativa);
		
		btnSalvar = new JButton("");
		btnSalvar.setVisible(false);
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
					String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
					String status = "Ativo";
					
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
					 
					if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
						int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
							
							TurmaDAO turmaDao = new TurmaDAO();
							Turma turma = new Turma();
							turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
							
							if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
								int idTurma = turma.getIdTurma();
								dadosAula.setIdTurma(idTurma);
							
								SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
								SemestreLetivo semestreLetivo1 = new SemestreLetivo();
								semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
								
								if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
									int idSemestre = semestreLetivo1.getIdSemestre();
									dadosAula.setIdSemestre(idSemestre);
									
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
										dteDataAtividade.setDate(null);
										btnGrupo.setSelected(false);
										btnIndividual.setSelected(false);
										txtDescricao.setText(null);
										lblJustificativa.setVisible(false);
										txtJustificativa.setVisible(false);
										btnSalvar.setVisible(false);
									}
									else if (decisao == 2) {
										JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
									}
									else {
										JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
									}
								}
								else {
									JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setToolTipText("Bot\u00E3o Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(198, 242, 60, 43);
		curso.add(btnSalvar);
		
		txtSenhaProf = new JTextField();
		txtSenhaProf.setVisible(false);
		txtSenhaProf.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSenhaProf.setBounds(10, 265, 119, 20);
		curso.add(txtSenhaProf);
		txtSenhaProf.setColumns(10);
		
		txtCodProfessor = new JTextField();
		txtCodProfessor.setVisible(false);
		txtCodProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodProfessor.setColumns(10);
		txtCodProfessor.setBounds(10, 242, 119, 20);
		curso.add(txtCodProfessor);
		
		txtDataAula = new JTextField();
		txtDataAula.setBounds(346, 109, 108, 23);
		curso.add(txtDataAula);
		txtDataAula.setVisible(false);
		txtDataAula.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDataAula.setColumns(10);
		
		scrJustificativa = new JScrollPane();
		scrJustificativa.setVisible(false);
		scrJustificativa.setBounds(128, 179, 326, 52);
		curso.add(scrJustificativa);
		
		txtJustificativa = new JTextArea();
		scrJustificativa.setViewportView(txtJustificativa);
		
		btnConsultar_1 = new JButton("");
		btnConsultar_1.setBounds(394, 242, 60, 43);
		curso.add(btnConsultar_1);
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "dados");
			}
		});
		btnConsultar_1.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/right.png")));
		btnConsultar_1.setToolTipText("Bot\u00E3o Avan\u00E7ar");
		btnConsultar_1.setFont(new Font("Arial", Font.PLAIN, 14));
		txtJustificativa.setVisible(false);
		
		tabDados = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabDados, "dados");
		
		dados = new JPanel();
		tabDados.addTab("Dados da Aula", null, dados, null);
		dados.setLayout(null);
		
		lblInicio = new JLabel("Hor\u00E1rio de In\u00EDcio");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblInicio.setBounds(10, 12, 118, 21);
		dados.add(lblInicio);
		
		cmbHorarioInicio = new JComboBox();
		cmbHorarioInicio.setModel(new DefaultComboBoxModel(new String[] {"", "08:30", "09:55", "14:00", "15:25", "19:10", "20:35"}));
		cmbHorarioInicio.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbHorarioInicio.setBounds(138, 14, 69, 20);
		dados.add(cmbHorarioInicio);
		
		lblTermino = new JLabel("Hor\u00E1rio de T\u00E9rmino");
		lblTermino.setHorizontalAlignment(SwingConstants.LEFT);
		lblTermino.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTermino.setBounds(240, 11, 135, 21);
		dados.add(lblTermino);
		
		cmbHorarioTermino = new JComboBox();
		cmbHorarioTermino.setModel(new DefaultComboBoxModel(new String[] {"", "09:45", "11:10", "15:15", "16:40", "20:25", "21:50"}));
		cmbHorarioTermino.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbHorarioTermino.setBounds(385, 12, 69, 20);
		dados.add(cmbHorarioTermino);
		
		txtAssunto = new JTextField();
		txtAssunto.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAssunto.setColumns(10);
		txtAssunto.setBounds(76, 44, 164, 20);
		dados.add(txtAssunto);
		
		lblConteudoMinistrado = new JLabel("Assunto");
		lblConteudoMinistrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblConteudoMinistrado.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblConteudoMinistrado.setBounds(10, 45, 56, 21);
		dados.add(lblConteudoMinistrado);
		
		lblQuantidadeDeAlunos = new JLabel("Qtd. Alunos");
		lblQuantidadeDeAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantidadeDeAlunos.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblQuantidadeDeAlunos.setBounds(282, 45, 93, 21);
		dados.add(lblQuantidadeDeAlunos);
		
		txtQtdAluno = new JTextField();
		txtQtdAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdAluno.setColumns(10);
		txtQtdAluno.setBounds(385, 46, 36, 20);
		dados.add(txtQtdAluno);
		
		lblMateriaisDisponibilizados = new JLabel("Materiais Disponibilizados");
		lblMateriaisDisponibilizados.setHorizontalAlignment(SwingConstants.LEFT);
		lblMateriaisDisponibilizados.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMateriaisDisponibilizados.setBounds(10, 75, 175, 21);
		dados.add(lblMateriaisDisponibilizados);
		
		txtMateriaisDisponibilizados = new JTextField();
		txtMateriaisDisponibilizados.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMateriaisDisponibilizados.setColumns(10);
		txtMateriaisDisponibilizados.setBounds(195, 77, 259, 20);
		dados.add(txtMateriaisDisponibilizados);
		
		lblLinkSesso = new JLabel("Link Sess\u00E3o");
		lblLinkSesso.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinkSesso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLinkSesso.setBounds(10, 107, 82, 21);
		dados.add(lblLinkSesso);
		
		txtLinkSessao = new JTextField();
		txtLinkSessao.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLinkSessao.setColumns(10);
		txtLinkSessao.setBounds(102, 109, 352, 20);
		dados.add(txtLinkSessao);
		
		lblLinkSessoE = new JLabel("Link da Aula Gravada");
		lblLinkSessoE.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinkSessoE.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLinkSessoE.setBounds(10, 139, 157, 21);
		dados.add(lblLinkSessoE);
		
		txtLinkGravacao = new JTextField();
		txtLinkGravacao.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLinkGravacao.setColumns(10);
		txtLinkGravacao.setBounds(158, 141, 296, 20);
		dados.add(txtLinkGravacao);
		
		lblObs = new JLabel("OBS");
		lblObs.setHorizontalAlignment(SwingConstants.LEFT);
		lblObs.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblObs.setBounds(10, 194, 36, 21);
		dados.add(lblObs);
		
		btnVoltar2 = new JButton("");
		btnVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "curso");
			}
		});
		btnVoltar2.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/left.png")));
		btnVoltar2.setToolTipText("Bot\u00E3o Voltar ");
		btnVoltar2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar2.setBounds(10, 242, 60, 43);
		dados.add(btnVoltar2);
		
		btnAvancar2 = new JButton("");
		btnAvancar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "atividade");
			}
		});
		btnAvancar2.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/right.png")));
		btnAvancar2.setToolTipText("Bot\u00E3o Avan\u00E7ar");
		btnAvancar2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAvancar2.setBounds(394, 242, 60, 43);
		dados.add(btnAvancar2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 171, 398, 60);
		dados.add(scrollPane_1);
		
		txtObs = new JTextArea();
		scrollPane_1.setViewportView(txtObs);
		
		tabAtividade = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabAtividade, "atividade");
		
		atividade = new JPanel();
		tabAtividade.addTab("Atividades", null, atividade, null);
		atividade.setLayout(null);
		
		lblAtividadesSolicitadas = new JLabel("Atividades Solicitadas Durante a Aula?");
		lblAtividadesSolicitadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtividadesSolicitadas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblAtividadesSolicitadas.setBounds(22, 11, 269, 21);
		atividade.add(lblAtividadesSolicitadas);
		
		btnSimAtividade = new JRadioButton("Sim");
		btnSimAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSimAtividade.isSelected()) {
					btnNaoAtividade.setSelected(false);
					dteDataAtividade.setEnabled(true);
					btnGrupo.setEnabled(true);
					btnIndividual.setEnabled(true);
					txtDescricao.setEnabled(true);
				}
			}
		});
		btnSimAtividade.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSimAtividade.setBounds(297, 7, 69, 30);
		atividade.add(btnSimAtividade);
		
		btnNaoAtividade = new JRadioButton("N\u00E3o");
		btnNaoAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNaoAtividade.isSelected()) {
					btnSimAtividade.setSelected(false);
					dteDataAtividade.setDate(null);
					btnGrupo.setSelected(false);
					btnIndividual.setSelected(false);
					txtDescricao.setText(null);
					dteDataAtividade.setEnabled(false);
					btnGrupo.setEnabled(false);
					btnIndividual.setEnabled(false);
					txtDescricao.setEnabled(false);
				}
			}
		});
		btnNaoAtividade.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNaoAtividade.setBounds(368, 8, 69, 30);
		atividade.add(btnNaoAtividade);
		
		lblDataDeEntrega = new JLabel("Data de Entrega");
		lblDataDeEntrega.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeEntrega.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(10, 59, 120, 21);
		atividade.add(lblDataDeEntrega);
		
		dteDataAtividade = new JDateChooser();
		dteDataAtividade.setEnabled(false);
		dteDataAtividade.setBounds(130, 60, 108, 20);
		atividade.add(dteDataAtividade);
		
		btnGrupo = new JRadioButton("Grupo");
		btnGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnGrupo.isSelected()) {
					btnIndividual.setSelected(false);
				}
			}
		});
		btnGrupo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrupo.setEnabled(false);
		btnGrupo.setBounds(288, 55, 69, 30);
		atividade.add(btnGrupo);
		
		btnIndividual = new JRadioButton("Individual");
		btnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnIndividual.isSelected()) {
					btnGrupo.setSelected(false);
				}
			}
		});
		btnIndividual.setFont(new Font("Arial", Font.PLAIN, 14));
		btnIndividual.setEnabled(false);
		btnIndividual.setBounds(359, 55, 85, 30);
		atividade.add(btnIndividual);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o ");
		lblDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 125, 69, 21);
		atividade.add(lblDescrio);
		
		btnSalvar2 = new JButton("");
		btnSalvar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					SimpleDateFormat formatarData = new SimpleDateFormat("EEE dd/MM/yyyy");
					String data, dataAtividade;
					data = formatarData.format(dteDataAula.getDate());
					data.toString();
					
					DadosAula dadosAula = new DadosAula();
					dadosAula.setCurso(cmbCurso.getSelectedItem().toString());
					dadosAula.setDisciplina(cmbDisciplina.getSelectedItem().toString());
					dadosAula.setTurma(cmbTurma.getSelectedItem().toString());
					dadosAula.setPeriodo(cmbPeriodo.getSelectedItem().toString());
					dadosAula.setSemestreLetivo(cmbSemestreLetivo.getSelectedItem().toString());
					dadosAula.setDataAula(data);
					dadosAula.setTeveAula(true);
					dadosAula.setJustificativa(null);
					dadosAula.setHorarioInicio(cmbHorarioInicio.getSelectedItem().toString());
					dadosAula.setHorarioTermino(cmbHorarioTermino.getSelectedItem().toString());
					dadosAula.setAssunto(txtAssunto.getText());
					dadosAula.setQtdAlunos(Integer.parseInt(txtQtdAluno.getText()));
					dadosAula.setMateriaisDisponibilizados(txtMateriaisDisponibilizados.getText());
					dadosAula.setLinkSessao(txtLinkSessao.getText());
					dadosAula.setLinkGravacao(txtLinkGravacao.getText());
					dadosAula.setObs(txtObs.getText());
					
					if (btnSimAtividade.isSelected()) {
						dadosAula.setAtividadeSolicitada(true);
						
						dataAtividade = formatarData.format(dteDataAtividade.getDate());
						dataAtividade.toString();
						
						dadosAula.setDataEntrega(dataAtividade);
						
						if (btnGrupo.isSelected()) {
							dadosAula.setQtdPessoas("Grupo");
							txtQtdPessoas.setText("Grupo");
						}
						else if (btnIndividual.isSelected()) {
							dadosAula.setQtdPessoas("Individual");
							txtQtdPessoas.setText("Individual");
						}
						else {
							JOptionPane.showMessageDialog(null, "Selecione se o a Atividade é em Grupo ou Individual");
						}
						
						dadosAula.setDescricao(txtDescricao.getText());
						
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
						String status = "Ativo";
						
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
						 
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
							int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
								
								TurmaDAO turmaDao = new TurmaDAO();
								Turma turma = new Turma();
								turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
								
								if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
									int idTurma = turma.getIdTurma();
									dadosAula.setIdTurma(idTurma);
								
									SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
									SemestreLetivo semestreLetivo1 = new SemestreLetivo();
									semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
									
									if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
										int idSemestre = semestreLetivo1.getIdSemestre();
										dadosAula.setIdSemestre(idSemestre);
										
										String resposta = JOptionPane.showInputDialog(null, "============Confira os Dados da Aula============"
												+ "\nCurso: " + cmbCurso.getSelectedItem().toString()
												+ "\nDisciplina: " + cmbDisciplina.getSelectedItem().toString() 
												+ "\nTurma: " + cmbTurma.getSelectedItem().toString()
												+ "\nPeriodo: " + cmbPeriodo.getSelectedItem().toString()
												+ "\nSemestre Letivo: " + cmbSemestreLetivo.getSelectedItem().toString()
												+ "\nData da Aula: " + data
												+ "\nTeve Aula?: Sim"
												+ "\nHorario Inicio: " + cmbHorarioInicio.getSelectedItem().toString()
												+ "\nHorario Termino: " + cmbHorarioTermino.getSelectedItem().toString()
												+ "\nAssunto: " + txtAssunto.getText()
												+ "\nQuantidade de Alunos: " + txtQtdAluno.getText()
												+ "\nMateriais Disponibilizados: " + txtMateriaisDisponibilizados.getText()
												+ "\nLink da Sessão: " + txtLinkSessao.getText()
												+ "\nLink da Gravação: " + txtLinkGravacao.getText()
												+ "\nObs: " + txtObs.getText()
												+ "\nAtividade Solicitada: Sim"
												+ "\nData de Entrega: " + dataAtividade
												+ "\nQuantidade de Pessoas: " + txtQtdPessoas.getText()
												+ "\nDescrição: " + txtDescricao.getText()
												+ "\n====================================================="
												+ "\n\n====================================================="
												+ "\nDigite 1 Para Salvar"
												+ "\nDigite 2 Para Alterar Alguma Informação"
												+ "\n=====================================================");
											
										int decisao = Integer.parseInt(resposta);
										if (decisao == 1) {
											DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
											dadosAulaDao.Salvar(dadosAula);
												
											JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
											
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
											dteDataAtividade.setDate(null);
											btnGrupo.setSelected(false);
											btnIndividual.setSelected(false);
											txtDescricao.setText(null);
											lblJustificativa.setVisible(false);
											txtJustificativa.setVisible(false);
											btnSalvar.setVisible(false);
										}
										else if (decisao == 2) {
											JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
										}
										else {
											JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
										}
									}
									else {
										JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
					}
					else if (btnNaoAtividade.isSelected()) {
						dadosAula.setAtividadeSolicitada(false);
						dadosAula.setDataEntrega(null);
						dadosAula.setQtdPessoas(null);
						dadosAula.setDescricao(null);
						
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String nomeDisciplina = cmbDisciplina.getSelectedItem().toString();
						String status = "Ativo";
						
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						cursoDisciplina = cursoDisciplinaDao.Consultar1(nomeCurso, nomeDisciplina, status);
						 
						if (nomeCurso.equals(cursoDisciplina.getNomeCurso()) && nomeDisciplina.equals(cursoDisciplina.getNomeDisciplina()) && status.equals(cursoDisciplina.getStatus())) {
							int idCursoDisciplina = cursoDisciplina.getIdCursoDisciplina();
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
								
								TurmaDAO turmaDao = new TurmaDAO();
								Turma turma = new Turma();
								turma = turmaDao.Consultar1(nomeCurso, nomeDisciplina, turmaCod, periodo, semestreLetivo, status);
								
								if (nomeCurso.equals(turma.getNomeCurso()) && nomeDisciplina.equals(turma.getDisciplina()) && turmaCod.equals(turma.getTurmaCod()) && periodo.equals(turma.getPeriodo()) && semestreLetivo.equals(turma.getSemestreLetivo()) && status.equals(turma.getStatus())) {
									int idTurma = turma.getIdTurma();
									dadosAula.setIdTurma(idTurma);
								
									SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
									SemestreLetivo semestreLetivo1 = new SemestreLetivo();
									semestreLetivo1 = semestreLetivoDao.Consultar2(semestreLetivo, status);
									
									if (semestreLetivo.equals(semestreLetivo1.getSemestre()) && status.equals(semestreLetivo1.getStatus())) {
										int idSemestre = semestreLetivo1.getIdSemestre();
										dadosAula.setIdSemestre(idSemestre);
										
										String resposta = JOptionPane.showInputDialog(null, "============Confira os Dados da Aula============"
												+ "\nCurso: " + cmbCurso.getSelectedItem().toString()
												+ "\nDisciplina: " + cmbDisciplina.getSelectedItem().toString() 
												+ "\nTurma: " + cmbTurma.getSelectedItem().toString()
												+ "\nPeriodo: " + cmbPeriodo.getSelectedItem().toString()
												+ "\nSemestre Letivo: " + cmbSemestreLetivo.getSelectedItem().toString()
												+ "\nData da Aula: " + data
												+ "\nTeve Aula?: Sim"
												+ "\nHorario Inicio: " + cmbHorarioInicio.getSelectedItem().toString()
												+ "\nHorario Termino: " + cmbHorarioTermino.getSelectedItem().toString()
												+ "\nAssunto: " + txtAssunto.getText()
												+ "\nQuantidade de Alunos: " + txtQtdAluno.getText()
												+ "\nMateriais Disponibilizados: " + txtMateriaisDisponibilizados.getText()
												+ "\nLink da Sessão: " + txtLinkSessao.getText()
												+ "\nLink da Gravação: " + txtLinkGravacao.getText()
												+ "\nObs: " + txtObs.getText()
												+ "\nAtividade Solicitada: Não"
												+ "\n====================================================="
												+ "\n\n====================================================="
												+ "\nDigite 1 Para Salvar"
												+ "\nDigite 2 Para Alterar Alguma Informação"
												+ "\n=====================================================");
											
										int decisao = Integer.parseInt(resposta);
										if (decisao == 1) {
											DadosAulaDAO dadosAulaDao = new DadosAulaDAO();
											dadosAulaDao.Salvar(dadosAula);
												
											JOptionPane.showMessageDialog (null, "Salvo com Sucesso!!");
											
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
											dteDataAtividade.setDate(null);
											btnGrupo.setSelected(false);
											btnIndividual.setSelected(false);
											txtDescricao.setText(null);
											lblJustificativa.setVisible(false);
											txtJustificativa.setVisible(false);
											btnSalvar.setVisible(false);
										}
										else if (decisao == 2) {
											JOptionPane.showMessageDialog (null, "Altere a Informação Desejada e e Clique no Botão Salvar Novamente");
										}
										else {
											JOptionPane.showMessageDialog (null, "Resposta Inválida, Digite 1 Para Salvar e 2 Para Alterar Alguma Informação");
										}
									}
									else {
										JOptionPane.showMessageDialog (null, "Verifique o Semestre Letivo Por Favor e Tente Novamente");
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
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione se Teve ou Não Atividade Solicitada");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Fazer o Cadastro da Aula!!. "
							+ "\n1. Verifique se Todos os Campos Foram Preenchidos"
							+ "\n2. Caso Todos Estejam Preenchidos. Verifique se Foram Preenchidos Corretamente"
							+ "\n\nErro: " + e1);
				}
			}
		});
		btnSalvar2.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar2.setToolTipText("Bot\u00E3o Salvar");
		btnSalvar2.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar2.setBounds(201, 211, 60, 43);
		atividade.add(btnSalvar2);
		
		btnVoltar3 = new JButton("");
		btnVoltar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "dados");
			}
		});
		btnVoltar3.setIcon(new ImageIcon(Tela_CadastroAula.class.getResource("/br/com/exemplo/view/images/left.png")));
		btnVoltar3.setToolTipText("Bot\u00E3o Voltar");
		btnVoltar3.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar3.setBounds(10, 242, 60, 43);
		atividade.add(btnVoltar3);
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setVisible(false);
		txtQtdPessoas.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQtdPessoas.setBounds(334, 265, 120, 20);
		atividade.add(txtQtdPessoas);
		txtQtdPessoas.setColumns(10);
		
		txtDataAtividade = new JTextField();
		txtDataAtividade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDataAtividade.setBounds(130, 61, 108, 20);
		atividade.add(txtDataAtividade);
		txtDataAtividade.setVisible(false);
		txtDataAtividade.setColumns(10);
		
		txtIdAula = new JTextField();
		txtIdAula.setVisible(false);
		txtIdAula.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIdAula.setBounds(334, 242, 120, 20);
		atividade.add(txtIdAula);
		txtIdAula.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(89, 109, 365, 54);
		atividade.add(scrollPane_2);
		
		txtDescricao = new JTextArea();
		scrollPane_2.setViewportView(txtDescricao);
		txtDescricao.setEnabled(false);
	}
}
