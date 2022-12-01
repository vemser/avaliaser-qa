package br.com.dbccompany.vemser.avaliaser.specs;

import br.com.dbccompany.vemser.avaliaser.util.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LoginSpecs {

    private static String tokenAdmin = new Auth().autenticacaoAdmin();
    private static String tokenGestor= new Auth().autenticacaoGestor();
    private static String tokenInstrutor = new Auth().autenticacaoInstrutor();

    private LoginSpecs() {}

    public static RequestSpecification requestAdminSpec() {
        return new RequestSpecBuilder().
                addHeader("Authorization", tokenAdmin).
                setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestGestorSpec() {
        return (new RequestSpecBuilder())
                .addHeader("Authorization", tokenGestor)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestInstrutorSpec() {
        return (new RequestSpecBuilder())
                .addHeader("Authorization", tokenInstrutor)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestFotoGestorSpec() {
        return (new RequestSpecBuilder())
                .addHeader("Authorization", tokenGestor)
                .setContentType(ContentType.MULTIPART)
                .build();
    }

    public static RequestSpecification requestFotoAdminSpec() {
        return (new RequestSpecBuilder())
                .addHeader("Authorization", tokenAdmin)
                .setContentType(ContentType.MULTIPART)
                .build();
    }

}
