package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.dto.UsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
public class BuscaUsuarioLogado {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve retornar usuário logado")
    public void deveRetornarUsuarioLogadoComSucesso() {
        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService.buscarUsuarioLogado()
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("marcus", usuarioLogadoDTO.getNome());
        assertEquals("paulo.sergio@dbccompany.com.br", usuarioLogadoDTO.getEmail());
    }
}
