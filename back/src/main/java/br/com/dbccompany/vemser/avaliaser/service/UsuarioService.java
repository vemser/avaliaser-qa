package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UsuarioService {

    public Response loginUsuario(String login) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(login)
                .when()
                        .post(Utils.getBaseUrl() + "/auth/login")
                ;
    }

    public Response buscarUsuarioLogado() {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                .when()
                        .get(Utils.getBaseUrl() + "/auth/usuario-logado")
                ;
    }

    public Response atualizarUsuarioLogado(String nome) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .body(nome)
                .when()
                        .put(Utils.getBaseUrl() + "/auth/atualizar-usuario-logado")
                ;
    }

    public Response recuperarSenha(String email) {
        return
                given()
                        .queryParam("email", email)
                .when()
                        .post(Utils.getBaseUrl() + "/auth/recuperar-senha")
                ;
    }

    public Response alterarSenhaRecuperacao(String senha) {
        return
                given()
                        .queryParam("senha", senha)
                .when()
                        .put(Utils.getBaseUrl() + "/auth/alterar-senha-usuario-recuperacao")
                ;
    }

    public Response alterarSenhaLogado(String alteraSenhaUsuarioLogado) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .body(alteraSenhaUsuarioLogado)
                .when()
                        .put(Utils.getBaseUrl() + "/auth/alterar-senha-usuario-logado")
                ;
    }

    public Response uploadImagem(Integer idUsuario) {
        return RestAssured
                .given()
                        .spec(LoginSpecs.requestFotoAdminSpec())
                        .pathParam("idUsuario", idUsuario)
                        .multiPart(new File("./imagens/imgPanda.jpg"))
                .when()
                        .put(Utils.getBaseUrl() + "/auth/upload-imagem-usuario-logado/{idUsuario}");
    }

}
