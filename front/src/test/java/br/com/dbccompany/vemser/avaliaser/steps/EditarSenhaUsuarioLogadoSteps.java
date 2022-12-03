package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.EditarSenhaUsuarioLogadoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class EditarSenhaUsuarioLogadoSteps {

    EditarSenhaUsuarioLogadoPage editarSenhaUsuarioLogadoPage = new EditarSenhaUsuarioLogadoPage();

    @E("que preencho o campo senha antiga válido")
    public void preencherCampoSenhaAntiga() {
        editarSenhaUsuarioLogadoPage.preencherCampoSenhaAntiga("administrador");
    }

    @E("que preencho o campo senha antiga inválido")
    public void preencherCampoSenhaAntigaInvalido() {
        editarSenhaUsuarioLogadoPage.preencherCampoSenhaAntiga("123");
    }

    @E("que preencho o campo senha nova válido")
    public void preencherCampoSenhaNova() {
        editarSenhaUsuarioLogadoPage.preencherCampoSenhaNova("12345678");
    }

    @E("que preencho o campo senha nova inválido")
    public void preencherCampoSenhaNovaInvalido() {
        editarSenhaUsuarioLogadoPage.preencherCampoSenhaNova("123");
    }

    @E("que preencho o campo confirme senha nova válido")
    public void preencherCampoConfirmaSenhaNova() {
        editarSenhaUsuarioLogadoPage.preencherCampoConfirmaSenhaNova("12345678");
    }

    @E("que preencho o campo confirme senha nova inválido")
    public void preencherCampoConfirmaSenhaNovaInvalido() {
        editarSenhaUsuarioLogadoPage.preencherCampoConfirmaSenhaNova("123");
    }

    @Quando("clico em Enviar alteração de senha")
    public void clicarBotaoEnviar() {
        editarSenhaUsuarioLogadoPage.clicarBtnEnviar();
    }

    @Entao("devo visualizar mensagem de confirmação de edição de senha e ser redirecionado para a página Dashboard")
    public void validarAlteracaoDeSanhaComSucesso() {
        Assert.assertEquals("Senha atualizada com sucesso.",
                editarSenhaUsuarioLogadoPage.validarMensagemDeAlteracaoDeSenhaComSucesso());
        Assert.assertTrue(editarSenhaUsuarioLogadoPage.validarUrlAtual().contains("/dashboard/admin"));
    }

    @Entao("devo visualizar mensagem de erro para senha antiga inválida")
    public void validarMensagemErroSenhaAntigaInvalido() {
        Assert.assertEquals("Houve um erro",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaAntigaInvalido());
    }

    @Entao("devo visualizar mensagem de erro para senha antiga vazio")
    public void validarMensagemErroSenhaAntigaVazio() {
        Assert.assertEquals("Por favor, digite sua antiga senha",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaInvalidoOuVazio());
    }

    @Entao("devo visualizar mensagem de erro para senha nova inválida")
    public void validarMensagemErroSenhaNovaInvalido() {
        Assert.assertEquals("Houve um erro",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaAntigaInvalido());
    }

    @Entao("devo visualizar mensagem de erro para senha nova vazio")
    public void validarMensagemErroSenhaNovaVazio() {
        Assert.assertEquals("Por favor, digite sua nova senha",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaInvalidoOuVazio());
    }

    @Entao("devo visualizar mensagem de erro para confirma senha nova inválida")
    public void validarMensagemErroConfirmeSenhaNovaInvalido() {
        Assert.assertEquals("As senhas devem corresponder!",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaInvalidoOuVazio());
    }

    @Entao("devo visualizar mensagem de erro para confirma senha nova vazio")
    public void validarMensagemErroConfirmeSenhaNovaVazio() {
        Assert.assertEquals("Por favor, confirme sua nova senha.",
                editarSenhaUsuarioLogadoPage.validarMensagemDeErroSenhaInvalidoOuVazio());
    }

}
