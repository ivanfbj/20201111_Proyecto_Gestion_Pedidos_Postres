package daoInterfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ConexionSql;
import software.Pedido;
import software.Postre;

public class DAOPedido extends ConexionSql {

	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	public void registrarPedido(Pedido objPedido) throws Exception {
		try {

			
			
		} catch (Exception e) {
			System.out.println("DAOPedido, Error en el insert tbpedidos");
			e.printStackTrace();
		} finally {

		}
	}

	public void modificarPostre(Pedido objPedido) throws Exception {

	};

	public void eliminarPostre(Pedido objPedido) throws Exception {
	};

	public static ArrayList<Postre> listaPostres() throws Exception {
		ArrayList<Postre> listaPedidosDeDB = new ArrayList<Postre>();
		try {

		} catch (Exception e) {
			System.out.println("DAOPostre, Error en el select tbpedidos");
			e.printStackTrace();
		} finally {

		}
		return listaPedidosDeDB;
	}

//REVISAR LA CLASE CONTROLADOR PEDIDO PARA MIGRAR LAS CONEXIONES A ESTA CLASE
	//validarSiExisteCodigoPedido
	//calcularValorTotalDelPedido
	//cantidadDePostresXPedido
	//edadPromedioClientesDomicilio

}
