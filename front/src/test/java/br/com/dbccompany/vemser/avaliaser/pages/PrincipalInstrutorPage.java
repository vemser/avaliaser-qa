package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PrincipalInstrutorPage extends BasePage {

    private static final By logoDBC =
            By.cssSelector("#logo-dbc-instrutor > img");

    private static final By btnMenu =
            By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");

    private static final By validacaoLogin =
            By.cssSelector("#boas-vindas-instrutor");

    private static final By btnMenuPerfilInstrutor =
            By.cssSelector("#menu-avatar-instrutor");

    private static final By btnTrocarSenha =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(1)");

    private static final By btnEditarPerfil =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(3)");

    private static final By btnSair =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(5)");

    private static final By btnDashboard =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(1)");

    private static final By btnListaFeedbacks =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(3)");


    private static final By btnCadastrarAluno =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(5)");

    private static final By btnCadastrarFeedback =
            By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(7)");


    private static final By abrirDetalhesAluno =
            By.cssSelector("#menu-avatar-instrutor");

    private static final By btnEditarAluno =
            By.cssSelector("#botao-deletar-instrutor");

    private static final By btnExcluirAluno =
            By.cssSelector("#botao-deletar-instrutor");

    private static final By btnQuantidadePorPagina =
            By.cssSelector("#root > div.MuiBox-root.css-1u4uuh3 > div > div.MuiTablePagination-root.css-o9ey65 > div > div.MuiInputBase-root.MuiInputBase-colorPrimary.css-rmmij8");

    private static final By btnProximaPagina =
            By.cssSelector("#root > div.MuiBox-root.css-1u4uuh3 > div > div.MuiTablePagination-root.css-o9ey65 > div > div.MuiTablePagination-actions > button:nth-child(2) > svg");

    private static final By btnPaginaAnterior =
            By.cssSelector("#root > div.MuiBox-root.css-1u4uuh3 > div > div.MuiTablePagination-root.css-o9ey65 > div > div.MuiTablePagination-actions > button:nth-child(1)");



    @Step("Clicar na Logo DBC")
    public void clicarLogoDBC() {
        click(logoDBC);
    }

    @Step("Clicar no menu")
    public void clicarMenu() {
        click(btnMenu);
    }

    @Step("Clicar no menu perfil Usuário")
    public void clicarMenuPerfil() {
        click(btnMenuPerfilInstrutor);
    }

    @Step("Clicar no botão trocar a senha")
    public void clicarBtnTrocarSenha() {
        click(btnTrocarSenha);
    }

    @Step("Clicar no botão editar perfil")
    public void clicarEditarPerfil() {
        click(btnEditarPerfil);
    }

    @Step("Clicar no botão sair")
    public void clicarBtnSair() {
        click(btnSair);
    }

    @Step("Clicar no botão Dashboard")
    public void clicarBtnDashboard() {
        click(btnDashboard);
    }

    @Step("Clicar no botão Lista Feedbacks")
    public void clicarBtnListaFeedback() {
        click(btnListaFeedbacks);
    }

    @Step("Clicar no botão cadastrar aluno")
    public void clicarBtnCadastrarAluno() {
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

    @Step("Clicar no botão editar aluno")
    public void clicarBtnEditarAluno() {
        click(btnEditarAluno);
    }

    @Step("Clicar no botão excluir aluno")
    public void clicarBtnExcluirAluno() {
        click(btnEditarAluno);
    }

    @Step("Clicar no botão próxima página")
    public void clicarBtnProximaPagina() {
        click(btnProximaPagina);
    }

    @Step("Clicar no botão página anterior")
    public void clicarBtnPaginaAnterior() {
        click(btnPaginaAnterior);
    }






}
