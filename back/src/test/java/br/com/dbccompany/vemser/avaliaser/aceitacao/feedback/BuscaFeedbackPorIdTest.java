package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.dto.FeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Feedback")
@Epic("Busca Feedback Por Id")
public class BuscaFeedbackPorIdTest {

    FeedbackService feedbackService = new FeedbackService();

    @Test
    @Tag("all")
    @Description("Deve buscar feedback por id")
    public void deveBuscarFeedbackPorId() {
        FeedbackDTO feedback = feedbackService.buscarPorId(7)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackDTO.class)
                ;

        assertEquals(7, feedback.getIdFeedBack());
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar feedback por id")
    public void deveNaoBuscarFeedbackPorIdInexistente() {
        String message = feedbackService.buscarPorId(10191993)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("FeedBack não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar feedback por id")
    public void deveNaoBuscarFeedbackPorIdZerado() {
        String message = feedbackService.buscarPorId(0)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("FeedBack não encontrado.", message);
    }

}
