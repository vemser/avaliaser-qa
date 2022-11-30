package br.com.dbccompany.vemser.avaliaser.aceitacao.base;

import br.com.dbccompany.vemser.avaliaser.util.Utils;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = Utils.getBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
