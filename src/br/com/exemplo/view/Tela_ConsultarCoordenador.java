package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.CoordenadorDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.DadosAulaDAO;
import br.com.exemplo.model.Coordenador;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.DadosAula;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;

public class Tela_ConsultarCoordenador extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JLabel lblCoordenador;
	private JComboBox cmbCoordenador;
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
	private JTable tabCoordenador;
	private JButton btnConsultar;
	private JSeparator separator_3;
	private JButton btnListarCoordenadoresAtivos;
	private JButton btnListarDesativados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ConsultarCoordenador frame = new Tela_ConsultarCoordenador();
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
	public Tela_ConsultarCoordenador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setTitle("S. Ger. Registros de Aulas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 389);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Informa\u00E7\u00E3o");
		mnNewMenu.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/info30.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Coordenador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"OK"};
				ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/information.png")));
				JOptionPane.showOptionDialog(null, "======================Coordenadores======================"
						+ "\n Nesta área você poderá: "
						+ "\n\n 1. Verificar os coordenadores cadastrados"
						+ "\n 2. Manter os coordenadores ativos no sistema ou desativá-los"
						+ "\n========================================================", "Informações dos Coordenadores", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/help30.png")));
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
		
		lblCoordenador = new JLabel("Coordenador");
		lblCoordenador.setHorizontalAlignment(SwingConstants.LEFT);
		lblCoordenador.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCoordenador.setBounds(10, 20, 96, 30);
		contentPane.add(lblCoordenador);
		
		cmbCoordenador = new JComboBox();
		cmbCoordenador.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					String status = "Ativo";
					
					List<Coordenador> lista1 = new ArrayList<Coordenador>();
					CoordenadorDAO coordenadoDao;
					coordenadoDao = new CoordenadorDAO();
					lista1 = coordenadoDao.ListarTodos2(status);
					DefaultComboBoxModel model1 = new DefaultComboBoxModel(lista1.toArray());
					cmbCoordenador.setModel(model1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}
			}
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
			}
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
			}
		});
		cmbCoordenador.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCoordenador.setBounds(116, 25, 234, 21);
		contentPane.add(cmbCoordenador);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 253, 476, 2);
		contentPane.add(separator_1);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/exit.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(360, 266, 60, 43);
		contentPane.add(btnSair);
		
		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tabCoordenador.getModel()).setRowCount(0);
				cmbCoordenador.setSelectedIndex(0);
				((DefaultTableModel) tabCoordenador.getModel()).setRowCount(0);
			}
		});
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/new.png")));
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovo.setBounds(80, 266, 60, 43);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ConsultarCoordenador telaConsultarCoordenador = new Tela_ConsultarCoordenador();
				telaConsultarCoordenador.setVisible(false);
				dispose();
				Tela_CadastroCoordenador telaCadastroCoordenador = new Tela_CadastroCoordenador();
				telaCadastroCoordenador.txtControle.setText("telaConsultarCoordenador");
				telaCadastroCoordenador.setVisible(true);
			}
		});
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/pencil.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(290, 266, 60, 43);
		contentPane.add(btnAlterar);
		
		btnDesativar = new JButton("");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Coordenador coordenador = new Coordenador();
					String status = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 0));
					if (status.equals("Desativado")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "O coordenador já está desativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Ativo")) {
						String teste = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 1));
						int idCoordenador = Integer.parseInt(teste);
						
						coordenador.setStatus("Desativado");
						coordenador.setIdCoordenador(idCoordenador);
						
						String nome = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 3));
						
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "Deseja mesmo desativar o coordenador " + nome + "?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
							
						if (resposta == JOptionPane.YES_OPTION) {
							
							CoordenadorDAO coordenadorDao = new CoordenadorDAO();
							coordenadorDao.AtivarDesativar(coordenador);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "O coordenador foi desativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							
							String status1 = "Desativado";
							
							List<Coordenador> lista = new ArrayList<Coordenador>();
							CoordenadorDAO coordenadoDao = new CoordenadorDAO();
							lista = coordenadoDao.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
							model.setNumRows(0);
							for (Coordenador coordenador1 : lista) {
								model.addRow (new Object[] {
										coordenador1.getStatus(),
										coordenador1.getIdCoordenador(),
										coordenador1.getCodCoordenador(),
										coordenador1.getNome(),
										coordenador1.getSenha(),
										coordenador1.getEmail(),
										coordenador1.getCelular(),
									});
							}
						}
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Desativar coordenador!!. "
							+ "\n\n1. Verifique se o coordenador já esta desativado" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnDesativar.setToolTipText("Desativar");
		btnDesativar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/toggle-off.png")));
		btnDesativar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDesativar.setBounds(220, 266, 60, 43);
		contentPane.add(btnDesativar);
		
		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ConsultarCoordenador telaConsultarCoordenador = new Tela_ConsultarCoordenador();
				telaConsultarCoordenador.setVisible(false);
				dispose();
				Tela_MenuCoordenador telaMenuCoordenador = new Tela_MenuCoordenador();
				telaMenuCoordenador.setVisible(true);
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 266, 60, 43);
		contentPane.add(btnVoltar);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 115, 476, 2);
		contentPane.add(separator_2);
		
		btnAtivar = new JButton("");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coordenador coordenador = new Coordenador();
					String status = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 0));
					if (status.equals("Ativo")) {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "O coordenador já está ativo!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
					}
					else if (status.equals("Desativado")) {
						String teste = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 1));
						int idCoordenador = Integer.parseInt(teste);
						
						coordenador.setStatus("Ativo");
						coordenador.setIdCoordenador(idCoordenador);
						
						String nome = String.valueOf(tabCoordenador.getValueAt(tabCoordenador.getSelectedRow(), 3));
						Object[] options = {"Salvar", "Cancelar"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/comments.png")));
						int resposta = JOptionPane.showOptionDialog(null, "Deseja mesmo ativar o coordenador " + nome + "?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
						
						if (resposta == JOptionPane.YES_OPTION) {
							
							CoordenadorDAO coordenadorDao = new CoordenadorDAO();
							coordenadorDao.AtivarDesativar(coordenador);
								
							Object[] options1 = {"OK"};
							ImageIcon icon1 = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
							JOptionPane.showOptionDialog(null, "O coordenador foi ativado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon1, options1, options1[0]);
							
							
							String status1 = "Ativo";
							
							List<Coordenador> lista = new ArrayList<Coordenador>();
							CoordenadorDAO coordenadoDao = new CoordenadorDAO();
							lista = coordenadoDao.ListarTodos4(status1);
							
							DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
							model.setNumRows(0);
							for (Coordenador coordenador1 : lista) {
								model.addRow (new Object[] {
										coordenador1.getStatus(),
										coordenador1.getIdCoordenador(),
										coordenador1.getCodCoordenador(),
										coordenador1.getNome(),
										coordenador1.getSenha(),
										coordenador1.getEmail(),
										coordenador1.getCelular(),
									});
							}
						}
						else if (resposta == JOptionPane.NO_OPTION) {
							
						}
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Ativar Coordenador!!. "
							+ "\n\n1. Verifique se o coordenador já esta ativo" 
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnAtivar.setToolTipText("Ativar");
		btnAtivar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/toggle-on.png")));
		btnAtivar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtivar.setBounds(150, 266, 60, 43);
		contentPane.add(btnAtivar);
		
		btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Coordenador> lista = new ArrayList<Coordenador>();
					CoordenadorDAO coordenadoDao = new CoordenadorDAO();
					lista = coordenadoDao.ListarTodos();
					
					DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
					model.setNumRows(0);
					for (Coordenador coordenador1 : lista) {
						model.addRow (new Object[] {
								coordenador1.getStatus(),
								coordenador1.getIdCoordenador(),
								coordenador1.getCodCoordenador(),
								coordenador1.getNome(),
								coordenador1.getSenha(),
								coordenador1.getEmail(),
								coordenador1.getCelular(),
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
		btnListarTodos.setBounds(291, 81, 123, 23);
		contentPane.add(btnListarTodos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 410, 114);
		contentPane.add(scrollPane);
		
		tabCoordenador = new JTable();
		tabCoordenador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Status", "ID Coordenador(a)", "C\u00F3digo do(a) Coordenador(a)", "Nome", "Senha", "Email", "Celular"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, int.class, int.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabCoordenador.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabCoordenador.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabCoordenador.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabCoordenador.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabCoordenador.getColumnModel().getColumn(5).setPreferredWidth(120);
		tabCoordenador.getColumnModel().getColumn(6).setPreferredWidth(110);
		
		scrollPane.setViewportView(tabCoordenador);
		tabCoordenador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeCoordenador = cmbCoordenador.getSelectedItem().toString();
					
					CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
					Coordenador coordenador = new Coordenador();
					coordenador = coordenadorDAO.Consultar2(nomeCoordenador);
					 
					if (nomeCoordenador.equals(coordenador.getNome())) {
						List<Coordenador> lista = new ArrayList<Coordenador>();
						lista = coordenadorDAO.ListarTodos3(nomeCoordenador);
						DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
						model.setNumRows(0);
						for (Coordenador coordenador1 : lista) {
							model.addRow (new Object[] {
									coordenador1.getStatus(),
									coordenador1.getIdCoordenador(),
									coordenador1.getCodCoordenador(),
									coordenador1.getNome(),
									coordenador1.getSenha(),
									coordenador1.getEmail(),
									coordenador1.getCelular(),
								});
						} 
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Consulta realizada com sucesso!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
					else {
						Object[] options = {"OK"};
						ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/high-priority.png")));
						JOptionPane.showOptionDialog(null, "Coordenador não cadastrado!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
					}
				} catch (Exception e1) {
					Object[] options = {"OK"};
					ImageIcon icon = new ImageIcon(getToolkit().createImage(getClass().getResource("/br/com/exemplo/view/images/error.png")));
					JOptionPane.showOptionDialog(null, "Erro ao Consultar Coordenador!!. "
							+ "\n\nErro: " + e1, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Tela_ConsultarCoordenador.class.getResource("/br/com/exemplo/view/images/search.png")));
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar.setBounds(360, 14, 60, 43);
		contentPane.add(btnConsultar);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(0, 68, 476, 2);
		contentPane.add(separator_3);
		
		btnListarCoordenadoresAtivos = new JButton("Listar Ativos");
		btnListarCoordenadoresAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Ativo";
					
					List<Coordenador> lista = new ArrayList<Coordenador>();
					CoordenadorDAO coordenadoDao = new CoordenadorDAO();
					lista = coordenadoDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
					model.setNumRows(0);
					for (Coordenador coordenador1 : lista) {
						model.addRow (new Object[] {
								coordenador1.getStatus(),
								coordenador1.getIdCoordenador(),
								coordenador1.getCodCoordenador(),
								coordenador1.getNome(),
								coordenador1.getSenha(),
								coordenador1.getEmail(),
								coordenador1.getCelular(),
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
		btnListarCoordenadoresAtivos.setBounds(15, 81, 123, 23);
		contentPane.add(btnListarCoordenadoresAtivos);
		
		btnListarDesativados = new JButton("Listar Inativos");
		btnListarDesativados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = "Desativado";
					
					List<Coordenador> lista = new ArrayList<Coordenador>();
					CoordenadorDAO coordenadoDao = new CoordenadorDAO();
					lista = coordenadoDao.ListarTodos4(status);
					
					DefaultTableModel model = (DefaultTableModel) tabCoordenador.getModel();
					model.setNumRows(0);
					for (Coordenador coordenador1 : lista) {
						model.addRow (new Object[] {
								coordenador1.getStatus(),
								coordenador1.getIdCoordenador(),
								coordenador1.getCodCoordenador(),
								coordenador1.getNome(),
								coordenador1.getSenha(),
								coordenador1.getEmail(),
								coordenador1.getCelular(),
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
		btnListarDesativados.setBounds(153, 81, 123, 23);
		contentPane.add(btnListarDesativados);
	}
}
