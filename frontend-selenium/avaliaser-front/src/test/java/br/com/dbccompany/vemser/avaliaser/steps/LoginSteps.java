package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.LoginPage;
import cucumber.api.java.gl.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Dado("que estou na página inicial de login")
    public void telaLogin(){
    Assert.assertEquals("https://avaliaser-front-flame.vercel.app/", loginPage.validarUrlAtual());
    }

    @E("que preencho o campo com email inválido")
    public void preencherCampoEmailInvalido() {
        loginPage.preencherCampoEmailInvalido();
    }
    @E("que preencho o campo senha válido")
    public void preencherCampoSenhaValida() {
        loginPage.preencherCampoSenhaValida();
    }

    @Quando("clico em ‘Entrar’")
    public void clicarBotaoEntrar(){
        loginPage.clicarBotaoEntrar();
    }

    @Entao("devo visualizar mensagem de erro Email")
    public void validarMensagemDeErroEmail(){
        String mensagemErro = loginPage.validarMensagemDeErroEmail();
        Assert.assertEquals(mensagemErro, "Por favor digite um email válido.\n" +
                "Ex: fulano@dbc@dbccompany.com.br");
    }



    @E("que preencho o campo com email válido")
    public void preencherCampoEmailValido() {
        loginPage.preencherCampoEmailValido();
    }
    @E("que preencho o campo com senha inválida")
    public void preencherCampoSenhaInvalida() {
        loginPage.preencherCampoSenhaInvalida();
    }

    @Entao("devo visualizar mensagem de erro Senha")
    public void validarMensagemDeErroSenha(){
        String mensagemErro = loginPage.validarMensagemDeErroSenha();
        Assert.assertEquals(mensagemErro, "A senha deve ter no mínimo 3 caracteres");
    }





}
