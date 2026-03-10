package br.com.fiapride.main;

// Importamos a classe Fones
import br.com.fiapride.model.Fones;

public class SistemaPrincipal {

    public static void main(String[] args) {

        // Instância 1
        Fones meuFone = new Fones();
        meuFone.cor = "preto";
        meuFone.nomeDispositivo = "AirPods";
        meuFone.volume = 20;

        // Instância 2
        Fones foneDoAmigo = new Fones();
        foneDoAmigo.cor = "branco";
        foneDoAmigo.nomeDispositivo = "JBL";
        foneDoAmigo.volume = 15;

        // Usando métodos
        meuFone.ligar();
        meuFone.aumentarVolume(5);

        foneDoAmigo.ligar();
        foneDoAmigo.aumentarVolume(10);

        System.out.println("\n--- Informações do meu fone ---");
        meuFone.mostrarInformacoes();

        System.out.println("\n--- Informações do fone do amigo ---");
        foneDoAmigo.mostrarInformacoes();

        meuFone.desligar();
        foneDoAmigo.desligar();
    }
}