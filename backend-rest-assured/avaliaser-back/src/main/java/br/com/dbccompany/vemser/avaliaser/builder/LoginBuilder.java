package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.LoginDTO;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class LoginBuilder {

    public LoginDTO loginAdmin() {
        return LoginDTO.builder()
                .email(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"))
                .senha(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"))
                .build();
    }

    public LoginDTO loginGestor() {
        return LoginDTO.builder()
                .email(Manipulation.getProp(CargoDTO.GESTOR).getProperty("prop.email"))
                .senha(Manipulation.getProp(CargoDTO.GESTOR).getProperty("prop.senha"))
                .build();
    }

    public LoginDTO loginInstrutor() {
        return LoginDTO.builder()
                .email(Manipulation.getProp(CargoDTO.INSTRUTOR).getProperty("prop.email"))
                .senha(Manipulation.getProp(CargoDTO.INSTRUTOR).getProperty("prop.senha"))
                .build();
    }

    public LoginDTO loginInvalido() {
        return LoginDTO.builder()
                .email("jaciane@gmail.com")
                .senha("1")
                .build();
    }

    public LoginDTO loginEmailInvalido() {
        LoginDTO loginEmailInvalido =  loginInvalido();
        loginEmailInvalido.setSenha(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"));

        return loginEmailInvalido;
    }

    public LoginDTO loginSenhaInvalido() {
        LoginDTO loginSenhaInvalido =  loginInvalido();
        loginSenhaInvalido.setEmail(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"));

        return loginSenhaInvalido;
    }

    public LoginDTO loginVazio() {
        return LoginDTO.builder()
                .email(StringUtils.EMPTY)
                .senha(StringUtils.EMPTY)
                .build();
    }

    public LoginDTO loginEmailVazio() {
        LoginDTO loginEmailVazio =  loginVazio();
        loginEmailVazio.setSenha(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"));

        return loginEmailVazio;
    }

    public LoginDTO loginSenhaVazio() {
        LoginDTO loginSenhaVazio =  loginVazio();
        loginSenhaVazio.setEmail(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.email"));

        return loginSenhaVazio;
    }

}
