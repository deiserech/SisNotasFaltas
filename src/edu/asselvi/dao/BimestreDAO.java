package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.Bimestre;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Usuario;

public class BimestreDAO implements GenericDAO<Bimestre>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE bimestre (" + "	"
					+ " BimestreId		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " descricao		VARCHAR(50) NOT NULL," 
					+ " dataInicio 		DATE NOT NULL," 
					+ "	dataFim			DATE  NOT NULL,"  
					+ "	diasLetivos	    INTEGER  NOT NULL" 
					+ ");");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE bimestre;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Bimestre> bimestres) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO bimestre ( descricao, dataInicio, dataFim, diasLetivos) VALUES (?, ?, ?, ?);");
				for (Bimestre bimestre : bimestres) {
					pst.setString(1, bimestre.getDescricao());
					pst.setDate(2, new java.sql.Date(bimestre.getDataInicio().getTime()));
					pst.setDate(3, new java.sql.Date(bimestre.getDataFim().getTime()));
					pst.setInt(4, bimestre.getDiasLetivos());
					pst.executeUpdate();
				}
			conexao.commit();
			return true;
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception e2) {
				throw new BDException(EErrosBD.ROLLBACK, e2.getMessage(), this.getClass().getSimpleName());
			}
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public Bimestre consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM bimestre WHERE BimestreId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Bimestre(rs.getInt("BimestreId"),
										   rs.getString("descricao"),
										   rs.getDate("dataInicio"),
										   rs.getDate("dataFim"),
										   rs.getInt("diasLetivos"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Bimestre> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM bimestre;");
			while(rs.next()) {
				bimestres.add(new Bimestre(rs.getInt("BimestreId"),
						   rs.getString("descricao"),
						   rs.getDate("dataInicio"),
						   rs.getDate("dataFim"),
						   rs.getInt("diasLetivos")));
			}
			return bimestres;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Bimestre bimestre) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE bimestre SET descricao = ?, dataInicio = ?, dataFim = ?, diasLetivos = ? WHERE BimestreId = ?;");
			pst.setString(1, bimestre.getDescricao());
			pst.setDate(2, new java.sql.Date(bimestre.getDataInicio().getTime()));
			pst.setDate(3, new java.sql.Date(bimestre.getDataFim().getTime()));
			pst.setInt(4, bimestre.getDiasLetivos());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean exclui(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM bimestre WHERE BimestreId = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.EXCLUI_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public int retornaProximoId() throws BDException {
		Connection conexao = Conexao.getConexao();
		int proximoId = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM bimestre;");
			while(rs.next()) {
				proximoId = rs.getInt("id") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList();
        Iterator var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            Bimestre bimestre = (Bimestre)var5.next();
            exporta.add(bimestre.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }
	
	public boolean insereVariosTrn(List<Bimestre> bimestres) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO bimestre ( descricao, dataInicio, dataFim, diasLetivos) VALUES (?, ?, ?, ?);");
            Iterator var5 = bimestres.iterator();

            while(var5.hasNext()) {
            	Bimestre bimestre = (Bimestre)var5.next();
            	pst.setString(1, bimestre.getDescricao());
				pst.setDate(2, new java.sql.Date(bimestre.getDataInicio().getTime()));
				pst.setDate(3, new java.sql.Date(bimestre.getDataFim().getTime()));
				pst.setInt(4, bimestre.getDiasLetivos());
				pst.executeUpdate();
            }

            conexao.commit();
            return true;
        } catch (Exception var11) {
            try {
                conexao.rollback();
            } catch (SQLException var10) {
                throw new BDException(EErosBanco.ROLLBACK, var10.getMessage());
            }

            throw new BDException(EErosBanco.INSERE_DADO, var11.getMessage());
        } finally {
            Conexao.closeConexao();
        }
    }
}
