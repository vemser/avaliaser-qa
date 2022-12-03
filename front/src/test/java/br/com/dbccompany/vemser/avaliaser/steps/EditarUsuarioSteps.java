package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.EditarUsuarioPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class EditarUsuarioSteps {

    EditarUsuarioPage editarUsuarioPage = new EditarUsuarioPage();

    @E("que altero o campo nome de usuário válido")
    public void alterarCampoNomeValido() {
        editarUsuarioPage.alterarCampoNome("nome atualizado");
    }

    @E("que altero o campo nome de usuário inválido")
    public void alterarCampoNomeInvalido() {
        editarUsuarioPage.alterarCampoNome("123!");
    }

    @E("que altero o campo nome de usuário para vazio")
    public void alterarCampoNomeVazio() {
        editarUsuarioPage.alterarCampoNome(StringUtils.EMPTY);
    }

    @Quando("clico em Editar nome")
    public void clicarBotaoEditar() {
        editarUsuarioPage.clicarBtnEditar();
    }

    @Entao("devo visualizar mensagem de confirmação de edição de nome e ser redirecionado para a página Dashboard")
    public void validarEdicaoComSucesso() {
        Assert.assertEquals("Nome foi editado com sucesso!",
                editarUsuarioPage.validarMensagemDeEdicaoComSucesso());
        Assert.assertTrue(editarUsuarioPage.validarUrlAtual().contains("/dashboard/admin"));
    }

    @Entao("devo visualizar mensagem de erro para nome de usuário inválido")
    public void validarMensagemErroNomeInvalido() {
        Assert.assertEquals("Campo nulo, ou preenchido de forma incorreta, tente de novo.",
                editarUsuarioPage.validarMensagemDeErroNomeInvalido());
    }

    @Entao("devo visualizar mensagem de erro para nome de usuário vazio")
    public void validarMensagemErroNomeVazio() {
        Assert.assertEquals("Por favor, digite seu nome completo",
                editarUsuarioPage.validarMensagemDeErroNome());
    }

}
