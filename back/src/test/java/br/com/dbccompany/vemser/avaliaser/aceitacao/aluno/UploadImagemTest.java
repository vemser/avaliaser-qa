package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Aluno")
@Epic("Upload Imagem Aluno")
public class UploadImagemTest {

    AlunoService alunoService = new AlunoService();

    @Test
    @Tag("all")
    @Description("Deve fazer upload de imagem com sucesso")
    public void deveInserirFotoComSucesso() {
        alunoService.uploadImagem(19)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                ;
    }

}
