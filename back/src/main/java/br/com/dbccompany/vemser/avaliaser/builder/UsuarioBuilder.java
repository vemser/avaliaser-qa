package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.*;
import br.com.dbccompany.vemser.avaliaser.util.Manipulation;
import org.apache.commons.lang3.StringUtils;

public class UsuarioBuilder {

    public UsuarioCreateDTO criarUsuario() {
        return UsuarioCreateDTO.builder()
                .email("jaciane.santana@dbccompany.com.br")
                .nome("Jaciane Santana")
                .build();
    }

    public UsuarioCreateDTO criarUsuarioInvalido() {
        UsuarioCreateDTO usuarioInvalido = criarUsuario();
        usuarioInvalido.setEmail("jaciane@gmail.com");
        usuarioInvalido.setNome("abc123!");

        return usuarioInvalido;
    }

    public UsuarioCreateDTO criarUsuarioComEmailInvalido() {
        UsuarioCreateDTO usuarioComEmailInvalido = criarUsuario();
        usuarioComEmailInvalido.setEmail("jaciane@gmail.com");

        return usuarioComEmailInvalido;
    }

    public UsuarioCreateDTO criarUsuarioComNomeInvalido() {
        UsuarioCreateDTO usuarioComNomeInvalido = criarUsuario();
        usuarioComNomeInvalido.setNome("abc123!");

        return usuarioComNomeInvalido;
    }

    public UsuarioCreateDTO criarUsuarioVazio() {
        UsuarioCreateDTO usuarioVazio = criarUsuario();
        usuarioVazio.setEmail(StringUtils.EMPTY);
        usuarioVazio.setNome(StringUtils.EMPTY);

        return usuarioVazio;
    }

    public UsuarioCreateDTO criarUsuarioComEmailVazio() {
        UsuarioCreateDTO usuarioComEmailVazio = criarUsuario();
        usuarioComEmailVazio.setEmail(StringUtils.EMPTY);

        return usuarioComEmailVazio;
    }

    public UsuarioCreateDTO criarUsuarioComNomeVazio() {
        UsuarioCreateDTO usuarioComNomeVazio = criarUsuario();
        usuarioComNomeVazio.setNome(StringUtils.EMPTY);

        return usuarioComNomeVazio;
    }

    public AtualizaUsuarioLogadoDTO atualizarUsuarioLogado() {
        return AtualizaUsuarioLogadoDTO.builder()
                .nome("Paulo Sergio")
                .build();
    }

    public AtualizaUsuarioLogadoDTO atualizarUsuarioLogadoInvalido() {
        AtualizaUsuarioLogadoDTO nomeInvalido = atualizarUsuarioLogado();
        nomeInvalido.setNome("abc123!");

        return nomeInvalido;
    }

    public AtualizaUsuarioLogadoDTO atualizarUsuarioLogadoVazio() {
        AtualizaUsuarioLogadoDTO nomeVazio = atualizarUsuarioLogado();
        nomeVazio.setNome(StringUtils.EMPTY);

        return nomeVazio;
    }

    public AtualizaUsuarioDTO atualizarUsuarioPorId() {
        return AtualizaUsuarioDTO.builder()
                .email("jaciane@dbccompany.com.br")
                .nome("Jaciane")
                .build();
    }

    public AtualizaUsuarioDTO atualizarUsuarioPorIdInvalido() {
        return AtualizaUsuarioDTO.builder()
                .email("jaciane@gmail.com")
                .nome("abc123!")
                .build();
    }

    public AtualizaUsuarioDTO atualizarUsuarioPorIdVazio() {
        return AtualizaUsuarioDTO.builder()
                .email(StringUtils.EMPTY)
                .nome(StringUtils.EMPTY)
                .build();
    }

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaUsuarioLogado() {
        return AlterarSenhaUsuarioLogadoDTO.builder()
                .senhaAntiga(Manipulation.getProp(CargoDTO.ADMIN).getProperty("prop.senha"))
                .senhaNova("12345678")
                .build();
    }

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaAntigaInvalida() {
        AlterarSenhaUsuarioLogadoDTO senhaAntigaInvalida = alterarSenhaUsuarioLogado();
        senhaAntigaInvalida.setSenhaAntiga("abc123!");

        return senhaAntigaInvalida;
    }

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaAntigaVazia() {
        AlterarSenhaUsuarioLogadoDTO senhaAntigaVazia = alterarSenhaUsuarioLogado();
        senhaAntigaVazia.setSenhaAntiga(StringUtils.EMPTY);

        return senhaAntigaVazia;
    }

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaNovaInvalida() {
        AlterarSenhaUsuarioLogadoDTO senhaNovaInvalida = alterarSenhaUsuarioLogado();
        senhaNovaInvalida.setSenhaNova("abc123!");

        return senhaNovaInvalida;
    }

    public AlterarSenhaUsuarioLogadoDTO alterarSenhaNovaVazia() {
        AlterarSenhaUsuarioLogadoDTO senhaNovaVazia = alterarSenhaUsuarioLogado();
        senhaNovaVazia.setSenhaNova(StringUtils.EMPTY);

        return senhaNovaVazia;
    }

}
