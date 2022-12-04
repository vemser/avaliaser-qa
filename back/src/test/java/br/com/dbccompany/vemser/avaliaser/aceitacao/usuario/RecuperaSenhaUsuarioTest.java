package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
@Epic("Recupera Senha Usuário")
public class RecuperaSenhaUsuarioTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve recuperar senha de usuario")
    public void deveRecuperarSenhaDeUsuarioComSucesso() {
        usuarioService.recuperarSenha(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"))
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
        String message = usuarioService.recuperarSenha("teste@gmail.com")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
        ;

        assertEquals("Usuário não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não recuperar senha de usuario")
    public void deveNaoRecuperarSenhaDeUsuarioComEmailVazio() {
        String message = usuarioService.recuperarSenha(StringUtils.EMPTY)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
        ;

        assertEquals("Usuário não encontrado.", message);
    }

}
