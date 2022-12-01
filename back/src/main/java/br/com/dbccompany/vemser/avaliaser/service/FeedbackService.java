package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FeedbackService {

    public Response listar(Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestInstrutorSpec())
                        .queryParam("page", page)
                        .queryParam("size", size)
                .when()
                        .get(Utils.getBaseUrl() + "/feedback/listar-feedback")
                ;
    }

    public Response listarPorAluno(Integer idAluno, Integer page, Integer size) {
        return
                given()
                        .spec(LoginSpecs.requestInstrutorSpec())
                        .pathParam("idAluno", idAluno)
                        .queryParam("page", page)
                        .queryParam("size", size)
                .when()
                        .get(Utils.getBaseUrl() + "/feedback/listar-feedback-por-id/{idAluno}")
                ;
    }

    public Response buscarPorId(Integer idFeedBack) {
        return
                given()
                        .spec(LoginSpecs.requestInstrutorSpec())
                        .pathParam("idFeedback", idFeedBack)
                .when()
                        .get(Utils.getBaseUrl() + "/feedback/buscar-feedback/{idFeedBack}")
                ;
    }

    public Response cadastrar(String feedback) {
        return
                given()
                        .spec(LoginSpecs.requestInstrutorSpec())
                        .body(feedback)
                .when()
                        .post(Utils.getBaseUrl() + "/feedback/cadastrar-feedback")
                ;
    }

    public Response atualizar(Integer idFeedBack, String atualizaFeedback) {
        return
                given()
                        .spec(LoginSpecs.requestInstrutorSpec())
                        .pathParam("idFeedback", idFeedBack)
                        .body(atualizaFeedback)
                .when()
                        .put(Utils.getBaseUrl() + "/feedback/editar-feedback/{idFeedBack}")
                ;
    }

}
