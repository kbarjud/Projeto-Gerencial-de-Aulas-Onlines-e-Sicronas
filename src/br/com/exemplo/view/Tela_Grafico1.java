package br.com.exemplo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import br.com.exemplo.dao.CursoDAO;
import br.com.exemplo.dao.CursoDisciplinaDAO;
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.CursoDisciplina;
import br.com.exemplo.model.GraficoD1;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.model.Turma;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Tela_Grafico1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblDataInicio;
	private JDateChooser dteDataInicio;
	private JLabel lblSemestre;
	private JComboBox cmbSemestreLetivo;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JLabel lblTurma;
	private JDateChooser dteDataFim;
	private JLabel lblDataFim;
	private JButton btnGrafico;
	private JComboBox cmbTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Grafico1 frame = new Tela_Grafico1();
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
	public Tela_Grafico1() {
		setTitle("Gerar Gr\u00E1fico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Grafico1.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 360);
		this.setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCurso.setBounds(10, 11, 36, 21);
		contentPane.add(lblCurso);
		
		cmbCurso = new JComboBox();
		cmbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String nomeCurso = cmbCurso.getSelectedItem().toString();
					String status = "Ativo";
					String disciplina = "%%";
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
					String disciplina = "%%";
					
					List<Turma> lista2 = new ArrayList<Turma>();
					TurmaDAO turmaDao = new TurmaDAO();
					lista2 = turmaDao.ListarTodos2(nomeCurso, disciplina, status);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(lista2.toArray());
					cmbTurma.setModel(model2);
				}
				catch (Exception e) {
					e.getMessage();
				}
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		cmbCurso.setForeground(Color.BLACK);
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbCurso.setBounds(10, 37, 239, 21);
		contentPane.add(cmbCurso);
		
		lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataInicio.setBounds(24, 200, 77, 21);
		contentPane.add(lblDataInicio);
		
		dteDataInicio = new JDateChooser();
		dteDataInicio.setBounds(125, 200, 108, 21);
		contentPane.add(dteDataInicio);
		
		lblSemestre = new JLabel("Semestre");
		lblSemestre.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemestre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSemestre.setBounds(10, 69, 77, 21);
		contentPane.add(lblSemestre);
		
		cmbSemestreLetivo = new JComboBox();
		cmbSemestreLetivo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					String status = "Ativo";
					
					List<SemestreLetivo> lista = new ArrayList<SemestreLetivo>();
					SemestreLetivoDAO semestreLetivoDao = new SemestreLetivoDAO();
					lista = semestreLetivoDao.ListarTodos4(status);
					DefaultComboBoxModel model = new DefaultComboBoxModel(lista.toArray());
					cmbSemestreLetivo.setModel(model);
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
		cmbSemestreLetivo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbSemestreLetivo.setBounds(10, 95, 100, 21);
		contentPane.add(cmbSemestreLetivo);
		
		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPeriodo.setBounds(120, 69, 59, 21);
		contentPane.add(lblPeriodo);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Matutino", "Vespertino", "Noturno"}));
		cmbPeriodo.setForeground(Color.BLACK);
		cmbPeriodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbPeriodo.setBounds(120, 95, 129, 21);
		contentPane.add(cmbPeriodo);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurma.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTurma.setBounds(108, 127, 42, 21);
		contentPane.add(lblTurma);
		
		dteDataFim = new JDateChooser();
		dteDataFim.setBounds(125, 232, 108, 21);
		contentPane.add(dteDataFim);
		
		lblDataFim = new JLabel("Data Fim");
		lblDataFim.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataFim.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataFim.setBounds(24, 232, 77, 21);
		contentPane.add(lblDataFim);
		
		btnGrafico = new JButton("");
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeCurso = cmbCurso.getSelectedItem().toString();
				String semestre = cmbSemestreLetivo.getSelectedItem().toString();
				String periodo = cmbPeriodo.getSelectedItem().toString();
				String turma = cmbTurma.getSelectedItem().toString();
				SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
				String dataInicio, dataFim;
				dataInicio = formatarData.format(dteDataInicio.getDate());
				dataFim = formatarData.format(dteDataFim.getDate());
				
				PreparedStatement ps;
				ResultSet rs;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerencial_aulas", "root", "");
					DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
					Statement stmt = conn.createStatement();
					try {
						String sql = ("SELECT dad.turma, dad.curso, dad.disciplina, dad.periodo, dad.qtd_alunos, CEILING((dad.qtd_alunos / ALUNOS_MATRICULADOS) * 100) AS PORCENTAGEM, tur.ALUNOS_MATRICULADOS, DATE_FORMAT(DATA_AULA, '%d/%m/%Y') AS DATA_AULA FROM  gerencial_aulas.dados_aulas as dad JOIN gerencial_aulas.turma as tur ON tur.ID_CURSO_DISCIPLINA = dad.ID_CURSO_DISCIPLINA WHERE dad.CURSO LIKE ? AND tur.turma LIKE ? AND dad.TURMA LIKE ? AND tur.PERIODO = ? AND dad.SEMESTRE_LETIVO LIKE ? AND dad.TEVE_AULA = 1 AND dad.DATA_AULA BETWEEN ? AND ?");
						ps = conn.prepareStatement(sql);

						ps.setString(1, nomeCurso);
						ps.setString(2, turma);
						ps.setString(3, turma);
						ps.setString(4, periodo);
						ps.setString(5, semestre);
						ps.setString(6, dataInicio);
						ps.setString(7, dataFim);
						//JOptionPane.showMessageDialog(null, ps);
						rs = ps.executeQuery();

						while (rs.next()) {
							String turmaBD = rs.getString("turma");
							String cursoBD = rs.getString("curso");
							String disciplinaBD = rs.getString("disciplina");
							String periodoBD = rs.getString("periodo");
							int alunosOnBD = rs.getInt("qtd_alunos");
							String porcentagem = rs.getString("PORCENTAGEM");
							int alunosTotalBD = rs.getInt("ALUNOS_MATRICULADOS");
							String dataAula = rs.getString("DATA_AULA");

							porcentagem = "(" + porcentagem +"%)";
							String alunosBD = alunosOnBD + "/" + alunosTotalBD;

							my_bar_chart_dataset.addValue(alunosOnBD, disciplinaBD + " | " + alunosBD+(porcentagem) + " - " + dataAula, "");
						}
						

						SimpleDateFormat formatarDataBR = new SimpleDateFormat("dd/MM/yyyy");
						
						String dataInicioBR = formatarDataBR.format(dteDataInicio.getDate());
						String dataFimBR = formatarDataBR.format(dteDataFim.getDate());

						JFreeChart BarChartObject = ChartFactory.createBarChart3D(
								"Presença de alunos \n Turma: " + turma + " - " + periodo + "\n Curso " + nomeCurso + "\n De: "
										+ dataInicioBR + " até: " + dataFimBR + "",
								"Disciplinas", "Alunos", my_bar_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
						rs.close();
						stmt.close();
						conn.close();

						CategoryPlot plot = BarChartObject.getCategoryPlot();
						plot.getRenderer().setSeriesPaint(0, new Color(252, 38, 23));
						plot.getRenderer().setSeriesPaint(1, new Color(248, 252, 23));
						plot.getRenderer().setSeriesPaint(2, new Color(23, 252, 23));
						plot.getRenderer().setSeriesPaint(3, new Color(23, 221, 252));
						plot.getRenderer().setSeriesPaint(4, new Color(135, 66, 245));
						plot.getRenderer().setSeriesPaint(5, new Color(50, 63, 250));
						plot.getRenderer().setSeriesPaint(6, new Color(230, 50, 250));
						plot.getRenderer().setSeriesPaint(7, new Color(255, 168, 28));
						plot.getRenderer().setSeriesPaint(8, new Color(142, 255, 28));
						plot.getRenderer().setSeriesPaint(9, new Color(28, 255, 210));
						plot.getRenderer().setSeriesPaint(10, new Color(0, 0, 0));

						plot.setBackgroundPaint(new Color(232, 232, 232));
						plot.setRangeGridlinePaint(new Color(84, 84, 84));

						BarChartObject.setBackgroundPaint(new Color(240, 240, 240));
						
						BarRenderer renderer=(BarRenderer)plot.getRenderer();				
						renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
				        renderer.setBaseItemLabelsVisible(true);
				        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
				                TextAnchor.TOP_CENTER);
				        renderer.setBasePositiveItemLabelPosition(position);

						ChartPanel painel = new ChartPanel(BarChartObject);
						painel.setBackground(Color.LIGHT_GRAY);
						painel.setMouseZoomable(true);
						GraficoD1 grafico1 = new GraficoD1();
						grafico1.GerarGrafico1(painel);
						
						dispose();
						
						
						//JOptionPane.showMessageDialog(null, painel);
						
						//getContentPane().add(painel);
					} catch (Exception i) {
						System.out.println(i);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		
		btnGrafico.setIcon(new ImageIcon(Tela_Grafico1.class.getResource("/br/com/exemplo/view/images/positive-dynamic--v1.png")));
		btnGrafico.setToolTipText("Gr\u00E1fico");
		btnGrafico.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrafico.setBounds(99, 267, 60, 43);
		contentPane.add(btnGrafico);
		
		cmbTurma = new JComboBox();
		cmbTurma.setForeground(Color.BLACK);
		cmbTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTurma.setBounds(79, 156, 100, 21);
		contentPane.add(cmbTurma);
	}

		
}
