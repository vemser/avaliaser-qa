package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.builder.LoginBuilder;
import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Auth {

    LoginBuilder loginBuilder = new LoginBuilder();

    public String autenticacaoAdmin() {
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

}
