package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.Periodo;




public class PeriodoDAO extends GenericDAO {
	private PreparedStatement ps;
	
	
	private String SELECT = "SELECT * FROM beneficio_periodo";

	
	public List<Periodo> listar() {
		List<Periodo> lista = new ArrayList<Periodo>();

		try {
			openConnection();

			ps = connect.prepareStatement(SELECT);


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Periodo periodo = new Periodo(rs.getInt("idBeneficioPeriodo"), rs.getString("descricao"));
					lista.add(periodo);
				}
			}

			closeConnection();
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
	
	

}
