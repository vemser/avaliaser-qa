package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties
public class AlterarSenhaUsuarioLogadoDTO {

    private String senhaAntiga;
    private String senhaNova;

}
