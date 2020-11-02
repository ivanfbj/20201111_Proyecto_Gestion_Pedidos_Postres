package software;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GuiRegistrarPostre extends JFrame {

    JTextField nombreDelPostre, cantidadDeCalorias, fechaVencimiento, precio, temperaturaMantenimiento, tiempoMaximoSinRefrigeracionHoras;
    ButtonGroup HorneadoRefrigeradoButtonGroup;
    JRadioButton esHorneado, esRefrigerado, esHojaldrado;
    JButton guardarButton, limpiarCamposButton, mostrarPostresButton;
    JLabel temperatura, tiempoSinRefrigerar;

	static ArrayList<Postre> postres = new ArrayList<Postre>();

	public GuiRegistrarPostre() {
		setTitle("Registrar Postre");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		// setLayout(null);
		// pack();

		add(new JLabel("Nombre del postre:"));
		add(nombreDelPostre = new JTextField(20));

		add(new JLabel("Cantidad de calorias:"));
		add(cantidadDeCalorias = new JTextField(20));

		add(new JLabel("Fecha de vencimiento:"));
		add(fechaVencimiento = new JTextField(20));

		add(new JLabel("Precio:"));
		add(precio = new JTextField(7));

		// add(new JLabel("Tipo de postre:"));
		HorneadoRefrigeradoButtonGroup = new ButtonGroup();
		add(esHorneado = new JRadioButton("Horneado"));
		add(esRefrigerado = new JRadioButton("Refrigerado"));
                add(esHojaldrado = new JRadioButton("Hojaldrado"));
                HorneadoRefrigeradoButtonGroup.add(esHorneado);
                HorneadoRefrigeradoButtonGroup.add(esRefrigerado);

                esHojaldrado.setVisible(false);
                
                esHorneado.addActionListener(new esHorneadoAccion());
                
		add(temperatura = new JLabel("Temperatura de mantenimiento:")).setVisible(false);
		add(temperaturaMantenimiento = new JTextField(10));

		add(tiempoSinRefrigerar = new JLabel("Tiempo maximo sin refrigeracion:")).setVisible(false);
		add(tiempoMaximoSinRefrigeracionHoras = new JTextField(9));
                
                temperaturaMantenimiento.setVisible(false);
                tiempoMaximoSinRefrigeracionHoras.setVisible(false);
                
                esRefrigerado.addActionListener(new esRefrigeradoAccion());
                
                
		add(guardarButton = new JButton("Guardar"));
		guardarButton.addActionListener(new Guardar());

		add(limpiarCamposButton = new JButton("Limpiar campos"));
		limpiarCamposButton.addActionListener(new LimpiarCampos());

		add(mostrarPostresButton = new JButton("Mostrar postres registrados"));
		mostrarPostresButton.addActionListener(new AccionMostrarRegistros());

		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class Guardar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//if (nombreDelPostre.getText().equals("") || cantidadDeCalorias.getText().equals("") || fechaVencimiento.getText().equals("") || precio.getText().equals("")
					//|| temperaturaMantenimiento.getText().equals("") || tiempoMaximoSinRefrigeracionHoras.getText().equals("")
					//|| (esHorneado.isSelected() == false & esRefrigerado.isSelected() == false)) {

				//JOptionPane.showMessageDialog(null, "Por favor verificar que todos los campos esten diligenciados", "FALTA INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                

				JOptionPane.showMessageDialog(null, "El postre fue registrado exitosamente.");
                                
                                if(esHorneado.isSelected()){
                                    
                                    //PostreHorneado Horneado = new PostreHorneado(nombrePostre.getText(), cantidadDeCalorias,  fechaVencimiento,  precio,  esHojaldrado);
                                    
                                    JOptionPane.showMessageDialog(null, "Es horneado ha sido selecionado");
                                }

				nombreDelPostre.setText(null);
				cantidadDeCalorias.setText(null);
				fechaVencimiento.setText(null);
				precio.setText(null);
				temperaturaMantenimiento.setText(null);
				tiempoMaximoSinRefrigeracionHoras.setText(null);
				HorneadoRefrigeradoButtonGroup.clearSelection();
			}
		}
	}

	class LimpiarCampos implements ActionListener {

		public void actionPerformed(ActionEvent e) {
/*
			nombreDelPostre.setText(null);
			cantidadDeCalorias.setText(null);
			fechaVencimiento.setText(null);
			precio.setText(null);
			temperaturaMantenimiento.setText(null);
			tiempoMaximoSinRefrigeracionHoras.setText(null);
			HorneadoRefrigeradoButtonGroup.clearSelection();
*/
		}
	}

	class AccionMostrarRegistros implements ActionListener {

		public void actionPerformed(ActionEvent e) {
/*
			String listadoDePostres = "";
			for (int i = 0; i < postres.size(); i++) {
				listadoDePostres += postres.get(i).toString() + "\n";

			}
			JOptionPane.showMessageDialog(null, listadoDePostres);
*/
		}
	}
        
        class esHorneadoAccion implements ActionListener {

		public void actionPerformed(ActionEvent e) {
           /*         
                    esHojaldrado.setVisible(true);
                    
                     temperaturaMantenimiento.setVisible(false);
                tiempoMaximoSinRefrigeracionHoras.setVisible(false);
                temperatura.setVisible(false);
                tiempoSinRefrigerar.setVisible(false);
*/
                }
        }
        
        class esRefrigeradoAccion implements ActionListener {

		          public void actionPerformed(ActionEvent e) {
/*
                esHojaldrado.setVisible(false);

                temperaturaMantenimiento.setVisible(true);
                tiempoMaximoSinRefrigeracionHoras.setVisible(true);
                temperatura.setVisible(true);
                tiempoSinRefrigerar.setVisible(true);

            }
        }
*/

}
        }//quitar al descomentarear
