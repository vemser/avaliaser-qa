package br.com.dbccompany.vemser.avaliaser.aceitacao.acompanhamento;

import br.com.dbccompany.vemser.avaliaser.dto.PageAcompanhamentoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.PageFeedbackDTO;
import br.com.dbccompany.vemser.avaliaser.service.AcompanhamentoService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListarAcompanhamentoTest {

    AcompanhamentoService acompanhamentoService = new AcompanhamentoService();

    @Test
    @Tag("all")
    @Description("Deve listar acompanhamentos com paginação")
    public void deveListarAcompanhamentosComPaginacao(){
        PageAcompanhamentoDTO pageAcompanhamento = acompanhamentoService.listar(0, 10)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageAcompanhamentoDTO.class)
                ;

        assertEquals(0, pageAcompanhamento.getPagina());
        assertEquals(10, pageAcompanhamento.getTamanho());

    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de feedbacks vazia")
    public void deveRetornarListaDeFeedbacksVazia() {
        PageAcompanhamentoDTO pageAcompanhamento = acompanhamentoService.listar(0, 0)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageAcompanhamentoDTO.class)
                ;

        assertEquals(0, pageAcompanhamento.getPagina());
        assertEquals(0, pageAcompanhamento.getTamanho());
        assertTrue(pageAcompanhamento.getElementos().isEmpty());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar lista de feedbacks")
    public void deveNaoRetornarListaDeFeedbacks() {
        acompanhamentoService.listar(-1, -1)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("Page ou Size não pode ser menor que zero."))

        ;
    }
}
