package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Usuario")
public class CadastrarUsuarioTest {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    /*@Test
    @Tag("bug")
    @Description("Deve cadastrar usuario com sucesso")
    public void deveCadastrarUsuarioComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();

        Integer idUsuario = usuarioService.cadastrar(Utils.convertCargoToJson(CargoDTO.ADMIN), Utils.convertUsuarioToJson(usuario))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("email", equalTo(usuario.getEmail()))
                .body("nome", equalTo(usuario.getNome()))
                .extract().path("idUsuario")
                ;

        usuarioService.deletar(idUsuario)
                .then()
                .statusCode(HttpStatus.SC_OK)
        ;
    }*/

}
