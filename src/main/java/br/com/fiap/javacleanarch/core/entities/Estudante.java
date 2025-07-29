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

    private void idadeValida(int idade) {
        if (idade >= 18) {
            throw new IllegalArgumentException("Idade inválida. O estudante deve ter pelo menos 18 anos.");
        }
    }

    private void enderecoEmailValido(String enderecoEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(enderecoEmail)) {
            throw new IllegalArgumentException("Endereço de email inválido.");
        }
    }

    public Estudante(String identificacaoInterna, String nome, String enderecoEmail, int idade) {
        idadeValida(idade);
        enderecoEmailValido(enderecoEmail);

        this.identificacaoInterna = identificacaoInterna;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.idade = idade;
    }
}
