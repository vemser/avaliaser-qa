package br.com.dbccompany.vemser.avaliaser.builder;

import br.com.dbccompany.vemser.avaliaser.dto.AcompanhamentoCreateDTO;

public class AcompanhamentoBuilder {
    public AcompanhamentoCreateDTO criarAcompanhamento() {
        return AcompanhamentoCreateDTO.builder()
                .titulo("Reunião Vem Ser")
                .descricao("Verificar evolução do estagiário e passar feedback")
                .dataInicio("2022-12-01")
                .build();
    }
}