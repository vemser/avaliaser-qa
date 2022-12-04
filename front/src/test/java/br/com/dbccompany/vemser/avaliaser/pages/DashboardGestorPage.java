package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardGestorPage extends BasePage{

    private static final By textDashboardGestor = By.cssSelector("#root > div.MuiBox-root.css-14ul6if > h3");
    private static final By msgBoasVindas = By.cssSelector("#boas-vindas-gestor");
    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnDashboard = By.cssSelector("#dashboard-visible-gestor");
    private static final By btnListaAcompanhamentos = By.cssSelector("#lista-acompanhamento-visible-gestor");
    private static final By btnCadastrarAcompanhamento = By.cssSelector("#cadastrar-acompanhamento-visible-gestor");
    private static final By btnAvaliarAcompanhamento = By.cssSelector("#avaliar-acompanhamento-visible-gestor");
    private static final By btnCadastrarAluno = By.cssSelector("#cadastrar-aluno-visible-gestor");
    private static final By btnFotoPerfil = By.cssSelector("#menu-avatar-gestor");
    private static final By btnEditarAluno = By.cssSelector("#botao-editar-20");

    @Step("Validar título de página Dashboard Gestor")
    public String validarTextoDashboardGestor(){
        return getText(textDashboardGestor);
    }

    @Step("Validar mensagem de boas vindas Gestor")
    public String validarMensagemDeBoasVindasGestor(){
        return getText(msgBoasVindas);
    }

    @Step("Clicar no botão Menu")
    public void clicarBtnMenu(){
        click(btnMenu);
    }

    @Step("Clicar no botão Lista acompanhamentos")
    public void clicarBtnListaAcompanhamentos() {
        click(btnListaAcompanhamentos);
    }

    @Step("Clicar no botão Cadastrar Acompanhamento")
    public void clicarBtnCadastrarAcompanhamento(){
        click(btnCadastrarAcompanhamento);
    }

    @Step("Clicar no botão Avaliar Acompanhamento")
    public void clicarBtnAvaliarAcompanhamento(){
        click(btnAvaliarAcompanhamento);
    }

    @Step("Clicar no botão Foto de Perfil")
    public void clicarBtnFotoPerfil(){
        click(btnFotoPerfil);
    }

    @Step("Clicar no botão cadastrar aluno como Gestor")
    public void clicarBtnCadastrarAlunoGestor() {
        click(btnCadastrarAluno);
    }

    @Step("Clicar no botão Editar Aluno")
    public void clicarBtnEditarAluno(){
        click(btnEditarAluno);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
