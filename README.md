# RPGTextual_CC_3Semestre

Projeto feito para a conclusão das Atividades Práticas Supervisionadas (APS) do terceiro semestre. Esse projeto consiste num RPG textual que busca conscientizar os usuários a respeito do
cuidado com o meio ambiente, e as melhoras práticas para um futuro sustentável. 

## Tecnologias utilizadas

Para o desenvolvimento do RPG textual, usamos as seguintes tecnologias:

- Java (linguagem de programação escolhida);
- Jansi (lib para mudança de cor dos outputs);
- Maven (gerenciador de dependências).

## Como rodar o projeto

Para rodar o projeto em sua máquina local, é necessário ter o Java instalado na versão 21. E além disso, ter feito a instalação do gerenciador de dependências Maven.

Primeiramente, faça o clone do projeto através do seguinte comando:

```bash
git clone https://github.com/Invokedzz/RPGTextual_CC_3Semestre
```

Depois disso, faça as instalações das dependências no diretório do projeto clonado:

```bash
mvn install 
```

E então, pode finalmente rodar o projeto utilizando este comando:

```bash
 mvn clean compile exec:java   
```
