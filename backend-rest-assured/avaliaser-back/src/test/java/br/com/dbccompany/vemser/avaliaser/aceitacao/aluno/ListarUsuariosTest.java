package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.dto.PageUsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
public class ListarUsuariosTest {

    UsuarioService usuarioService = new UsuarioService();

    /*@Test
    @Tag("all")
    @Description("Deve listar usuários com paginação")
    public void deveListarUsuariosComPaginacao() {
        PageUsuarioDTO pageUsuarioDTO = usuarioService.listar(0, 10)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(PageUsuarioDTO.class)
                ;

        assertAll("pageUsuarioDto",
                () -> assertEquals(0, pageUsuarioDTO.getPagina()),
                () -> assertEquals(10, pageUsuarioDTO.getTamanho())
        );
    }*/

}
