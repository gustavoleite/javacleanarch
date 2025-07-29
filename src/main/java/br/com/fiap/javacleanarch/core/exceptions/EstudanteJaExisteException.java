package br.com.fiap.javacleanarch.core.exceptions;

public class EstudanteJaExisteException extends RuntimeException {
    public EstudanteJaExisteException(String nome) {
        super("Estudante com o nome '" + nome + "' já existe.");
    }
}
