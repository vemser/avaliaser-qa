package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.LoginPage;

import cucumber.api.java.pt.Dado;
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

    @E("que preencho o campo email Admim válido")
    public void preencherCampoEmailAdminValido() {
        loginPage.preencherCampoEmailValido("paulo.sergio@dbccompany.com.br");
    }
    @E("que preencho o campo senha Admim válida")
    public void preencherCampoSenhaAdminValida() {
        loginPage.preencherCampoSenhaValida("admin");
    }

    @Entao("devo ser redirecionado para a página principal de administrador e visualizar mensagem de boas-vindas")
    public void telaPrincipalAdmin(){
        loginPage.validarUrlAtual();
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/admin", loginPage.validarUrlAtual());
        String mensagemBoasVindas = loginPage.validarMensagemDeBoasVindas();
        Assert.assertEquals("Seja Bem vindo(a)", mensagemBoasVindas);
    }

    @Entao("devo visualizar mensagem de erro email ou senha incorretos")
    public void validarMensagemDeErroEmailOuSenhaIncorretos(){
        String mensagemErro = loginPage.validarMensagemDeErroEmailOuSenhaIncorretos();
        Assert.assertEquals("Email ou senha incorretos. Login não concluído.", mensagemErro);
    }

    @E("que preencho o campo com email inválido")
    public void preencherCampoEmailInvalido() {
        loginPage.preencherCampoEmailInvalido();
    }
    @E("que preencho o campo senha válido")
    public void preencherCampoSenhaValida() {
        loginPage.preencherCampoSenhaValida("123");
    }

    @Quando("clico em ‘Entrar’")
    public void clicarBotaoEntrar(){
        loginPage.clicarBotaoEntrar();
    }

    @Entao("devo visualizar mensagem de erro Email")
    public void validarMensagemDeErroEmailInvalido(){
        String mensagemErro = loginPage.validarMensagemDeErroEmailInvalido();
        Assert.assertEquals("Por favor digite um email válido.\n" +
                "Ex: fulano@dbc@dbccompany.com.br", mensagemErro);
    }



    @E("que preencho o campo com email válido")
    public void preencherCampoEmailValido() {
        loginPage.preencherCampoEmailValido("teste.qa@dbccompany.com.br");
    }
    @E("que preencho o campo com senha inválida")
    public void preencherCampoSenhaInvalida() {
        loginPage.preencherCampoSenhaInvalida();
    }

    @Entao("devo visualizar mensagem de erro Senha")
    public void validarMensagemDeErroSenha(){
        String mensagemErro = loginPage.validarMensagemDeErroSenha();
        Assert.assertEquals("A senha deve ter no mínimo 3 caracteres",mensagemErro);
    }

    @E("que não preencho o campo email")
    public void preencherCampoEmailVazio() {
        loginPage.preencherCampoEmailVazio();
    }
    @E("que não preencho o campo senha")
    public void preencherCampoSenhaVazia() {
        loginPage.preencherCampoSenhaVazia();
    }

    @Entao("devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Email")
    public void validarMensagemDeErroEmailVazio(){
        String mensagemErroEmail = loginPage.validarMensagemDeErroEmailVazio();
        Assert.assertEquals("Por favor, digite seu e-mail",mensagemErroEmail);
    }

    @Entao("devo validar mensagem de erro ao realizar tentativa de login sem preencher campo Senha")
    public void validarMensagemDeErroCampoSenhaVazia(){
        String mensagemErroSenha = loginPage.validarMensagemDeErroSenha();
        Assert.assertEquals("Por favor, digite sua senha",mensagemErroSenha);
    }

    @Quando("clico no botão ‘Mostrar’")
    public void clicarBotaoMostrar(){
        loginPage.clicarBotaoMostrar();
    }

    @Entao("devo visualizar a senha digitada na tela")
    public void visualizarSenhaDigitada(){
        Assert.assertEquals("123", loginPage.visualizarSenha());
    }


    @Quando("clico no link ‘Redefinir senha’")
    public void clicarRedefinirSenha(){
        loginPage.clicarRedefinirSenha();
    }

    @Entao("devo validar modal para a mudança de senha")
    public void validarModalRedefinirSenha(){
        loginPage.validarModalRedefinirSenha();
    }





}
