package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;

public class AlunoBuilder {

    public AlunoCreateDTO criarAluno() {
        return AlunoCreateDTO.builder()
                .nome("AlunoQADbc Teste")
                .email("alunoqadbcgaby.teste@dbccompany.com.br")
                .build();
    }

    public AlunoCreateDTO criarAlunoVazio() {
        return AlunoCreateDTO.builder()
                .nome("")
                .email("gabriela.teste@dbccompany.com.br")
                .build();
    }

    public AlunoCreateDTO criarAlunoInvalido() {
        return AlunoCreateDTO.builder()
                .nome("1543")
                .email("gabriela.teste@dbccompany.com.br")
                .build();
    }

    public AlunoDTO atualizarAluno() {
        return AlunoDTO.builder()
                .nome("Testee Aluno")
                .email("testeqa.alunodbccompany@dbccompany.com.br")
                .build();
    }

    public AlunoDTO atualizarAlunoInvalido() {
        AlunoDTO nomeInvalido = atualizarAluno();
        nomeInvalido.setNome("abc123!");
        return nomeInvalido;
    }

    public AlunoDTO atualizarAlunoVazio() {
        AlunoDTO nomeVazio = atualizarAluno();
        nomeVazio.setNome("");
        return nomeVazio;
    }
}

