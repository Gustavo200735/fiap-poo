package br.com.fiapride.model;

// Aula 5 - Nova classe criada para associação
public class EstojoCarregamento {
    private int nivelBateria;

    public EstojoCarregamento(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public int getNivelBateria() { 
        return nivelBateria; 
    }
}