package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.builder.FeedbackBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizaFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.dto.FeedbackCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.FeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Feedback")
public class AtualizaFeedbackTest {

    FeedbackService feedbackService = new FeedbackService();
    FeedbackBuilder feedbackBuilder = new FeedbackBuilder();

    @Test
    @Tag("all")
    @Description("Deve atualizar feedback com sucesso")
    public void deveAtualizarFeedbackComSucesso() {
        FeedbackCreateDTO feedbackCreate = feedbackBuilder.criarFeedback();
        FeedbackDTO feedback = feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        AtualizaFeedbackDTO atualizafeedback = feedbackBuilder.atualizarFeedback();

        FeedbackDTO feedbackAtualizado = feedbackService
                .atualizar(feedback.getIdFeedBack(), Utils.convertAtualizaFeedbackToJson(atualizafeedback))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        assertEquals(feedbackAtualizado.getDescricao(), atualizafeedback.getDescricao());
        assertEquals(feedbackAtualizado.getTipo(), atualizafeedback.getTipo());
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar feedback")
    public void deveNaoAtualizarFeedbackComIdFeedbackInexistente() {
        AtualizaFeedbackDTO atualizafeedback = feedbackBuilder.atualizarFeedback();

        String message = feedbackService
                .atualizar(19931019, Utils.convertAtualizaFeedbackToJson(atualizafeedback))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("FeedBack não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar feedback")
    public void deveNaoAtualizarFeedbackComIdAlunoInexistente() {
        FeedbackCreateDTO feedbackCreate = feedbackBuilder.criarFeedback();
        FeedbackDTO feedback = feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        AtualizaFeedbackDTO atualizafeedbackInvalido = feedbackBuilder.atualizarFeedbackComIdAlunoInexistente();

        String message = feedbackService
                .atualizar(feedback.getIdFeedBack(), Utils.convertAtualizaFeedbackToJson(atualizafeedbackInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Aluno não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar feedback")
    public void deveNaoAtualizarFeedbackComDescricaoVazio() {
        // RETORNA 500

        FeedbackCreateDTO feedbackCreate = feedbackBuilder.criarFeedback();
        FeedbackDTO feedback = feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        AtualizaFeedbackDTO atualizafeedbackInvalido = feedbackBuilder.atualizarFeedbackComDescricaoVazio();

        feedbackService
                .atualizar(feedback.getIdFeedBack(), Utils.convertAtualizaFeedbackToJson(atualizafeedbackInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar feedback")
    public void deveNaoAtualizarFeedbackComTipoVazio() {
        FeedbackCreateDTO feedbackCreate = feedbackBuilder.criarFeedback();
        FeedbackDTO feedback = feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        AtualizaFeedbackDTO atualizafeedbackInvalido = feedbackBuilder.atualizarFeedbackComTipoVazio();

        feedbackService
                .atualizar(feedback.getIdFeedBack(), Utils.convertAtualizaFeedbackToJson(atualizafeedbackInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

}
