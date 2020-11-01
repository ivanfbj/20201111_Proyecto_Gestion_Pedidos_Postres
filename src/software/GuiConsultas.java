package software;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiConsultas extends JFrame {

    JTextField cantidadPostres,porcentajePostresRefrigerados, edadPromedioClientesDomicilio;
    JButton calcularCantidad, calcularPorcentaje,calcularPromedio;

    public GuiConsultas() {
        setTitle("Consultas");
        setLayout(new FlowLayout());

        add(new JLabel("Cantidad de postres pedido:"));
        add(cantidadPostres = new JTextField(20));
        cantidadPostres.setEditable(false);

        add(new JLabel("Cantidad de postres refrigerados:"));
        add(porcentajePostresRefrigerados = new JTextField(20));
        porcentajePostresRefrigerados.setEditable(false);

        add(new JLabel("Edad promedio clientes domicilio:"));
        add(edadPromedioClientesDomicilio = new JTextField(20));
        edadPromedioClientesDomicilio.setEditable(false);
        
         add(calcularCantidad = new JButton("Mostrar cantidad"));
        // calcularCantidad.addActionListener(new CalcularPromedio());
        // se crea el boton para mostrar la cantidad de postres por perdido.
        
        
         add(calcularPorcentaje = new JButton("Mostrar porcentaje"));
        // cancularPorcentaje.addActionListener(new CalcularPromedio());
        // se crea el boton para mostrar el porcentaje de posttres refrigerados.
        
        
        add(calcularPromedio = new JButton("Mostrar promedio"));
        // calcularPromedio.addActionListener(new CalcularPromedio());
        // se crea el boton para mostrar la edad promedio del total de ambos clientes.

        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

    }
     class calcularCantidad implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            

        }

    }
     
      class calcularPorcentaje implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

        }

    }

    class calcularPromedio implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

        }

    }

}
