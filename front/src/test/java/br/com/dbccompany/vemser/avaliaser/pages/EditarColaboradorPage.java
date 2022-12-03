package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditarColaboradorPage extends BasePage{

    private static final By campoNome = By.cssSelector("#nomeCompletoColaborador");
    private static final By campoEmail = By.cssSelector("#emailColaborador");
    private static final By btnEditar = By.cssSelector("#botao-verde");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroNome = By.cssSelector("#erro-nome");
    private static final By msgErroEmail = By.cssSelector("#erro-email");

    @Step("Alterar campo nome")
    public void alterarCampoNome(String nome) {
        clear(campoNome);
        sendKeys(campoNome, nome);
    }

    @Step("Alterar campo email")
    public void alterarCampoEmail(String email){
        clear(campoEmail);
        sendKeys(campoEmail, email);
    }

    @Step("Clicar no botão Editar")
    public void clicarBtnEditar(){
        click(btnEditar);
    }

    @Step("Validar mensagem de edição com sucesso")
    public String validarMensagemDeEdicaoComSucesso(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem erro para nome inválido")
    public String validarMensagemDeErroNomeInvalido(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem de erro para nome vazio")
    public String validarMensagemDeErroNomeVazio() {
        return getText(msgErroNome);
    }

    @Step("Validar mensagem de erro para email inválido ou vazio")
    public String validarMensagemDeErroEmail() {
        return getText(msgErroEmail);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
