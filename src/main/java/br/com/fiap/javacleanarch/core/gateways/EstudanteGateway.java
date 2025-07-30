package br.com.fiap.javacleanarch.core.gateways;

import br.com.fiap.javacleanarch.core.dtos.EstudanteDTO;
import br.com.fiap.javacleanarch.core.dtos.NovoEstudanteDTO;
import br.com.fiap.javacleanarch.core.entities.Estudante;
import br.com.fiap.javacleanarch.core.exceptions.EstudanteNaoEncontradoException;
import br.com.fiap.javacleanarch.core.interfaces.IDataSource;
import br.com.fiap.javacleanarch.core.interfaces.IEstudanteGateway;

public class EstudanteGateway implements IEstudanteGateway {

    private final IDataSource dataStorageSource;

    private EstudanteGateway(IDataSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteGateway create(IDataSource dataSource) {
        return new EstudanteGateway(dataSource);
    }

    @Override
    public Estudante buscarPorNome(String nome) {
        final EstudanteDTO estudanteDTO = this.dataStorageSource.obterEstudantePorNome(nome);
        if (estudanteDTO == null) {
            throw new EstudanteNaoEncontradoException(nome);
        }
        return Estudante.create(
                estudanteDTO.identificacaoInterna(),
                estudanteDTO.nome(),
                estudanteDTO.idade(),
                estudanteDTO.enderecoEmail()
        );
    }

    @Override
    public Estudante incluir(Estudante novoEstudante) {
        final NovoEstudanteDTO novoEstudanteDTO = new NovoEstudanteDTO(
                novoEstudante.getNome(),
                novoEstudante.getIdade(),
                novoEstudante.getEnderecoEmail()
        );

        final EstudanteDTO estudanteCriado = this.dataStorageSource.incluirEstudante(novoEstudanteDTO);
        return Estudante.create(
                estudanteCriado.identificacaoInterna(),
                estudanteCriado.nome(),
                estudanteCriado.idade(),
                estudanteCriado.enderecoEmail()
        );
    }
}
