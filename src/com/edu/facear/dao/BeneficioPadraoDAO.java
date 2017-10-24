package com.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;




public class BeneficioPadraoDAO extends GenericDAO {
	private PreparedStatement ps,psBeneficio,psPeriodo;
	
	
	private String INSERT = "INSERT INTO beneficioPadrao (Beneficio_idBeneficio, valor, descontoReal, descontoPorCento, Periodo_idPeriodo) VALUES (?,?,?,?,?);";
	private String UPDATE = "UPDATE beneficioPadrao SET Beneficio_idBeneficio = ?, valor = ?, descontoReal = ?, descontoPorCento = ?, Periodo_idPeriodo = ? WHERE idBeneficioPadrao = ?";	
	private String SELECT = "SELECT * FROM beneficioPadrao";
	private String DELETE = "DELETE FROM beneficioPadrao WHERE idBeneficioPadrao = ?";

	
	public List<BeneficioPadrao> listar() {
		List<BeneficioPadrao> lista = new ArrayList<BeneficioPadrao>();

		try {
			openConnection();

			ps = connect.prepareStatement(SELECT);


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					
					// Populando objeto Beneficio
					
					psBeneficio = connect.prepareStatement("SELECT * FROM beneficio WHERE idBeneficio = ? ");
					psBeneficio.setInt(1, rs.getInt("Beneficio_idBeneficio"));
					ResultSet rsBeneficio = psBeneficio.executeQuery();
								
					Beneficio beneficio = null;
					
					if(rs.first()) {
					beneficio = new Beneficio(rsBeneficio.getInt("idBeneficio"), rsBeneficio.getString("descricao"));
					}
					
					
					// Populando objeto Periodo Beneficio
					
					psPeriodo = connect.prepareStatement("SELECT * FROM beneficio_periodo WHERE idPeriodo = ? ");
					psPeriodo.setInt(1, rs.getInt("Periodo_idPeriodo"));
					ResultSet rsPeriodo = psPeriodo.executeQuery();
								
					BeneficioPeriodo periodo = null;
					
					if(rs.first()) {
					periodo = new BeneficioPeriodo(rsPeriodo.getInt("idPeriodo"), rsPeriodo.getString("descricao"));
					}
					
					
					
					
					BeneficioPadrao beneficioPadrao = new BeneficioPadrao(beneficio,rs.getInt("idBeneficioPadrao"),rs.getDouble("valor"),rs.getDouble("descontoReal"),rs.getFloat("descontoPorCento"), periodo);
					lista.add(beneficioPadrao);
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

	public boolean cadastrar(BeneficioPadrao beneficioPadrao) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(INSERT);
			ps.setInt(1, beneficioPadrao.getBeneficio().getId());
			ps.setDouble(2, beneficioPadrao.getValorBeneficio());
			ps.setDouble(3, beneficioPadrao.getDescReal());
			ps.setFloat(4, beneficioPadrao.getDescPorCento());
			ps.setInt(5, beneficioPadrao.getBeneficioPeriodo().getId());
			

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

	public boolean atualizar(BeneficioPadrao beneficioPadrao) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement(UPDATE);
			
			ps.setInt(1, beneficioPadrao.getBeneficio().getId());
			ps.setDouble(2, beneficioPadrao.getValorBeneficio());
			ps.setDouble(3, beneficioPadrao.getDescReal());
			ps.setFloat(4, beneficioPadrao.getDescPorCento());
			ps.setInt(5, beneficioPadrao.getBeneficioPeriodo().getId());
			ps.setInt(6, beneficioPadrao.getId());

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
