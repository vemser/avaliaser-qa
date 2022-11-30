package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AdministradorService {

    public Response listar(Integer paginaQueEuQuero, Integer tamanhoDeRegistrosPorPagina) {
        return
                given()
                        .spec(LoginSpecs.requestSpec())
                        .queryParam("paginaQueEuQuero", paginaQueEuQuero)
                        .queryParam("tamanhoDeRegistrosPorPagina", tamanhoDeRegistrosPorPagina)
                .when()
                        .get(Utils.getBaseUrl() + "/administrador/listar-usuarios")
                ;
    }

    public Response buscarPorId(Integer idUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestSpec())
                        .pathParam("idUsuario", idUsuario)
                    .when()
                        .get(Utils.getBaseUrl() + "/administrador/usuario/{idUsuario}")
                ;
    }

    public Response cadastrar(String cargo, String usuario) {
        return
                given()
                        .spec(LoginSpecs.requestSpec())
                        .queryParam("cargo", cargo)
                        .body(usuario)
                .when()
                        .post(Utils.getBaseUrl() + "/administrador/cadastrar-usuario")
                ;
    }

    public Response deletar(Integer idUsuario) {
        return
                given()
                        .spec(LoginSpecs.requestSpec())
                        .pathParam("idUsuario", idUsuario)
                .when()
                        .delete(Utils.getBaseUrl() + "/auth/delete/{idUsuario}")
                ;
    }

}
