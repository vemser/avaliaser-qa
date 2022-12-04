package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.CadastrarFeedbackPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

public class CadastrarFeedbackSteps {

    CadastrarFeedbackPage feedbackPage = new CadastrarFeedbackPage();

    @E("seleciono a stack do aluno")
    public void selecionarCamposValidos() throws InterruptedException {
        feedbackPage.clicarStack();
    }

    @E("preencho campo descrição de feedback válido")
    public void preencherCampoDescricaoValido(){
        feedbackPage.preencherDescricao();
    }

    @E("seleciono o aluno")
    public void selecionarAluno() throws InterruptedException {
        feedbackPage.clicarCampoSelecionarAluno();
        feedbackPage.clicarAlunoSelecionado();
    }

    @E("seleciono o status do aluno")
    public void selecionarStatus()  {
        feedbackPage.clicarCampoSelecionarStatus();
        feedbackPage.clicarStatusSelecionado();
    }

    @E("clico em enviar feedback")
    public void clicarEnviarFeedback(){
        feedbackPage.clicarBtnEnviar();
    }

    @Entao("devo validar mensagem de Feedback cadastrado com sucesso")
    public void validarCadastroFeedbackComSucesso(){
        Assert.assertEquals("Feedback cadastrado com sucesso", feedbackPage.validarCadastroFeedback());
    }

    @Entao("devo visualizar mensagem de erro para descrição de feedback vazia")
    public void validarMensagemErroDescricaoVazio(){
        Assert.assertEquals("Por favor, digite alguma coisa na descrição",
                feedbackPage.validarMensagemErroDescricaoVazio());
    }

    @Entao("devo visualizar mensagem de erro para selecionar campos obrigatórios")
    public void validarMensagemErroCamposObrigatorios() {
        Assert.assertTrue(feedbackPage.validarMensagemErroCamposObrigatorios().contains("Preencha todos os campos!"));
    }

}
