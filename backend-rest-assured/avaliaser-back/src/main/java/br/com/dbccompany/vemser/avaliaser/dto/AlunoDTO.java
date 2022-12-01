package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
@JsonIgnoreProperties
public class AlunoDTO {
    private Integer idAluno;
    private String nome;
    private String email;
    private String stack;
    private String foto;


}
