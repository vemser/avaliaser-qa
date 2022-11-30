package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.LoginDTO;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class LoginBuilder {

    public LoginDTO loginAdmin() {
        return LoginDTO.builder()
                .email(Manipulation.getPropAdmin().getProperty("prop.email"))
                .senha(Manipulation.getPropAdmin().getProperty("prop.senha"))
                .build();
    }

    public LoginDTO loginEmailInvalido() {
        LoginDTO loginEmailInvalido =  loginAdmin();
        loginEmailInvalido.setEmail("jaciane@gmail.com");

        return loginEmailInvalido;
    }

    public LoginDTO loginSenhaInvalido() {
        LoginDTO loginSenhaInvalido =  loginAdmin();
        loginSenhaInvalido.setSenha("1");

        return loginSenhaInvalido;
    }

    public LoginDTO loginEmailVazio() {
        LoginDTO loginEmailVazio =  loginAdmin();
        loginEmailVazio.setEmail(StringUtils.EMPTY);

        return loginEmailVazio;
    }

    public LoginDTO loginSenhaVazio() {
        LoginDTO loginSenhaVazio =  loginAdmin();
        loginSenhaVazio.setSenha(StringUtils.EMPTY);

        return loginSenhaVazio;
    }

}
