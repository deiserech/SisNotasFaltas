package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.model.Usuario;

public class ExportaUsuario {
    public ExportaUsuario() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.consulta();
        List<String> usuariosExp = new ArrayList();
        Iterator var7 = usuarios.iterator();

        while(var7.hasNext()) {
        	Usuario usuario = (Usuario)var7.next();
        	usuariosExp.add(usuario.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\usuario.txt", usuariosExp, false);
    }
}
