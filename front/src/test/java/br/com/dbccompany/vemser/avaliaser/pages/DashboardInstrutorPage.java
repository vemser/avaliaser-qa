package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardInstrutorPage extends BasePage {

    private static final By validacaoLogin = By.cssSelector("#boas-vindas-instrutor");
    private static final By btnMenuPerfilInstrutor = By.cssSelector("#menu-avatar-instrutor");
    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnDashboard = By.cssSelector("#dashboard-visible-instrutor");
    private static final By btnListaFeedbacks = By.cssSelector("#dashboard-feedbacks-visible-instrutor");
    private static final By btnCadastrarAluno = By.cssSelector("#cadastrar-aluno-visible-instrutor");
    private static final By btnCadastrarFeedback = By.cssSelector("#cadastrar-feedback-visible-instrutor");
    private static final By abrirDetalhesAluno = By.cssSelector("#nome");

    @Step("Clicar no menu perfil Usuário")
    public void clicarMenuPerfil() {
        click(btnMenuPerfilInstrutor);
    }

    @Step("Clicar no botão Menu")
    public void clicarBtnMenu(){
        click(btnMenu);
    }

    @Step("Clicar no botão Dashboard")
    public void clicarBtnDashboard() {
        click(btnDashboard);
    }

    @Step("Clicar no botão Lista Feedbacks")
    public void clicarBtnListaFeedback() {
        click(btnListaFeedbacks);
    }

    @Step("Clicar no botão cadastrar aluno como Instrutor")
    public void clicarBtnCadastrarAlunoInstrutor() {
        click(btnCadastrarAluno);
    }

    @Step("Clicar no botão cadastrar feedback")
    public void clicarBtnCadastrarFeedback() {
        click(btnCadastrarFeedback);
    }

    @Step("Abrir Detalhes Aluno")
    public void abrirDetalhesAluno() {
        click(abrirDetalhesAluno);
    }

    @Step("Validar nome do Instrutor Logado")
    public String validarNomeInstrutorLogado() {
        return getText(validacaoLogin);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
