package br.com.dbccompany.vemser.avaliaser.aceitacao.avaliacao;

import br.com.dbccompany.vemser.avaliaser.builder.AvaliacaoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizaAvaliacaoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AvaliacaoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Avaliacao")
@Epic("Atualiza Avaliação")
public class AtualizaAvaliacaoTest {

    AvaliacaoService avaliacaoService = new AvaliacaoService();
    AvaliacaoBuilder avaliacaoBuilder = new AvaliacaoBuilder();

    @Test
    @Tag("all")
    @Description("Deve atualizar avaliação com sucesso")
    public void deveAtualizarAvaliacaoComSucesso() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();
        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        AtualizaAvaliacaoDTO atualizaAvaliacao = avaliacaoBuilder.atualizarAvaliacao();

        AvaliacaoDTO avaliacaoAtualizada = avaliacaoService
                .atualizar(avaliacao.getIdAvaliacao(), Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacao))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        assertEquals(avaliacaoAtualizada.getDescricao(), atualizaAvaliacao.getDescricao());
        assertEquals(avaliacaoAtualizada.getTipo(), atualizaAvaliacao.getStatus());
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar avaliação")
    public void deveNaoAtualizarAvaliacaoComIdAvaliacaoInexistente() {
        AtualizaAvaliacaoDTO atualizaAvaliacao = avaliacaoBuilder.atualizarAvaliacao();

        String message = avaliacaoService
                .atualizar(19931019, Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacao))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Avaliação não encontrada.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar avaliação")
    public void deveNaoAtualizarAvaliacaoComIdAlunoInexistente() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();
        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        AtualizaAvaliacaoDTO atualizaAvaliacaoInvalido = avaliacaoBuilder.atualizarAvaliacaoComIdAlunoInexistente();

        String message = avaliacaoService
                .atualizar(avaliacao.getIdAvaliacao(), Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacaoInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Aluno não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar avaliação")
    public void deveNaoAtualizarAvaliacaoComIdAcompanhamentoInexistente() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();
        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        AtualizaAvaliacaoDTO atualizaAvaliacaoInvalido = avaliacaoBuilder.atualizarAvaliacaoComIdAcompanhamentoInexistente();

        String message = avaliacaoService
                .atualizar(avaliacao.getIdAvaliacao(), Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacaoInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Acompanhamento não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar avaliação")
    public void deveNaoAtualizarAvaliacaoComDescricaoVazio() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();
        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        AtualizaAvaliacaoDTO atualizaAvaliacaoInvalido = avaliacaoBuilder.atualizarAvaliacaoComDescricaoVazio();

        avaliacaoService
                .atualizar(avaliacao.getIdAvaliacao(), Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacaoInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não atualizar avaliação")
    public void deveNaoAtualizarAvaliacaoComStatusVazio() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();
        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AvaliacaoDTO.class)
                ;

        AtualizaAvaliacaoDTO atualizaAvaliacaoInvalido = avaliacaoBuilder.atualizarAvaliacaoComStatusVazio();

        avaliacaoService
                .atualizar(avaliacao.getIdAvaliacao(), Utils.convertAtualizaAvaliacaoToJson(atualizaAvaliacaoInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

}
