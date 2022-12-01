package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.*;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class FeedbackBuilder {

    public FeedbackCreateDTO criarFeedback() {
        return FeedbackCreateDTO.builder()
                .idAluno(3)
                .descricao("Jaciane Santana")
                .tipo(TipoFeedbackDTO.POSITIVO.toString())
                .build();
    }

/*    public FeedbackCreateDTO criarFeedbackInvalido() {
        FeedbackCreateDTO feedbackInvalido = criarFeedback();
        feedbackInvalido.setIdAluno();
        feedbackInvalido.setDescricao();
        feedbackInvalido.setTipo();

        return feedbackInvalido;
    }*/

/*    public FeedbackCreateDTO criarFeedbackVazio() {
        FeedbackCreateDTO feedbackVazio = criarFeedback();
        feedbackVazio.setIdAluno(0);
        feedbackVazio.setDescricao(StringUtils.EMPTY);
        feedbackVazio.setTipo(StringUtils.EMPTY);

        return feedbackVazio;
    }*/

}
