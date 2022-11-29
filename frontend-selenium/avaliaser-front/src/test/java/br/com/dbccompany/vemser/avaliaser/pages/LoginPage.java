package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final By campoEmail =
            By.cssSelector("#email");

    private static final By campoSenha =
            By.cssSelector("#senha");


    private static final By btnEntrar =
            By.cssSelector("#botao-logar");

    private static final By redefinirSenha =
            By.cssSelector("#box-login > p");

    private static final By btnMostrarSenha =
            By.cssSelector("#box-login > div > div:nth-child(4) > div > div > button");

    private static final By mensagemErroEmailInvalido =
            By.cssSelector("#root > div > div");

    private static final By mensagemErroEmailVazio =
            By.cssSelector("#erro-email");

    private static final By mensagemErroSenha =
            By.cssSelector("#erro-senha");

    private static final By mensagemErroEmailOuSenhaIncorreto =
            By.cssSelector("#\\32  > div.Toastify__toast-body");

    private static final By mensagemBoasVindas =
            By.cssSelector("#\\31  > div.Toastify__toast-body");

    private static final By modalRedefinirSenha =
            By.cssSelector("body > div.MuiModal-root.css-19ni2f5 > form");

    @Step("Preencher campo com email inválido")
    public void preencherCampoEmailInvalido() {
        sendKeys(campoEmail,"teste.qa@naoexiste.com");
    }

    @Step("Preencher campo com email válido")
    public void preencherCampoEmailValido(String email) {
        sendKeys(campoEmail,email);
    }

    @Step("Preencher campo com email vazio")
    public void preencherCampoEmailVazio() {
        sendKeys(campoEmail,"");
    }

    @Step("Preencher campo com senha inválida")
    public void preencherCampoSenhaInvalida() {
        sendKeys(campoSenha,"1");
    }

    @Step("Preencher campo com senha válida")
    public void preencherCampoSenhaValida(String senha) {
        sendKeys(campoSenha,senha);
    }

    @Step("Preencher campo com senha vazia")
    public void preencherCampoSenhaVazia() {
        sendKeys(campoSenha,"");
    }
    @Step("Clicar no botão Entrar")
    public void clicarBotaoEntrar() {
        click(btnEntrar);
    }

    @Step("Clicar no botão Mostrar")
    public void clicarBotaoMostrar() {
        click(btnMostrarSenha);
    }

    @Step("Validar Mensagem de Erro Email Invalido")
    public String validarMensagemDeErroEmailInvalido(){
         return getText(mensagemErroEmailInvalido);
    }

    @Step("Validar Mensagem de Erro Email Vazio")
    public String validarMensagemDeErroEmailVazio(){
        return getText(mensagemErroEmailVazio);
    }

    @Step("Validar Mensagem de Erro Senha")
    public String validarMensagemDeErroSenha(){
        return getText(mensagemErroSenha);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

    @Step("Clicar Visualizar Senha")
    public String visualizarSenha(){
       return getText(campoSenha);
    }

    @Step("Clicar Redefinir Senha")
    public void clicarRedefinirSenha() {
        click(redefinirSenha);
    }

    @Step("Validar modal Redefinir Senha")
    public void validarModalRedefinirSenha(){
        Assert.assertNotNull(modalRedefinirSenha);
    }

    @Step("Validar Mensagem de Boas Vindas")
    public String validarMensagemDeBoasVindas(){
        return getText(mensagemBoasVindas);
    }

    @Step("Validar Mensagem de Erro Email ou Senha Incorretos")
    public String validarMensagemDeErroEmailOuSenhaIncorretos(){
        return getText(mensagemErroEmailOuSenhaIncorreto);
    }
}
