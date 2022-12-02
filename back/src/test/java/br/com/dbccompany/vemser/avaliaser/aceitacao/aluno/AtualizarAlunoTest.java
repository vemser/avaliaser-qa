package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.builder.AlunoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
@DisplayName("Aluno - Atualizar")
public class AtualizarAlunoTest {
    AlunoService alunoService = new AlunoService();
    AlunoBuilder alunoBuilder = new AlunoBuilder();

    public AtualizarAlunoTest() {
    }

    @Test
    @Tag("all")
    @Description("Deve retornar aluno atualizado")
        public void deveAtualizarAlunoComSucesso() {
            AlunoDTO alunoAtualizado = alunoBuilder.atualizarAluno();
            AlunoDTO alunoDTO = alunoService
                            .atualizarAluno(35, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                            .then()
                            .log().all()
                            .statusCode(200)
                            .extract().as(AlunoDTO.class)
                    ;
                    Assert.assertEquals("Teste Aluno", alunoDTO.getNome());
                    Assert.assertEquals("QA", alunoDTO.getStack());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao atualizar aluno com nome invalido")
        public void deveRetornarErroAoAtualizarAlunoNomeInvalido() {
            AlunoDTO alunoAtualizado = alunoBuilder.atualizarAlunoInvalido();
                     alunoService
                            .atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
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

        alunoService
                        .atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                .then()
                .log().all()
                .statusCode(400);

    }

}

