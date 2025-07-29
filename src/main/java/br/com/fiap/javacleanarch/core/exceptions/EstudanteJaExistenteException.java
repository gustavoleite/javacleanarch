package br.com.fiap.javacleanarch.core.exceptions;

public class EstudanteJaExistenteException extends RuntimeException {
    public EstudanteJaExistenteException(String nome) {
        super("Estudante com o nome '" + nome + "' já existe.");
    }
}
