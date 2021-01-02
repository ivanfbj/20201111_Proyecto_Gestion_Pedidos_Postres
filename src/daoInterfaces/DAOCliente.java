package daoInterfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ConexionSql;
import software.Cliente;

public class DAOCliente extends ConexionSql {

	PreparedStatement pst = null;
	ResultSet rs = null;

	public void registrarCliente(Cliente objCliente) throws Exception {

		try {
			this.conectar();
			pst = this.conexion.prepareStatement("Insert into tbcliente (sNombreCliente,sDireccion,nTelefono,sSexo,nEdad) values (?,?,?,?,?)");
			pst.setString(1, objCliente.getNombreCliente());
			pst.setString(2, objCliente.getDireccion());
			pst.setLong(3, objCliente.getTelefono());
			pst.setString(4, objCliente.getSexo());
			pst.setInt(5, objCliente.getEdad());
			pst.execute();

			System.out.println("DAOCliente, Se ejecutó el insert tbcliente correctamente");

		} catch (Exception e) {
			System.out.println("DAOCliente, Error en el insert tbcliente");
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
		}

	}

	public void modificarCliente(Cliente cliente) throws Exception {

	};

	public void eliminarCliente(Cliente cliente) throws Exception {
	};

	public ArrayList<Cliente> listaClientes() throws Exception {
		ArrayList<Cliente> listaClientesDeDB = new ArrayList<Cliente>();

		try {
			this.conectar();
			pst = this.conexion.prepareStatement("Select sNombreCliente,sDireccion,nTelefono,sSexo,nEdad from tbcliente");
			rs = pst.executeQuery();

			while (rs.next()) {
				Cliente clienteDB = new Cliente(rs.getString("sNombreCliente"), rs.getString("sDireccion"), rs.getLong("nTelefono"), rs.getString("sSexo"), rs.getInt("nEdad"));
				listaClientesDeDB.add(clienteDB);
			}
			System.out.println("DAOCliente, Se consultan correctamente la tabla tbcliente");

		} catch (Exception e) {
			System.out.println("DAOCliente, Error en el select tbcliente");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}
		return listaClientesDeDB;
	}

//	public boolean validarSiExisteCliente() {
//		boolean existeCliente = false;
//		
//		if(DAOCliente.listaClientes().isEmpty()==false) {
//			
//		}
//		
//		
//		
//		return existeCliente;
//		
//	}
	
}
