package br.com.fiapride.main;

// Importamos a classe Passageiro para que o sistema a reconheça
import br.com.fiapride.model.Fones;

public class SistemaPrincipal {

    public static void main(String[] args) {
    	Fones meuFone = new Fones();
    	meuFone.cor = "preto";
    	meuFone.nomeDispositivo = "airpod";
    	// Fabriquei a segunda (Instância 2)
    	Fones foneDoAmigo = new Fones();
    	foneDoAmigo.cor = "branco";
    	foneDoAmigo.nomeDispositivo = "jbl";
    	System.out.println("Meu fone é: " + meuFone.cor);
    	System.out.println("A do professor é: " + foneDoAmigo.cor);
    	System.out.println("Amarca do meu fone é: " + meuFone.nomeDispositivo);
    	System.out.println("A marca do fone do meu amigo é: " + foneDoAmigo.nomeDispositivo);
    }
}