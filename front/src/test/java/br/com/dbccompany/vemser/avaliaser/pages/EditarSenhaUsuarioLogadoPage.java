package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditarSenhaUsuarioLogadoPage extends BasePage{

    private static final By campoSenhaAntiga = By.cssSelector("#senhaAntiga");
    private static final By campoSenhaNova = By.cssSelector("#novaSenha");
    private static final By campoConfirmaSenhaNova = By.cssSelector("#confirmarNovaSenha");
    private static final By btnEnviar = By.cssSelector("#botao-azul");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroSenha = By.cssSelector("#erro-cargo01");

    @Step("Preenche campo senha antiga")
    public void preencherCampoSenhaAntiga(String senhaAntiga) {
        sendKeys(campoSenhaAntiga, senhaAntiga);
    }

    @Step("Preenche campo senha nova")
    public void preencherCampoSenhaNova(String senhaNova) {
        sendKeys(campoSenhaNova, senhaNova);
    }

    @Step("Preenche campo confirma senha nova")
    public void preencherCampoConfirmaSenhaNova(String confirmaSenhaNova) {
        sendKeys(campoConfirmaSenhaNova, confirmaSenhaNova);
    }

    @Step("Clicar no botão Enviar")
    public void clicarBtnEnviar(){
        click(btnEnviar);
    }

    @Step("Validar mensagem de alteração de senha com sucesso")
    public String validarMensagemDeAlteracaoDeSenhaComSucesso(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem erro para senha antiga inválido")
    public String validarMensagemDeErroSenhaAntigaInvalido(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem de erro para senha inválido ou vazio")
    public String validarMensagemDeErroSenhaInvalidoOuVazio() {
        return getText(msgErroSenha);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
