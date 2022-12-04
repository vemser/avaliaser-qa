package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AlunoPage extends BasePage{

    private static final By btnEditarAluno = By.cssSelector("#botao-editar-20");
    private static final By btnDeletarAluno = By.cssSelector("#botao-deletar-20");
    private static final By btnConfirmarDeletar = By.cssSelector("#botao-confirmar-modal");
    private static final By msgAlunoDeletado = By.cssSelector("#\\32  > div.Toastify__toast-body > div:nth-child(2)");

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
