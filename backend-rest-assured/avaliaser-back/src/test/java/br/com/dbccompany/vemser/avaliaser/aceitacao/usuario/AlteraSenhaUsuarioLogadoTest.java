package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AlterarSenhaUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
public class AlteraSenhaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve alterar senha de usuario logado")
    public void deveAlterarSenhaDeUsuarioLogadoComSucesso() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaUsuarioLogado = usuarioBuilder.alterarSenhaUsuarioLogado();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaUsuarioLogado))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;

        alteraSenhaUsuarioLogado.setSenhaAntiga(usuarioBuilder.alterarSenhaUsuarioLogado().getSenhaNova());
        alteraSenhaUsuarioLogado.setSenhaNova(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"));
        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaUsuarioLogado));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaInvalido() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaAntigaInvalida = usuarioBuilder.alterarSenhaAntigaInvalida();

        List<String> errors = usuarioService
                .alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaAntigaInvalida))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
        ;

        assertEquals("senhaAntiga: Senha precisa ter entre 8 e 16 caracteres.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaVazio() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaAntigaVazia= usuarioBuilder.alterarSenhaAntigaVazia();

        List<String> errors = usuarioService
                .alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaAntigaVazia))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
        ;

        assertEquals("senhaAntiga: Senha precisa ter entre 8 e 16 caracteres.", errors.get(0));
        assertEquals("senhaAntiga: Senha antiga não pode ficar em branco.", errors.get(1));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaInvalido() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaNovaInvalida= usuarioBuilder.alterarSenhaNovaInvalida();

        List<String> errors = usuarioService
                .alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaNovaInvalida))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
        ;

        assertEquals("senhaNova: Senha precisa ter entre 8 e 16 caracteres.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaVazio() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaNovaVazia = usuarioBuilder.alterarSenhaNovaVazia();

        List<String> errors = usuarioService
                .alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaNovaVazia))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
        ;

        assertEquals("senhaNova: Senha nova não pode ficar em branco.", errors.get(0));
        assertEquals("senhaNova: Senha precisa ter entre 8 e 16 caracteres.", errors.get(1));
    }

}
