package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.dto.PageUsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Administrador")
public class ListaUsuariosTest {

    AdministradorService administradorService = new AdministradorService();

    @Test
    @Tag("all")
    @Description("Deve listar usuários com paginação")
    public void deveListarUsuariosComPaginacao() {
        PageUsuarioDTO pageUsuarioDTO = administradorService.listar(0, 10)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageUsuarioDTO.class)
                ;

        assertEquals(0, pageUsuarioDTO.getPagina());
        assertEquals(10, pageUsuarioDTO.getTamanho());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de usuários vazia")
    public void deveRetornarListaDeUsuariosVazia() {
        PageUsuarioDTO pageUsuarioDTO = administradorService.listar(0, 0)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageUsuarioDTO.class)
                ;

        assertEquals(0, pageUsuarioDTO.getPagina());
        assertEquals(0, pageUsuarioDTO.getTamanho());
        assertTrue(pageUsuarioDTO.getElementos().isEmpty());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar lista de usuários")
    public void deveNaoRetornarListaDeUsuarios() {
        administradorService.listar(-1, -1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .extract().response()
                ;
    }

}
