package br.com.dbccompany.vemser.avaliaser.service;

import br.com.dbccompany.vemser.avaliaser.specs.LoginSpecs;
import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class AlunoService {
    public AlunoService() {
    }

    public Response cadastrar(String stack, String aluno) {
        return (Response) RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .queryParam("stack", new Object[]{stack})
                .body(stack)
                .when()
                .post(Utils.getBaseUrl() + "/aluno/cadastrar-aluno", new Object[0]);
    }

    public Response buscarPorId(Integer idAluno) {
        return (Response)RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .when()
                .get(Utils.getBaseUrl() + "aluno/{idAluno}", new Object[0]);
    }

    public Response atualizarAluno(Integer idAluno, String stack, String alunoAtualizado) {
        RestAssured.defaultParser = Parser.JSON;
        return (Response)RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .queryParam("stack", new Object[]{stack})
                .body(alunoAtualizado)
                .when()
                .put(Utils.getBaseUrl() + "/aluno/atualizar-aluno/{idAluno}", new Object[0]);
    }

    public Response deletar(Integer idAluno) {
        return (Response)RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .pathParam("idAluno", idAluno)
                .when()
                .delete(Utils.getBaseUrl() + "/aluno/delete/{idAluno}", new Object[0]);
    }

    public Response listar(Integer paginaQueEuQuero, Integer tamanhoDeRegistrosPorPagina) {
        return (Response)RestAssured
                .given()
                .spec(LoginSpecs.requestGestorSpec())
                .queryParam("paginaQueEuQuero", paginaQueEuQuero)
                .queryParam("tamanhoDeRegistrosPorPagina", tamanhoDeRegistrosPorPagina)
                .when()
                .get(Utils.getBaseUrl() + "/aluno/listar-usuarios", new Object[0]);
    }

}