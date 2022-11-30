package br.com.dbccompany.vemser.avaliaser.specs;

import br.com.dbccompany.vemser.avaliaser.util.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LoginSpecs {

    private static String token = new Auth().autenticacao();

    private LoginSpecs() {}

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder().
                addHeader("Authorization", token).
                setContentType(ContentType.JSON).
                build();
    }

}
