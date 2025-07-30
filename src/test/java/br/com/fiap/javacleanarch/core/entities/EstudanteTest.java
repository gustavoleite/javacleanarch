package br.com.fiap.javacleanarch.core.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudanteTest {

    @DisplayName("Cria estudante com sucesso")
    @Test
    void testEstudanteOk() {
        // arrange
        String nome = "João da Silva";
        int idade = 20;
        String email = "joao@fiap.com.br";
        // act
        var estudante = Estudante.create(null, nome, idade, email);
        // assert
        assertEquals(estudante.getNome(), nome);
        assertEquals(estudante.getIdade(),idade);
        assertEquals(estudante.getEnderecoEmail(), email);
        assertNull(estudante.getIdentificacaoInterna());
    }

    @DisplayName("Cria estudante com identificação e com sucesso")
    @Test
    void testEstudanteIdentificacaoOk() {
        // arrange
        String nome = "João da Silva";
        int idade = 20;
        String email = "joao@fiap.com.br";
        String identificador = "identidade";
        // act
        var estudante = Estudante.create(identificador, nome, idade, email);
        // assert
        assertEquals(estudante.getNome(), nome);
        assertEquals(estudante.getIdade(),idade);
        assertEquals(estudante.getEnderecoEmail(), email);
        assertEquals(estudante.getIdentificacaoInterna(), identificador);
    }
}