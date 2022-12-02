package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Usuario")
public class UploadImagemAdministradorTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    @Tag("all")
    @Description("Deve fazer upload de imagem com sucesso")
    public void deveFazerUploadFotoComSucesso() {
        usuarioService.uploadImagem(1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                ;
    }

}