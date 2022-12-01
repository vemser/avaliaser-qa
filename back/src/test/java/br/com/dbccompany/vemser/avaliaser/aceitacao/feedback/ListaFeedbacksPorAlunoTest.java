package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.dto.PageFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Feedback")
public class ListaFeedbacksPorAlunoTest {

    FeedbackService feedbackService = new FeedbackService();

    @Test
    @Tag("all")
    @Description("Deve listar feedbacks por aluno com paginação")
    public void deveListarFeedbacksPorAlunoComPaginacao() {
        PageFeedbackDTO pageFeedback = feedbackService.listarPorAluno(19, 0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageFeedbackDTO.class)
                ;

        assertEquals(0, pageFeedback.getPagina());
        assertEquals(10, pageFeedback.getTamanho());
    }

    @Test
    @Tag("all")
    @Description("Deve não listar feedbacks por aluno com paginação")
    public void deveNaoListarFeedbacksPorAlunoComIdInexistente() {
        // RETORNA 200 COM LISTA VAZIA

        String message = feedbackService.listarPorAluno(19931019, 0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("idAluno não encontrado.", message);
    }

}
