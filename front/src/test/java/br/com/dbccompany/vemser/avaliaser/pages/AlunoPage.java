package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AlunoPage extends BasePage{
    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnCadastrarAluno =
            By.cssSelector("#cadastrar-aluno-visible-gestor");

    private static final By btnEditarAluno = By.cssSelector("#botao-editar-12");
    private static final By btnDeletarAluno = By.cssSelector("#botao-deletar-12");
    private static final By btnConfirmarDeletar = By.cssSelector("#botao-confirmar-modal");
    private static final By msgAlunoDeletado = By.cssSelector("#\\32  > div.Toastify__toast-body > div:nth-child(2)");

    @Step("Clicar no botão Menu")
    public void clicarBtnMenu(){
        click(btnMenu);
    }

    @Step("Clicar no botão Cadastrar Aluno")
    public void clicarBtnCadastrarAluno(){
        click(btnCadastrarAluno);
    }

    @Step("Clicar no botão Editar Aluno")
    public void clicarBtnEditarAluno(){
        click(btnEditarAluno);
    }

    @Step("Clicar no botão Deletar Colaborador")
    public void clicarBtnDeletarAluno(){
        click(btnDeletarAluno);
    }

    @Step("Clicar no botão Confirmar deletar")
    public void clicarBtnConfirmarDeletar(){
        click(btnConfirmarDeletar);
    }

    @Step("Validar mensagem de confirmação aluno deletado")
    public String validarMensagemDeAlunoDeletado(){
        return getText(msgAlunoDeletado);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
