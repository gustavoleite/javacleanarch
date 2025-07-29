package br.com.fiap.javacleanarch.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Getter
@EqualsAndHashCode
public class Curso {

    private String nome;
    private boolean ativo;
    private ArrayList<Estudante> estudantes = new ArrayList<>();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    private void nomeValido(String nome) {
        if (nome.trim().isBlank()) {
            throw new InvalidParameterException("Nome inválido. O nome do curso não pode ser vazio.");
        }
    }

    public Curso(String nome, boolean ativo) {
        nomeValido(nome);

        this.nome = nome;
        this.ativo = ativo;
    }
}
