package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AdministradorService {

    public Response listar(Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .queryParam("page", page)
                        .queryParam("size", size)
                .when()
                        .get(Utils.getBaseUrl() + "/administrador/listar-usuarios")
                ;
    }

    public Response buscarPorId(Integer idUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .pathParam("idUsuario", idUsuario)
                    .when()
                        .get(Utils.getBaseUrl() + "/administrador/usuario/{idUsuario}")
                ;
    }

    public Response cadastrar(String cargo, String usuario) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .queryParam("cargo", cargo)
                        .body(usuario)
                .when()
                        .post(Utils.getBaseUrl() + "/administrador/cadastrar-usuario")
                ;
    }

    public Response atualizarUsuarioPorId(Integer idUsuario, String atualizaUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .pathParam("idUsuario", idUsuario)
                        .body(atualizaUsuario)
                .when()
                        .put(Utils.getBaseUrl() + "/administrador/atualizar-usuario/{idUsuario}")
                ;
    }

    public Response deletar(Integer idUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .pathParam("idUsuario", idUsuario)
                .when()
                        .delete(Utils.getBaseUrl() + "/administrador/delete/{idUsuario}")
                ;
    }

    public Response deletarTeste(Integer idUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestAdminSpec())
                        .pathParam("idUsuario", idUsuario)
                .when()
                        .delete(Utils.getBaseUrl() + "/teste/delete/{idUsuario}")
                ;
    }

}
