package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlteraSenhaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("todos")
    @Description("Deve alterar senha de usuario logado")
    public void deveAlterarSenhaDeUsuarioLogadoComSucesso() {
        usuarioService.alterarSenhaLogado(Manipulation.getProp().getProperty("prop.senha"), "12345678")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;

        usuarioService.alterarSenhaLogado("12345678", Manipulation.getProp().getProperty("prop.senha"));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaInvalido() {
        List<String> errors = usuarioService.alterarSenhaLogado("abc123", "12345678")
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
        String message = usuarioService.alterarSenhaLogado(StringUtils.EMPTY, "12345678")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
        ;

        assertEquals("Senha atual informada está incorreta! Não é possível alterar senha.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaInvalido() {
        List<String> errors = usuarioService
                .alterarSenhaLogado(Manipulation.getProp().getProperty("prop.senha"), "abc123")
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
        List<String> errors = usuarioService
                .alterarSenhaLogado(Manipulation.getProp().getProperty("prop.senha"), StringUtils.EMPTY)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
        ;

        assertEquals("senhaNova: Senha nova não pode ficar em branco.", errors.get(0));
        assertEquals("senhaNova: Senha precisa ter entre 8 e 16 caracteres.", errors.get(1));
    }

}
