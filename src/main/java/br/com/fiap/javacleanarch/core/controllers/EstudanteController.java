package br.com.fiap.javacleanarch.core.controllers;

import br.com.fiap.javacleanarch.core.dtos.EstudanteDTO;
import br.com.fiap.javacleanarch.core.dtos.NovoEstudanteDTO;
import br.com.fiap.javacleanarch.core.exceptions.EstudanteJaExistenteException;
import br.com.fiap.javacleanarch.core.gateways.EstudanteGateway;
import br.com.fiap.javacleanarch.core.interfaces.IDataSource;
import br.com.fiap.javacleanarch.core.presenters.EstudantePresenter;
import br.com.fiap.javacleanarch.core.usecases.CadastrarEstudanteUseCase;

public class EstudanteController {

    private final IDataSource dataStorageSource;

    private EstudanteController(IDataSource dataSource) {
        this.dataStorageSource = dataSource;
    }

    public static EstudanteController create(IDataSource dataSource) {
        return new EstudanteController(dataSource);
    }

    public EstudanteDTO Cadastrar(NovoEstudanteDTO novoEstudanteDTO) {
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);
        var useCase = CadastrarEstudanteUseCase.create(estudanteGateway);

        try {
            var estudante = useCase.run(novoEstudanteDTO);
            return EstudantePresenter.toDto(estudante);
        } catch (EstudanteJaExistenteException e) {
            return null;
        }
    }
}
