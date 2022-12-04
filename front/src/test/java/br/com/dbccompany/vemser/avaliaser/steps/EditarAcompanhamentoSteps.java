package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.EditarAcompanhamentoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class EditarAcompanhamentoSteps {

    EditarAcompanhamentoPage editarAcompanhamentoPage = new EditarAcompanhamentoPage();

    @E("clico em ‘Editar’ um acompanhamento")
    public void clicarBotaoEditarAcompanhamento() {
        editarAcompanhamentoPage.clicarBtnEditarAcompanhamento();
    }

    @E("que altero título acompanhamento válido")
    public void alterarCampoTituloAcompanhamento() {
        editarAcompanhamentoPage.alterarCampoTitulo("título teste");
    }

    @E("que altero título acompanhamento para vazio")
    public void alterarCampoTituloAcompanhamentoVazio() {
        editarAcompanhamentoPage.alterarCampoTitulo(StringUtils.EMPTY);
    }

    @E("que altero descrição acompanhamento válido")
    public void alterarCampoDescricaoAcompanhamento() {
        editarAcompanhamentoPage.alterarCampoDescricao("descrição teste");
    }

    @E("que altero descrição acompanhamento para vazio")
    public void alterarCampoDescricaoAcompanhamentoVazio() {
        editarAcompanhamentoPage.alterarCampoDescricao(StringUtils.EMPTY);
    }

    @Quando("clico em ‘Editar’ acompanhamento para salvar alteração")
    public void clicarBotaoEditarParaSalvarAcompanhamento() {
        editarAcompanhamentoPage.clicarBtnEditarParaSalvarAcompanhamento();
    }

    @Entao("devo visualizar mensagem de confirmação de edição e ser redirecionado para a página lista Acompanhamentos")
    public void confirmaEditarAcompanhamento() {
        Assert.assertEquals("Acompanhamento editado com sucesso!",
                editarAcompanhamentoPage.validarMensagemDeConfirmacao());
        Assert.assertTrue(editarAcompanhamentoPage.validarUrlAtual().contains("/lista-acompanhamento"));
    }

    @Entao("devo visualizar mensagem de erro para título vazio")
    public void validaMensagemDeErroTitulo() {
        Assert.assertEquals("Por favor, digite um titulo para o acompanhamento",
                editarAcompanhamentoPage.validarMensagemDeErroTituloVazio());
    }

    @Entao("devo visualizar mensagem de erro para descrição vazio")
    public void validaMensagemDeErroDescricao() {
        Assert.assertEquals("Por favor, preencha a descrição",
                editarAcompanhamentoPage.validarMensagemDeErroDescricaoVazio());
    }

}
