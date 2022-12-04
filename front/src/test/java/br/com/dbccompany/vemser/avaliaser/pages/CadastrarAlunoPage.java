package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CadastrarAlunoPage extends BasePage{

    private static final By campoNome = By.cssSelector("#nome");
    private static final By campoEmail = By.cssSelector("#email");
    private static final By btnGestorDePessoas = By.cssSelector("#gestor");
    private static final By btnInstrutor = By.cssSelector("#instrutor");
    private static final By btnEnviar = By.cssSelector("#botao-verde");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroNome = By.cssSelector("#erro-nome");
    private static final By msgErroEmail = By.cssSelector("#erro-email");
    private static final By msgErroCargo = By.cssSelector("#erro-cargo");

    @Step("Preencher campo nome")
    public void preencherCampoNome(String nome){
        sendKeys(campoNome, nome);
    }

    @Step("Preencher campo email")
    public void preencherCampoEmail(String email){
        sendKeys(campoEmail, email);
    }

    @Step("Clicar no botão Gestor de Pessoas")
    public void clicarBtnGestorDePessoas(){
        click(btnGestorDePessoas);
    }

    @Step("Clicar no botão Instrutor")
    public void clicarBtnInstrutor(){
        click(btnInstrutor);
    }

    @Step("Clicar no botão Enviar")
    public void clicarBtnEnviar(){
        click(btnEnviar);
    }

    @Step("Validar mensagem de cadastro com sucesso")
    public String validarMensagemDeCadastroComSucesso(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem de erro para nome ou email inválido")
    public String validarMensagemDeErroNomeOuEmail() {
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem de erro para nome inválido ou vazio")
    public String validarMensagemDeErroNome() {
        return getText(msgErroNome);
    }

    @Step("Validar mensagem de erro para email inválido ou vazio")
    public String validarMensagemDeErroEmail() {
        return getText(msgErroEmail);
    }

    @Step("Validar mensagem de erro para cargo não selecionado")
    public String validarMensagemDeErroCargo() {
        return getText(msgErroCargo);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
