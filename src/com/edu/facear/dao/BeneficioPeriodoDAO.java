package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioPeriodo;




public class BeneficioPeriodoDAO extends GenericDAO {
	private PreparedStatement ps;
	
	
	private String INSERT = "INSERT INTO beneficio_periodo (descricao) VALUES (?);";
	private String UPDATE = "UPDATE beneficio_periodo SET descricao = ? WHERE idBeneficioPeriodo = ?";	
	private String SELECT = "SELECT * FROM beneficio_periodo";
	private String DELETE = "DELETE FROM beneficio_periodo WHERE idBeneficioPeriodo = ?";

	
	public List<BeneficioPeriodo> listar() {
		List<BeneficioPeriodo> lista = new ArrayList<BeneficioPeriodo>();

		try {
			openConnection();

			ps = connect.prepareStatement(SELECT);


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					BeneficioPeriodo beneficioPeriodo = new BeneficioPeriodo(rs.getInt("idBeneficioPeriodo"), rs.getString("descricao"));
					lista.add(beneficioPeriodo);
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
	

	public boolean deletar(Integer id) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(DELETE);

			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				exito = true;
			}

			closeConnection();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exito;
	}

	public boolean cadastrar(BeneficioPeriodo beneficioPeriodo) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(INSERT);
			ps.setString(1, beneficioPeriodo.getDescricao());
			

			if (ps.executeUpdate() > 0) {
				exito = true;
			}

			closeConnection();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exito;
	}

	public boolean atualizar(BeneficioPeriodo beneficioPeriodo) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(UPDATE);
			ps.setString(1, beneficioPeriodo.getDescricao());
			
			ps.setInt(2, beneficioPeriodo.getId());

			if (ps.executeUpdate() > 0) {
				exito = true;
			}

			closeConnection();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exito;
	}

	

}
