package com.edu.facear.dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.facear.model.Beneficio;
import com.edu.facear.model.BeneficioLancamento;
import com.edu.facear.model.BeneficioPadrao;
import com.edu.facear.model.BeneficioPeriodo;
import com.mysql.jdbc.Statement;




public class BeneficioLancamentoDAO extends GenericDAO {
	private PreparedStatement ps, psBeneLanc, psPeriodo,psBene;
	
	


	
	public List<BeneficioLancamento> listar() {
		List<BeneficioLancamento> lista = new ArrayList<BeneficioLancamento>();

		try {
			openConnection();

			ps = connect.prepareStatement("SELECT * FROM beneficio_lancamento");


			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					
					ArrayList<BeneficioPadrao> beneficiosPadrao = new ArrayList<BeneficioPadrao>();
					
					
					psBeneLanc = connect.prepareStatement("SELECT * FROM beneficiolancado WHERE idBeneficioLancamento = ?");
					psBeneLanc.setInt(1, rs.getInt("idBeneficioLancamento"));
					
					ResultSet rsBeneLanc = psBeneLanc.executeQuery();
					
					if (rsBeneLanc != null) {
						while (rsBeneLanc.next()) {
							
							
							psPeriodo = connect.prepareStatement("SELECT * FROM beneficio_periodo WHERE idBeneficioPeriodo = ?");
							psPeriodo.setInt(1, rsBeneLanc.getInt("Periodo_idPeriodo"));
							ResultSet rsPeriodo = psPeriodo.executeQuery();
							
							
							BeneficioPeriodo beneficioPeriodo = new BeneficioPeriodo(rsPeriodo.getInt("idBeneficioPeriodo"),rsPeriodo.getString("descricao"));
							
							
							
							
							psBene = connect.prepareStatement("SELECT * FROM beneficio WHERE idBeneficio = ?");
							psBene.setInt(1, rsBeneLanc.getInt("Beneficio_idBeneficio"));
							ResultSet rsBene = psBene.executeQuery();
							
							
							
							Beneficio beneficio = new Beneficio(rsBene.getInt("idBeneficio"),rsBene.getString("descricao"));
							
							
							BeneficioPadrao benefPad = new BeneficioPadrao(beneficio,rsBeneLanc.getInt("idBeneficioLancado"),rsBeneLanc.getDouble("descontoReal"),rsBeneLanc.getDouble("valor"),rsBeneLanc.getFloat("descontoPorCento"),beneficioPeriodo);
							beneficiosPadrao.add(benefPad);
						}
					}
					
					
					
					
					BeneficioLancamento beneficioLancamento = new BeneficioLancamento(rs.getInt("idBeneficioLancamento"),rs.getDate("data"), beneficiosPadrao);
					lista.add(beneficioLancamento);
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

			
			ps = connect.prepareStatement("DELETE FROM beneficiolancado WHERE idBeneficioLancamento = ?");

			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				
				ps = connect.prepareStatement("DELETE FROM beneficio_lancamento WHERE idBeneficioLancamento = ?");

				ps.setInt(1, id);
				
				if (ps.executeUpdate() > 0) {		
				exito = true;
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

		return exito;
	}

	public boolean cadastrar(BeneficioLancamento beneficioLancamento) {
		boolean exito = false;

		try {
			openConnection();

			//UPDATE beneficio SET descricao = ? WHERE idBeneficio = ?
			ps = connect.prepareStatement("INSERT INTO beneficio_lancamento (data) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, beneficioLancamento.getData());
			

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				
					if(rs.first()) {
						
						for(BeneficioPadrao benPad:beneficioLancamento.getBeneficiosPadrao()) {
							psBeneLanc = connect.prepareStatement("INSERT INTO beneficiolancado (Beneficio_idBeneficio, valor, descontoReal, descontoPorCento, Periodo_idPeriodo, idBeneficioLancamento) VALUES (?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
							psBeneLanc.setInt(1, benPad.getBeneficio().getId());
							psBeneLanc.setDouble(2, benPad.getValorBeneficio());
							psBeneLanc.setDouble(3, benPad.getDescReal());
							psBeneLanc.setFloat(4, benPad.getDescPorCento());
							psBeneLanc.setInt(5, benPad.getBeneficioPeriodo().getId());
							psBeneLanc.setInt(6, rs.getInt(1));
							
							if (ps.executeUpdate() > 0) {
								exito = true;
							}
							
						}
						
						
						
							
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

		return exito;
	}

	public boolean atualizar(BeneficioLancamento beneficioLancamento) {
		boolean exito = false;

		try {
			openConnection();

			ps = connect.prepareStatement("UPDATE beneficio_lancamento SET data = ? WHERE idBeneficioLancamento = ?");
			ps.setDate(1, beneficioLancamento.getData());
			ps.setInt(2, beneficioLancamento.getId());
			

			if (ps.executeUpdate() > 0) {
				
				ps = connect.prepareStatement("DELETE FROM beneficiolancado WHERE idBeneficioLancamento = ?");

				ps.setInt(1, beneficioLancamento.getId());
				
				if (ps.executeUpdate() > 0) {
						
						for(BeneficioPadrao benPad:beneficioLancamento.getBeneficiosPadrao()) {
							psBeneLanc = connect.prepareStatement("INSERT INTO beneficiolancado (Beneficio_idBeneficio, valor, descontoReal, descontoPorCento, Periodo_idPeriodo, idBeneficioLancamento) VALUES (?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
							psBeneLanc.setInt(1, benPad.getBeneficio().getId());
							psBeneLanc.setDouble(2, benPad.getValorBeneficio());
							psBeneLanc.setDouble(3, benPad.getDescReal());
							psBeneLanc.setFloat(4, benPad.getDescPorCento());
							psBeneLanc.setInt(5, benPad.getBeneficioPeriodo().getId());
							psBeneLanc.setInt(6, beneficioLancamento.getId());
							
							if (ps.executeUpdate() > 0) {
								exito = true;
							}
							
						}
			
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

		return exito;
	}

	

}
