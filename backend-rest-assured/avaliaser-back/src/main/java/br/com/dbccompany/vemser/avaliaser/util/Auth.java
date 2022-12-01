package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.builder.LoginBuilder;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Auth {

    public String autenticacaoAdmin() {
        LoginBuilder loginBuilder = new LoginBuilder();

        return
                given()
                        .contentType(ContentType.JSON)
                        .body(new Gson().toJson(loginBuilder.loginAdmin()))
                .when()
                        .post(Utils.getBaseUrl() + "/auth/login")
                .then()
                        .extract().asString()
                ;
    }

    public String autenticacaoGestor() {
        LoginBuilder loginBuilder = new LoginBuilder();
        return ((ValidatableResponse)((Response) RestAssured
         .given()
                .contentType(ContentType.JSON)
                .body((new Gson()).toJson(loginBuilder.loginGestor()))
           .when().post(Utils.getBaseUrl() + "/auth/login", new Object[0]))
            .then())
                .extract().asString();
    }

}
