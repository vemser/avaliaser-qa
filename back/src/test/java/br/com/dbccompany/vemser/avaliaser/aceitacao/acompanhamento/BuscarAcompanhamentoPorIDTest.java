package br.com.dbccompany.vemser.avaliaser.aceitacao.acompanhamento;

import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AcompanhamentoService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Acompanhamento")
@Epic("Busca Acompanhamento Por Id")
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

        assertEquals("Acompanhamento teste QA", acompanhamento.getTitulo());
        assertEquals("Favor não editar e nem apagar", acompanhamento.getDescricao());
        assertEquals("2022-12-01", acompanhamento.getDataInicio());
    }

    @Test
    @Tag("all")
    @Description("Deve validar erro ao tentar buscar acompanhamento por id inexistente")
    public void deveNaoBuscarAcompanhamentoPorIdInexistente() {
         acompanhamentoService.buscarPorId(36987)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

}
