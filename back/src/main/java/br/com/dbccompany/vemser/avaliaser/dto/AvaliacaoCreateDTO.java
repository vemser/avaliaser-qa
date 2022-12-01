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
public class AvaliacaoCreateDTO {

    private Integer idAcompanhamento;
    private Integer idAluno;
    private String descricao;
    private String tipo;
    private String dataCriacao;

}
