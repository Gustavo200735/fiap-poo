package br.com.fiapride.model;

public class Fones {    

    // Características (atributos)
    public String cor;
    public String nomeDispositivo;
    public int volume;

    // Métodos (comportamentos)

    public void ligar() {
        System.out.println(nomeDispositivo + " foi ligado.");
    }

    public void desligar() {
        System.out.println(nomeDispositivo + " foi desligado.");
    }

    public void aumentarVolume(int valor) {
        volume += valor;
        System.out.println("Volume agora está em: " + volume);
    }

    public void mostrarInformacoes() {
        System.out.println("Marca do fone: " + nomeDispositivo);
        System.out.println("Cor do fone: " + cor);
        System.out.println("Volume atual: " + volume);
    }
}