package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.dto.PageFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Feedback")
@Epic("Lista Feedbacks")
public class ListaFeedbacksTest {

    FeedbackService feedbackService = new FeedbackService();

    @Test
    @Tag("all")
    @Description("Deve listar feedbacks com paginação")
    public void deveListarFeedbacksComPaginacao() {
        PageFeedbackDTO pageFeedback = feedbackService.listar(0, 10)
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
    @Description("Deve retornar lista de feedbacks vazia")
    public void deveRetornarListaDeFeedbacksVazia() {
        PageFeedbackDTO pageFeedback = feedbackService.listar(0, 0)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageFeedbackDTO.class)
                ;

        assertEquals(0, pageFeedback.getPagina());
        assertEquals(0, pageFeedback.getTamanho());
        assertTrue(pageFeedback.getElementos().isEmpty());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar lista de feedbacks")
    public void deveNaoRetornarListaDeFeedbacks() {
        feedbackService.listar(-1, -1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .extract().response()
                ;
    }

}
