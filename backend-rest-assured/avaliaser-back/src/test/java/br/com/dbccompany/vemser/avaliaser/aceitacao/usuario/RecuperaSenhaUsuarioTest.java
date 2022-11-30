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

public class RecuperaSenhaUsuarioTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve recuperar senha de usuario")
    public void deveRecuperarSenhaDeUsuarioComSucesso() {
        usuarioService.recuperarSenha(Manipulation.getProp().getProperty("prop.email"))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não recuperar senha de usuario")
    public void deveNaoRecuperarSenhaDeUsuarioComEmailInvalido() {
        usuarioService.recuperarSenha("teste@gmail.com")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

    @Test
    @Tag("all")
    @Description("Deve não recuperar senha de usuario")
    public void deveNaoRecuperarSenhaDeUsuarioComEmailVazio() {
        usuarioService.recuperarSenha(StringUtils.EMPTY)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

}
