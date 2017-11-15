package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.Bimestre;
import edu.asselvi.model.Curso;
import edu.asselvi.model.Disciplina;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Escola;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Funcionario;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;

public class Cadastros {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Escola cadastraEscola() throws IOException {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro da Escola      ««|");
		System.out.println("----------------------------------");
		int escolaId = 0;
		System.out.println("Informe o nome da escola.........: ");
		String descricao = (teclado.readLine());
		Escola escola = new Escola(escolaId, descricao);
		return escola;
	}

	public static List<Curso> cadastraCurso() throws IOException {
		char novo = 'S';
		List<Curso> cursos = new ArrayList<Curso>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Cursos      ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			System.out.println("Informe a descrição do curso.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o código da escola.......: ");
			int escolaId = (Integer.parseInt(teclado.readLine()));
			cursos.add(new Curso(0, escolaId, descricao));

			System.out.println("Deseja cadastrar novo curso?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return cursos;
	}

	public static List<Object> cadastraSerie(Map<Integer, Integer> seriesCad) throws IOException {
		List<Object> retorno = new ArrayList<Object>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Séries      ««|");
		System.out.println("----------------------------------");

		System.out.println("Informe o número da série........: ");
		int serieId = (Integer.parseInt(teclado.readLine()));
		boolean serieOk = false;
		do {
			if (serieId == seriesCad.get(serieId)) {
				System.out.println("Série já cadastrada. Informe nova Série:");
				serieId = (Integer.parseInt(teclado.readLine()));
			} else {
				serieOk = true;
			}
		} while (!serieOk);

		System.out.println("Informe a descrição da série.....: ");
		String descricao = (teclado.readLine());
		System.out.println("Informe a idade mínima...........: ");
		int idadeMinima = (Integer.parseInt(teclado.readLine()));
		System.out.println("Informe a duração(meses).........: ");
		int duracao = ((Integer.parseInt(teclado.readLine())));
		System.out.println("Informe o código do curso........: ");
		int cursoId = (Integer.parseInt(teclado.readLine()));
		retorno.add(new Serie(serieId, cursoId, descricao, idadeMinima, duracao));

		System.out.println("Informe o código das disciplinas.: ");
		System.out.println("Digite '0' para SAIR.............: ");
		int disciplina = Integer.parseInt(teclado.readLine());
		while (disciplina != 0) {
			disciplina = Integer.parseInt(teclado.readLine());
			retorno.add(new DisciplinaSerie(disciplina, serieId));
		}
		return retorno;
	};

	public static List<Turma> cadastraTurma() throws IOException {
		char novo = 'S';
		List<Turma> turmas = new ArrayList<Turma>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Turmas      ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int turmaId = 0;
			System.out.println("Informe a descrição da turma.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o número de vagas........: ");
			int vagas = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o ano correspondente.....: ");
			int ano = ((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o código da série........: ");
			int serieId = (Integer.parseInt(teclado.readLine()));
			turmas.add(new Turma(turmaId, serieId, descricao, vagas, ano));

			System.out.println("Deseja cadastrar nova turma?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return turmas;
	};

	public static List<Disciplina> cadastraDisciplina() throws IOException {
		char novo = 'S';
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Cadastro de Disciplinas   ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int disciplinaId = 0;
			System.out.println("Informe a descrição da disciplina: ");
			String descricao = (teclado.readLine());
			disciplinas.add(new Disciplina(disciplinaId, descricao));

			System.out.println("Deseja cadastrar nova disciplina?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return disciplinas;
	};

	public static List<Object> cadastraFuncionario(int proximoId) throws IOException, ParseException {
		List<Object> retorno = new ArrayList<Object>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Cadastro de Funcionários  ««|");
		System.out.println("----------------------------------");
		int funcionarioId = 0;
		System.out.println("Informe o nome...................: ");
		String nome = (teclado.readLine());
		System.out.println("Informe o cpf....................: ");
		String cpf = (teclado.readLine());
		System.out.println("Informe a data de nascimento.....: ");
		String data = teclado.readLine();
		Date dataNascimento = sdf.parse(data);
		System.out.println("Informe o sexo...................: ");
		ESexo sexo = (ESexo.valueOf(teclado.readLine()));
		System.out.println("Informe o perfil do funcionário..: ");
		System.out.println("(1-Coordenador/2-Secretária/3-Professor)");
		int tipoFuncionario = Integer.parseInt(teclado.readLine());

		if (tipoFuncionario == 3) {
			System.out.println("Informe o código das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				disciplina = Integer.parseInt(teclado.readLine());
				retorno.add(new DisciplinaProfessor(disciplina, funcionarioId));
			}
		}
		retorno.add(new Funcionario(funcionarioId, funcionarioId, tipoFuncionario, nome, cpf, dataNascimento, sexo));
		return retorno;
	};

	public static List<Usuario> cadastraUsuario() throws IOException {
		char novo = 'S';
		List<Usuario> usuarios = new ArrayList<Usuario>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Usuários    ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			System.out.println("Informe o perfil do usuário......: ");
			System.out.println("(1-Coordenador/2-Secretária/3-Professor/4-Aluno)");
			int perfil = Integer.parseInt(teclado.readLine());
			System.out.println("Informe o código " + (perfil == 4 ? "do aluno........:" : "do funcionário..:"));
			int cdUsuario = Integer.parseInt(teclado.readLine());
			System.out.println("Informe o login..................: ");
			String login = teclado.readLine();
			System.out.println("Informe a senha..................: ");
			String senha = teclado.readLine();

			usuarios.add(new Usuario(cdUsuario, login, senha, perfil));

			System.out.println("Deseja cadastrar novo usuário?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return usuarios;
	};

	public static List<Horario> cadastraHorario(Map<Integer, Integer> serieTurma) throws IOException {
		char novo = 'S';
		List<Horario> horarios = new ArrayList<Horario>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Horários    ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int horarioId = 0;
			System.out.println("Informe o dia da semana(1-2-3-4-5): ");
			int diaSemana = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da disciplina...: ");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da turma........: ");
			int turmaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a hora de início.........: ");
			int horaInicio = (Integer.parseInt(teclado.readLine()));
			int serieId = serieTurma.get(turmaId);
			int disciplinaSerieId = Integer.parseInt(disciplinaId + "" + serieId);
			horarios.add(new Horario(horarioId, diaSemana, disciplinaSerieId, turmaId, horaInicio));

			System.out.println("Deseja cadastrar novo horário?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return horarios;
	};

	public static List<Object> cadastraAluno(int proximoId) throws IOException, ParseException {
		List<Object> retorno = new ArrayList<Object>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Alunos      ««|");
		System.out.println("----------------------------------");
		int perfil = 4;
		System.out.println("Informe o nome...................: ");
		String nome = (teclado.readLine());
		System.out.println("Informe o cpf....................: ");
		String cpf = (teclado.readLine());
		System.out.println("Informe a data de nascimento.....: ");
		String data = teclado.readLine();
		Date dataNascimento = sdf.parse(data);
		System.out.println("Informe o sexo...................: ");
		ESexo sexo = (ESexo.valueOf(teclado.readLine()));
		retorno.add(new Aluno(proximoId, proximoId, perfil, nome, cpf, dataNascimento, sexo));

		System.out.println("Informe o código da turma........: ");
		System.out.println("Digite '0' para SAIR.............: ");
		int turma = Integer.parseInt(teclado.readLine());
		while (turma != 0) {
			turma = Integer.parseInt(teclado.readLine());
			retorno.add(new AlunoTurma(proximoId, turma));
		}
		return retorno;
	};

	public static List<Bimestre> cadastraBimestre() throws IOException, ParseException {
		char novo = 'S';
		int cont = 0;
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Cadastro de Bimestre    ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			cont++;
			int bimestreId = 0;
			System.out.println("Informe a descição do bimestre...: ");
			String descricao = teclado.readLine();
			System.out.println("Informe a data de início.........: ");
			String data = teclado.readLine();
			Date dataInicio = sdf.parse(data);
			System.out.println("Informe a data de término........: ");
			data = teclado.readLine();
			Date dataFim = sdf.parse(data);
			System.out.println("Informe o número de dias letivos.: ");
			int diasLetivos = (Integer.parseInt(teclado.readLine()));
			bimestres.add(new Bimestre(bimestreId, descricao, dataInicio, dataFim, diasLetivos));
			if (cont < 4) { // 4 bimestres
				System.out.println("Deseja cadastrar novo bimestre?(S/N).: ");
				novo = Character.toUpperCase((teclado.readLine().charAt(0)));
			}
		}
		return bimestres;
	}

}
