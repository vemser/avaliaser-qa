package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.builder.AlunoBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

public class AtualizarAlunoTest {
    AlunoService alunoService = new AlunoService();
    AlunoBuilder alunoBuilder = new AlunoBuilder();

    public AtualizarAlunoTest() {
    }

    @Test
    @Tag("all")
    @Description("Deve retornar aluno atualizado")
        public void deveAtualizarAlunoComSucesso() {
            AlunoDTO alunoAtualizado = this.alunoBuilder.atualizarAluno();
            AlunoDTO alunoDTO = alunoService
                            .atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                            .then()
                            .log().all()
                            .statusCode(200)
                            .extract().as(AlunoDTO.class)
                    ;
                    Assert.assertEquals("Jaciane Santana", alunoDTO.getNome());
                    Assert.assertEquals("QA", alunoDTO.getStack());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao atualizar aluno com nome invalido")
        public void deveRetornarErroAoAtualizarAlunoNomeInvalido() {
            AlunoDTO alunoAtualizado = alunoBuilder.atualizarAlunoInvalido();
            AlunoDTO alunoDTO = alunoService
                            .atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                            .then()
                            .log().all()
                            .statusCode(400)
                            .extract().as(AlunoDTO.class);

    }

    @Test
    @Tag("all")
    @Description("Deve retornar erro ao atualizar aluno com nome vazio")
    public void deveRetornarErroAoAtualizarAlunoNomeVazio() {
        AlunoDTO alunoAtualizado = this.alunoBuilder.atualizarAlunoInvalido();
        AlunoDTO alunoDTO =  alunoService
                        .atualizarAluno(1, "QA", Utils.convertAtualizarAlunoToJson(alunoAtualizado))
                .then()
                .log().all()
                .statusCode(400)
                .extract().as(AlunoDTO.class);

    }

}

