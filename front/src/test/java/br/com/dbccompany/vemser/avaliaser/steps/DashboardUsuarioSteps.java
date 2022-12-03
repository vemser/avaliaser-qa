package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.DashboardUsuarioPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;


public class DashboardUsuarioSteps {

    DashboardUsuarioPage dashboardUsuarioPage = new DashboardUsuarioPage();

    @E("que clico em 'Menu'")
    public void clicarBotaoMenu() {
        dashboardUsuarioPage.clicarBtnMenu();
    }

    @E("clico no ícone da foto de perfil")
    public void clicarBotaoFotoDePerfil() {
        dashboardUsuarioPage.clicarBtnFotoPerfil();
    }

    @Quando("clico em ‘Trocar Senha’")
    public void clicarBotaoTrocarSenha() {
        dashboardUsuarioPage.clicarBtnTrocarSenha();
    }

    @Quando("clico em ‘Editar Usuário’")
    public void clicarBotaoEditar() {
        dashboardUsuarioPage.clicarBtnEditar();
    }

    @Quando("clico em ‘Sair’")
    public void clicarBotaoSair() {
        dashboardUsuarioPage.clicarBtnSair();
    }

    @Entao("devo ser redirecionado para a página de ‘Alterar Senha’")
    public void paginaTrocarSenha() {
        Assert.assertTrue(dashboardUsuarioPage.validarUrlAtual().contains("/alterar-senha"));
    }

    @Entao("devo ser redirecionado para a página de ‘Editar Usuário’")
    public void paginaEditarUsuario() {
        Assert.assertTrue(dashboardUsuarioPage.validarUrlAtual().contains("/editar-usuario"));
    }

    @Entao("devo ser redirecionado para a página de ‘Login’")
    public void paginaLogin() {
        Assert.assertEquals("https://avaliaser-front-flame.vercel.app/", dashboardUsuarioPage.validarUrlAtual());
    }

    @E("que acesso a página de Editar Usuário")
    public void acessarPaginaEditarUsuario() throws InterruptedException {
        Thread.sleep(5000);
        dashboardUsuarioPage.clicarBtnFotoPerfil();
        dashboardUsuarioPage.clicarBtnEditar();
    }

    @E("que acesso a página de Alterar Senha de usuário logado")
    public void acessarPaginaAlterarSenhaUsuarioLogado() throws InterruptedException {
        Thread.sleep(5000);
        dashboardUsuarioPage.clicarBtnFotoPerfil();
        dashboardUsuarioPage.clicarBtnTrocarSenha();
    }

}
