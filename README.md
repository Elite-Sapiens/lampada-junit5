# Exercício da lâmpada com JUnit5

O desafio consiste em implementar uma classe ```Lâmpada``` com uma classe ```Interruptor``` para acionar o funcionamento da lâmpada. Após uma certa quantidade de cliques, a lâmpada queima.
Alguns testes foram implementados com JUnit5:

- Retornar desligada, assim que a classe é instanciada.
- Retornar desligada ao apertar o interruptor duas vezes, já que ela inicia desligada, aperta uma vez ela liga, na próxima desliga.
- Retornar queimada quando for acionada 1000 vezes, seja ligando ou desligando. Por padrão, nos testes foram adotados uma quantidade de cliques com valor 1000.
- Retornar desligada ao apertar o interruptor em um número par de vezes.
- Retornar sempre queimada com a quantidade de cliques informada no arquivo csv.
