package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
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

    private static final By mensagemErroEmail =
            By.cssSelector("#\\31  > div.Toastify__toast-body > div:nth-child(2)");

    private static final By mensagemErroSenha =
            By.cssSelector("#erro-senha");

    @Step("Preencher campo com email inválido")
    public void preencherCampoEmailInvalido() {
        sendKeys(campoEmail,"teste.qa@gmail.com.br");
    }

    @Step("Preencher campo com email válido")
    public void preencherCampoEmailValido() {
        sendKeys(campoEmail,"teste.qa@dbccompany.com.br");
    }

    @Step("Preencher campo com senha inválida")
    public void preencherCampoSenhaInvalida() {
        sendKeys(campoSenha,"1");
    }

    @Step("Preencher campo com senha válida")
    public void preencherCampoSenhaValida() {
        sendKeys(campoSenha,"123");
    }
    @Step("Clicar no botão Entrar")
    public void clicarBotaoEntrar() {
        click(btnEntrar);
    }

    @Step("Validar Mensagem de Erro Email")
    public String validarMensagemDeErroEmail(){
         return getText(mensagemErroEmail);
    }

    @Step("Validar Mensagem de Erro Senha")
    public String validarMensagemDeErroSenha(){
        return getText(mensagemErroSenha);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }


}
