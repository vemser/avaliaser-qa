package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizarUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtualizaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve retornar usuário logado atualizado")
    public void deveRetornarUsuarioLogadoAtualizadoComSucesso() {
        AtualizarUsuarioLogadoDTO nome = usuarioBuilder.atualizarUsuario();

        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService
                .atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nome))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("Paulo Sergio", usuarioLogadoDTO.getNome());
        assertEquals(Manipulation.getProp().getProperty("prop.email"), usuarioLogadoDTO.getEmail());

        nome.setNome("paulo");
        usuarioService.atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nome));
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeInvalido() {
        AtualizarUsuarioLogadoDTO nomeInvalido = usuarioBuilder.atualizarUsuarioInvalido();

        List<String> errors = usuarioService
                .atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nomeInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("nome: Não permitido números e caracteres especiais.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeVazio() {
        AtualizarUsuarioLogadoDTO nomeVazio = usuarioBuilder.atualizarUsuarioVazio();

        List<String> errors = usuarioService.atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nomeVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("nome: Nome não pode ficar em branco.", errors.get(0));
    }

}
