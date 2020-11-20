import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import com.itextpdf.kernel.colors.Color;

import br.com.exemplo.model.Grafico1;
import br.com.exemplo.until.ConnectionFactory;

public class Grafico1DAO {
	private Grafico1 grafico1;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Grafico1DAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void GerarGrafico (String nomeCurso, String turmaCod, String periodo, String semestre, String dataInicio, String dataFim) throws Exception {
		try {
			String sql = ("SELECT dad.turma, dad.curso, dad.disciplina, dad.periodo, dad.qtd_alunos, tur.ALUNOS_MATRICULADOS, DATE_FORMAT(DATA_AULA, '%d/%m/%Y') AS DATA_AULA FROM gerencial_aulas.dados_aulas as dad JOIN gerencial_aulas.turma as tur ON tur.ID_CURSO_DISCIPLINA = dad.ID_CURSO_DISCIPLINA WHERE dad.CURSO LIKE ? AND tur.turma LIKE ? AND dad.TURMA LIKE ? AND tur.PERIODO = ? AND dad.SEMESTRE_LETIVO LIKE ? AND dad.TEVE_AULA = 1 AND dad.DATA_AULA BETWEEN ? AND ?");
			ps = conn.prepareStatement(sql);
			ps.setString(1, nomeCurso);
			ps.setString(2, turmaCod);
			ps.setString(3, turmaCod);
			ps.setString(4, periodo);
			ps.setString(5, semestre);
			ps.setString(6, dataInicio);
			ps.setString(7, dataFim);
			ps.executeUpdate();
			while (rs.next()) {
				String turmaBD = rs.getString("turma");
				String cursoBD = rs.getString("curso");
				String disciplinaBD = rs.getString("disciplina");
				String periodoBD = rs.getString("periodo");
				int alunosOnBD = rs.getInt("QTD_ALUNOS");
				int alunosTotalBD = rs.getInt("ALUNOS_MATRICULADOS");
				String professorBD = rs.getString("NOME");
				String alunosBD = alunosOnBD + "/" + alunosTotalBD;

				my_bar_chart_dataset.addValue(alunosOnBD, cursoBD + " | " +turmaBD+ " - " + alunosBD, "");
				}

				JFreeChart BarChartObject = ChartFactory.createBarChart3D(
				"Presença média de alunos por turma em uma disciplina e professor \n Disciplina: " + disciplina + " - " + periodo + "\nProfessor: "+ professorBD + "\n De: "
				+ dataIni + " até: " + dataFim + "\n Semestre: "+semestre,
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

				ChartPanel painel = new ChartPanel(BarChartObject);
				painel.setBackground(Color.LIGHT_GRAY);
				painel.setMouseZoomable(true);
				criarTela(painel);
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}

