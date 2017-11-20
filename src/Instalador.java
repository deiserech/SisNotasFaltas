import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.BaseDAO;

public class Instalador {
	public static void main(String[] args) throws IOException, BDException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String caminho = System.getProperty("user.dir") + "/config/bancodados.properties";
		FileInputStream arquivo = new FileInputStream(new File(caminho));
		Properties propriedades = new Properties();
		propriedades.load(arquivo);
		arquivo.close();
		BaseDAO baseDao = new BaseDAO();
		baseDao.criaBase(propriedades.getProperty("ip"), propriedades.getProperty("base"),
				propriedades.getProperty("useSSL"), propriedades.getProperty("login"),
				propriedades.getProperty("senha"));
	}
}
