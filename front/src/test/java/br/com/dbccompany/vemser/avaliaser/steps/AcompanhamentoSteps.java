package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.AcompanhamentoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class AcompanhamentoSteps {

    AcompanhamentoPage listaAcompanhamentosPage = new AcompanhamentoPage();

    @E("clico em ‘Editar’ um acompanhamento")
    public void clicarBotaoEditarAcompanhamento() {
        listaAcompanhamentosPage.clicarBtnEditarAcompanhamento();
    }

    @E("que altero título acompanhamento válido")
    public void alterarCampoTituloAcompanhamento() {
        listaAcompanhamentosPage.alterarCampoTitulo("título teste");
    }

    @E("que altero título acompanhamento para vazio")
    public void alterarCampoTituloAcompanhamentoVazio() {
        listaAcompanhamentosPage.alterarCampoTitulo(StringUtils.EMPTY);
    }

    @E("que altero descrição acompanhamento válido")
    public void alterarCampoDescricaoAcompanhamento() {
        listaAcompanhamentosPage.alterarCampoDescricao("descrição teste");
    }

    @E("que altero descrição acompanhamento para vazio")
    public void alterarCampoDescricaoAcompanhamentoVazio() {
        listaAcompanhamentosPage.alterarCampoDescricao(StringUtils.EMPTY);
    }

    @Quando("clico em ‘Editar’ acompanhamento para salvar alteração")
    public void clicarBotaoEditarParaSalvarAcompanhamento() {
        listaAcompanhamentosPage.clicarBtnEditarParaSalvarAcompanhamento();
    }

    @Entao("devo visualizar lista de acompanhamentos")
    public void listaAcompanhamentos() {
        Assert.assertEquals("Lista acompanhamentos",
                listaAcompanhamentosPage.validarTituloPaginaListaAcompanhamentos());
    }

    @Entao("devo visualizar mensagem de confirmação de edição e ser redirecionado para a página lista Acompanhamentos")
    public void confirmaEditarAcompanhamento() {
        Assert.assertEquals("Acompanhamento editado com sucesso!",
                listaAcompanhamentosPage.validarMensagemDeConfirmacao());
        Assert.assertTrue(listaAcompanhamentosPage.validarUrlAtual().contains("/lista-acompanhamento"));
    }

    @Entao("devo visualizar mensagem de erro para título vazio")
    public void validaMensagemDeErroTitulo() {
        Assert.assertEquals("Por favor, digite um titulo para o acompanhamento",
                listaAcompanhamentosPage.validarMensagemDeErroTituloVazio());
    }

    @Entao("devo visualizar mensagem de erro para descrição vazio")
    public void validaMensagemDeErroDescricao() {
        Assert.assertEquals("Por favor, preencha a descrição",
                listaAcompanhamentosPage.validarMensagemDeErroDescricaoVazio());
    }

}
