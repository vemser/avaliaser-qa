package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AtualizaFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.dto.FeedbackCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.TipoFeedbackDTO;
import org.apache.commons.lang3.StringUtils;

public class FeedbackBuilder {

    public FeedbackCreateDTO criarFeedback() {
        return FeedbackCreateDTO.builder()
                .idAluno(19)
                .descricao("teste feedback")
                .tipo(TipoFeedbackDTO.ATENCAO.toString())
                .build();
    }

    public FeedbackCreateDTO criarFeedbackInvalido() {
        return FeedbackCreateDTO.builder()
                .idAluno(19931019)
                .descricao("qualquer feedback")
                .tipo("qualquer tipo")
                .build();
    }

    public FeedbackCreateDTO criarFeedbackVazio() {
        return FeedbackCreateDTO.builder()
                .idAluno(0)
                .descricao(StringUtils.EMPTY)
                .tipo(StringUtils.EMPTY)
                .build();
    }

    public FeedbackCreateDTO criarFeedbackComIdAlunoInexistente() {
        FeedbackCreateDTO feedbackComIdAlunoInexistente = criarFeedback();
        feedbackComIdAlunoInexistente.setIdAluno(19931019);

        return feedbackComIdAlunoInexistente;
    }

    public FeedbackCreateDTO criarFeedbackComDescricaoVazio() {
        FeedbackCreateDTO feedbackComDescricaoVazio = criarFeedback();
        feedbackComDescricaoVazio.setDescricao(StringUtils.EMPTY);

        return feedbackComDescricaoVazio;
    }

    public FeedbackCreateDTO criarFeedbackComTipoVazio() {
        FeedbackCreateDTO feedbackComTipoVazio = criarFeedback();
        feedbackComTipoVazio.setTipo(StringUtils.EMPTY);

        return feedbackComTipoVazio;
    }

    public AtualizaFeedbackDTO atualizarFeedback() {
        return AtualizaFeedbackDTO.builder()
                .idAluno(19)
                .descricao("Atualização de feedback")
                .tipo(TipoFeedbackDTO.POSITIVO.toString())
                .build();
    }

    public AtualizaFeedbackDTO atualizarFeedbackComIdAlunoInexistente() {
        AtualizaFeedbackDTO atualizaFeedbackComIdAlunoInexistente = atualizarFeedback();
        atualizaFeedbackComIdAlunoInexistente.setIdAluno(19931019);

        return atualizaFeedbackComIdAlunoInexistente;
    }

    public AtualizaFeedbackDTO atualizarFeedbackComDescricaoVazio() {
        AtualizaFeedbackDTO atualizaFeedbackComDescricaoVazio = atualizarFeedback();
        atualizaFeedbackComDescricaoVazio.setDescricao(StringUtils.EMPTY);

        return atualizaFeedbackComDescricaoVazio;
    }

    public AtualizaFeedbackDTO atualizarFeedbackComTipoVazio() {
        AtualizaFeedbackDTO atualizaFeedbackComTipoVazio = atualizarFeedback();
        atualizaFeedbackComTipoVazio.setTipo(StringUtils.EMPTY);

        return atualizaFeedbackComTipoVazio;
    }

}
