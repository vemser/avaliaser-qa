package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AlterarSenhaUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.AtualizarUsuarioLogadoDTO;
import br.com.dbccompany.vemser.avaliaser.dto.UsuarioCreateDTO;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class UsuarioBuilder {

    public UsuarioCreateDTO criarUsuario() {
        return UsuarioCreateDTO.builder()
                .email("jaciane.santana@dbccompany.com.br")
                .nome("Jaciane Santana")
                .build();
    }

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

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaUsuarioLogado() {
        return AlterarSenhaUsuarioLogadoDTO.builder()
                .senhaAntiga(Manipulation.getProp().getProperty("prop.senha"))
                .senhaNova("12345678")
                .build();
    }

}
