package br.com.dbccompany.vemser.avaliaser.aceitacao.usuario;

import br.com.dbccompany.vemser.avaliaser.builder.UsuarioBuilder;
import br.com.dbccompany.vemser.avaliaser.dto.AlterarSenhaUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.service.UsuarioService;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;

@DisplayName("Usuario")
@Epic("Altera Senha Usuário Logado")
public class AlteraSenhaUsuarioLogadoTest {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    @Test
    @Tag("all")
    @Description("Deve alterar senha de usuario logado")
    public void deveAlterarSenhaDeUsuarioLogadoComSucesso() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaUsuarioLogado = usuarioBuilder.alterarSenhaUsuarioLogado();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaUsuarioLogado))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().response()
        ;

        alteraSenhaUsuarioLogado.setSenhaAntiga(usuarioBuilder.alterarSenhaUsuarioLogado().getSenhaNova());
        alteraSenhaUsuarioLogado.setSenhaNova(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"));
        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaUsuarioLogado));
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaInvalido() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaAntigaInvalida = usuarioBuilder.alterarSenhaAntigaInvalida();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaAntigaInvalida))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senhaAntiga: Senha precisa ter entre 8 e 16 caracteres."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaAntigaVazio() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaAntigaVazia= usuarioBuilder.alterarSenhaAntigaVazia();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaAntigaVazia))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senhaAntiga: Senha precisa ter entre 8 e 16 caracteres."))
                    .body(containsString("senhaAntiga: Senha antiga não pode ficar em branco."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaInvalido() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaNovaInvalida= usuarioBuilder.alterarSenhaNovaInvalida();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaNovaInvalida))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senhaNova: Senha precisa ter entre 8 e 16 caracteres."))
        ;
    }

    @Test
    @Tag("all")
    @Description("Deve não alterar senha de usuario logado")
    public void deveNaoAlterarSenhaDeUsuarioLogadoComSenhaNovaVazio() {
        AlterarSenhaUsuarioLogadoDTO alteraSenhaNovaVazia = usuarioBuilder.alterarSenhaNovaVazia();

        usuarioService.alterarSenhaLogado(Utils.convertAlterarSenhaUsuarioLogadoToJson(alteraSenhaNovaVazia))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("senhaNova: Senha nova não pode ficar em branco."))
                    .body(containsString("senhaNova: Senha precisa ter entre 8 e 16 caracteres."))
        ;
    }

}
