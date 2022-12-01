package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties
public class AvaliacaoDTO {

    private Integer idAvaliacao;
    private List<AcompanhamentoDTO> acompanhamento;
    private List<AlunoDTO> aluno;
    private List<UsuarioDTO> responsavel;
    private String descricao;
    private String tipo;
    private String dataCriacao;

}
