package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
public class BuscarUsuarioPorIdTest {

    AdministradorService administradorService = new AdministradorService();

    @Test
    @Tag("all")
    @Description("Deve buscar usuário por id")
    public void deveBuscarUsuarioPorId() {
        UsuarioDTO usuarioDTO = administradorService.buscarPorId(1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals("paulo", usuarioDTO.getNome());
        assertEquals(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"), usuarioDTO.getEmail());
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar usuário por id")
    public void deveNaoBuscarUsuarioPorIdInexistente() {
        String message = administradorService.buscarPorId(10191993)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Usuário não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar usuário por id")
    public void deveNaoBuscarUsuarioPorIdZerado() {
        String message = administradorService.buscarPorId(0)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Usuário não encontrado.", message);
    }

}
