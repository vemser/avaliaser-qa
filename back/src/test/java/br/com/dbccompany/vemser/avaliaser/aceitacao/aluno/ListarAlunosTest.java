package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.PageAlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Aluno")
@Epic("Lista Alunos")
public class ListarAlunosTest {

    AlunoService alunoService = new AlunoService();

    @Test
    @Tag("all")
    @Description("Deve listar alunos com paginação")
    public void deveListarAlunosComPaginacao() {
        PageAlunoDTO pageAlunoDTO  = alunoService.listar(0, 10)
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(PageAlunoDTO.class)
        ;

        assertEquals(0, pageAlunoDTO.getPagina());
        assertEquals(10, pageAlunoDTO.getTamanho());
    }

    @Test
    @Tag("all")
    @Description("Deve retornar lista de alunos vazia")
    public void deveRetornarListaDeAlunosVazia() {
        PageAlunoDTO pageAlunoDTO = alunoService.listar(0, 0)
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(PageAlunoDTO.class)
        ;

        assertEquals(0, pageAlunoDTO.getPagina());
        assertEquals(0, pageAlunoDTO.getTamanho());
    }

}
