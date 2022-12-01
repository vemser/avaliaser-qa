package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AcompanhamentoService {
    public Response cadastrar(AcompanhamentoCreateDTO acompanhamento) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .body(acompanhamento)
                .when()
                .post(Utils.getBaseUrl() + "/acompanhamento/cadastrar-acompanhamento", new Object[0]);
    }
}
