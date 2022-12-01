package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UploadImagemTest {

    AlunoService alunoService = new AlunoService();

    @Test
    @Tag("all")
    @Description("Deve fazer upload de imagem com sucesso")
    public void deveCadastrarAlunoComSucesso(){

        AlunoDTO alunoDTO = alunoService
                .uploadImagem(21)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AlunoDTO.class);

    }
}
