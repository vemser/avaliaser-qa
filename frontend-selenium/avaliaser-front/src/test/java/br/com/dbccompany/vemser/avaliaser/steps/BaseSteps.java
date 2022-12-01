package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.util.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSteps extends Browser {

    @Before
    public void abrirNavegador(){
        browserUp("https://avaliaser-front-flame.vercel.app/");
//        driver.manage().deleteAllCookies();
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }

}
