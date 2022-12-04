package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.CadastrarColaboradorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class CadastrarColaboradorSteps {

    CadastrarColaboradorPage cadastrarColaboradorPage = new CadastrarColaboradorPage();

    @E("que preencho o campo nome válido")
    public void preencherCampoNomeValido() {
        cadastrarColaboradorPage.preencherCampoNome("Jaciane Santana");
    }

    @E("que preencho o campo nome inválido")
    public void preencherCampoNomeInvalido() {
        cadastrarColaboradorPage.preencherCampoNome("123!");
    }

    @E("que preencho o campo email válido")
    public void preencherCampoEmailValido() {
        cadastrarColaboradorPage.preencherCampoEmail("jaciane.santana@dbccompany.com.br");
    }

    @E("que preencho o campo email inválido")
    public void preencherCampoEmailInvalido() {
        cadastrarColaboradorPage.preencherCampoEmail("jaciane.santana@gmail.com");
    }

    @E("que seleciono um cargo")
    public void clicarEmUmCargo() {
        cadastrarColaboradorPage.clicarBtnGestorDePessoas();
    }

    @Quando("clico em ‘Enviar’ para cadastrar colaborador")
    public void clicarBotaoEnviarColaborador() {
        cadastrarColaboradorPage.clicarBtnEnviar();
    }

    @Entao("devo visualizar mensagem de sucesso na tela e ser redirecionado para a página Dashboard")
    public void validarCadastroComSucesso() {
        Assert.assertTrue(cadastrarColaboradorPage.validarMensagemDeCadastroComSucesso()
                .contains("Colaborador cadastrado com sucesso!"));
        Assert.assertTrue(cadastrarColaboradorPage.validarUrlAtual().contains("/dashboard/admin"));
    }

    @Entao("devo visualizar mensagem de erro para nome ou email na tela")
    public void validarMensagemErroNomeOuEmailInvalido() {
        Assert.assertEquals("Campo nulo, ou preenchido de forma incorreta, tente de novo.",
                cadastrarColaboradorPage.validarMensagemDeErroNomeOuEmail());
    }

    @Entao("devo visualizar mensagem de erro para nome vazio")
    public void validarMensagemErroNomeVazio() {
        Assert.assertEquals("Por favor, digite seu nome completo",
                cadastrarColaboradorPage.validarMensagemDeErroNome());
    }

    @Entao("devo visualizar mensagem de erro para email inválido")
    public void validarMensagemErroEmailInvalido() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br",
                cadastrarColaboradorPage.validarMensagemDeErroEmail());
    }

    @Entao("devo visualizar mensagem de erro para email vazio")
    public void validarMensagemErroEmailVazio() {
        Assert.assertEquals("Por favor, digite seu e-mail",
                cadastrarColaboradorPage.validarMensagemDeErroEmail());
    }

    @Entao("devo visualizar mensagem de erro para cargo vazio")
    public void validarMensagemErroCargoVazio() {
        Assert.assertEquals("Por favor, escolha um dos tipos de perfil.",
                cadastrarColaboradorPage.validarMensagemDeErroCargo());
    }

}
