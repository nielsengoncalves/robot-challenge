# Robot Challenge
[![Build Status](https://travis-ci.org/nielsenmg/robot-challenge.svg?branch=master)](https://travis-ci.org/nielsenmg/robot-challenge)
![codecov.io](https://codecov.io/github/nielsenmg/robot-challenge/coverage.svg?branch=master)

O projeto consiste em prover uma API de comunicação para que um robô consiga se movimentar em Marte a partir de uma lista de comandos.
## Requisitos

- [Java8](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)
- [Maven](https://maven.apache.org/)

## Instalação

Primeiramente é necessário fazer o download dos arquivos:

```bash
https://github.com/nielsenmg/robot-challenge.git
```

Navegue até o diretório raiz `/robot-challenge` e execute o seguinte comando para a execução do projeto:
```bash
mvn spring-boot:run
```

## Configurações
Todas as configurações do projeto devem ser feitas através do arquivo `application.properties`.

```yaml
server.port=8080      # Porta que o servidor irá rodar
nasa.robot.start-x=0  # Posição X inicial do robô
nasa.robot.start-y=0  # Posição Y inicial do robô
nasa.surface.size=5   # Tamanho da superfície
```

Por padrão a aplicação é inicializada na porta 8080.

## Exemplos

| Movimento | Descrição                      | 
|-----------|--------------------------------|
| M         | Mover em frente                |
| L         | Girar 90 graus para a esquerda |
| R         | Girar 90 graus para a direita  |

| Método  | URL                  | Retorno Esperado  | Descrição                                                      |
|---------|----------------------|-------------------|----------------------------------------------------------------|
| POST    | /rest/mars/MMRMMRMM  | (2, 0, S)         | Robô move 2 passos para o Norte, 2 para o Leste e 2 Para o Sul |
| POST    | /rest/mars/MML       | (0, 2, W)         | Robô move 2 passos para o Norte e gira para a esquerda         |
| POST    | /rest/mars/AAA       | 400 - Bad Request | A não é um movimento válido                                    |
| POST    | /rest/mars/MMMMMMMM  | 400 - Bad Request | Robô não pode andar mais do que o limite da superfície         |

**Tipos de Respostas:**

| Código | Nome                   | Descrição                                                            |
|--------|------------------------|----------------------------------------------------------------------| 
|200     | OK                     | Indica que a operação foi realizada com sucesso.                     |
|400     | Bad Request            | Indica que os parâmetros fornecidos estão incorretos.                |
|404     | Not Found              | Indica que o recurso solicitado não foi localizado.                  |
|500     | Internal Server Error  | Indica que ocorreu algum erro interno no processamento da requisição |
 

## Testes
Os testes podem ser executados através do comando:
```bash
mvn test
```