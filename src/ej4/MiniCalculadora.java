package ej4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class MiniCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;

	// definimos las variables globales para hacer uso de ellas en diferentes m�todos
	private JPanel contentPane;
	private JTextField operando1;
	private JTextField operando2;
	private JTextField resultado;

	private JButton suma;
	private JButton resta;
	private JButton multiplicacion;
	private JButton division;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// instanciamos la clase MiniCalculadora
					MiniCalculadora frame = new MiniCalculadora();
					// hacemos visible el objeto de la clase
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MiniCalculadora() {

		// el t�tulo de la ventana
		setTitle("MiniCalculadora");
		// llamamos al m�todo que hace salida de la app al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// establecemos las dimensiones de la ventana
		setBounds(100, 100, 450, 300);
		// creamos el panel
		contentPane = new JPanel();
		// layout absolute
		contentPane.setLayout(null);
		// asignamos el panel a la ventana
		setContentPane(contentPane);

		// el textfield del operando 1
		operando1 = new JTextField();
		operando1.setBounds(96, 26, 62, 19);
		contentPane.add(operando1);
		operando1.setColumns(10);
		// el textfield del operando 2
		operando2 = new JTextField();
		operando2.setBounds(96, 55, 62, 19);
		contentPane.add(operando2);
		operando2.setColumns(10);
		// el textfield del resultado
		resultado = new JTextField();
		resultado.setBounds(96, 192, 62, 19);
		contentPane.add(resultado);
		resultado.setColumns(10);

		// la etiqueta para el textfield operando 1
		JLabel operando1Etiqueta = new JLabel("operando 1:");
		operando1Etiqueta.setBounds(10, 26, 116, 19);
		contentPane.add(operando1Etiqueta);
		// la etiqueta para el textfield operando 2
		JLabel operando2Etiqueta = new JLabel("operando 2:");
		operando2Etiqueta.setBounds(10, 55, 114, 19);
		contentPane.add(operando2Etiqueta);
		// la etiqueta para el textfield resultado
		JLabel resultadoEtiqueta = new JLabel("resultado:");
		resultadoEtiqueta.setBounds(11, 186, 75, 30);
		contentPane.add(resultadoEtiqueta);
		// la etiqueta para botones de operaciones matem�ticas
		JLabel operacionRealizar = new JLabel("operaci\u00F3n a realizar:");
		operacionRealizar.setBounds(10, 95, 121, 13);
		contentPane.add(operacionRealizar);

		// el bot�n para salir de la app
		JButton botonSalir = new JButton("salir");
		botonSalir.setBounds(306, 168, 74, 21);
		contentPane.add(botonSalir);
		// el bot�n para mostrar about
		JButton botonAbout = new JButton("about");
		botonAbout.setBounds(306, 213, 74, 21);
		contentPane.add(botonAbout);
		
		// los botones de operaciones matem�ticas
		suma = new JButton("+");
		suma.setBounds(34, 118, 54, 21);
		contentPane.add(suma);

		resta = new JButton("-");
		resta.setBounds(34, 149, 54, 21);
		contentPane.add(resta);

		multiplicacion = new JButton("*");
		multiplicacion.setBounds(126, 118, 62, 21);
		contentPane.add(multiplicacion);

		division = new JButton("/");
		division.setBounds(126, 149, 62, 21);
		contentPane.add(division);

		// invocamos el m�todo  al hacer click sobre el bot�n suma
		suma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(String.format("%.2f", obtenerResultado("suma")));
			}
		});
		// invocamos el m�todo  al hacer click sobre el bot�n resta
		resta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(String.format("%.2f", obtenerResultado("resta")));
			}
		});
		// invocamos el m�todo  al hacer click sobre el bot�n multiplicaci�n
		multiplicacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(String.format("%.2f", obtenerResultado("multiplicaci�n")));
			}
		});
		// invocamos el m�todo  al hacer click sobre el bot�n divisi�n
		division.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// comprobamos el valor de operando2
				if (Double.parseDouble(operando2.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
				} else {
					resultado.setText(String.format("%.2f", obtenerResultado("division")));
				}
			}
		});
		// invocamos el m�todo que cierra la app al pulsar el bot�n de salir 
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		// mostramos el mensaje al pulsar el bot�n de about
		botonAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bootcamp Java&Angular");
			}
		});

	}
	// el m�todo que retorna el resultado de la operaci�n matem�tica pulsada
	public double obtenerResultado(String operacion) {

		double resultadoOperacion = 0;

		switch (operacion) {

		case "suma":
			resultadoOperacion = Double.parseDouble(operando1.getText()) + Double.parseDouble(operando2.getText());
			break;
		case "resta":
			resultadoOperacion = Double.parseDouble(operando1.getText()) - Double.parseDouble(operando2.getText());
			break;
		case "multiplicaci�n":
			resultadoOperacion = Double.parseDouble(operando1.getText()) * Double.parseDouble(operando2.getText());
			break;
		case "division":
			resultadoOperacion = Double.parseDouble(operando1.getText()) / Double.parseDouble(operando2.getText());

		}

		return resultadoOperacion;

	}

}
