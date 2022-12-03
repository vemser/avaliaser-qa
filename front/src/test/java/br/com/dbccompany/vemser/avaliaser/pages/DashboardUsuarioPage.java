package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardUsuarioPage extends BasePage{

    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnDashboard =
            By.cssSelector("#dashboard-visible-admin");
    private static final By btnFotoPerfil = By.cssSelector("#menu-avatar-admin");
    private static final By btnTrocarSenha = By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation." +
            "MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded." +
            "MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(1)");
    private static final By btnEditar = By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation." +
            "MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded." +
            "MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(3)");
    private static final By btnSair = By.cssSelector("#menu-appbar > div.MuiPaper-root.MuiPaper-elevation." +
            "MuiPaper-rounded.MuiPaper-elevation1.MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded." +
            "MuiPaper-elevation8.MuiPopover-paper.css-177ic5c > ul > li:nth-child(5)");

    @Step("Clicar no botão Menu")
    public void clicarBtnMenu() throws InterruptedException {
        Thread.sleep(5000);
        click(btnMenu);
    }

    @Step("Clicar no botão Dashboard")
    public void clicarBtnDashboard(){
        click(btnDashboard);
    }

    @Step("Clicar no botão Foto de Perfil")
    public void clicarBtnFotoPerfil(){
        click(btnFotoPerfil);
    }

    @Step("Clicar no botão Trocar Senha")
    public void clicarBtnTrocarSenha(){
        click(btnTrocarSenha);
    }

    @Step("Clicar no botão Editar")
    public void clicarBtnEditar(){
        click(btnEditar);
    }

    @Step("Clicar no botão Sair")
    public void clicarBtnSair(){
        click(btnSair);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
