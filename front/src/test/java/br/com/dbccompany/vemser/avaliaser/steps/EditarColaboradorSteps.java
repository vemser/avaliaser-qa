package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.EditarColaboradorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class EditarColaboradorSteps {

    EditarColaboradorPage editarColaboradorPage = new EditarColaboradorPage();

    @E("que altero o campo nome válido")
    public void alterarCampoNomeValido() {
        editarColaboradorPage.alterarCampoNome("jaciane");
    }

    @E("que altero o campo nome inválido")
    public void alterarCampoNomeInvalido() {
        editarColaboradorPage.alterarCampoNome("123!");
    }

    @E("que altero o campo nome para vazio")
    public void alterarCampoNomeVazio() {
        editarColaboradorPage.alterarCampoNome(StringUtils.EMPTY);
    }

    @E("que altero o campo email válido")
    public void alterarCampoEmailValido() {
        editarColaboradorPage.alterarCampoEmail("jaciane@dbccompany.com.br");
    }

    @E("que altero o campo email inválido")
    public void alterarCampoEmailInvalido() {
        editarColaboradorPage.alterarCampoEmail("jaciane@gmail.com");
    }

    @E("que altero o campo email para vazio")
    public void alterarCampoEmailVazio() {
        editarColaboradorPage.alterarCampoEmail(StringUtils.EMPTY);
    }

    @Quando("clico em ‘Editar’ para colaborador")
    public void clicarBotaoEditarColaborador() {
        editarColaboradorPage.clicarBtnEditarColaborador();
    }

    @Entao("devo visualizar mensagem de confirmação de edição e ser redirecionado para a página Dashboard")
    public void validarEdicaoComSucesso() {
        Assert.assertTrue(editarColaboradorPage.validarMensagemDeEdicaoComSucesso().contains("Colaborador editado com sucesso!"));
        Assert.assertTrue(editarColaboradorPage.validarUrlAtual().contains("/dashboard/admin"));
    }

    @Entao("devo visualizar mensagem de erro para editar nome inválido")
    public void validarMensagemErroNomeInvalido() {
        Assert.assertEquals("Campo nulo, ou preenchido de forma incorreta, tente de novo.",
                editarColaboradorPage.validarMensagemDeErroNomeInvalido());
    }

    @Entao("devo visualizar mensagem de erro para editar nome vazio")
    public void validarMensagemErroNomeVazio() {
        Assert.assertEquals("Por favor, digite seu nome completo",
                editarColaboradorPage.validarMensagemDeErroNomeVazio());
    }

    @Entao("devo visualizar mensagem de erro para editar email inválido")
    public void validarMensagemErroEmailInvalido() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br",
                editarColaboradorPage.validarMensagemDeErroEmail());
    }

    @Entao("devo visualizar mensagem de erro para editar email vazio")
    public void validarMensagemErroEmailVazio() {
        Assert.assertEquals("Por favor, digite seu e-mail",
                editarColaboradorPage.validarMensagemDeErroEmail());
    }

}
