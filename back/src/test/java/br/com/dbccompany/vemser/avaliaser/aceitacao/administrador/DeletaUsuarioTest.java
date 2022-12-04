package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
@Epic("Deleta Usuário")
public class DeletaUsuarioTest {

    AdministradorService administradorService = new AdministradorService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("delete")
    @Description("Deve deletar usuario com sucesso")
    public void deveDeletarUsuarioComSucesso() {
        // Deletar funciona de forma exclusão lógica
        // Por limitação de emails válidos com @dbccompany.com.br, endpoint foi testado uma vez e liberado

        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();
        UsuarioDTO usuarioCriado = administradorService
                .cadastrar(CargoDTO.GESTOR.toString(), Utils.convertUsuarioToJson(usuario))
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);

        administradorService.deletar(usuarioCriado.getIdUsuario())
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                ;

        administradorService.buscarPorId(usuarioCriado.getIdUsuario())
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body("message", equalTo("Usuário não encontrado."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não deletar usuario")
    public void deveNaoDeletarUsuarioComIdInexistente() {
        String message = administradorService
                .deletar(19931019).then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Usuário não encontrado.", message);
    }

}
