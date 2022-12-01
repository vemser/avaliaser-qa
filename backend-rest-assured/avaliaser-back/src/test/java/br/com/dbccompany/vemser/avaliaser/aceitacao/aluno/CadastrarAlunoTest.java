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

@DisplayName("Gestor")
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
                .cadastrar(CargoDTO.GESTOR.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("email", equalTo(aluno.getEmail()))
                .body("nome", equalTo(aluno.getNome()))
                .extract().as(AlunoDTO.class)
                ;

        assertEquals(aluno.getNome(), alunoDTO.getNome());
        assertEquals(aluno.getEmail(), alunoDTO.getEmail());

//        alunoService.deletar(alunoDTO.getIdAluno())
//                .then()
//                .statusCode(HttpStatus.SC_OK)
//        ;
    }
}
