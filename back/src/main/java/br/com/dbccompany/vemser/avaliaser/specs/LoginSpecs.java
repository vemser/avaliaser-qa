package br.com.dbccompany.vemser.avaliaser.specs;

import br.com.dbccompany.vemser.avaliaser.util.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LoginSpecs {

    private static String tokenAdmin = new Auth().autenticacaoAdmin();
    private static String tokenGestor= new Auth().autenticacaoAdmin();

    private LoginSpecs() {}

    public static RequestSpecification requestAdminSpec() {
        return new RequestSpecBuilder().
                addHeader("Authorization", tokenAdmin).
                setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecGestor() {
        return (new RequestSpecBuilder())
                .addHeader("Authorization", tokenGestor)
                .setContentType(ContentType.JSON)
                .build();
    }

}
