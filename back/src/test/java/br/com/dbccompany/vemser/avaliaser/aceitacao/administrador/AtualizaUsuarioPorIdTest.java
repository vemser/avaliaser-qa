package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizaUsuarioDTO;
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

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
@Epic("Atualiza Usuário")
public class AtualizaUsuarioPorIdTest {

    AdministradorService administradorService = new AdministradorService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve retornar usuário atualizado")
    public void deveAtualizarUsuarioPorIdComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();
        UsuarioDTO usuarioCriado = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuario))
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);

        AtualizaUsuarioDTO atualizaUsuario = usuarioBuilder.atualizarUsuarioPorId();

        UsuarioDTO usuarioAtualizado = administradorService
                .atualizarUsuarioPorId(usuarioCriado.getIdUsuario(), Utils.convertAtualizarUsuarioPorIdToJson(atualizaUsuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals("Jaciane", usuarioAtualizado.getNome());
        assertEquals("jaciane@dbccompany.com.br", usuarioAtualizado.getEmail());

        administradorService.deletarTeste(usuarioAtualizado.getIdUsuario())
                .then().log().all().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário atualizado")
    public void deveNaoAtualizarUsuarioComIdUsuarioInexistente() {
        AtualizaUsuarioDTO atualizaUsuario = usuarioBuilder.atualizarUsuarioPorId();

        String message = administradorService
                .atualizarUsuarioPorId(19931019, Utils.convertAtualizarUsuarioPorIdToJson(atualizaUsuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("message")
                ;

        assertEquals("Usuário não encontrado.", message);
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário atualizado")
    public void deveNaoAtualizarUsuarioComDadosInvalidos() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();
        UsuarioDTO usuarioCriado = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuario))
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);

        AtualizaUsuarioDTO atualizaUsuario = usuarioBuilder.atualizarUsuarioPorIdInvalido();

        administradorService
                .atualizarUsuarioPorId(usuarioCriado.getIdUsuario(), Utils.convertAtualizarUsuarioPorIdToJson(atualizaUsuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("nome: Não permitido números e caracteres especiais."))
                    .body(containsString("email: Email inválido."))
                ;

        administradorService.deletarTeste(usuarioCriado.getIdUsuario())
                .then().log().all().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("all")
    @Description("Deve não retornar usuário atualizado")
    public void deveNaoAtualizarUsuarioComDadosVazios() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();
        UsuarioDTO usuarioCriado = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuario))
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);

        AtualizaUsuarioDTO atualizaUsuario = usuarioBuilder.atualizarUsuarioPorIdVazio();

        administradorService
                .atualizarUsuarioPorId(usuarioCriado.getIdUsuario(), Utils.convertAtualizarUsuarioPorIdToJson(atualizaUsuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("email: Email inválido."))
                    .body(containsString("nome: Nome não pode ficar em branco."))
                ;

        administradorService.deletarTeste(usuarioCriado.getIdUsuario())
                .then().log().all().statusCode(HttpStatus.SC_OK);
    }

}
