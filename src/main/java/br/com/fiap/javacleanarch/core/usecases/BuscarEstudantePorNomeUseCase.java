package br.com.fiap.javacleanarch.core.usecases;

import br.com.fiap.javacleanarch.core.entities.Estudante;
import br.com.fiap.javacleanarch.core.exceptions.EstudanteNaoEncontradoException;
import br.com.fiap.javacleanarch.core.interfaces.IEstudanteGateway;

public class BuscarEstudantePorNomeUseCase {
    private final IEstudanteGateway estudanteGateway;

    public BuscarEstudantePorNomeUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public BuscarEstudantePorNomeUseCase create(IEstudanteGateway estudanteGateway) {
        return new BuscarEstudantePorNomeUseCase(estudanteGateway);
    }

    public Estudante run(String nome) {
        Estudante estudante = estudanteGateway.buscarPorNome(nome);
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException(nome);
        }

        return estudante;
    }
}
