
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.model.Usuario;

public class ImportaUsuario {
    public static void ImportacaoUsuario(String separador) {
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\usuario.txt");
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Usuario usuario = new Usuario(Integer.parseInt(valores[0]),
            							  valores[1],
            							  valores[2]);
            usuarios.add(usuario);
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
        	usuarioDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	usuarioDAO.insereVariosTrn(usuarios);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
