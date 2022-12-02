package br.com.dbccompany.vemser.avaliaser.aceitacao.avaliacao;

import br.com.dbccompany.vemser.avaliaser.builder.AvaliacaoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.*;
import br.com.dbccompany.vemser.avaliaser.service.AvaliacaoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Avaliacao")
public class CadastraAvaliacaoTest {

    AvaliacaoService avaliacaoService = new AvaliacaoService();
    AvaliacaoBuilder avaliacaoBuilder = new AvaliacaoBuilder();

    @Test
    @Tag("all")
    @Description("Deve cadastrar avaliação com sucesso")
    public void deveCadastrarAvaliacaoComSucesso() {
        AvaliacaoCreateDTO avaliacaoCreate = avaliacaoBuilder.criarAvaliacao();

        AvaliacaoDTO avaliacao = avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreate))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AvaliacaoDTO.class)
                ;

        assertEquals(avaliacaoCreate.getDescricao(), avaliacao.getDescricao());
        assertEquals(avaliacaoCreate.getTipo(), avaliacao.getTipo());
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComDadosInvalidos() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoInvalido();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComDadosVazios() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoVazio();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComIdAcompanhamentoInexistente() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoComIdAcompanhamentoInexistente();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("Acompanhamento não encontrado."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComIdAlunoInexistente() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoComIdAlunoInexistente();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("Aluno não encontrado."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComDescricaoVazio() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoComDescricaoVazio();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("descricao: Descrição não pode ser nulo."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComTipoVazio() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoComTipoVazio();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar avaliação")
    public void deveNaoCadastrarAvaliacaoComDataVazio() {
        AvaliacaoCreateDTO avaliacaoCreateInvalido = avaliacaoBuilder.criarAvaliacaoComDataVazio();

        avaliacaoService.cadastrar(Utils.convertAvaliacaoToJson(avaliacaoCreateInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("dataCriacao: Data de Criação não pode ser nula."))
        ;
    }

}
