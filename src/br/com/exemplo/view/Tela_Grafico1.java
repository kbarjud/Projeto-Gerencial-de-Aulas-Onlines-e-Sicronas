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
import br.com.exemplo.dao.SemestreLetivoDAO;
import br.com.exemplo.dao.TurmaDAO;
import br.com.exemplo.model.Curso;
import br.com.exemplo.model.SemestreLetivo;
import br.com.exemplo.model.Turma;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

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
	private JTextField txtTurma;
	private JLabel lblTurma;
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
					Tela_Grafico1 frame = new Tela_Grafico1();
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
	public Tela_Grafico1() {
		setTitle("S. Ger. Registros de Aulas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Grafico1.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 360);
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
		cmbCurso.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					String status = "Ativo";
					
					List<Curso> lista = new ArrayList<Curso>();
					CursoDAO cursoDao = new CursoDAO();
					lista = cursoDao.ListarTodos2(status);
					DefaultComboBoxModel model = new DefaultComboBoxModel(lista.toArray());
					cmbCurso.setModel(model);
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
		
		txtTurma = new JTextField();
		txtTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTurma.setBounds(91, 159, 77, 20);
		contentPane.add(txtTurma);
		txtTurma.setColumns(10);
		
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
				String turma = txtTurma.getText();
				SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
				String dataInicio, dataFim;
				dataInicio = formatarData.format(dteDataInicio.getDate());
				dataFim = formatarData.format(dteDataFim.getDate());
				
			}
		});
		btnGrafico.setIcon(new ImageIcon(Tela_Grafico1.class.getResource("/br/com/exemplo/view/images/positive-dynamic--v1.png")));
		btnGrafico.setToolTipText("Gr\u00E1fico");
		btnGrafico.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGrafico.setBounds(99, 267, 60, 43);
		contentPane.add(btnGrafico);
	}
}
