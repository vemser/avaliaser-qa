package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;

public class AlunoBuilder {

    public AlunoCreateDTO criarAluno() {
        return AlunoCreateDTO.builder()
                .email("gabriela.freitas@dbccompany.com.br")
                .nome("Gabriela de Freitas")
                .build();
    }

    public AlunoDTO atualizarAluno() {
        return AlunoDTO.builder()
                .nome("Jaciane Santana")
                .email("jaciane.santana@dbccompany.com.br")
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

