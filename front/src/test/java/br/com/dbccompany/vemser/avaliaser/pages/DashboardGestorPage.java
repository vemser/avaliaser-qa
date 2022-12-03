package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardGestorPage extends BasePage{

    private static final By textDashboardGestor = By.cssSelector("#root > div.MuiBox-root.css-14ul6if > h3");
    private static final By msgBoasVindas = By.cssSelector("#boas-vindas-gestor");
    private static final By btnMenu = By.cssSelector("#root > header > div > div > div.MuiBox-root.css-14knnik > button");
    private static final By btnListaAcompanhamentos =
            By.cssSelector("#lista-acompanhamento-visible-gestor");

    private static final By btnCadastrarAcompanhamento =
            By.cssSelector("#cadastrar-acompanhamento-visible-gestor");

    private static final By btnAvaliarAcompanhamento =
            By.cssSelector("#avaliar-acompanhamento-visible-gestor");

    @Step("Validar título de página Dashboard Gestor")
    public String validarTextoDashboardGestor(){
        return getText(textDashboardGestor);
    }

    @Step("Validar mensagem de boas vindas Gestor")
    public String validarMensagemDeBoasVindasGestor(){
        return getText(msgBoasVindas);
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

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
