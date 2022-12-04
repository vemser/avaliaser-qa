package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Aluno")
@Epic("Busca Aluno Por Id")
public class BuscarAlunoPorIdTest {
    AlunoService alunoService = new AlunoService();

    @Test
    @Tag("all")
    @Description("Deve buscar aluno por id")
    public void deveBuscarAlunoPorId() {
        AlunoDTO alunoDTO = alunoService.buscarPorId(19)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(AlunoDTO.class)
                ;

        assertEquals("Jaciane Santana", alunoDTO.getNome());
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar aluno por id inexistente")
    public void deveNaoBuscarAlunoPorIdInexistente() {
        String message = alunoService.buscarPorId(15975364)
                .then()
                    .log().all()
                    .statusCode(400)
                    .extract().path("message")
        ;

        assertEquals("Aluno não encontrado.", message);
    }
}