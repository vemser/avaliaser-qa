package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AlunoPage extends BasePage{
    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnCadastrarAluno =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded." +
                    "MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded." +
                    "MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(5)");

    private static final By btnEditarAluno = By.cssSelector("");
    private static final By btnDeletarAluno = By.cssSelector("");
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
