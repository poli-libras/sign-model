Sign Model 2.0
==============

Contexto
--------

Essas alterações foram feitas com base nos requisitos levantados pela análise de sinais da apostila do curso do Centro Educacional Cultura Surda.

Esta apostila apresenta várias listagens de vocabulário em LIBRAS com o sinal em Sign Writing, o que facilita o trabalho de pensar como cada sinal poderia ser representado em nosso modelo.

Dessa forma, pensando em como os sinais descritos na apostila seriam melhor representados em nosso modelo, pode-se avançar com essa melhoria, garantindo que mais sinais possam ser representados.

Análise
--------

A seguir segue os pontos levantados na análise seguidos de um diagnóstico no modelo, que pode ser uma indicação de alteração, ou não.

* **Munheca**. Bastante usado no Sign Writing, mas não necessário no modelo, pois pode ser sempre resolvido por composição de símbolos. Exemplo: sinal ONTEM no Sign Writing tem um movimento pra cima munhecado, mas pode ser representado por um símbolo BLACK-HORIZONTAL seguido de um BLACK-VERTICAL. 

* **Firmeza**. Utilizado no sinal PODE. Ainda não achei um outro exemplo. Será implementado por um tipo específico de interpolação no HandMovement. A interpolação poderia ser de cada segmento, mas por hora achamos que seria exagero. 

* **Refinamento de ângulos**, assim como já temos INCLINADO para a rotação, poderíamos ter também para plano e orientação. Mas pelos sinais estudados, creio que este problema será melhor endereçado pela propriedade "tremida". 

* **Tremida** ("shakeYaw"), para representar movimentos como o de "Ç", OUTUBRO e ENTENDE; tem até uma representação específica no Sign Writing. Pode ser um atributo do símbolo. A princípio parece ser do movimento, mas considerando os sinais Ç e OUTUBRO ficaria meio sem sentido. 

* **Locação nos movimentos**. Deve-se diferenciar a locação estática, que perdura por todo o sinal, como em MECÂNICO, da locação dinâmica, que é parte do movimento, como em CHEFE ou CHAPÉU. No caso da locação dinâmica, seria preciso especificar se a locação ocorre no início, meio ou fim do movimento (ou segmento). 

* **Esfregar os dedos**, como em SAL e FARINHA. Deve-se acrescentar como opção de movimento de dedos. Neste caso a implementação no Virtual Jonah pode ter que ser diferente de acordo com a configuração de mão! 

* **Movimento espiral**, como em MACARRÃO. Já temos o tipo de movimento HELICOIDAL. 

* **Movimento circular**: garantir que seja possível em todas as dimensões, ex: FLOR, BOTÃO. Permitir movimento meio-circular quarto-circular. Cada uma das opções HORÁRIO e ANTI-HORÁRIO ainda permitem duas possibilidades: mão sai pra fora, ou sai pra dentro. 

* **Locação na perna**, para sinais CALÇA e SAIA. Acho que esses sinais já ficam bem com a locação CINTURA, que já existe. Mas se fosse fazer perna, teria a frente da perna e o lado da perna. 

* **Movimento de ombro**. Usado em CAMISA. Poderia ser implementado como atributo de expressão corporal, da mesma forma que existem os atributos da expressão facial. 

* **Movimento de cabeça**: balançar cabeça como "sim" ou como "não". 

* **Mãos em unidade**: na verdade indica somente que a mão não-dominante também vai ao ponto de locação, o que tem mais sentido para os sinais sem movimento. Como é um atributo confuso, poderia ser alterado jogando a locação para mão, mas o que permitiria inconsistência, já que a mão não-dominante ou vai pro mesmo lugar que a dominante, ou fica parada. Dessa forma, vou deixar como estar. 

* **Mãos sobre-postas**. Em alguns sinais é preciso indicar qual mão está sobre outra para evitar ambiguidade. ex: DE NADA. Poderia ser um atributo do símbolo, e que só faria sentido se houvesse contato entre as mãos. Mas agora que temos os Locations mais refinados (para mão e para contato), talvez esse atributo não seja necessário. Exemplo, no sinal DE NADA, temos a mão direita e a mão esquerda com locação no ESPACO_NEUTRO_DIREITO, e a mão direita tem contato do tipo ESFREGAR na locação PALMA_DA_MAO_ESQUERDA.

* **Contato esfregar**. Deve ser usado no modelo pra representar um ligeiro movimento circular sobre um contato. Em alguns lugares na apostila é usado como uma espécie de "contato contínuo durante o movimento", mas vamos evitar esse sentido; nesse último caso usar o contato normal. 

* **Marcas de alternado e simultâneo**, bastante presentes no Sign Writing, mas desnecessárias em nosso modelo, pois especifica-se precisamente o movimento de cada mão de forma independente. 

* **Mão esquerda sendo utilizada** não será mais representado pelo modelo. Caso não haja mão esquerda, rightHand == null denota essa situação de forma inequívoca.

* **Movimento oscilatório dos dedos**, como em MAR. Seria a enumeração PROXIMAIS_ABREM_E_FECHAM_ALTERNADAMENTE, mas pode ser interessante mudar o nome deste enum. Opção: OSCILAM, ou MOVEM_SE_ALTERNADAMENTE. 

* **Divisão das locações**, em direito e esquerdo, como OMBRO_DIREITO/OMBRO_ESQUERDO, TESTA_DIREITA/TESTA_ESQUERDA, ESPACO_NEUTRO_DIREITO/ESPACO_NEUTRO_ESQUERDO 

