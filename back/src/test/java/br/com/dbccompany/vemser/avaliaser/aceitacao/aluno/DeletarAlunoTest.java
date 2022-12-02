package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.builder.AlunoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.StackDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Aluno")
@Epic("Deleta Aluno")
public class DeletarAlunoTest {


    AlunoService alunoService = new AlunoService();
    AlunoBuilder alunoBuilder = new AlunoBuilder();

    @Test
    @Tag("all")
    @Description("Deve deletar Aluno com sucesso")
    public void deveDeletarAlunoComSucesso() {

        AlunoCreateDTO aluno = alunoBuilder.criarAluno();

        AlunoDTO alunoDTO = alunoService
                .cadastrar(StackDTO.QA.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AlunoDTO.class)
                ;

        alunoService.deletar(alunoDTO.getIdAluno())
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