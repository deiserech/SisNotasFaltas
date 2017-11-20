package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.Escola;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Usuario;

public class EscolaDAO implements GenericDAO<Escola>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE escola (" + "	"
					+ " EscolaId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ "	descricao				VARCHAR(100)  NOT NULL"  
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
			st.execute("DROP TABLE escola;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<Escola> escolas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO escola (descricao) VALUES (?);");
				for (Escola escola: escolas) {
					pst.setString(1, escola.getDescricao());
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
	public Escola consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM escola WHERE EscolaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Escola(rs.getInt("EscolaId"),
										   rs.getString("descricao"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Escola> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Escola> escolas = new ArrayList<Escola>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM escola;");
			while(rs.next()) {
				escolas.add(new Escola(rs.getInt("EscolaId"),
						   rs.getString("descricao")));
			}
			return escolas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Escola escola) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE escola SET EscolaId = ? ;");
			pst.setInt(1, escola.getEscolaId());
			pst.setString(2, escola.getDescricao());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM escola WHERE EscolaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM escola;");
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

	public Map<Integer, Escola> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Escola> series = new HashMap<Integer, Escola>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM escola;");
			while(rs.next()) {
				series.put(rs.getInt("escolaId"), 
						new Escola(	rs.getInt("escolaId"),
						 			rs.getString("descricao")));
			}
			return series;
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
            Escola escola = (Escola)var5.next();
            exporta.add(escola.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Escola> escolas) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO escola (descricao) VALUES (?);");
            Iterator var5 = escolas.iterator();

            while(var5.hasNext()) {
            	Escola escola = (Escola)var5.next();
                pst.setString(1, escola.getDescricao());
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
