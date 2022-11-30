package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.LoginDTO;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class LoginBuilder {

    public LoginDTO login() {
        return LoginDTO.builder()
                .email(Manipulation.getProp().getProperty("prop.email"))
                .senha(Manipulation.getProp().getProperty("prop.senha"))
                .build();
    }

    public LoginDTO loginEmailInvalido() {
        LoginDTO loginEmailInvalido =  login();
        loginEmailInvalido.setEmail("jaciane@gmail.com");

        return loginEmailInvalido;
    }

    public LoginDTO loginSenhaInvalido() {
        LoginDTO loginSenhaInvalido =  login();
        loginSenhaInvalido.setSenha("1");

        return loginSenhaInvalido;
    }

    public LoginDTO loginEmailVazio() {
        LoginDTO loginEmailVazio =  login();
        loginEmailVazio.setEmail(StringUtils.EMPTY);

        return loginEmailVazio;
    }

    public LoginDTO loginSenhaVazio() {
        LoginDTO loginSenhaVazio =  login();
        loginSenhaVazio.setSenha(StringUtils.EMPTY);

        return loginSenhaVazio;
    }

}
