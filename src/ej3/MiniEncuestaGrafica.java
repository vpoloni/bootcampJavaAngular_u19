package ej3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;

public class MiniEncuestaGrafica extends JFrame {
	
	private static final long serialVersionUID = 1L;

	// definimos las variables globales para hacer uso de ellas en diferentes métodos
	private JRadioButton linux;
	private JRadioButton windows;
	private JRadioButton mac;

	private JCheckBox programacion;
	private JCheckBox disenyoGrafico;
	private JCheckBox administracion;

	private JSlider sliderHoras;
	
	// el método main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// instanciamos la clase MiniEncuestaGrafica
					MiniEncuestaGrafica frame = new MiniEncuestaGrafica();
					// hacemos visible el objeto de la clase
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MiniEncuestaGrafica() {

		// seteamos el título de la ventana
		setTitle("Encuesta");
		// llamamos al método que hace salida de la app al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// establecemos las dimensiones de la ventana
		setBounds(100, 100, 450, 300);

		
		// creamos el panel
		JPanel contentPane = new JPanel();
		// seteamos el absolute layout
		contentPane.setLayout(null);
		// asignamos el panel a la ventana
		setContentPane(contentPane);
 
		
		
		// creamos el label de SO
		JLabel elegirSistema = new JLabel("Elige un sistema operativo:");
		elegirSistema.setBounds(10, 10, 160, 27);
		contentPane.add(elegirSistema);
		// creamos el botón de linux
		linux = new JRadioButton("Linux", true);
		linux.setBounds(20, 43, 103, 21);
		linux.setActionCommand("Linux");
		contentPane.add(linux);
		// creamos el botón de windows
		windows = new JRadioButton("Windows", false);
		windows.setBounds(20, 69, 103, 21);
		windows.setActionCommand("Windows");
		contentPane.add(windows);
		// creamos el botón de mac
		mac = new JRadioButton("Mac", false);
		mac.setBounds(20, 92, 103, 21);
		mac.setActionCommand("Mac");
		contentPane.add(mac);

		// agrupamos todos los botones
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(linux);
		bgroup.add(windows);
		bgroup.add(mac);

		
		
		// creamos el label de especialidad
		JLabel elegirEspecialidad = new JLabel("Elige tu especialidad:");
		elegirEspecialidad.setBounds(235, 17, 180, 13);
		contentPane.add(elegirEspecialidad);
		// creamos el checkBox de programación
		programacion = new JCheckBox("Programaci\u00F3n", true);
		programacion.setBounds(235, 43, 93, 21);
		contentPane.add(programacion);
		// creamos el checkBox de diseño gráfico
		disenyoGrafico = new JCheckBox("Dise\u00F1o gr\u00E1fico", true);
		disenyoGrafico.setBounds(235, 69, 93, 21);
		contentPane.add(disenyoGrafico);
		// creamos el checkBox de administración
		administracion = new JCheckBox("Administraci\u00F3n", false);
		administracion.setBounds(235, 92, 93, 21);
		contentPane.add(administracion);

		
		
		// creamos el label de horas
		JLabel indicaHoras = new JLabel("Indica horas dedicadas en el ordenador:");
		indicaHoras.setBounds(103, 143, 244, 13);
		contentPane.add(indicaHoras);
		// creamos el slider para horas
		sliderHoras = new JSlider();
		sliderHoras.setSnapToTicks(true);
		sliderHoras.setPaintTicks(true);
		sliderHoras.setPaintLabels(true);
		sliderHoras.setMaximum(10);
		sliderHoras.setMinorTickSpacing(1);
		sliderHoras.setMajorTickSpacing(1);
		sliderHoras.setBounds(50, 166, 318, 44);
		contentPane.add(sliderHoras);

		
		
		// creamos el botón que recoge toda la info
		JButton botonMostrar = new JButton("Mostrar datos");
		botonMostrar.setBounds(145, 221, 124, 21);
		contentPane.add(botonMostrar);

		// llamamos a los métodos al pulsar el botón de mostrar datos
		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema operativo: " + obtenerSistemaOperativo()
						+ "\n Especialidades: " + obtenerEspecialidad() + "\n Horas: " + obtenerHoras());
			}
		});

	}

	// el método que obtiene el sístema operativo pulsado
	public String obtenerSistemaOperativo() {
		String botonSistemaOperativoSeleccionado = "";

		if (linux.isSelected()) {
			botonSistemaOperativoSeleccionado = linux.getText();
		} else if (windows.isSelected()) {
			botonSistemaOperativoSeleccionado = windows.getText();
		} else if (mac.isSelected()) {
			botonSistemaOperativoSeleccionado = mac.getText();
		}
		return botonSistemaOperativoSeleccionado;
	}

	// el método que obtiene las especialidades seleccionadas
	public String obtenerEspecialidad() {
		String checkboxEspecialidadSeleccionada = "";

		if (programacion.isSelected()) {
			checkboxEspecialidadSeleccionada += programacion.getText() + " ";
		}
		if (disenyoGrafico.isSelected()) {
			checkboxEspecialidadSeleccionada += disenyoGrafico.getText() + " ";
		}
		if (administracion.isSelected()) {
			checkboxEspecialidadSeleccionada += administracion.getText() + " ";
		}
		return checkboxEspecialidadSeleccionada;

	}

	// el método que obtiene la cantidad de horas seleccionadas en slider
	public int obtenerHoras() {
		int sliderHorasSeleccionadas = 0;
		sliderHorasSeleccionadas = sliderHoras.getValue();
		return sliderHorasSeleccionadas;
	}
}
