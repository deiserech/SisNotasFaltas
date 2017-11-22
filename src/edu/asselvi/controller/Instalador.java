package edu.asselvi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.BaseDAO;
import edu.asselvi.populador.manual.ExportaAlunoTurma;
import edu.asselvi.populador.manual.ExportaBimestre;
import edu.asselvi.populador.manual.ExportaCurso;
import edu.asselvi.populador.manual.ExportaDisciplina;
import edu.asselvi.populador.manual.ExportaDisciplinaProfessor;
import edu.asselvi.populador.manual.ExportaDisciplinaSerie;
import edu.asselvi.populador.manual.ExportaEscola;
import edu.asselvi.populador.manual.ExportaFrequencia;
import edu.asselvi.populador.manual.ExportaHorario;
import edu.asselvi.populador.manual.ExportaNota;
import edu.asselvi.populador.manual.ExportaPessoa;
import edu.asselvi.populador.manual.ExportaSerie;
import edu.asselvi.populador.manual.ExportaTurma;
import edu.asselvi.populador.manual.ExportaUsuario;
import edu.asselvi.populador.manual.ImportaAlunoTurma;
import edu.asselvi.populador.manual.ImportaBimestre;
import edu.asselvi.populador.manual.ImportaCurso;
import edu.asselvi.populador.manual.ImportaDisciplina;
import edu.asselvi.populador.manual.ImportaDisciplinaProfessor;
import edu.asselvi.populador.manual.ImportaDisciplinaSerie;
import edu.asselvi.populador.manual.ImportaEscola;
import edu.asselvi.populador.manual.ImportaFrequencia;
import edu.asselvi.populador.manual.ImportaHorario;
import edu.asselvi.populador.manual.ImportaNota;
import edu.asselvi.populador.manual.ImportaPessoa;
import edu.asselvi.populador.manual.ImportaSerie;
import edu.asselvi.populador.manual.ImportaTurma;
import edu.asselvi.populador.manual.ImportaUsuario;
import edu.asselvi.view.Menu;

public class Instalador {
	public static boolean buscaParametros() throws IOException, BDException {
		String caminho = System.getProperty("user.dir") + "/config/bancodados.properties";
		FileInputStream arquivo = new FileInputStream(new File(caminho));
		Properties propriedades = new Properties();
		propriedades.load(arquivo);
		arquivo.close();
		Sistema.base.setUrl(propriedades.getProperty("url"));
		Sistema.base.setBase(propriedades.getProperty("base"));
		Sistema.base.setUseSSL(propriedades.getProperty("useSSL"));
		Sistema.base.setLogin(propriedades.getProperty("login"));
		Sistema.base.setSenha(propriedades.getProperty("senha"));
		return true;
	}

	public static boolean criarDatabase() throws BDException, IOException, NumberFormatException, ParseException {
		BaseDAO baseDao = new BaseDAO();
		
		return baseDao.criaBase();
	}

	public static void importarDados() throws IOException, NumberFormatException, ParseException {
		String separador = Menu.menuImportacao();
		ImportaEscola.ImportacaoEscola(separador);
		ImportaAlunoTurma.ImportacaoAlunoTurma(separador);
		ImportaBimestre.ImportacaoBimestre(separador);
		ImportaCurso.ImportacaoCurso(separador);
		ImportaDisciplina.ImportacaoDisciplina(separador);
		ImportaDisciplinaProfessor.ImportacaoDisciplinaProfessor(separador);
		ImportaDisciplinaSerie.ImportacaoDisciplinaSerie(separador);
		ImportaFrequencia.ImportacaoFrequencia(separador);
		ImportaUsuario.ImportacaoUsuario(separador);
		ImportaPessoa.ImportacaoPessoa(separador);
		ImportaSerie.ImportacaoSerie(separador);
		ImportaTurma.ImportacaoTurma(separador);
		ImportaHorario.ImportacaoHorario(separador);
		ImportaNota.ImportacaoNota(separador);
		Menu.mensagens(1);
	}

	public static void exportarDados() throws IOException, BDException {
		String separador = Menu.menuExportacao();
		ExportaEscola.ExportacaoEscola(separador);
		ExportaAlunoTurma.ExportacaoAlunoTurma(separador);
		ExportaBimestre.ExportacaoBimestre(separador);
		ExportaCurso.ExportacaoCurso(separador);
		ExportaDisciplina.ExportacaoDisciplina(separador);
		ExportaDisciplinaProfessor.ExportacaoDisciplinaProfessor(separador);
		ExportaDisciplinaSerie.ExportacaoDisciplinaSerie(separador);
		ExportaEscola.ExportacaoEscola(separador);
		ExportaFrequencia.ExportacaoFrequencia(separador);
		ExportaHorario.ExportacaoHorario(separador);
		ExportaNota.ExportacaoNota(separador);
		ExportaPessoa.ExportacaoPessoa(separador);
		ExportaSerie.ExportacaoSerie(separador);
		ExportaTurma.ExportacaoTurma(separador);
		ExportaUsuario.ExportacaoUsuario(separador);
		Menu.mensagens(4);
	}

}
