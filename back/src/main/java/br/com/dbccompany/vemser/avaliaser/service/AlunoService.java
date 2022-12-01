package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.io.File;

public class AlunoService {
    public AlunoService() {
    }

    public Response cadastrar(String stack, String aluno) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .queryParam("stack", stack)
                .body(aluno)
                .when()
                .post(Utils.getBaseUrl() + "/aluno/cadastrar-aluno");
    }

    public Response buscarPorId(Integer idAluno) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .when()
                .get(Utils.getBaseUrl() + "aluno/{idAluno}");
    }

    public Response atualizarAluno(Integer idAluno, String stack, String alunoAtualizado) {
        RestAssured.defaultParser = Parser.JSON;
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .queryParam("stack", stack)
                .body(alunoAtualizado)
                .when()
                .put(Utils.getBaseUrl() + "/aluno/atualizar-aluno/{idAluno}");
    }

    public Response deletar(Integer idAluno) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .when()
                .delete(Utils.getBaseUrl() + "/aluno/delete/{idAluno}");
    }

    public Response listar(Integer paginaQueEuQuero, Integer tamanhoDeRegistrosPorPagina) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .queryParam("paginaQueEuQuero", paginaQueEuQuero)
                .queryParam("tamanhoDeRegistrosPorPagina", tamanhoDeRegistrosPorPagina)
                .when()
                .get(Utils.getBaseUrl() + "/aluno/listar-usuarios");
    }

    public Response uploadImagem(Integer idAluno) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestFotoGestorSpec())
                .pathParam("idAluno", idAluno)
                .multiPart(new File("./imagens/imgPanda.jpg"))
                .when()
                .put(Utils.getBaseUrl() + "/aluno/upload-imagem/{idAluno}");
    }
}