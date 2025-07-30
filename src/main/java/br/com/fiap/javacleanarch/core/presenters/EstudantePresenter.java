package br.com.fiap.javacleanarch.core.presenters;

import br.com.fiap.javacleanarch.core.dtos.EstudanteDTO;
import br.com.fiap.javacleanarch.core.entities.Estudante;

public class EstudantePresenter {

    public static EstudanteDTO toDto(Estudante estudante) {
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        final EstudanteDTO estudanteDTO = new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEnderecoEmail()
        );

        return estudanteDTO;
    }
}
