package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.dto.AlterarSenhaUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizarUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import com.google.gson.Gson;
import net.datafaker.Faker;
import org.junit.Assert;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public enum Env {
        DEV, HML, PRD
    }

    public static String getBaseUrl() {
        String baseUrl = null;
        Env env = envStringToEnum();

        switch (env) {
            case HML -> {
                baseUrl = "http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliaser-back";
            }
            default -> {
                Assert.fail("Ambiente não configurado");
            }
        }

        return baseUrl;
    }

    public static Env envStringToEnum() {
        try {
            return Env.valueOf(getEnv());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ambiente não existente: " + getEnv());
        }
    }

    public static String getEnv() {
        return Manipulation.getPropAdmin().getProperty("prop.env");
    }

    public static String convertUsuarioToJson(UsuarioCreateDTO usuario) {
        return new Gson().toJson(usuario);
    }

    public static String convertAtualizarUsuarioToJson(AtualizarUsuarioLogadoDTO nomeUsuario) {
        return new Gson().toJson(nomeUsuario);
    }

    public static String convertAlterarSenhaUsuarioLogadoToJson(AlterarSenhaUsuarioLogadoDTO alterarSenhaUsuarioLogado) {
        return new Gson().toJson(alterarSenhaUsuarioLogado);
    }

    public static UsuarioCreateDTO convertJsonToUsuario(String toJson) {
        return new Gson().fromJson(toJson, UsuarioCreateDTO.class);
    }

}
