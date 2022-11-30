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
