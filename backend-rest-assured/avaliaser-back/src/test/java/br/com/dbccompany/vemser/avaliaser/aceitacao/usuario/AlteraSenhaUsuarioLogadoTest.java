package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AlteraSenhaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve alterar senha de usuario logado")
    public void deveAlterarSenhaDeUsuarioLogadoComSucesso() {
        usuarioService.alterarSenhaLogado(Manipulation.getProp().getProperty("prop.senha"), "123456")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaInvalido() {
        usuarioService.alterarSenhaLogado("123456", "246810")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaVazio() {
        usuarioService.alterarSenhaLogado(StringUtils.EMPTY, "246810")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaInvalido() {
        usuarioService.alterarSenhaLogado("123456", "246810")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaVazio() {
        usuarioService.alterarSenhaLogado("246810", StringUtils.EMPTY)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .extract().response()
        ;

        //validar mensagem
    }

}
