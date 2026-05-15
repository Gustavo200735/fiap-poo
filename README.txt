# Projeto FiapRide - Filippo

## Informações do Aluno

- **Nome:** Filippo
- **RM:** [Seu RM]
- **Turma:** [Sua Turma]
- **Curso:** Ciência da Computação
- **GitHub:** [@seu-usuario]

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide** (aplicativo de mobilidade urbana) e também aplicamos os mesmos conceitos em um Desafio Pessoal paralelo.

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe 'Passageiro'? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? Pense: E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?

**Sua Resposta:**
Se o sistema escalar para milhões de usuários, criar variáveis soltas no `main` tornaria o código impossível de manter, cheio de redundâncias e propenso a erros. A classe resolve isso funcionando como um "molde" ou "planta baixa". Ao criar a classe `Passageiro`, definimos uma única vez a estrutura de dados (nome, saldo) e os comportamentos. Assim, o sistema apenas instancia milhões de objetos estruturados na memória usando esse mesmo molde, mantendo o estado de cada usuário isolado e o código extremamente limpo.

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100.0` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?

**Sua Resposta:**
O risco de alterar o saldo diretamente é a perda total de controle sobre a regra de negócio. Sem um método específico, qualquer parte do código poderia atribuir valores negativos ou fraudar o saldo de um passageiro. O método `adicionarSaldo(valor)` encapsula a inteligência do negócio: ele recebe o valor, verifica se é uma quantia válida (maior que zero) e só então atualiza o saldo interno. Ele protege a startup garantindo que o estado do objeto só mude mediante as regras estipuladas.

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o 'get' público, mas perigoso deixar o atributo original público? Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?

**Sua Resposta:**
Deixar um atributo público é como entregar o documento original: qualquer parte externa do sistema pode acessá-lo e, pior, modificá-lo ou apagá-lo livremente, quebrando a integridade do objeto. Ao usar o modificador `private` no atributo e liberar apenas um método `get` como `public`, nós entregamos apenas uma "cópia" do valor (somente leitura) para quem chamou. Assim, o sistema pode consultar a informação, mas não tem poder para alterá-la diretamente.

### Aula 4 - Construtores

**Pergunta:** Na nossa classe 'Veiculo', nós tomamos duas decisões arquitetônicas muito importantes: (1) Nós não criamos o método `setModelo()`. (2) O `setPlaca()` foi criado como privado, e criamos um método público chamado `atualizarPlaca()` para acessá-lo. Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo automaticamente' na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?

**Sua Resposta:**
Gerar "Getters e Setters" para tudo de forma automática fere a regra de negócios. No mundo real, o modelo de um carro não muda fisicamente após sua fabricação, portanto, não deve existir um `setModelo()` – a informação nasce com o construtor e fica imutável. Já a placa do veículo até pode mudar, mas envolve um processo rigoroso (Detran). Se o `setPlaca` for público, qualquer um altera facilmente. Ocultando o `setter` original como `private` e exigindo o uso do `atualizarPlaca()`, nós obrigamos o sistema a passar por validações de segurança e processos de negócio antes de permitir a alteração dessa informação sensível.

### Aula 5 - Associação

**Pergunta:** No construtor da `Viagem`, nós exigimos o objeto inteiro (`Passageiro solicitante`). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (`String nomeDoPassageiro`) em vez do objeto todo? Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo?

**Sua Resposta:**
Não seria viável usar apenas a String do nome porque o sistema perderia a referência do objeto principal. A `Viagem` não existe apenas para imprimir um recibo textual; ela executa ações financeiras e lógicas sobre quem a solicitou. Se passarmos apenas "Ana Silva" (String), não temos como acessar os métodos e atributos da Ana. Exigindo o objeto `Passageiro`, a Viagem consegue, ao ser finalizada, acionar métodos reais do usuário, como por exemplo invocar `passageiro.descontarSaldo()` de forma segura e conectada.

### Aula 6 - Herança

**Pergunta:** No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de Carro NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`. Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?

**Sua Resposta:**
O Java impede isso para proteger o princípio do Encapsulamento (Aula 3). Um atributo `private` pertence unicamente à classe onde foi declarado. Se as classes filhas pudessem mexer diretamente nessas variáveis, elas poderiam contornar todas as validações de segurança e regras de negócio criadas pelos desenvolvedores da superclasse. Usar `super()` no construtor ou `setters` públicos/protegidos garante que os dados da mãe sejam manipulados exclusivamente pelas vias seguras que a própria mãe desenhou.

### Aula 7 - Polimorfismo

**Pergunta:** No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do Carro e da Moto? Por que o contrato precisa existir na base da hierarquia?

