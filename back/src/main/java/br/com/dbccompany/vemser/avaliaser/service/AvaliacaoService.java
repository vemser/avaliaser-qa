package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AvaliacaoService {

    public Response listar(Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .queryParam("page", page)
                        .queryParam("size", size)
                .when()
                        .get(Utils.getBaseUrl() + "/avaliacao-acompanhamento")
                ;
    }

    public Response listarPorAluno(Integer idAluno, Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .pathParam("idAluno", idAluno)
                        .queryParam("page", page)
                        .queryParam("size", size)
                .when()
                        .get(Utils.getBaseUrl() + "/avaliacao-acompanhamento/{idAluno}")
                ;
    }

    public Response cadastrar(String avaliacao) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .body(avaliacao)
                .when()
                        .post(Utils.getBaseUrl() + "/avaliacao-acompanhamento/cadastrar-avaliacao")
                ;
    }

    public Response atualizar(Integer idAvaliacao, String atualizaAvaliacao) {
        return
                given()
                        .spec(LoginSpecs.requestGestorSpec())
                        .pathParam("idAvaliacao", idAvaliacao)
                        .body(atualizaAvaliacao)
                .when()
                        .put(Utils.getBaseUrl() + "/avaliacao-acompanhamento/{idAvaliacao}")
                ;
    }

}
