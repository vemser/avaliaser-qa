package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.dto.*;
import com.google.gson.Gson;

public class Utils {

    public static String getBaseUrl() {
        String baseUrl = "http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliaser-back";

        return baseUrl;
    }

    public static String convertLoginToJson(LoginDTO login) {
        return new Gson().toJson(login);
    }

    public static String convertUsuarioToJson(UsuarioCreateDTO usuario) {
        return new Gson().toJson(usuario);
    }

    public static String convertAtualizarUsuarioToJson(AtualizaUsuarioLogadoDTO nomeUsuario) {
        return new Gson().toJson(nomeUsuario);
    }

    public static String convertAtualizarUsuarioPorIdToJson(AtualizaUsuarioDTO usuarioAtualizado) {
        return new Gson().toJson(usuarioAtualizado);
    }

    public static String convertAlterarSenhaUsuarioLogadoToJson(AlterarSenhaUsuarioLogadoDTO alterarSenhaUsuarioLogado) {
        return new Gson().toJson(alterarSenhaUsuarioLogado);
    }

    public static String convertAlunoToJson(AlunoCreateDTO aluno) {
        return (new Gson()).toJson(aluno);
    }

    public static String convertAtualizarAlunoToJson(AlunoDTO idAluno) {
        return (new Gson()).toJson(idAluno);
    }

    public static String convertFeedbackToJson(FeedbackCreateDTO feedback) {
        return new Gson().toJson(feedback);
    }

    public static String convertAtualizaFeedbackToJson(AtualizaFeedbackDTO atualizaFeedback) {
        return new Gson().toJson(atualizaFeedback);
    }

    public static String convertAvaliacaoToJson(AvaliacaoCreateDTO avaliacao) {
        return new Gson().toJson(avaliacao);
    }

    public static String convertAtualizaAvaliacaoToJson(AtualizaAvaliacaoDTO atualizaAvaliacao) {
        return new Gson().toJson(atualizaAvaliacao);
    }

    public static String convertAcompanhamentoToJson(AcompanhamentoCreateDTO acompanhamento) {
        return new Gson().toJson(acompanhamento);
    }

    public static String convertAtualizarAcompanhamentoToJson(AtualizarAcompanhamentoDTO atualizarAcompanhamento) {
        return new Gson().toJson(atualizarAcompanhamento);
    }

}
