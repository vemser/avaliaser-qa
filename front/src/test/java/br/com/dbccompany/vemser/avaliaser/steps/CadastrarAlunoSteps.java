package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.CadastrarAlunoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class CadastrarAlunoSteps {

    CadastrarAlunoPage cadastrarAlunoPage = new CadastrarAlunoPage();

    @E("que preencho o campo nome de aluno válido")
    public void preencherCampoNomeValido() {
        cadastrarAlunoPage.preencherCampoNome("Aluno teste");
    }

    @E("que preencho o campo email de aluno válido")
    public void preencherCampoEmailValido() {
        cadastrarAlunoPage.preencherCampoEmail("alunodbc.testefinal@dbccompany.com.br");
    }

    @E("que preencho o campo email de aluno inválido")
    public void preencherCampoEmailInvalido() {
        cadastrarAlunoPage.preencherCampoEmail("aluno@gmail.com");
    }

    @E("que seleciono uma trilha")
    public void clicarEmUmaTrilha() {
        cadastrarAlunoPage.clicarBtnTrilha();
        cadastrarAlunoPage.clicarTrilhaSelecionada();
    }

    @Quando("clico em ‘Enviar’ para salvar cadastro de aluno")
    public void clicarBotaoEnviarAluno() {
        cadastrarAlunoPage.clicarBtnEnviar();
    }

    @Entao("devo visualizar mensagem de sucesso de aluno cadastrado e ser redirecionado para a página Dashboard")
    public void validarCadastroComSucesso() {
        Assert.assertTrue(cadastrarAlunoPage.validarMensagemDeCadastroComSucesso()
                .contains("Aluno cadastrado com sucesso!"));
        Assert.assertTrue(cadastrarAlunoPage.validarUrlAtual().contains("/dashboard/gestor"));
    }

    @Entao("devo visualizar mensagens de erro campos obrigatórios para cadastrar aluno")
    public void validarMensagemErroCamposObrigatorios() {
        Assert.assertEquals("Por favor, digite seu nome completo", cadastrarAlunoPage.validarMensagemDeErroNome());
        Assert.assertEquals("Por favor, digite seu e-mail", cadastrarAlunoPage.validarMensagemDeErroEmail());
    }

    @Entao("devo visualizar mensagem de erro para email de cadastrar aluno inválido")
    public void validarMensagemErroEmailInvalido() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br",
                cadastrarAlunoPage.validarMensagemDeErroEmail());
    }

}
