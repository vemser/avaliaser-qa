package br.com.dbccompany.vemser.avaliaser.aceitacao.administrador;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioDTO;
import br.com.dbccompany.vemser.avaliaser.service.AdministradorService;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Administrador")
public class CadastraUsuarioTest {

    AdministradorService administradorService = new AdministradorService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve cadastrar usuario com sucesso")
    public void deveCadastrarUsuarioAdminComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();

        UsuarioDTO usuarioDTO = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals(usuario.getNome(), usuarioDTO.getNome());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals("Admin", usuarioDTO.getCargo());

        administradorService.deletarTeste(usuarioDTO.getIdUsuario())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve cadastrar usuario com sucesso")
    public void deveCadastrarUsuarioGestorComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();

        UsuarioDTO usuarioDTO = administradorService
                .cadastrar(CargoDTO.GESTOR.toString(), Utils.convertUsuarioToJson(usuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals(usuario.getNome(), usuarioDTO.getNome());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals("Gestor de Pessoas", usuarioDTO.getCargo());

        administradorService.deletarTeste(usuarioDTO.getIdUsuario())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve cadastrar usuario com sucesso")
    public void deveCadastrarUsuarioInstrutorComSucesso() {
        UsuarioCreateDTO usuario = usuarioBuilder.criarUsuario();

        UsuarioDTO usuarioDTO = administradorService
                .cadastrar(CargoDTO.INSTRUTOR.toString(), Utils.convertUsuarioToJson(usuario))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(UsuarioDTO.class)
                ;

        assertEquals(usuario.getNome(), usuarioDTO.getNome());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals("Instrutor", usuarioDTO.getCargo());

        administradorService.deletarTeste(usuarioDTO.getIdUsuario())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComDadosInvalidos() {
        UsuarioCreateDTO usuarioInvalido = usuarioBuilder.criarUsuarioInvalido();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
        assertEquals("nome: Não permitido números e caracteres especiais.", errors.get(1));
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComEmailInvalido() {
        UsuarioCreateDTO usuarioComEmailInvalido = usuarioBuilder.criarUsuarioComEmailInvalido();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioComEmailInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComNomeInvalido() {
        UsuarioCreateDTO usuarioComNomeInvalido = usuarioBuilder.criarUsuarioComNomeInvalido();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioComNomeInvalido))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("nome: Não permitido números e caracteres especiais.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComDadosVazios() {
        UsuarioCreateDTO usuarioVazio = usuarioBuilder.criarUsuarioVazio();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("nome: Nome não pode ficar em branco.", errors.get(0));
        assertEquals("email: Email inválido.", errors.get(1));
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComEmailVazio() {
        UsuarioCreateDTO usuarioComEmailVazio = usuarioBuilder.criarUsuarioComEmailVazio();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioComEmailVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("email: Email inválido.", errors.get(0));
    }

    @Test
    @Tag("all")
    @Description("Deve não cadastrar usuario")
    public void deveNaoCadastrarUsuarioComNomeVazio() {
        UsuarioCreateDTO usuarioComNomeVazio = usuarioBuilder.criarUsuarioComNomeVazio();

        List<String> errors = administradorService
                .cadastrar(CargoDTO.ADMIN.toString(), Utils.convertUsuarioToJson(usuarioComNomeVazio))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().path("errors")
                ;

        assertEquals("nome: Nome não pode ficar em branco.", errors.get(0));
    }

}
