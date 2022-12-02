package br.com.dbccompany.vemser.avaliaser.aceitacao.acompanhamento;

import br.com.dbccompany.vemser.avaliaser.builder.AcompanhamentoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AcompanhamentoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Cadastra Acompanhamento")
@DisplayName("Acompanhamento")
public class CadastrarAcompanhamentoTest {

    AcompanhamentoService acompanhamentoService = new AcompanhamentoService();
    AcompanhamentoBuilder acompanhamentoBuilder = new AcompanhamentoBuilder();

    @Test
    @Tag("all")
    @Description("Deve cadastrar acompanhamento com sucesso")
    public void deveCadastrarAcompanhamentoComSucesso() {
        AcompanhamentoCreateDTO acompanhamentoCreateDTO = acompanhamentoBuilder.criarAcompanhamento();

        AcompanhamentoDTO acompanhamento = acompanhamentoService.cadastrar(Utils.convertAcompanhamentoToJson(acompanhamentoCreateDTO))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AcompanhamentoDTO.class)
                ;

        assertEquals(acompanhamentoCreateDTO.getDescricao(), acompanhamento.getDescricao());
        assertEquals(acompanhamentoCreateDTO.getTitulo(), acompanhamento.getTitulo());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao tentar cadastrar acompanhamento com titulo vazio")
    public void deveNaoCadastrarAcompanhamentoComTituloVazio() {
        AcompanhamentoCreateDTO acompanhamentoCreateDTO = acompanhamentoBuilder.criarAcompanhamentoTituloVazio();

        acompanhamentoService.cadastrar(Utils.convertAcompanhamentoToJson(acompanhamentoCreateDTO))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("titulo: Titulo não pode ficar em branco."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao tentar cadastrar acompanhamento com descricao vazia")
    public void deveNaoCadastrarAcompanhamentoComDescricaoVazia() {
        AcompanhamentoCreateDTO acompanhamentoCreateDTO = acompanhamentoBuilder.criarAcompanhamentoDescricaoVazia();

        acompanhamentoService.cadastrar(Utils.convertAcompanhamentoToJson(acompanhamentoCreateDTO))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("descricao: Descrição não pode ficar em branco."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao tentar cadastrar acompanhamento com data início vazia")
    public void deveNaoCadastrarAcompanhamentoComDataInicioVazia() {
        AcompanhamentoCreateDTO acompanhamentoCreateDTO = acompanhamentoBuilder.criarAcompanhamentoDataInicioVazia();

        acompanhamentoService.cadastrar(Utils.convertAcompanhamentoToJson(acompanhamentoCreateDTO))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("dataInicio: Data de Início não pode ser nula."))
        ;
    }

}
