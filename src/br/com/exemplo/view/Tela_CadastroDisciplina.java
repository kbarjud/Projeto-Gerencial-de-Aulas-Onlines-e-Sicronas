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
	private JButton btnListarDisciplinasAtivas;
	private JButton btnListarDisciplinasDesativadas;
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
	public Tela_CadastroDisciplina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 527);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Disciplina");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "=============Disciplinas============="
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Cadastrar as disciplinas"
						+ "\n 2. Manter as disciplinas ou desativá-las"
						+ "\n==================================", "Informações das Disciplinas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================", "Informações do Sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
		btnConsultar.setToolTipText("Consultar");
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
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Curso não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
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
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Curso não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar!!. "
							+ "\n\nVerifique o curso e a disciplina, pois essa disciplina não está cadastrada nesse curso"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(246, 134, 60, 43);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("");
		btnVoltar.setToolTipText("Voltar");
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
		btnSair.setToolTipText("Sair");
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
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cursoNome = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 0));
					String disciplinaNome = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 1));
					
					if (cursoNome.equals(cmbCurso.getSelectedItem().toString()) && disciplinaNome.equals(txtDisciplina.getText())) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Por favor altere o curso ou a disciplina antes de prosseguir!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					
					}
					else {
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String nomeDisciplina = txtDisciplina.getText();
						String status = "Ativo";
						
						Disciplina disciplina = new Disciplina();
						DisciplinaDAO disciplinaDao = new DisciplinaDAO();
						disciplina = disciplinaDao.Consultar2(nomeDisciplina, status);
						
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						
						Curso curso = new Curso();
						CursoDAO cursoDao = new CursoDAO();
						curso = cursoDao.Consultar1(nomeCurso, status);
						
						if (disciplina.getNomeDisciplina().equals("")) {
							disciplina.setNomeDisciplina (txtDisciplina.getText());
							disciplina.setStatus("Ativo");
							
							disciplinaDao.Salvar(disciplina);
							disciplina = disciplinaDao.Consultar2(nomeDisciplina, status);
							
							if (nomeDisciplina.equals(disciplina.getNomeDisciplina())) {
								int idDisciplina = disciplina.getIdDisciplina();
								cursoDisciplina.setIdDisciplina(idDisciplina);
								cursoDisciplina.setNomeDisciplina(nomeDisciplina);
								
								if (nomeCurso.equals(curso.getNomeCurso())) {
									int idCurso = curso.getIdCurso();
									cursoDisciplina.setIdCurso(idCurso);
									cursoDisciplina.setNomeCurso(nomeCurso);
									
									String teste = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 3));
									int idCursoDisciplina = Integer.parseInt(teste);
									cursoDisciplina.setStatus ("Ativo");
									cursoDisciplina.setIdCursoDisciplina(idCursoDisciplina);
									
									cursoDisciplinaDao.Alterar(cursoDisciplina);
									
									List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
									lista = cursoDisciplinaDao.ListarTodos1(idCursoDisciplina);
									
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
									
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Alterado com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								}
								else {
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Erro ao pegar ID do curso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
								}
							}
							else {
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao pegar ID da disciplina!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							}
						}
						
						else if (nomeDisciplina.equals(disciplina.getNomeDisciplina())) {
							int idDisciplina = disciplina.getIdDisciplina();
							cursoDisciplina.setIdDisciplina(idDisciplina);
							cursoDisciplina.setNomeDisciplina(nomeDisciplina);
							
							if (nomeCurso.equals(curso.getNomeCurso())) {
								int idCurso = curso.getIdCurso();
								cursoDisciplina.setIdCurso(idCurso);
								cursoDisciplina.setNomeCurso(nomeCurso);
								
								String teste = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 3));
								int idCursoDisciplina = Integer.parseInt(teste);
								cursoDisciplina.setStatus ("Ativo");
								cursoDisciplina.setIdCursoDisciplina(idCursoDisciplina);
								
								cursoDisciplinaDao.Alterar(cursoDisciplina);
								
								List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
								lista = cursoDisciplinaDao.ListarTodos1(idCursoDisciplina);
								
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
								
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Alterado com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							}
							else {
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao pegar ID do curso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							
							}
						}
						else {
							Object[] options = {"OK"};
							ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "Erro ao pegar ID da disciplina!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						}
					}
				} catch(Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Alterar!!. "
							+ "\n\n1. Verifique se todos os campos foram preenchidos ou realize uma consulta para saber se esse curso e disciplina já está cadastrado" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				
				}
			}
		});
		btnAlterar.setToolTipText("Alterar");
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
					if (txtDisciplina.getText().equals("")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Informe a disciplina antes de prosseguir", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else {
						String nomeDisciplina = txtDisciplina.getText();
						String nomeCurso = cmbCurso.getSelectedItem().toString();
						String status = "Ativo";
						
						CursoDisciplina cursoDisciplina = new CursoDisciplina();
						CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
						
						Disciplina disciplina = new Disciplina();
						DisciplinaDAO disciplinaDao = new DisciplinaDAO();
						disciplina = disciplinaDao.Consultar2(nomeDisciplina, status);
						
						CursoDAO cursoDao = new CursoDAO();
						Curso curso = new Curso();
						
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
								
								curso = cursoDao.Consultar1(nomeCurso, status);
								 
								if (nomeCurso.equals(curso.getNomeCurso())) {
									int idCurso = curso.getIdCurso();
									cursoDisciplina.setIdCurso(idCurso);	
									
									cursoDisciplina.setStatus("Ativo");
									
									cursoDisciplinaDao.Salvar(cursoDisciplina);
														
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
									
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
									Object[] options = {"OK"};
									ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
									JOptionPane.showOptionDialog(null, "Erro ao pegar o ID do curso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								}
							}
						}
						else if (nomeDisciplina.equals(disciplina.getNomeDisciplina())){
							int idDisciplina = disciplina.getIdDisciplina();
							cursoDisciplina.setIdDisciplina(idDisciplina);
							
							cursoDisciplina.setNomeCurso(cmbCurso.getSelectedItem().toString());
							cursoDisciplina.setNomeDisciplina(txtDisciplina.getText());
							
							curso = cursoDao.Consultar1(nomeCurso, status);
							 
							if (nomeCurso.equals(curso.getNomeCurso())) {
								int idCurso = curso.getIdCurso();
								cursoDisciplina.setIdCurso(idCurso);	
								cursoDisciplina.setStatus("Ativo");
								
								cursoDisciplinaDao.Salvar(cursoDisciplina);
													
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Salvo com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
								
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
								Object[] options = {"OK"};
								ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
								JOptionPane.showOptionDialog(null, "Erro ao pegar o ID do curso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
							}
						}
						txtDisciplina.setText(null);
						cmbCurso.setSelectedIndex(0);
					}
					
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao salvar!!. "
							+ "\n\n1. Verifique se a disciplina foi preenchida corretamente e se o cadastro da mesma já foi feito"
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvar.setToolTipText("Salvar");
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
		btnNovo.setToolTipText("Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(106, 134, 60, 43);
		contentPane.add(btnNovo);
		
		btnAtivar = new JButton("");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					String status = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 2));
					if (status.equals("Ativo")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "A disciplina já está ativa!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 3));
						int idCursoDisciplina = Integer.parseInt(teste);
						
						cursoDisciplina.setStatus("Ativo");
						cursoDisciplina.setIdCursoDisciplina(idCursoDisciplina);
						
						String nomeCurso = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 0));
						String nomeDisciplina = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 1));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "====================================================="
								+ "\nDeseja mesmo ativar a disciplina " + nomeDisciplina + " do curso " + nomeCurso + "?"
								+ "\n=====================================================", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						if (resposta == JOptionPane.YES_OPTION) {
							
							CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
							cursoDisciplinaDao.AtivarDesativar(cursoDisciplina);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "A disciplina foi ativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							
							txtDisciplina.setText(null);
							
							String status1 = "Ativo";
							
							List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
							lista = cursoDisciplinaDao.ListarTodos6(status1);
							
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
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Ativar Disciplina!!. "
							+ "\n\n1. Verifique se a disciplina já esta ativa" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAtivar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setToolTipText("Ativar");
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(98, 401, 60, 43);
		contentPane.add(btnAtivar);
		
		btnDesativar = new JButton("");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CursoDisciplina cursoDisciplina = new CursoDisciplina();
					String status = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 2));
					if (status.equals("Desativado")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "A disciplina já está desativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 3));
						int idCursoDisciplina = Integer.parseInt(teste);
						
						cursoDisciplina.setStatus("Desativado");
						cursoDisciplina.setIdCursoDisciplina(idCursoDisciplina);
						
						String nomeCurso = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 0));
						String nomeDisciplina = String.valueOf(tabDisciplina.getValueAt(tabDisciplina.getSelectedRow(), 1));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "====================================================="
								+ "\nDeseja mesmo desativar a disciplina " + nomeDisciplina + " do curso " + nomeCurso + "?"
								+ "\n=====================================================", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
							
						if (resposta == JOptionPane.YES_OPTION) {
							
							CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
							cursoDisciplinaDao.AtivarDesativar(cursoDisciplina);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "A disciplina foi desativada!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							
							txtDisciplina.setText(null);
							
							String status1 = "Desativado";
							
							List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
							lista = cursoDisciplinaDao.ListarTodos6(status1);
							
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
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Desativar Disciplina!!. "
							+ "\n\n1. Verifique se a disciplina já esta desativada" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnDesativar.setIcon(new ImageIcon(Tela_CadastroDisciplina.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setToolTipText("Desativar");
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(177, 401, 60, 43);
		contentPane.add(btnDesativar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 188, 447, 2);
		contentPane.add(separator_3);
		
		btnListarDisciplinasAtivas = new JButton("Listar Ativos");
		btnListarDisciplinasAtivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String status = "Ativo";
					
					List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					lista = cursoDisciplinaDao.ListarTodos6(status);
					
					DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
					model.setNumRows(0);
					for (CursoDisciplina cursoDisciplina : lista) {
						model.addRow (new Object[] {
								cursoDisciplina.getNomeCurso(),
								cursoDisciplina.getNomeDisciplina(),
								cursoDisciplina.getStatus(),
								cursoDisciplina.getIdCursoDisciplina(),
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
		btnListarDisciplinasAtivas.setToolTipText("");
		btnListarDisciplinasAtivas.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDisciplinasAtivas.setBounds(11, 201, 123, 23);
		contentPane.add(btnListarDisciplinasAtivas);
		
		btnListarDisciplinasDesativadas = new JButton("Listar Inativos");
		btnListarDisciplinasDesativadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Desativado";
					
					List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					lista = cursoDisciplinaDao.ListarTodos6(status);
					
					DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
					model.setNumRows(0);
					for (CursoDisciplina cursoDisciplina : lista) {
						model.addRow (new Object[] {
								cursoDisciplina.getNomeCurso(),
								cursoDisciplina.getNomeDisciplina(),
								cursoDisciplina.getStatus(),
								cursoDisciplina.getIdCursoDisciplina(),
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
		btnListarDisciplinasDesativadas.setToolTipText("");
		btnListarDisciplinasDesativadas.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListarDisciplinasDesativadas.setBounds(145, 201, 123, 23);
		contentPane.add(btnListarDisciplinasDesativadas);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
					CursoDisciplinaDAO cursoDisciplinaDao = new CursoDisciplinaDAO();
					lista = cursoDisciplinaDao.ListarTodos();
					
					DefaultTableModel model = (DefaultTableModel) tabDisciplina.getModel();
					model.setNumRows(0);
					for (CursoDisciplina cursoDisciplina : lista) {
						model.addRow (new Object[] {
								cursoDisciplina.getNomeCurso(),
								cursoDisciplina.getNomeDisciplina(),
								cursoDisciplina.getStatus(),
								cursoDisciplina.getIdCursoDisciplina(),
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
