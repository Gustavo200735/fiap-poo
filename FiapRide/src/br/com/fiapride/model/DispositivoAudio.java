package br.com.fiapride.model;

// Aula 8 - Classe mãe como abstract class
public abstract class DispositivoAudio {
    // Atributo com modificador de acesso adequado (protected para filhas)
    protected String nomeDispositivo; 

    public DispositivoAudio(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    // Implementação obrigatória nas filhas
    public abstract void mostrarInformacoes(); 
}