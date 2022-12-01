package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UploadImagemTest {

    AdministradorService administradorService = new AdministradorService();

    @Test
    @Tag("all")
    @Description("Deve fazer upload de imagem com sucesso")
    public void deveFazerUploadFotoComSucesso(){

        UsuarioDTO usuarioCriado = administradorService
                .uploadImagem(1)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(UsuarioDTO.class);

    }

}
