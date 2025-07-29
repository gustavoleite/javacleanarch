package br.com.fiap.javacleanarch.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
@EqualsAndHashCode
public class Estudante {

    private String identificacaoInterna;

    private String nome;

    private String enderecoEmail;

    private int idade;

    private static void idadeValida(int idade) {
        if (idade >= 18) {
            throw new IllegalArgumentException("Idade inválida. O estudante deve ter pelo menos 18 anos.");
        }
    }

    private static void enderecoEmailValido(String enderecoEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(enderecoEmail)) {
            throw new IllegalArgumentException("Endereço de email inválido.");
        }
    }

    public static Estudante create(String nome, String enderecoEmail, int idade) throws IllegalArgumentException {
        if (nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Parâmetros inválidos para criar um estudante.");
        }

        enderecoEmailValido(enderecoEmail);
        idadeValida(idade);

        return new Estudante(null, nome, enderecoEmail, idade);
    }

    public Estudante(String identificacaoInterna, String nome, String enderecoEmail, int idade) {
        idadeValida(idade);
        enderecoEmailValido(enderecoEmail);

        this.identificacaoInterna = identificacaoInterna;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.idade = idade;
    }

    public void setIdentificacaoInterna(String identificacaoInterna) {
        this.identificacaoInterna = identificacaoInterna;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        enderecoEmailValido(enderecoEmail);
        this.enderecoEmail = enderecoEmail;
    }

    public void setIdade(int idade) {
        idadeValida(idade);
        this.idade = idade;
    }
}
