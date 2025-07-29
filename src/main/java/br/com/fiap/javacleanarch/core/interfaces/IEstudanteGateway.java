package br.com.fiap.javacleanarch.core.interfaces;

import br.com.fiap.javacleanarch.core.entities.Estudante;

public interface IEstudanteGateway {
    Estudante buscarPorNome(String nome);

    Estudante incluir(Estudante novoEstudante);
}
