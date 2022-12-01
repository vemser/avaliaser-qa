package br.com.dbccompany.vemser.avaliaser.aceitacao.aluno;

import br.com.dbccompany.vemser.avaliaser.dto.AlunoDTO;
import br.com.dbccompany.vemser.avaliaser.service.AlunoService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Gestor")
public class DeletarAlunoTest {

    AlunoService alunoService = new AlunoService();

    AlunoDTO alunoDTO = alunoService.deletar(0)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .extract().as(AlunoDTO.class)
            ;

}