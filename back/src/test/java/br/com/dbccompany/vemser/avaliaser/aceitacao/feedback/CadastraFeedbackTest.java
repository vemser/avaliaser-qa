package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.builder.FeedbackBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.FeedbackCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.FeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Feedback")
@Epic("Cadastra Feedback")
public class CadastraFeedbackTest {

    FeedbackService feedbackService = new FeedbackService();
    FeedbackBuilder feedbackBuilder = new FeedbackBuilder();

    @Test
    @Tag("all")
    @Description("Deve cadastrar feedback com sucesso")
    public void deveCadastrarFeedbackComSucesso() {
        FeedbackCreateDTO feedbackCreate = feedbackBuilder.criarFeedback();

        FeedbackDTO feedback = feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        assertEquals(feedbackCreate.getDescricao(), feedback.getDescricao());
        assertEquals(feedbackCreate.getTipo(), feedback.getTipo());
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar feedback")
    public void deveNaoCadastrarFeedbackComDadosInvalidos() {
        FeedbackCreateDTO feedbackCreateInvalido = feedbackBuilder.criarFeedbackInvalido();

        feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar feedback")
    public void deveNaoCadastrarFeedbackComDadosVazios() {
        FeedbackCreateDTO feedbackCreateInvalido = feedbackBuilder.criarFeedbackVazio();

        feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreateInvalido))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar feedback")
    public void deveNaoCadastrarFeedbackComIdAlunoInexistente() {
        FeedbackCreateDTO feedbackCreateInvalido = feedbackBuilder.criarFeedbackComIdAlunoInexistente();

        feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("Aluno não encontrado."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar feedback")
    public void deveNaoCadastrarFeedbackComDescricaoVazio() {
        //  MENSAGEM ERRADA

        FeedbackCreateDTO feedbackCreateInvalido = feedbackBuilder.criarFeedbackComDescricaoVazio();

        feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("descricao: Descrição não pode ser nulo."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar feedback")
    public void deveNaoCadastrarFeedbackComTipoVazio() {
        FeedbackCreateDTO feedbackCreateInvalido = feedbackBuilder.criarFeedbackComTipoVazio();

        feedbackService.cadastrar(Utils.convertFeedbackToJson(feedbackCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

}
