package br.com.fiap.javacleanarch.core.usecases;

import br.com.fiap.javacleanarch.core.dtos.NovoEstudanteDTO;
import br.com.fiap.javacleanarch.core.entities.Estudante;
import br.com.fiap.javacleanarch.core.exceptions.EstudanteJaExisteException;
import br.com.fiap.javacleanarch.core.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {

    IEstudanteGateway estudanteGateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway estudanteGateway) {
        return new CadastrarEstudanteUseCase(estudanteGateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) {
        final Estudante estudanteExistente = this.estudanteGateway.buscarPorNome(novoEstudanteDTO.nome().trim());

        if (estudanteExistente != null) {
            throw new EstudanteJaExisteException(novoEstudanteDTO.nome());
        }

        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.enderecoEmail(),
                novoEstudanteDTO.idade()
        );

        return this.estudanteGateway.incluir(novoEstudante);
    }
}
