package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AtualizaAvaliacaoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.TipoFeedbackDTO;
import org.apache.commons.lang3.StringUtils;

public class AvaliacaoBuilder {

    public AvaliacaoCreateDTO criarAvaliacao() {
        return AvaliacaoCreateDTO.builder()
                .idAcompanhamento(11)
                .idAluno(19)
                .descricao("teste avaliação")
                .tipo(TipoFeedbackDTO.ATENCAO.toString())
                .dataCriacao("2022-12-01")
                .build();
    }

    public AvaliacaoCreateDTO criarAvaliacaoInvalido() {
        return AvaliacaoCreateDTO.builder()
                .idAcompanhamento(19931019)
                .idAluno(19931019)
                .descricao("teste avaliação")
                .tipo("qualquer tipo")
                .dataCriacao("qualquer data")
                .build();
    }

    public AvaliacaoCreateDTO criarAvaliacaoVazio() {
        return AvaliacaoCreateDTO.builder()
                .idAcompanhamento(0)
                .idAluno(0)
                .descricao(StringUtils.EMPTY)
                .tipo(StringUtils.EMPTY)
                .dataCriacao(StringUtils.EMPTY)
                .build();
    }

    public AvaliacaoCreateDTO criarAvaliacaoComIdAcompanhamentoInexistente() {
        AvaliacaoCreateDTO avaliacaoComIdAcompanhamentoInexistente = criarAvaliacao();
        avaliacaoComIdAcompanhamentoInexistente.setIdAcompanhamento(19931019);

        return avaliacaoComIdAcompanhamentoInexistente;
    }

    public AvaliacaoCreateDTO criarAvaliacaoComIdAlunoInexistente() {
        AvaliacaoCreateDTO avaliacaoComIdAlunoInexistente = criarAvaliacao();
        avaliacaoComIdAlunoInexistente.setIdAluno(19931019);

        return avaliacaoComIdAlunoInexistente;
    }

    public AvaliacaoCreateDTO criarAvaliacaoComDescricaoVazio() {
        AvaliacaoCreateDTO avaliacaoComDescricaoVazio = criarAvaliacao();
        avaliacaoComDescricaoVazio.setDescricao(StringUtils.EMPTY);

        return avaliacaoComDescricaoVazio;
    }

    public AvaliacaoCreateDTO criarAvaliacaoComTipoVazio() {
        AvaliacaoCreateDTO avaliacaoComTipoVazio = criarAvaliacao();
        avaliacaoComTipoVazio.setTipo(StringUtils.EMPTY);

        return avaliacaoComTipoVazio;
    }

    public AvaliacaoCreateDTO criarAvaliacaoComDataVazio() {
        AvaliacaoCreateDTO avaliacaoComDataVazio = criarAvaliacao();
        avaliacaoComDataVazio.setDataCriacao(StringUtils.EMPTY);

        return avaliacaoComDataVazio;
    }

    public AtualizaAvaliacaoDTO atualizarAvaliacao() {
        return AtualizaAvaliacaoDTO.builder()
                .idAluno(19)
                .idAcompanhamento(11)
                .descricao("Atualização de avaliação")
                .status(TipoFeedbackDTO.POSITIVO.toString())
                .build();
    }

    public AtualizaAvaliacaoDTO atualizarAvaliacaoComIdAlunoInexistente() {
        AtualizaAvaliacaoDTO atualizaAvaliacaoComIdAlunoInexistente = atualizarAvaliacao();
        atualizaAvaliacaoComIdAlunoInexistente.setIdAluno(19931019);

        return atualizaAvaliacaoComIdAlunoInexistente;
    }

    public AtualizaAvaliacaoDTO atualizarAvaliacaoComIdAcompanhamentoInexistente() {
        AtualizaAvaliacaoDTO atualizaAvaliacaoComIdAcompanhamentoInexistente = atualizarAvaliacao();
        atualizaAvaliacaoComIdAcompanhamentoInexistente.setIdAcompanhamento(19931019);

        return atualizaAvaliacaoComIdAcompanhamentoInexistente;
    }

    public AtualizaAvaliacaoDTO atualizarAvaliacaoComDescricaoVazio() {
        AtualizaAvaliacaoDTO atualizaAvaliacaoComDescricaoVazio = atualizarAvaliacao();
        atualizaAvaliacaoComDescricaoVazio.setDescricao(StringUtils.EMPTY);

        return atualizaAvaliacaoComDescricaoVazio;
    }

    public AtualizaAvaliacaoDTO atualizarAvaliacaoComStatusVazio() {
        AtualizaAvaliacaoDTO atualizaAvaliacaoComStatusVazio = atualizarAvaliacao();
        atualizaAvaliacaoComStatusVazio.setStatus(StringUtils.EMPTY);

        return atualizaAvaliacaoComStatusVazio;
    }

}
