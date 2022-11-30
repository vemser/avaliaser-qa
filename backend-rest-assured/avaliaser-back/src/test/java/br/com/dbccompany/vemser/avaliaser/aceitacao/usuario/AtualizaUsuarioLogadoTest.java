package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.dto.UsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtualizaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve retornar usuário logado atualizado")
    public void deveRetornarUsuarioLogadoAtualizadoComSucesso() {
        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService.atualizarUsuarioLogado("Paulo Sergio")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("Paulo Sergio", usuarioLogadoDTO.getNome());
        assertEquals(Manipulation.getProp().getProperty("prop.email"), usuarioLogadoDTO.getEmail());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeInvalido() {
        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService.atualizarUsuarioLogado("@123!")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("Paulo Sergio", usuarioLogadoDTO.getNome());
        assertEquals(Manipulation.getProp().getProperty("prop.email"), usuarioLogadoDTO.getEmail());
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeVazio() {
        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService.atualizarUsuarioLogado(StringUtils.EMPTY)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("Paulo Sergio", usuarioLogadoDTO.getNome());
        assertEquals(Manipulation.getProp().getProperty("prop.email"), usuarioLogadoDTO.getEmail());
    }

}
