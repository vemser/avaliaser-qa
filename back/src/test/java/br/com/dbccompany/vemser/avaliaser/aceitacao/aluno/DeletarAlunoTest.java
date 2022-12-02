package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Deletar Aluno")
public class DeletarAlunoTest {


    AlunoService alunoService = new AlunoService();

    @Test
    @Tag("all")
    @Description("Deve deletar Aluno com sucesso")
    public void deveDeletarAlunoComSucesso() {
        AlunoService alunoService = new AlunoService();

        alunoService.deletar(30)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
               ;
    }

    @Test
    @Tag("all")
    @Description("Deve deletar Aluno com sucesso")
    public void deveNaoDeletarAlunoIdInexistente() {
        AlunoService alunoService = new AlunoService();

        alunoService.deletar(98)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }
}