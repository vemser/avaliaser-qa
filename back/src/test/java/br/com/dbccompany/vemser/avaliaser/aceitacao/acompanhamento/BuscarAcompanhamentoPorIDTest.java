package br.com.dbccompany.vemser.avaliaser.aceitacao.acompanhamento;

import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AcompanhamentoService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static org.hamcrest.Matchers.containsString;

@DisplayName("Acompanhamento")
public class BuscarAcompanhamentoPorIDTest {

    AcompanhamentoService acompanhamentoService = new AcompanhamentoService();

    @Test
    @Tag("all")
    @Description("Deve buscar acompanhamento por id")
    public void deveBuscarAcompanhamentoPorId() {
        AcompanhamentoDTO acompanhamento = acompanhamentoService.buscarPorId(11)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AcompanhamentoDTO.class)
                ;

        Assert.assertEquals("Acompanhamento teste QA", acompanhamento.getTitulo());
        Assert.assertEquals("Favor não editar e nem apagar", acompanhamento.getDescricao());
        Assert.assertEquals("2022-12-01", acompanhamento.getDataInicio());

    }

    @Test
    @Tag("all")
    @Description("Deve validar erro ao tentar buscar acompanhamento por id inexistente")
    public void deveNaoBuscarAcompanhamentoPorIdInexistente() {
         acompanhamentoService.buscarPorId(36987)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("Acompanhamento não localizado, verifique se o ID inserido está correto."))
                ;


    }
}
