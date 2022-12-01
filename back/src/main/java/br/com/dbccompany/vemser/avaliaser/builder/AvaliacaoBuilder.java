package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AvaliacaoCreateDTO;
import br.com.dbccompany.vemser.avaliaser.dto.TipoFeedbackDTO;

public class AvaliacaoBuilder {

    public AvaliacaoCreateDTO criarAvaliacao() {
        return AvaliacaoCreateDTO.builder()
                .idAcompanhamento(0)
                .idAluno(19)
                .descricao("descrição")
                .tipo(TipoFeedbackDTO.POSITIVO.toString())
                .dataCriacao("2022-12-01")
                .build();
    }

}
