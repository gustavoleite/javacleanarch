package br.com.fiap.javacleanarch.core.interfaces;

import br.com.fiap.javacleanarch.core.dtos.EstudanteDTO;
import br.com.fiap.javacleanarch.core.dtos.NovoEstudanteDTO;

public interface IDataSource {
    EstudanteDTO obterEstudantePorNome(String nome);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudanteDTO);
}
