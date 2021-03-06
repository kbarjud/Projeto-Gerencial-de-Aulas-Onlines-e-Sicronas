package br.com.exemplo.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;

import br.com.exemplo.view.Tela_Grafico1;

public class GraficoD3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoD3 frame = new GraficoD3();
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

	
	public GraficoD3() {
		setTitle("Gr\u00E1fico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficoD3.class.getResource("/br/com/exemplo/view/images/graduated.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void GerarGrafico3(ChartPanel painel){
		setSize(1050, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(painel);
		//add(painel);
		setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	void criarTela(ChartPanel painel) {
		setSize(800,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(painel);
		setVisible(true);
		this.setLocationRelativeTo(null);
		}

}
