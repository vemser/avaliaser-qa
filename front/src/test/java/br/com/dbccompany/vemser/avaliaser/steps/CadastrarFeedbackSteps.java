package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.CadastrarFeedbackPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

public class CadastrarFeedbackSteps {

    CadastrarFeedbackPage feedbackPage = new CadastrarFeedbackPage();

    @E("seleciono a stack")
    public void selecionarStack(){
        feedbackPage.clicarStack();
    }

    @E("seleciono o aluno")
    public void selecionarAluno(){
        feedbackPage.clicarCampoSelecionarAluno();
        feedbackPage.clicarAlunoSelecionado();
    }

    @E("preencho o campo ´Descrição´")
    public void preencherCampoDescricao(){
        feedbackPage.preencherDescrição();
    }

    @E("seleciono o status")
    public void selecionarStatus(){
        feedbackPage.clicarCampoSelecionarStatus();
        feedbackPage.clicarStatusSelecionado();
    }

    @E("clico em enviar")
    public void clicarEnviar(){
        feedbackPage.clicarBtnEnviar();
    }

    @Entao("devo validar mensagem de Feedback cadastrado com sucesso")
    public void validarCadastroFeedbackComSucesso(){
        Assert.assertEquals("Feedback cadastrado com sucesso", feedbackPage.validarCadastroFeedback());
    }

}

