package br.com.dbccompany.vemser.avaliaser.aceitacao.feedback;

import br.com.dbccompany.vemser.avaliaser.dto.PageFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.FeedbackService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Feedback")
@Epic("Lista Feedbacks por Aluno")
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
        String message = feedbackService.listarPorAluno(19931019, 0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Aluno não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não listar feedbacks por aluno com paginação")
    public void deveNaoListarFeedbacksPorAlunoComDadosInvalidos() {
        feedbackService.listarPorAluno(19931019, -1, -1)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                //.body(containsString("Page ou Size não pode ser menor que zero."))
                .body(containsString("Aluno não encontrado."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de feedbacks vazia")
    public void deveRetornarListaDeFeedbacksVazia() {
        PageFeedbackDTO pageFeedback = feedbackService.listarPorAluno(19, 0, 0)
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
    @Description("Deve não listar feedbacks por aluno com paginação")
    public void deveNaoListarFeedbacksPorAlunoComDadosDePaginacaoInvalidos() {
        feedbackService.listarPorAluno(19, -1, -1)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("Page ou Size não pode ser menor que zero."))
        ;
    }

}