* **Locação do contato**. Apesar de o modelo conseguir representar o contato em muitos sinais, não é possível indicar que o sinal ocorre no ESPACO_NEUTRO e que há contato com outra parte do corpo ao mesmo tempo. Por isso é preciso distinguir a locação do símbolo da locação do ponto de contato, mesmo que haja coincidência na maioria das vezes.

* **Locação própria de cada mão**. No primeiro símbolo do sinal PAGAR, a mão esquerda tem locação ESPACO_NEUTRO_DIREITO, enquanto que a mão direita tem locação ORELHA. Para conseguirmos representar isso é preciso com que Locação seja propriedade da mão, e não do símbolo. Mesmo problema em PEDAGOGIA.

* **Movimento alternado dos dedos**, em PLANETA_TERRA, é necessário uma nova movimentação dos dedos para representar que eles estão fechando um por um a partir do dedo mínimo. 

* **Ponto de contato**, como diferenciar onde o contato será feito. Duas opções: 1- deixar o modelo mais elaborado; 2-fazer o VJ inferir (encostar a parte da mão que estiver mais próxima ao ponto de contato). Principais problemas: FLORESTA há contato entre a mão esquerda e o cotovelo, RIO_DE_JANEIRO também não está modelável (contato vale por dois símbolos) 

* **Agarrar**, presente no sinal CAMISA, onde a mão deve agarrar a camisa. 

Alterações aplicadas
--------------------

**Hand**

* yaw, pitch e roll são salvos como double pq são ângulos (em radianos ou graus? acho q graus pq é oq é usados nas libs 3D, neh?).

* **shakeYaw**: para Ç e OUTUBRO 

* **FingersMovement**

    * "Proximais abrem e fecham" alternadamente virou Oscilam 
    * "Se esfregam" adicionado 
    * Location no Contact adicionado 
    * "Proximais fecham alternadamente" adicionado 

* **HandMovement**

    * interpolation adicionado, sinal PODE 
    * startsInLocation é trocado por locationAt = {início, meio, fim} 

Obs: é preciso ter cuidado para não confundir o Contact + ContactQuantity com esse MovementLocationAt. Por exemplo, para sinais sem movimento, como SABER e DIA fica bem claro como usamos o ponto de contato, mas para sinais como JUNHO não é tão óbvio.

Para resolver essa dilema assim estabeleceremos:

* Se o sinal não possuir movimento de mão, as propriedades Contact e ContactQuantity definirão comportamentos como os dos sinais SABER, DIA.
* Se o sinal possuir movimento, o atributo ContactQuantity não faz sentido, e Contact será utilizado em conjunto com o MovementLocationAt. Isso será aplicado a sinais como DESCULPAR e JUNHO. 

Importante notar ainda que o MovementLocationAt poderia ser definido para cada segmento, mas por enquanto acho que em geral isso daria mais trabalho. No entanto, no caso de JUNHO isso dificulta, pois por causa disso serão necessários criar dois símbolos.

* **Movimento circular**

para melhor representar o movimento circular foi criada a classe RoundSegment, que herda de Segment.

Definição do segmento circular:

   * **Direction**: {horário, anti-horário} // herdado
   * **Magnitude** (raio) // herdado
   * **RoundPlane**: vertical x horizontal
   * **RoundLength**: inteiro x meio x quarto
   * **initialMovVector** vetor que ajuda a determinar se movimento é "para fora" ou "para dentro" ou intermediários. 

Como criamos uma herança, é preciso pensar no JPA de Segment e RoundSegment .

* **Movimento corporal**

   * Movimento dos ombros: atributo shoulder em Body.
   * Movimento de cabeça: atributo head em Body.

* **Mais enumerações**

   * queixo vira queixo direito, queixo esquerdo, queixo
   * espaço neutro vira espaço neutro, espaço neutro direito, espaço neutro esquerdo
   * TESTA_DIREITA / TESTA_ESQUERDA
   * OMBRO_DIREITO / OMBRO_ESQUERDO
   * QUADRIL
   * BUSTO_DIREITO / BUSTO_ESQUERDO
   * PROXIMAIS_FECHAM_ALTERNADAMENTE

Obs: provavelmente as locações do grupo MAO só façam sentido pra especificar o ponto de contato, e não as locações das mãos.
Mas todas as outros valores de Location serviriam para locações e pontos de contato.

Diagrama de classes do Sign Model 2.0
-------------------------------------

Modelo atual
------------

![Diagrama de classes do sign-model 2.0](https://raw.github.com/poli-libras/sign-model/master/doc/model2.png)

Exemplos de sinais modelados:
-----------------------------

https://github.com/poli-libras/sign-model/tree/master/doc/sinais

Sinais ainda não contemplados pelo modelo
-----------------------

* FLORESTA (ponto de contato é entre ombro e mão, e não entre mãos)
* RIO DE JANEIRO (locação do contato perdura por dois símbolos)
* ANO (movimento circular no espaço neutro)
* LIBERDADE (posição inicial das mãos não pode ser representado) 
* PELEJAR (posição final das mãos difícil de ser representado) 
* RACIOCINAR (posição das mãos durante o movimento difícil de ser representado)
* MECANICO (as duas mãos apresentam movimento circular alternado no espaço neutro) 
* PIZZA (dá pra aproximar, desconsiderando o contato entre os dados no fim do sinal)
* ANO (???)


