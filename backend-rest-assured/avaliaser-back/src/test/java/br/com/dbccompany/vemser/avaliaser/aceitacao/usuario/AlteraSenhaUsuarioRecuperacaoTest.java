package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AlteraSenhaUsuarioRecuperacaoTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve alterar senha de recuperação de usuario")
    public void deveAlterarSenhaDeRecuperacaoComSucesso() {
        usuarioService.alterarSenhaRecuperacao("123456")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de recuperação de usuario")
    public void deveNaoAlterarSenhaDeRecuperacaoComEmailInvalido() {
        usuarioService.alterarSenhaRecuperacao("teste@gmail.com")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de recuperação de usuario")
    public void deveNaoAlterarSenhaDeRecuperacaoComEmailVazio() {
        usuarioService.alterarSenhaRecuperacao(StringUtils.EMPTY)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN)
                    .extract().response()
        ;

        //validar mensagem
    }

}
