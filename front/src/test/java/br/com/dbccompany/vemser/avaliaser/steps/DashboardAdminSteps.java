package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardAminPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;


public class DashboardAdminSteps {

    DashboardAminPage dashboardAminPage = new DashboardAminPage();

    @E("clico em ‘Deletar Colaborador’")
    public void clicarBotaoDeletarColaborador() {
        dashboardAminPage.clicarBtnDeletarColaborador();
    }

    @Quando("clico em ‘Cadastrar Colaborador’")
    public void clicarBotaoCadastrarColaborador() {
        dashboardAminPage.clicarBtnCadastrarColaborador();
    }

    @Quando("clico em ‘Editar Colaborador’")
    public void clicarBotaoEditarColaborador() {
        dashboardAminPage.clicarBtnEditarColaborador();
    }

    @Quando("clico em ‘Confirmar’")
    public void clicarBotaoConfirmarDeletar() {
        dashboardAminPage.clicarBtnConfirmarDeletar();
    }

    @Entao("devo visualizar mensagem de boas-vindas e lista de colaboradores na tela")
    public void paginaPrincipalAdmin() {
        Assert.assertEquals("Dashboard Colaboradores", dashboardAminPage.validarTextoDashboardAdmin());
        Assert.assertEquals("Seja bem-vindo(a) paulo!", dashboardAminPage.validarMensagemDeBoasVindasAdmin());
    }

    @Entao("devo ser redirecionado para a página de ‘Cadastrar Colaborador’")
    public void paginaCadastrarColaborador() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/cadastrar-colaborador"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Colaborador’")
    public void paginaEditarColaborador() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/editar-colaborador"));
    }

    @Entao("devo visualizar mensagem de confirmação na tela")
    public void mensagemConfirmacaoColaboradorDeletado() {
        Assert.assertEquals("Colaborador desativado com sucesso.",
                dashboardAminPage.validarMensagemDeColaboradorDeletado());
    }

    @Entao("devo ser redirecionado para a página de ‘Alterar Senha’")
    public void paginaTrocarSenha() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/alterar-senha"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Usuário’")
    public void paginaEditarUsuario() {
        Assert.assertTrue(dashboardAminPage.validarUrlAtual().contains("/editar-usuario"));
    }

    @Entao("devo ser redirecionado para a página de ‘Login’")
    public void paginaLogin() {
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/", dashboardAminPage.validarUrlAtual());
    }

    @E("que acesso a página de Cadastrar Colaborador")
    public void acessarPaginaCadastrarColaborador() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnMenu();
        dashboardAminPage.clicarBtnCadastrarColaborador();
    }

    @E("que acesso a página de Editar Colaborador")
    public void acessarPaginaEditarColaborador() throws InterruptedException {
        Thread.sleep(5000);
        dashboardAminPage.clicarBtnEditarColaborador();
    }

}
