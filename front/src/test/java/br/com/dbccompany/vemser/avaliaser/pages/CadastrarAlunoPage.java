package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CadastrarAlunoPage extends BasePage{

    private static final By campoNome = By.cssSelector("#nomeCompletoAluno");
    private static final By campoEmail = By.cssSelector("#emailAluno");
    private static final By btnTrilha = By.cssSelector("#select-trilha");
    private static final By trilhaSelecionada = By.cssSelector("#frontend");
    private static final By btnEnviar = By.cssSelector("#botao-verde");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroNome = By.cssSelector("#erro-nomeCompletoAluno");
    private static final By msgErroEmail = By.cssSelector("#erro-emailAluno");

    @Step("Preencher campo nome")
    public void preencherCampoNome(String nome){
        sendKeys(campoNome, nome);
    }

    @Step("Preencher campo email")
    public void preencherCampoEmail(String email){
        sendKeys(campoEmail, email);
    }

    @Step("Clicar para selecionar uma trilha")
    public void clicarBtnTrilha(){
        click(btnTrilha);
    }

    @Step("Clicar na trilha selecionada")
    public void clicarTrilhaSelecionada(){
        click(trilhaSelecionada);
    }

    @Step("Clicar no botão Enviar")
    public void clicarBtnEnviar(){
        click(btnEnviar);
    }

    @Step("Validar mensagem de cadastro com sucesso")
    public String validarMensagemDeCadastroComSucesso(){
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Validar mensagem de erro para nome vazio")
    public String validarMensagemDeErroNome() {
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
