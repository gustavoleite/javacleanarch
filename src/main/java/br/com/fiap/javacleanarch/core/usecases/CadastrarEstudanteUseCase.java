package br.com.fiap.javacleanarch.core.usecases;

import br.com.fiap.javacleanarch.core.dtos.NovoEstudanteDTO;
import br.com.fiap.javacleanarch.core.entities.Estudante;
import br.com.fiap.javacleanarch.core.exceptions.EstudanteJaExistenteException;
import br.com.fiap.javacleanarch.core.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {

    private final IEstudanteGateway estudanteGateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway estudanteGateway) {
        return new CadastrarEstudanteUseCase(estudanteGateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) {
        final Estudante estudanteExistente = this.estudanteGateway.buscarPorNome(novoEstudanteDTO.nome().trim());

        if (estudanteExistente != null) {
            throw new EstudanteJaExistenteException(novoEstudanteDTO.nome());
        }

        final Estudante novoEstudante = Estudante.create(
                null,
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.idade(),
                novoEstudanteDTO.enderecoEmail()
        );

        return this.estudanteGateway.incluir(novoEstudante);
    }
}
