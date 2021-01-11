package daoInterfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ConexionSql;
import software.Cliente;
import software.Postre;
import software.PostreHorneado;
import software.PostreRefrigerado;

public class DAOPostre extends ConexionSql {

	private static PreparedStatement pst = null;
	private static ResultSet rs = null;

	public static void registrarPostre(Postre objPostre) throws Exception {
		try {
			DAOPostre.conectar();

			if (objPostre.esRefrigerado()) {
				pst = DAOPostre.conexion.prepareStatement(
						"insert into tbpostres (sNombrePostre,nCantidadDeCalorias,sFechaVencimiento,nPrecio,bEsRefrigerado,nTemperaturaMantenimiento,nTiempoMaximoSinRefrigeracionHoras) values (?,?,?,?,?,?,?);");
				pst.setString(1, objPostre.getNombrePostre());
				pst.setDouble(2, objPostre.getCantidadDeCalorias());
				pst.setString(3, objPostre.getFechaVencimiento());
				pst.setDouble(4, objPostre.getPrecio());
				pst.setInt(5, 1);// este parametro va así
				pst.setDouble(6, ((PostreRefrigerado) objPostre).getTemperaturaMantenimiento());
				pst.setDouble(7, ((PostreRefrigerado) objPostre).getTiempoMaximoSinRefrigeracionHoras());
				pst.execute();
			} else {
				pst = DAOPostre.conexion.prepareStatement("insert into tbpostres (sNombrePostre,nCantidadDeCalorias,sFechaVencimiento,nPrecio,bEsRefrigerado,bEsHojaldrado) values (?,?,?,?,?,?);");
				pst.setString(1, objPostre.getNombrePostre());
				pst.setDouble(2, objPostre.getCantidadDeCalorias());
				pst.setString(3, objPostre.getFechaVencimiento());
				pst.setDouble(4, objPostre.getPrecio());
				pst.setInt(5, 0);// este parametro va así
				pst.setInt(6, ((PostreHorneado) objPostre).getEsHojaldradoInt());
				pst.execute();
			}

		} catch (Exception e) {
			System.out.println("DAOPostre, Error en el insert tbpostres");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}
	}

	public void modificarPostre(Postre objPostre) throws Exception {

	};

	public void eliminarPostre(Postre objPostre) throws Exception {
	};

	public static ArrayList<Postre> listaPostres() throws Exception {
		ArrayList<Postre> listaPostresDeDB = new ArrayList<Postre>();

		try {
			DAOPostre.conectar();
			pst = DAOCliente.conexion.prepareStatement(
					"select nIdPostre,sNombrePostre,nCantidadDeCalorias,sFechaVencimiento,nPrecio,bEsRefrigerado,nTemperaturaMantenimiento,nTiempoMaximoSinRefrigeracionHoras,bEsHojaldrado from tbpostres");
			rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getInt("bEsRefrigerado") == 1) {
					PostreRefrigerado postreRefrigeradoDeDB = new PostreRefrigerado(rs.getString("sNombrePostre"), rs.getDouble("nCantidadDeCalorias"), rs.getString("sFechaVencimiento"),
							rs.getDouble("nPrecio"), rs.getDouble("nTemperaturaMantenimiento"), rs.getDouble("nTiempoMaximoSinRefrigeracionHoras"));
					postreRefrigeradoDeDB.setnIdPostre(rs.getLong("nIdPostre"));
					listaPostresDeDB.add(postreRefrigeradoDeDB);

				} else {
					boolean esHojaldradoDB = (rs.getInt("bEsHojaldrado") == 1) ? true : false;

					PostreHorneado postreHorneadoDeDB = new PostreHorneado(rs.getString("sNombrePostre"), rs.getDouble("nCantidadDeCalorias"), rs.getString("sFechaVencimiento"),
							rs.getDouble("nPrecio"), esHojaldradoDB);
					postreHorneadoDeDB.setnIdPostre(rs.getLong("nIdPostre"));
					listaPostresDeDB.add(postreHorneadoDeDB);

				}

			}

		} catch (Exception e) {
			System.out.println("DAOPostre, Error en el select tbpostres");
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}

		}
		return listaPostresDeDB;
	}

	public static double PorcentajePostresRefrigerado() {
		double porcentaje = 0;

		return porcentaje;

	}

}
