package br.com.dbccompany.vemser.avaliaser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioDTO {

    private Integer idUsuario;
    private String nome;
    private String email;
    private String foto;
    private String cargo;

}
