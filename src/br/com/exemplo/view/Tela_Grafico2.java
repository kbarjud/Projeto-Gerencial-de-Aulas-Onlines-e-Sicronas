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
import br.com.exemplo.dao.DisciplinaDAO;
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.GraficoD1;
import br.com.exemplo.model.GraficoD2;
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

public class Tela_Grafico2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblDisciplina;
	private JComboBox cmbDisciplina;
	private JLabel lblDataInicio;
	private JDateChooser dteDataInicio;
	private JLabel lblSemestre;
	private JComboBox cmbSemestreLetivo;
	private JLabel lblPeriodo;
	private JComboBox cmbPeriodo;
	private JDateChooser dteDataFim;
	private JLabel lblDataFim;
	private JButton btnGrafico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Grafico2 frame = new Tela_Grafico2();
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
	public Tela_Grafico2() {
		setTitle("Gerar Gr\u00E1fico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Grafico1.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 296);
		this.setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102), new Color(204, 102, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisciplina.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDisciplina.setBounds(10, 11, 61, 21);
		contentPane.add(lblDisciplina);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					String status = "Ativo";
					
					List<Curso> lista = new ArrayList<Curso>();
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					lista = disciplinaDAO.ListarTodosAtivos();
					DefaultComboBoxModel model = new DefaultComboBoxModel(lista.toArray());
					cmbDisciplina.setModel(model);
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
		cmbDisciplina.setForeground(Color.BLACK);
		cmbDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbDisciplina.setBounds(10, 37, 239, 21);
		contentPane.add(cmbDisciplina);
		
		lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataInicio.setBounds(20, 137, 77, 21);
		contentPane.add(lblDataInicio);
		
		dteDataInicio = new JDateChooser();
		dteDataInicio.setBounds(121, 137, 108, 21);
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
		
		dteDataFim = new JDateChooser();
		dteDataFim.setBounds(121, 169, 108, 21);
		contentPane.add(dteDataFim);
		
		lblDataFim = new JLabel("Data Fim");
		lblDataFim.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataFim.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDataFim.setBounds(20, 169, 77, 21);
		contentPane.add(lblDataFim);
		
		btnGrafico = new JButton("");
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String disciplina = cmbDisciplina.getSelectedItem().toString();
				String semestre = cmbSemestreLetivo.getSelectedItem().toString();
				String periodo = cmbPeriodo.getSelectedItem().toString();
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
						String sql = ("SELECT dad.turma, dad.curso, dad.disciplina, dad.periodo, FORMAT(AVG(dad.qtd_alunos),0) AS QTD_ALUNOS, CEILING((AVG(dad.qtd_alunos) / ALUNOS_MATRICULADOS) * 100) AS PORCENTAGEM, tur.ALUNOS_MATRICULADOS" + 
								" FROM  gerencial_aulas.dados_aulas as dad" + 
								" JOIN gerencial_aulas.turma as tur ON tur.ID_TURMA = dad.ID_TURMA" + 
								" WHERE dad.DISCIPLINA LIKE ?" + 
								" AND tur.DISCIPLINA LIKE ?" + 
								" AND dad.TEVE_AULA = 1" + 
								" AND dad.DATA_AULA BETWEEN ? AND ?" + 
								" AND dad.PERIODO = ?" + 
								" AND dad.SEMESTRE_LETIVO = ?" + 
								" GROUP BY dad.id_turma");
						ps = conn.prepareStatement(sql);

						ps.setString(1, disciplina);
						ps.setString(2, disciplina);
						ps.setString(3, dataInicio);
						ps.setString(4, dataFim);
						ps.setString(5, periodo);
						ps.setString(6, semestre);
						//JOptionPane.showMessageDialog(null, ps);
						rs = ps.executeQuery();

						while (rs.next()) {
							String turmaBD = rs.getString("turma");
							String cursoBD = rs.getString("curso");
							String disciplinaBD = rs.getString("disciplina");
							String periodoBD = rs.getString("periodo");
							int alunosOnBD = rs.getInt("QTD_ALUNOS");
							String porcentagem = rs.getString("PORCENTAGEM");
							int alunosTotalBD = rs.getInt("ALUNOS_MATRICULADOS");

							porcentagem = "(" + porcentagem +"%)";
							String alunosBD = alunosOnBD + "/" + alunosTotalBD;

							my_bar_chart_dataset.addValue(alunosOnBD, cursoBD + " | " +turmaBD+ " - " + alunosBD+(porcentagem), "");
						}
						
						SimpleDateFormat formatarDataBR = new SimpleDateFormat("dd/MM/yyyy");
						
						String dataInicioBR = formatarDataBR.format(dteDataInicio.getDate());
						String dataFimBR = formatarDataBR.format(dteDataFim.getDate());

						JFreeChart BarChartObject = ChartFactory.createBarChart3D(
								"Presença média de alunos por turma em uma disciplina \n Disciplina: " + disciplina + " - " + periodo + "\n De: "
										+ dataInicioBR + " até: " + dataFimBR + "\n Semestre: "+semestre,
								"Turma", "Alunos", my_bar_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
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
						plot.getRenderer().setSeriesPaint(10, new Color(255, 255, 255));

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
						GraficoD2 grafico2 = new GraficoD2();
						grafico2.GerarGrafico2(painel);
						
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
		btnGrafico.setBounds(95, 204, 60, 43);
		contentPane.add(btnGrafico);
	}

		
}
