package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AtualizarUsuarioLogadoDTO;
import org.apache.commons.lang3.StringUtils;

public class AtualizarUsuarioLogadoBuilder {

    public AtualizarUsuarioLogadoDTO atualizarUsuario() {
        return AtualizarUsuarioLogadoDTO.builder()
                .nome("Paulo Sergio")
                .build();
    }

    public AtualizarUsuarioLogadoDTO atualizarUsuarioInvalido() {
        AtualizarUsuarioLogadoDTO nomeInvalido = atualizarUsuario();
        nomeInvalido.setNome("abc123!");

        return nomeInvalido;
    }

    public AtualizarUsuarioLogadoDTO atualizarUsuarioVazio() {
        AtualizarUsuarioLogadoDTO nomeVazio = atualizarUsuario();
        nomeVazio.setNome(StringUtils.EMPTY);

        return nomeVazio;
    }

}
