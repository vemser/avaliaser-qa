package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.PageAlunoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.PageUsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Aluno")
public class ListarAlunosTest {
    AlunoService alunoService = new AlunoService();
    PageAlunoDTO pageAlunoDTO = new PageAlunoDTO();

    public ListarAlunosTest() {
    }

    @Test
    @Tag("all")
    @Description("Deve listar alunos com paginação")
    public void deveListarAlunosComPaginacao() {
        PageUsuarioDTO pageUsuarioDTO = alunoService.listar(0, 10)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PageUsuarioDTO.class)
        ;

        Assertions.assertEquals(0, pageAlunoDTO.getPagina());
        Assertions.assertEquals(10, pageAlunoDTO.getTamanho());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de alunos vazia")
    public void deveRetornarListaDeAlunosVazia() {
        this.pageAlunoDTO = alunoService.listar(0, 0)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PageAlunoDTO.class)
        ;

        Assertions.assertEquals(0, pageAlunoDTO.getPagina());
        Assertions.assertEquals(0, pageAlunoDTO.getTamanho());
        Assertions.assertNull(pageAlunoDTO.getElementos());
    }
}
