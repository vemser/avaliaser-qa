package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties
public class UsuarioDTO {

    private Integer idUsuario;
    private String nome;
    private String email;
    private String foto;
    private String cargo;

}
