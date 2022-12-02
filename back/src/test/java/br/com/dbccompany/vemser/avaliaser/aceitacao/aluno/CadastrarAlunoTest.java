package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.builder.AlunoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.*;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Aluno")
public class CadastrarAlunoTest {
    AlunoBuilder alunoBuilder = new AlunoBuilder();
    AlunoService alunoService = new AlunoService();

    public CadastrarAlunoTest() {
    }

    @Test
    @Tag("all")
    @Description("Deve cadastrar aluno com sucesso")
    public void deveCadastrarAlunoComSucesso() {

        AlunoCreateDTO aluno = alunoBuilder.criarAluno();

        AlunoDTO alunoDTO = alunoService
                .cadastrar(StackDTO.QA.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AlunoDTO.class)
                ;

        assertEquals(aluno.getNome(), alunoDTO.getNome());
        assertEquals("QA", alunoDTO.getStack());

//        alunoService.deletar(alunoDTO.getIdAluno())
//                .then()
//                .statusCode(HttpStatus.SC_OK)
//        ;
    }


    @Test
    @Tag("all")
    @Description("Deve validar erro ao tentar cadastrar aluno com campos vazios")
    public void deveNaoCadastrarAlunoComCampoVazio() {

        AlunoCreateDTO aluno = alunoBuilder.criarAlunoVazio();

         alunoService
                .cadastrar(StackDTO.QA.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;

    }

    @Test
    @Tag("all")
    @Description("Deve validar erro ao tentar cadastrar aluno com campo invalido")
    public void deveNaoCadastrarAlunoComCampoInvalido() {

        AlunoCreateDTO aluno = alunoBuilder.criarAlunoInvalido();

        alunoService
                .cadastrar(StackDTO.QA.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;

    }

}
