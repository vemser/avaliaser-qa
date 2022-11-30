package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
public class BuscarAdministradorPorIdTest {

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
        assertEquals("paulo.sergio@dbccompany.com.br", usuarioDTO.getEmail());
    }

}
