

package software;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GuiPromedioCliente extends JFrame {
    JTextField TotalClientes, TotalClientesDomicilio,EdadPromedioClientes,EdadPromedioClientesDomicilio;
    JButton CalcularPromedio;
    public GuiPromedioCliente(){
        setTitle("Promedio clientes");
        setLayout(new FlowLayout());
        
        add(new JLabel("Total clientes:"));
        add(TotalClientes = new JTextField(20));
        
         add(new JLabel("Total clientes domicilio:"));
        add(TotalClientesDomicilio = new JTextField(20));
        
        
         add(new JLabel("Edad promedio clientes:"));
        add(EdadPromedioClientes = new JTextField(20));
        
         add(new JLabel("Edad promedio clientes domicilio:"));
        add(EdadPromedioClientesDomicilio = new JTextField(10));
        
        add(CalcularPromedio = new JButton("Calcular promedio"));
        // CalcularPromedio.addActionListener(new CalcularPromedio());
        // se crea el boton para calcular la edad promedio del total de ambos clientes.
        
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        
}
   public static void main(String[] args) {
        GuiPromedioCliente ventana = new GuiPromedioCliente();
    }

}
