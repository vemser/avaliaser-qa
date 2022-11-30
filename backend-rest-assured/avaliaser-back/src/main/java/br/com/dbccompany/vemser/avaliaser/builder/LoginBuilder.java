package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.LoginDTO;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;

public class LoginBuilder {

    public LoginDTO login() {
        return LoginDTO.builder()
                .email(Manipulation.getProp().getProperty("prop.email"))
                .senha(Manipulation.getProp().getProperty("prop.senha"))
                .build();
    }

}
