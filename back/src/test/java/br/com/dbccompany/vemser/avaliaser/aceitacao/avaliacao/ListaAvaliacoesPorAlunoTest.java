package br.com.dbccompany.vemser.avaliaser.aceitacao.avaliacao;

import br.com.dbccompany.vemser.avaliaser.dto.PageAvaliacaoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AvaliacaoService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Avaliacao")
public class ListaAvaliacoesPorAlunoTest {

    AvaliacaoService avaliacaoService = new AvaliacaoService();

    @Test
    @Tag("all")
    @Description("Deve listar avaliações por aluno com paginação")
    public void deveListarAvaliacoesPorAlunoComPaginacao() {
        PageAvaliacaoDTO pageAvaliacao = avaliacaoService.listarPorAluno(19, 0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageAvaliacaoDTO.class)
                ;

        assertEquals(0, pageAvaliacao.getPagina());
        assertEquals(10, pageAvaliacao.getTamanho());
    }

    @Test
    @Tag("all")
    @Description("Deve não listar avaliações por aluno com paginação")
    public void deveNaoListarAvaliacoesPorAlunoComIdInexistente() {
        String message = avaliacaoService.listarPorAluno(19931019, 0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Aluno não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não listar avaliações por aluno com paginação")
    public void deveNaoListarAvaliacoesPorAlunoComDadosInvalidos() {
        // FALTA MENSAGEM DE ERRO PARA ID INVÁLIDO

        avaliacaoService.listarPorAluno(19931019, -1, -1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("Page ou Size não pode ser menor que zero."))
                    .body(containsString("Aluno não encontrado."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de avaliações vazia")
    public void deveRetornarListaDeAvaliacoesVazia() {
        PageAvaliacaoDTO pageAvaliacao = avaliacaoService.listarPorAluno(19, 0, 0)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageAvaliacaoDTO.class)
                ;

        assertEquals(0, pageAvaliacao.getPagina());
        assertEquals(0, pageAvaliacao.getTamanho());
        assertTrue(pageAvaliacao.getElementos().isEmpty());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar lista de avaliacoes")
    public void deveNaoRetornarListaDeAvaliacoesComDadosDePaginacaoInvalidos() {
        avaliacaoService.listarPorAluno(19, -1, -1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .extract().response()
                ;
    }

}
