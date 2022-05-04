package ej1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class SaludadorPersonalizable extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// el método main 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// instanciamos la clase SaludadorPersonalizable
					SaludadorPersonalizable frame = new SaludadorPersonalizable();
					// hacemos visible el objeto de la clase
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SaludadorPersonalizable() {

		// el título de la ventana
		setTitle("Saludador");
		// llamamos al método que hace salida de la app al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// establecemos las dimensiones de la ventana
		setBounds(100, 100, 450, 300);
		// creamos el panel
		JPanel contentPane = new JPanel();
		// layout absolute
		contentPane.setLayout(null);
		// asignamos el panel a la ventana
		setContentPane(contentPane);

		// la etiqueta que pide escribir un nombre para saludar
		JLabel nombreSaludarEtiqueta = new JLabel("Escribe un nombre para saludar:");
		nombreSaludarEtiqueta.setBounds(129, 54, 191, 27);
		contentPane.add(nombreSaludarEtiqueta);

		// el textField para introducir el nombre
		JTextField textField = new JTextField();
		textField.setBounds(132, 91, 177, 41);
		contentPane.add(textField);

		// el botón de saludar
		JButton botonSaludar = new JButton("Saludar");
		botonSaludar.setBounds(174, 155, 85, 21);
		contentPane.add(botonSaludar);

		// mostramos el valor introducido en el textField al pulsar el botón de saludar
		botonSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hola, " + textField.getText());
			}
		});

	}
}
