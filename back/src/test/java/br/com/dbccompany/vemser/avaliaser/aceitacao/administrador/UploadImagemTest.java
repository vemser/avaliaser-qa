package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UploadImagemTest {

    AdministradorService administradorService = new AdministradorService();

    @Test
    @Tag("todos")
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
