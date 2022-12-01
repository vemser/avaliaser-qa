package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.dto.*;
import com.google.gson.Gson;
import net.datafaker.Faker;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

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

    public static String convertAtualizarUsuarioToJson(AtualizarUsuarioLogadoDTO nomeUsuario) {
        return new Gson().toJson(nomeUsuario);
    }

    public static String convertAtualizarUsuarioPorIdToJson(AtualizarUsuarioDTO usuarioAtualizado) {
        return new Gson().toJson(usuarioAtualizado);
    }

    public static String convertAlterarSenhaUsuarioLogadoToJson(AlterarSenhaUsuarioLogadoDTO alterarSenhaUsuarioLogado) {
        return new Gson().toJson(alterarSenhaUsuarioLogado);
    }

    public static UsuarioCreateDTO convertJsonToUsuario(String toJson) {
        return new Gson().fromJson(toJson, UsuarioCreateDTO.class);
    }

}
