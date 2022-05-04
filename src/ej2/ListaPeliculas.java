package ej2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ListaPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tituloPeliculaEscrito;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// instanciamos la clase ListaPeliculas
					ListaPeliculas frame = new ListaPeliculas();
					// hacemos visible el objeto de la clase
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListaPeliculas() {
		
		// el t�tulo de la ventana
		setTitle("Pel\u00EDculas");
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
		
		
		// la etiqueta que pide escribir el t�tulo de la pel�cula
		JLabel escibitTituloEtiqueta = new JLabel("Escribe el t\u00EDtulo de una pel\u00EDcula:");
		escibitTituloEtiqueta.setBounds(28, 24, 199, 21);
		contentPane.add(escibitTituloEtiqueta);
		
		// el textField para introducir el t�tulo de la pel�cula
		tituloPeliculaEscrito = new JTextField();
		tituloPeliculaEscrito.setBounds(28, 55, 141, 28);
		contentPane.add(tituloPeliculaEscrito);
	
		
		// la etiqueta de pel�culas 
		JLabel peliculasEtiqueta = new JLabel("Pel\u00EDculas:");
		peliculasEtiqueta.setBounds(204, 109, 76, 13);
		contentPane.add(peliculasEtiqueta);
		
		// el comboBox para coger los t�tulos introducidos
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(204, 143, 128, 21);
		contentPane.add(comboBox);
		
		
		// el bot�n que a�ade los t�tulos al comboBox
		JButton botonAnyadir = new JButton("A\u00F1adir");
		botonAnyadir.setBounds(28, 105, 85, 21);
		contentPane.add(botonAnyadir);
		
		// a�adimos el valor al comboBox al pulsar el bot�n de a�adir
		botonAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem(tituloPeliculaEscrito.getText());
						
			}
		});
		
	}
}
