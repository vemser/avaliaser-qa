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

import static org.hamcrest.Matchers.containsString;

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

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("email: Email inválido."))
                    .body(containsString("senha: Senha precisa ter entre 8 e 16 caracteres."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComEmailInvalido() {
        LoginDTO loginEmailInvalido = loginBuilder.loginEmailInvalido();

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginEmailInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("email: Email inválido."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComSenhaInvalido() {
        LoginDTO loginSenhaInvalido = loginBuilder.loginSenhaInvalido();

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginSenhaInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senha: Senha precisa ter entre 8 e 16 caracteres."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComDadosVazios() {
        LoginDTO loginVazio = loginBuilder.loginVazio();

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senha: Senha precisa ter entre 8 e 16 caracteres."))
                    .body(containsString("email: Email inválido."))
                    .body(containsString("senha: Senha não pode ficar em branco."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComEmailVazio() {
        LoginDTO loginEmailVazio = loginBuilder.loginEmailVazio();

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginEmailVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("email: Email inválido."))
                ;
    }

    @Test
    @Tag("all")
    @Description("Deve não logar")
    public void deveNaoLogarComSenhaVazio() {
        LoginDTO loginSenhaVazio = loginBuilder.loginSenhaVazio();

        usuarioService.loginUsuario(Utils.convertLoginToJson(loginSenhaVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senha: Senha precisa ter entre 8 e 16 caracteres."))
                    .body(containsString("senha: Senha não pode ficar em branco."))
                ;
    }

}
