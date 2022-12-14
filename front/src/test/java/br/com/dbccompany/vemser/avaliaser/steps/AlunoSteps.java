package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.AlunoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class AlunoSteps {

    AlunoPage alunoPage = new AlunoPage();

    @E("clico em ‘Deletar Aluno’")
    public void clicarBotaoDeletarAluno() throws InterruptedException {
        Thread.sleep(5000);
        alunoPage.clicarBtnDeletarAluno();
    }

    @Quando("clico em ‘Editar Aluno’")
    public void clicarBotaoEditarAluno() {
        alunoPage.clicarBtnEditarAluno();
    }

    @Quando("clico em ‘Confirmar’ para deletar aluno")
    public void clicarBotaoConfirmarDeletar() {
        alunoPage.clicarBtnConfirmarDeletar();
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Aluno’")
    public void paginaCadastrarAluno() {
        Assert.assertTrue(alunoPage.validarUrlAtual().contains("/cadastrar-aluno"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Aluno’")
    public void paginaEditarAluno() {
        Assert.assertTrue(alunoPage.validarUrlAtual().contains("/editar-aluno"));
    }

    @Entao("devo visualizar mensagem de confirmação para aluno deletado")
    public void mensagemConfirmacaoAlunoDeletado() {
        //Thread.sleep(5000);
        Assert.assertTrue(alunoPage.validarMensagemDeAlunoDeletado().contains("Aluno desativado com sucesso."));
    }

}
