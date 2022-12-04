package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditarAlunoPage extends BasePage{

    private static final By campoNome = By.cssSelector("#nomeCompletoAluno");
    private static final By campoEmail = By.cssSelector("#emailAluno");
    private static final By btnTrilha = By.cssSelector("#select-trilha");
    private static final By trilhaSelecionada = By.cssSelector("#frontend");
    private static final By btnEditar = By.cssSelector("#botao-verde");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroNome = By.cssSelector("#erro-nomeCompletoAluno");
    private static final By msgErroEmail = By.cssSelector("#erro-emailAluno");

    @Step("Alterar campo nome")
    public void alterarCampoNome(String nome){
        clear(campoNome);
        sendKeys(campoNome, nome);
    }

    @Step("Alterar campo email")
    public void alterarCampoEmail(String email){
        clear(campoEmail);
        sendKeys(campoEmail, email);
    }

    @Step("Clicar para selecionar outra trilha")
    public void clicarBtnTrilha(){
        click(btnTrilha);
    }

    @Step("Clicar na trilha selecionada")
    public void clicarTrilhaSelecionada(){
        click(trilhaSelecionada);
    }

    @Step("Clicar no botão Editar")
    public void clicarBtnEditar(){
        click(btnEditar);
    }

    @Step("Validar mensagem de edição com sucesso")
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
