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
    public void telaLogin() {
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/", loginPage.validarUrlAtual());
    }

    @E("que preencho o campo email Admim válido")
    public void preencherCampoEmailAdminValido() {
        loginPage.preencherCampoEmailValido("paulo.sergio@dbccompany.com.br");
    }

    @E("que preencho o campo email Gestor válido")
    public void preencherCampoEmailGestorValido() {
        loginPage.preencherCampoEmailValido("moises.noah@dbccompany.com.br");
    }

    @E("que preencho o campo email Instrutor válido")
    public void preencherCampoEmailInstrutorValido() {
        loginPage.preencherCampoEmailValido("mayra.amaral@dbccompany.com.br");
    }

    @E("que preencho o campo com email válido")
    public void preencherCampoEmailValido() {
        loginPage.preencherCampoEmailValido("paulo.serio@dbccompany.com.br");
    }

    @E("que preencho o campo com email inválido")
    public void preencherCampoEmailInvalido() {
        loginPage.preencherCampoEmailInvalido();
    }

    @E("que preencho o campo senha Admim válida")
    public void preencherCampoSenhaAdminValida() {
        loginPage.preencherCampoSenhaValida("administrador");
    }

    @E("que preencho o campo senha Gestor válida")
    public void preencherCampoSenhaGestorValida() {
        loginPage.preencherCampoSenhaValida("moisesnoah");
    }

    @E("que preencho o campo senha Instrutor válida")
    public void preencherCampoSenhaInstrutorValida() {
        loginPage.preencherCampoSenhaValida("a!0SC*C9");
    }

    @E("que preencho o campo senha válido")
    public void preencherCampoSenhaValida() {
        loginPage.preencherCampoSenhaValida("12345678");
    }

    @E("que preencho o campo com senha inválida")
    public void preencherCampoSenhaInvalida() {
        loginPage.preencherCampoSenhaInvalida();
    }

    @Quando("clico em ‘Entrar’")
    public void clicarBotaoEntrar() {
        loginPage.clicarBotaoEntrar();
    }

    @Quando("clico no link ‘Redefinir senha’")
    public void clicarRedefinirSenha() {
        loginPage.clicarRedefinirSenha();
    }

    @Entao("devo ser redirecionado para a página principal de administrador e visualizar mensagem de boas-vindas")
    public void telaPrincipalAdmin() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/admin", loginPage.validarUrlAtual());
        Assert.assertEquals("Seja bem-vindo(a)", loginPage.validarMensagemDeBoasVindas());
    }

    @Entao("devo ser redirecionado para a página principal de gestor de pessoas e visualizar mensagem de boas-vindas")
    public void telaPrincipalGestor() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/gestor", loginPage.validarUrlAtual());
        Assert.assertEquals("Seja bem-vindo(a)", loginPage.validarMensagemDeBoasVindas());
    }

    @Entao("devo ser redirecionado para a página principal de instrutor e visualizar mensagem de boas-vindas")
    public void telaPrincipalInstrutor() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/dashboard/instrutor", loginPage.validarUrlAtual());
        Assert.assertEquals("Seja bem-vindo(a)", loginPage.validarMensagemDeBoasVindas());
    }

    @Entao("devo visualizar mensagem de erro email ou senha")
    public void validarMensagemDeErroEmailOuSenhaIncorretos() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br", loginPage.validarMensagemDeErroEmailInvalido());
        Assert.assertEquals("A senha deve ter no mínimo 8 caracteres", loginPage.validarMensagemDeErroSenha());
    }

    @Entao("devo visualizar mensagem de erro Email")
    public void validarMensagemDeErroEmailInvalido() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br", loginPage.validarMensagemDeErroEmailInvalido());
    }

    @Entao("devo visualizar mensagem de erro Senha")
    public void validarMensagemDeErroSenha() {
        Assert.assertEquals("A senha deve ter no mínimo 8 caracteres", loginPage.validarMensagemDeErroSenha());
    }

    @Entao("devo visualizar mensagens de erro para campo vazio Email e Senha")
    public void validarMensagemDeErroEmailVazio() {
        Assert.assertEquals("Por favor, digite seu e-mail", loginPage.validarMensagemDeErroEmailVazio());
        Assert.assertEquals("Por favor, digite sua senha", loginPage.validarMensagemDeErroSenha());
    }

    @Entao("devo visualizar mensagem de erro para campo vazio Email")
    public void validarMensagemDeErroCampoEmailVazio() {
        Assert.assertEquals("Por favor, digite seu e-mail", loginPage.validarMensagemDeErroEmailVazio());
    }

    @Entao("devo visualizar mensagem de erro para campo vazio Senha")
    public void validarMensagemDeErroCampoSenhaVazio() {
        Assert.assertEquals("Por favor, digite sua senha", loginPage.validarMensagemDeErroSenha());
    }

    @Entao("devo visualizar tela para a mudança de senha")
    public void validarModalRedefinirSenha() {
        loginPage.validarModalRedefinirSenha();
    }

    @Dado("que faço login no sistema como administrador")
    public void logarDashboardAdmin() {
        loginPage.preencherCampoEmailValido("paulo.sergio@dbccompany.com.br");
        loginPage.preencherCampoSenhaValida("administrador");
        loginPage.clicarBotaoEntrar();
    }

    @Dado("que faço login no sistema como gestor")
    public void logarDashboardGestor() {
        loginPage.preencherCampoEmailValido("moises.noah@dbccompany.com.br");
        loginPage.preencherCampoSenhaValida("moisesnoah");
        loginPage.clicarBotaoEntrar();
    }

}
