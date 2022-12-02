package br.com.dbccompany.vemser.avaliaser.aceitacao.acompanhamento;

import br.com.dbccompany.vemser.avaliaser.builder.AcompanhamentoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.*;
import br.com.dbccompany.vemser.avaliaser.service.AcompanhamentoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtualizarAcompanhamentoTest {

    AcompanhamentoService acompanhamentoService = new AcompanhamentoService();
    AcompanhamentoBuilder acompanhamentoBuilder = new AcompanhamentoBuilder();

    @Test
    @Tag("all")
    @Description("Deve atualizar acompanhamento com sucesso")
    public void deveAtualizarAcompanhamentoComSucesso() {
        AtualizarAcompanhamentoDTO atualizarAcompanhamento = acompanhamentoBuilder.atualizarAcompanhamento();

        AcompanhamentoDTO acompanhamentoAtualizado = acompanhamentoService
                .atualizar(Utils.convertAtualizarAcompanhamentoToJson(atualizarAcompanhamento), 15)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AcompanhamentoDTO.class)
                ;

        assertEquals("Verificar a evolução do estagiário e passar feedback", acompanhamentoAtualizado.getDescricao());
        assertEquals("Reunião Vem Ser", acompanhamentoAtualizado.getTitulo());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao tentar atualizar acompanhamento com titulo vazio")
    public void deveNaoAtualizarAcompanhamentoComTituloVazio() {
        AtualizarAcompanhamentoDTO atualizarAcompanhamento = acompanhamentoBuilder.atualizarAcompanhamentoTituloVazio();

        acompanhamentoService
                .atualizar(Utils.convertAtualizarAcompanhamentoToJson(atualizarAcompanhamento), 15)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("titulo: Titulo não pode ficar em branco."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao tentar atualizar acompanhamento com descricao vazia")
    public void deveNaoAtualizarAcompanhamentoComDescricaoVazia() {
        AtualizarAcompanhamentoDTO atualizarAcompanhamento = acompanhamentoBuilder.atualizarAcompanhamentoDescricaoVazia();

        acompanhamentoService
                .atualizar(Utils.convertAtualizarAcompanhamentoToJson(atualizarAcompanhamento), 15)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("descricao: Descrição não pode ficar em branco."))
        ;
    }
}
