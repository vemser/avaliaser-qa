package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizaUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
@Epic("Atualiza Usuário")
public class AtualizaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve retornar usuário logado atualizado")
    public void deveRetornarUsuarioLogadoAtualizadoComSucesso() {
        AtualizaUsuarioLogadoDTO nome = usuarioBuilder.atualizarUsuarioLogado();

        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService
                .atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nome))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioLogadoDTO.class)
                ;

        assertEquals("Paulo Sergio", usuarioLogadoDTO.getNome());
        assertEquals(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"), usuarioLogadoDTO.getEmail());

        nome.setNome("paulo");
        usuarioService.atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nome));
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeInvalido() {
        AtualizaUsuarioLogadoDTO nomeInvalido = usuarioBuilder.atualizarUsuarioLogadoInvalido();

        usuarioService.atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nomeInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("nome: Não permitido números e caracteres especiais."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário logado atualizado")
    public void deveNaoRetornarUsuarioLogadoAtualizadoComNomeVazio() {
        AtualizaUsuarioLogadoDTO nomeVazio = usuarioBuilder.atualizarUsuarioLogadoVazio();

        usuarioService.atualizarUsuarioLogado(Utils.convertAtualizarUsuarioToJson(nomeVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("nome: Nome não pode ficar em branco."))
                ;
    }

}
