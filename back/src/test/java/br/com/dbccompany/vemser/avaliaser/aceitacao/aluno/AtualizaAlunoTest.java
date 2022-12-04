package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.builder.AlunoBuilder;
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
@Epic("Atualiza Aluno")
public class AtualizaAlunoTest {
    AlunoService alunoService = new AlunoService();
    AlunoBuilder alunoBuilder = new AlunoBuilder();

    @Test
    @Tag("all")
    @Description("Deve retornar aluno atualizado")
    public void deveAtualizarAlunoComSucesso() {
        AlunoDTO alunoAtualizado = alunoBuilder.atualizarAluno();

        AlunoCreateDTO aluno = alunoBuilder.criarAluno();

        AlunoDTO alunoDTO = alunoService.cadastrar(StackDTO.QA.toString(), Utils.convertAlunoToJson(aluno))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AlunoDTO.class)
                ;

        alunoService.atualizarAluno(alunoDTO.getIdAluno(), "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(AlunoDTO.class)
                ;

        alunoService.deletarTeste(alunoDTO.getIdAluno())
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao atualizar aluno com nome invalido")
    public void deveRetornarErroAoAtualizarAlunoNomeInvalido() {
        AlunoDTO alunoAtualizado = alunoBuilder.atualizarAlunoInvalido();
        alunoService.atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                .then()
                    .log().all()
                    .statusCode(400)
                ;

    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao atualizar aluno com nome vazio")
    public void deveRetornarErroAoAtualizarAlunoNomeVazio() {
        AlunoDTO alunoAtualizado = alunoBuilder.atualizarAlunoVazio();
        alunoService.atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                .then()
                    .log().all()
                    .statusCode(400)
                ;

    }

}