**Sua Resposta:**
Não conseguiríamos chamá-lo. O Java trabalha com tipagem estática e forte, e ao declarar o loop como `Veiculo`, o compilador só tem garantia de que existem ali os comportamentos definidos nessa classe mãe. O contrato precisa existir na base (superclasse) para que o polimorfismo funcione: a classe genérica diz "O QUE" todos devem fazer (declarando o método), permitindo que o sistema chame aquela ação sem saber qual é o objeto exato no momento, confiando que cada filha específica vai saber "COMO" fazer através da sobrescrita (`@Override`).

### Aula 8 - Classes Abstratas

**Pergunta:** Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo especifico? Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Pense: Se esquecermos de colocar 'abstract', qual o risco que corremos?

**Sua Resposta:**
Não faz sentido no mundo real; "Veículo" é apenas uma categoria ou conceito, ninguém dirige um "veículo genérico". Se esquecermos de usar a palavra-chave `abstract`, corremos o risco de permitir que desenvolvedores façam `new Veiculo()` no sistema. Isso geraria objetos incompletos, sem regras específicas de motorização ou rodas (como Carro ou Moto), quebrando totalmente a lógica, relatórios e processos do nosso aplicativo de mobilidade. A palavra `abstract` serve justamente para proibir instâncias "vazias de significado real".

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples (apenas uma mãe), mas múltipla implementação de interfaces (vários contratos)? Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` E de `Bateria` ao mesmo tempo (herança múltipla), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar()`? Como as interfaces resolvem esse problema?

**Sua Resposta:**
A herança múltipla de classes gera o temido "Problema do Diamante": o compilador não saberia dizer qual lógica do método `ligar()` ele deveria executar, a do `Veiculo` ou a da `Bateria`. As interfaces resolvem isso porque elas apenas definem "contratos" – assinaturas de métodos vazios, sem implementação. Como as interfaces não dizem *como* o método funciona, a classe `CarroEletrico` pode implementar quantas interfaces quiser sem risco de conflito, pois a implementação real (o código que de fato liga o motor) será escrita exclusivamente pela própria classe que assumiu o contrato.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)
**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Domínio de dispositivos eletrônicos e wearables de áudio, com foco na modelagem de um sistema de Fones de Ouvido Bluetooth.

**Quais classes você criou?**
- `DispositivoBluetooth` (Interface - Contrato de conexão)
- `DispositivoAudio` (Classe Abstrata - Base da hierarquia)
- `EstojoCarregamento` (Associação)
- `Fones` (Subclasse que consolida todas as heranças, interfaces e atributos)
- `SistemaPrincipal` (Classe com método Main para execução)

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio técnico foi entender como migrar os dados soltos e métodos genéricos criados nas primeiras aulas para uma estrutura robusta usando Classes Abstratas e Interfaces de forma combinada. Tive que revisar minha lógica para que a classe `Fones` utilizasse corretamente o `super()` herdando os dados e regras de `DispositivoAudio`, ao mesmo tempo em que me comprometi a implementar a obrigatoriedade da interface `DispositivoBluetooth` (o método `conectar()`). Além disso, entender e aplicar na prática a associação estrutural entre os fones e o `EstojoCarregamento` exigiu bastante atenção para proteger o encapsulamento das duas entidades.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi como pensar "orientado a objetos", saindo do paradigma estrutural de apenas rodar códigos de cima para baixo. Agora compreendo a importância de modelar o mundo real em Classes, proteger as regras de negócio via Encapsulamento, e reutilizar e escalar sistemas inteligentemente aplicando Herança e Polimorfismo, construindo sistemas seguros que podem crescer em manutenibilidade.

**Qual conceito foi mais difícil de entender?**
A diferença exata entre quando usar uma Classe Abstrata e quando usar uma Interface. Superei a dificuldade compreendendo a metáfora de que Herança (Abstrata) é sobre "o que o objeto É" (um fone É um dispositivo de áudio), enquanto Interface é sobre "o que o objeto FAZ" ou um "contrato que ele assina" (um fone FAZ conexões bluetooth, assim como um relógio ou uma TV também podem fazer sem pertencerem à mesma família).

**O que você melhoraria no seu projeto se pudesse refazer?**
Eu adicionaria tratamentos de exceções (`try-catch`) nos `setters` para evitar que lógicas incorretas crashassem a aplicação, melhorando as validações. Também tentaria expandir a arquitetura implementando mais tipos de fones (`Headset`, `Earbuds`) para explorar o polimorfismo de uma maneira ainda mais ampla na classe `SistemaPrincipal`.