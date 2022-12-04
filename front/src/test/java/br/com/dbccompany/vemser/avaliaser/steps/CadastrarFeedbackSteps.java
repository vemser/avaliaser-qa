package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.CadastrarFeedbackPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

public class CadastrarFeedbackSteps {

    CadastrarFeedbackPage feedbackPage = new CadastrarFeedbackPage();

    @E("preencho campo descrição de feedback válido")
    public void preencherCampoDescricaoValido(){
        feedbackPage.preencherDescricao();
    }

    @E("seleciono todos os campos válidos")
    public void selecionarCamposValidos() throws InterruptedException {
        feedbackPage.clicarStack();
        feedbackPage.clicarCampoSelecionarAluno();
        Thread.sleep(2000);
        feedbackPage.clicarAlunoSelecionado();
        feedbackPage.clicarCampoSelecionarStatus();
        Thread.sleep(2000);
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
    public void validarMensagemErroCamposObrigatorios() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(feedbackPage.validarMensagemErroDescricaoVazio().contains("Preencha todos os campos!"));
    }

}
