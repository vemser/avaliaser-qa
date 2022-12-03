package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.AlunoPage;
import br.com.dbccompany.vemser.avaliaser.pages.DashboardGestorPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class AlunoSteps {

    AlunoPage alunoPage = new AlunoPage();

    @E("clico em ‘Deletar Aluno’")
    public void clicarBotaoDeletarAluno() {
        alunoPage.clicarBtnDeletarAluno();
    }

    @Quando("clico em ‘Cadastrar Aluno’")
    public void clicarBotaoCadastrarAluno() {
        alunoPage.clicarBtnCadastrarAluno();
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
        Assert.assertEquals("Aluno desativado com sucesso.",
                alunoPage.validarMensagemDeAlunoDeletado());
    }

}
