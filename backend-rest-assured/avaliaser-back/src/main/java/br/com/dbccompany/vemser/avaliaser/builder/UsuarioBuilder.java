package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;

public class UsuarioBuilder {

    public UsuarioCreateDTO criarUsuario() {
        return UsuarioCreateDTO.builder()
                .email("jaciane.santana@dbccompany.com.br")
                .nome("Jaciane Santana")
                .build();
    }

}
