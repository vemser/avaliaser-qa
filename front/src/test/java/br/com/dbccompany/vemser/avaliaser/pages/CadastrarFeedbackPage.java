package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CadastrarFeedbackPage extends BasePage{

    private static final By selecionarStack = By.cssSelector("#qa");
    private static final By campoSelecionarAluno = By.cssSelector("#idAluno");
    private static final By alunoSelecionado = By.cssSelector("#alunos-qa-19");
    //private static final By alunoSelecionado = By.cssSelector("#alunos-front-20");
    private static final By campoInputDescricao = By.cssSelector("#descricao");
    private static final By campoSelecionarStatus = By.cssSelector("#status");
    private static final By statusSelecionado = By.cssSelector("#menu-tipo > div.MuiPaper-root.MuiPaper-elevation." +
            "MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded." +
            "MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(2)");
    private static final By btnEnviar = By.cssSelector("#botao-azul");
    private static final By msgConfirmacaoOUErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By msgErroDescricaoVazio = By.cssSelector("#erro-descricao");

    @Step("clicar selecionar Stack")
    public void clicarStack(){
        click(selecionarStack);
    }

    @Step("clicar campo selecionar aluno")
    public void clicarCampoSelecionarAluno(){
        click(campoSelecionarAluno);
    }

    @Step("clicar aluno selecionado")
    public void clicarAlunoSelecionado(){
        click(alunoSelecionado);
    }

    @Step("preencher descrição")
    public void preencherDescricao(){
        sendKeys(campoInputDescricao, "TESTE FEEDBACK");
    }

    @Step("clicar campo selecionar status")
    public void clicarCampoSelecionarStatus(){
        click(campoSelecionarStatus);
    }

    @Step("clicar status selecionado")
    public void clicarStatusSelecionado(){
        click(statusSelecionado);
    }

    @Step("clicar botão enviar")
    public void clicarBtnEnviar(){
        click(btnEnviar);
    }

    @Step("validar cadastro feedback com sucesso")
    public String validarCadastroFeedback(){
        return getAttributeInnerText(msgConfirmacaoOUErro);
    }

    @Step("validar mensagem erro campos vazios")
    public String validarMensagemErroCamposObrigatorios(){
        return getAttributeInnerText(msgConfirmacaoOUErro);
    }

    @Step("validar mensagem erro campo descrição vazio")
    public String validarMensagemErroDescricaoVazio(){
        return getText(msgErroDescricaoVazio);
    }

}
