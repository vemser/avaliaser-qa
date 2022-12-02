package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Aluno")
public class BuscarAlunoPorIdTest {
    AlunoService alunoService = new AlunoService();

    public BuscarAlunoPorIdTest() {
    }

    @Test
    @Tag("all")
    @Description("Deve buscar aluno por id")
    public void deveBuscarAlunoPorId() {
        AlunoDTO alunoDTO = alunoService.buscarPorId(30)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(AlunoDTO.class)
                ;

        Assertions.assertEquals("Gaby Teste", alunoDTO.getNome());
    }

    @Test
    @Tag("all")
    @Description("Deve não buscar aluno por id inexistente")
    public void deveNaoBuscarAlunoPorIdInexistente() {
        String message = alunoService.buscarPorId(15975364)
                .then()
                .log().all()
                .statusCode(400)
                .extract().path("message", new String[0])
        ;

        Assertions.assertEquals("Aluno não encontrado.", message);
    }
}