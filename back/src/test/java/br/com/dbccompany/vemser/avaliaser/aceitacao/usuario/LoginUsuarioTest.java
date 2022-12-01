package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.LoginBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.LoginDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
public class LoginUsuarioTest {

    UsuarioService usuarioService = new UsuarioService();
    LoginBuilder loginBuilder = new LoginBuilder();

    @Test
    @Tag("all")
    @Description("Deve logar com sucesso")
    public void deveLogarComoAdminComSucesso() {
        LoginDTO login = loginBuilder.loginAdmin();

        usuarioService.loginUsuario(Utils.convertLoginToJson(login))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComDadosInvalidos() {
        LoginDTO loginInvalido = loginBuilder.loginInvalido();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
        assertEquals("senha: Senha precisa ter entre 8 e 16 caracteres.", errors.get(1));
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComEmailInvalido() {
        LoginDTO loginEmailInvalido = loginBuilder.loginEmailInvalido();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginEmailInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComSenhaInvalido() {
        LoginDTO loginSenhaInvalido = loginBuilder.loginSenhaInvalido();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginSenhaInvalido))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().path("errors")
                ;

        assertEquals("senha: Senha precisa ter entre 8 e 16 caracteres.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComDadosVazios() {
        LoginDTO loginVazio = loginBuilder.loginVazio();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
        assertEquals("senha: Senha precisa ter entre 8 e 16 caracteres.", errors.get(1));
        assertEquals("senha: Senha não pode ficar em branco.", errors.get(2));
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComEmailVazio() {
        LoginDTO loginEmailVazio = loginBuilder.loginEmailVazio();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginEmailVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComSenhaVazio() {
        LoginDTO loginSenhaVazio = loginBuilder.loginSenhaVazio();

        List<String> errors = usuarioService.loginUsuario(Utils.convertLoginToJson(loginSenhaVazio))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().path("errors")
                ;

        assertEquals("senha: Senha precisa ter entre 8 e 16 caracteres.", errors.get(0));
        assertEquals("senha: Senha não pode ficar em branco.", errors.get(1));
    }

}
