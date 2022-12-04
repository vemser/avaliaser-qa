package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AcompanhamentoService {
    public Response cadastrar(String acompanhamento) {
        return
                given()
                .spec(LoginSpecs.requestGestorSpec())
                .body(acompanhamento)
                .when()
                .post(Utils.getBaseUrl() + "/acompanhamento/cadastrar-acompanhamento");
    }

    public Response atualizar(String acompanhamento, Integer idAcompanhamento) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .pathParam("idAcompanhamento", idAcompanhamento)
                        .body(acompanhamento)
                        .when()
                        .put(Utils.getBaseUrl() + "/acompanhamento/editar-acompanhamento/{idAcompanhamento}");
    }

    public Response buscarPorId(Integer idAcompanhamento) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .pathParam("idAcompanhamento", idAcompanhamento)
                        .when()
                        .get(Utils.getBaseUrl() + "/acompanhamento/buscar-acompanhamento/{idAcompanhamento}");
    }

    public Response listar(Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .when()
                        .get(Utils.getBaseUrl() + "/acompanhamento/listar-acompanhamento")
                ;
    }
}
