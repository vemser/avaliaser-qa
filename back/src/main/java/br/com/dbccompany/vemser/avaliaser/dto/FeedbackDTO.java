package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties
public class FeedbackDTO {

    private Integer idFeedBack;
    private String descricao;
    private String tipo;
    private UsuarioRetornoAvaliacaoFeedbackDTO usuarioDTO;
    private AlunoDTO alunoDTO;

}
