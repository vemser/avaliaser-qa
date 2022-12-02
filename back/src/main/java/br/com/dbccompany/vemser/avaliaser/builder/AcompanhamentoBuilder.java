package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizarAcompanhamentoDTO;

public class AcompanhamentoBuilder {
    public AcompanhamentoCreateDTO criarAcompanhamento() {
        return AcompanhamentoCreateDTO.builder()
                .titulo("Reunião Vem Ser")
                .descricao("Verificar evolução do estagiário e passar feedback")
                .dataInicio("2022-12-01")
                .build();
    }

    public AcompanhamentoCreateDTO criarAcompanhamentoTituloVazio() {
        return AcompanhamentoCreateDTO.builder()
                .titulo("")
                .descricao("Verificar evolução do estagiário e passar feedback")
                .dataInicio("2022-12-01")
                .build();
    }
    public AcompanhamentoCreateDTO criarAcompanhamentoDescricaoVazia() {
        return AcompanhamentoCreateDTO.builder()
                .titulo("Reunião Vem Ser")
                .descricao("")
                .dataInicio("2022-12-01")
                .build();
    }

    public AcompanhamentoCreateDTO criarAcompanhamentoDataInicioVazia() {
        return AcompanhamentoCreateDTO.builder()
                .titulo("Reunião Vem Ser")
                .descricao("Verificar evolução do estagiário e passar feedback")
                .dataInicio("")
                .build();
    }

    public AtualizarAcompanhamentoDTO atualizarAcompanhamento() {
        return AtualizarAcompanhamentoDTO.builder()
                .titulo("Reunião Vem Ser")
                .descricao("Verificar a evolução do estagiário e passar feedback")
                .build();
    }

    public AtualizarAcompanhamentoDTO atualizarAcompanhamentoTituloVazio() {
        return AtualizarAcompanhamentoDTO.builder()
                .titulo("")
                .descricao("Verificar a evolução do estagiário e passar feedback")
                .build();
    }
    public AtualizarAcompanhamentoDTO atualizarAcompanhamentoDescricaoVazia() {
        return AtualizarAcompanhamentoDTO.builder()
                .titulo("Reunião Vem Ser 10")
                .descricao("")
                .build();
    }



}