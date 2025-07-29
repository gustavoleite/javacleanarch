package br.com.fiap.javacleanarch.core.exceptions;

public class EstudanteNaoEncontradoException extends RuntimeException {
    public EstudanteNaoEncontradoException(String nome) {
        super("Estudante com o nome '" + nome + "' não foi encontrado.");
    }
}
