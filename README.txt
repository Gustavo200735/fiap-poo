# Sistema de Fones (Java - POO)

Este projeto foi feito para praticar conceitos básicos de **Programação Orientada a Objetos em Java**.

## Aula 1 – Classes e Objetos

Criamos a classe **Fones**, que representa um fone de ouvido.

Ela possui algumas características:

* `cor`
* `nomeDispositivo`
* `volume`

Depois criamos objetos dessa classe no `SistemaPrincipal`.

Exemplo:

```java
Fones meuFone = new Fones();
```

---

## Aula 2 – Métodos e Comportamentos

Na segunda aula adicionamos **métodos** para o objeto.

Métodos criados:

* `ligar()`
* `desligar()`
* `aumentarVolume()`
* `mostrarInformacoes()`

Esses métodos simulam ações que podem ser feitas com o fone.

---

## Aula 3 – Encapsulamento

Na terceira aula aprendemos a **proteger os dados da classe**.

Para isso:

* Os atributos foram alterados para `private`
* Foram criados **getters e setters** para acessar os dados.

Exemplo:

```java
private String cor;

public String getCor() {
    return cor;
}
```

---

## Objetivo

Praticar conceitos básicos de **POO em Java**:

* Classes
* Objetos
* Métodos
* Encapsulamento
* Getters e Setters
