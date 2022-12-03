package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditarUsuarioPage extends BasePage{

    private static final By campoNome = By.cssSelector("#nomeCompletoUsuario");
    private static final By btnEditar = By.cssSelector("#botao-verde");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroNome = By.cssSelector("#erro-nome");

    @Step("Alterar campo nome")
    public void alterarCampoNome(String nome) {
        clear(campoNome);
        sendKeys(campoNome, nome);
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
    public String validarMensagemDeErroNome() {
        return getText(msgErroNome);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
