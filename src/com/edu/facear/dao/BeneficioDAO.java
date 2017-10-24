package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.model.Beneficio;




public class BeneficioDAO extends GenericDAO {
	private PreparedStatement ps;
	
	
	private String INSERT = "INSERT INTO beneficio (descricao) VALUES (?);";
	private String UPDATE = "UPDATE beneficio SET descricao = ? WHERE idBeneficio = ?";	
	private String SELECT = "SELECT * FROM beneficio";
	private String DELETE = "DELETE FROM beneficio WHERE idBeneficio = ?";

	
	public List<Beneficio> listar() {
		List<Beneficio> lista = new ArrayList<Beneficio>();

		try {
			openConnection();

			ps = connect.prepareStatement(SELECT);


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Beneficio beneficio = new Beneficio(rs.getInt("idBeneficio"), rs.getString("descricao"));
					lista.add(beneficio);
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

	public boolean cadastrar(Beneficio beneficio) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(INSERT);
			ps.setString(1, beneficio.getDescricao());
			

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

	public boolean atualizar(Beneficio beneficio) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(UPDATE);
			ps.setString(1, beneficio.getDescricao());
			
			ps.setInt(2, beneficio.getId());

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


	public int ultimoID() {
		int id = 1;
		
		try {
			openConnection();

			ps = connect.prepareStatement("SELECT idBeneficio FROM beneficio ORDER BY idBeneficio DESC LIMIT 1");


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				if(rs.first()) {
					id += rs.getInt("idBeneficio");
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
		
		return id;
		
		
	}

	

}
