package br.com.dbccompany.vemser.avaliaser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AcompanhamentoPage extends BasePage{

    private static final By textPaginaListaAcompanhamentos = By.cssSelector("#titulo-body");
    private static final By campoTitulo = By.cssSelector("#titulo");
    private static final By campoDescricao = By.cssSelector("#descricao");
    private static final By msgErroTitulo = By.cssSelector("#erro-titulo");
    private static final By msgErroDescricao = By.cssSelector("#erro-descricao");
    private static final By msgConfirmacaoOuErro = By.cssSelector(".Toastify__toast-body > :nth-child(2)");
    private static final By btnEditar = By.cssSelector("#botao-avaliar-acompanhamento-1");
    private static final By btnEditarSalvar = By.cssSelector("#botao-azul");

    @Step("Validar título de página Lista Acompanhamentos")
    public String validarTituloPaginaListaAcompanhamentos(){
        return getText(textPaginaListaAcompanhamentos);
    }

    @Step("Alterar campo título")
    public void alterarCampoTitulo(String titulo) {
        clear(campoTitulo);
        sendKeys(campoTitulo, titulo);
    }

    @Step("Alterar campo descrição")
    public void alterarCampoDescricao(String descricao) {
        clear(campoDescricao);
        sendKeys(campoDescricao, descricao);
    }

    @Step("Validar mensagem de erro para título vazio")
    public String validarMensagemDeErroTituloVazio() {
        return getText(msgErroTitulo);
    }

    @Step("Validar mensagem de erro para descrição vazio")
    public String validarMensagemDeErroDescricaoVazio() {
        return getText(msgErroDescricao);
    }

    @Step("Validar mensagem de confirmação para edição de acompanhamento")
    public String validarMensagemDeConfirmacao() {
        return getAttributeInnerText(msgConfirmacaoOuErro);
    }

    @Step("Clicar no botão para editar acompanhamento")
    public void clicarBtnEditarAcompanhamento() {
        click(btnEditar);
    }

    @Step("Clicar no botão editar para salvar acompanhamento")
    public void clicarBtnEditarParaSalvarAcompanhamento() {
        click(btnEditarSalvar);
    }

    @Step("Validar url atual")
    public String validarUrlAtual() {
        return getCurrentUrl();
    }

}
