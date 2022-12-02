package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Administrador")
@Epic("Upload imagem Usuário")
public class UploadImagemUsuarioTest {

    AdministradorService administradorService = new AdministradorService();

    @Test
    @Tag("all")
    @Description("Deve fazer upload de imagem com sucesso")
    public void deveFazerUploadFotoComSucesso() {
        administradorService
                .uploadImagem(1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                ;
    }

}
