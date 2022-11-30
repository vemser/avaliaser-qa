package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
public class CadastrarAdministradorTest {

    AdministradorService administradorService = new AdministradorService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve cadastrar usuario com sucesso")
    public void deveCadastrarUsuarioComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();

        UsuarioDTO usuarioDTO = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("email", equalTo(usuario.getEmail()))
                    .body("nome", equalTo(usuario.getNome()))
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals(usuario.getNome(), usuarioDTO.getNome());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals(CargoDTO.ADMIN.toString(), usuarioDTO.getCargo());

        administradorService.deletar(usuarioDTO.getIdUsuario())
                .then()
                .statusCode(HttpStatus.SC_OK)
        ;
    }

}
