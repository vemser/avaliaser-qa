package br.com.dbccompany.vemser.avaliaser.steps;

import br.com.dbccompany.vemser.avaliaser.pages.EditarAlunoPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class EditarAlunoSteps {

    EditarAlunoPage editarAlunoPage = new EditarAlunoPage();

    @E("que altero o campo nome de aluno válido")
    public void alterarCampoNomeValido() {
        editarAlunoPage.alterarCampoNome("Aluno teste atualizado");
    }

    @E("que altero o campo nome de aluno para vazio")
    public void alterarCampoNomeVazio() {
        editarAlunoPage.alterarCampoNome(StringUtils.EMPTY);
    }

    @E("que altero o campo email de aluno válido")
    public void alterarCampoEmailValido() {
        editarAlunoPage.alterarCampoEmail("aluno.atualizado@dbccompany.com.br");
    }

    @E("que altero o campo email de aluno para vazio")
    public void alterarCampoEmailVazio() {
        editarAlunoPage.alterarCampoEmail(StringUtils.EMPTY);
    }

    @E("que altero o campo email de aluno inválido")
    public void alterarCampoEmailInvalido() {
        editarAlunoPage.alterarCampoEmail("aluno@gmail.com");
    }

    @Quando("clico em ‘Editar’ para salvar alteração de aluno")
    public void clicarBotaoEditarAluno() {
        editarAlunoPage.clicarBtnEditar();
    }

    @Entao("devo visualizar mensagem de sucesso de aluno editado e ser redirecionado para a página Dashboard")
    public void validarEdicaoComSucesso() {
        Assert.assertTrue(editarAlunoPage.validarMensagemDeCadastroComSucesso()
                .contains("Aluno atualizado com sucesso!"));
        Assert.assertTrue(editarAlunoPage.validarUrlAtual().contains("/dashboard/gestor"));
    }

    @Entao("devo visualizar mensagens de erro campos obrigatórios para editar aluno")
    public void validarMensagemErroCamposObrigatorios() {
        Assert.assertEquals("Por favor, digite seu nome completo", editarAlunoPage.validarMensagemDeErroNome());
        Assert.assertEquals("Por favor, digite seu e-mail", editarAlunoPage.validarMensagemDeErroEmail());
    }

    @Entao("devo visualizar mensagem de erro para email de editar aluno inválido")
    public void validarMensagemErroEmailInvalido() {
        Assert.assertEquals("Só aceitamos email @dbccompany.com.br",
                editarAlunoPage.validarMensagemDeErroEmail());
    }

}
