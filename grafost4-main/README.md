# 🌍 Problema do Caixeiro Viajante com Heurísticas de Inserção

## 👥 Integrantes do Grupo

- José Eugênio — 2320466  
- Mateus Rocha Lessa — 2410456  
- Carlos Huan Celestino de Brito — 2320478  
- Lucas de Vasconcelos Barreira Carvalho — 2410424  

🎥 **Vídeo explicativo do projeto:**  
https://youtu.be/9czh8XwxNc0?si=dTKlWpv6kaBuPvdD

---

##  Descrição do Projeto

Este projeto foi desenvolvido para a disciplina de **Grafos**.

O objetivo é resolver o **Problema do Caixeiro Viajante (TSP)** utilizando heurísticas de inserção.

O problema consiste em:

- Dado um conjunto de pontos (cidades) no plano  
- Construir um ciclo (tour) que passa por todos os pontos  
- Minimizar a distância total percorrida  

Foram implementadas duas heurísticas:

- **Nearest Insertion** → Inserção pelo ponto mais próximo  
- **Smallest Increase** → Inserção pelo menor aumento de custo  

---

## O que o programa faz

Dado um arquivo de entrada com coordenadas, o programa:

- Lê os pontos do plano cartesiano  
- Constrói um tour usando **Nearest Insertion**  
- Constrói outro tour usando **Smallest Increase**  
- Calcula o comprimento total de cada tour  
- Exibe os resultados  
- Mostra uma visualização gráfica comparando as duas heurísticas  

---

##  Explicação das Classes

###  Point
Representa um ponto no plano cartesiano:
- Armazena coordenadas `(x, y)`  
- Calcula distância entre pontos  

---

###  Tour
Representa o ciclo (tour) do TSP:
- Estrutura baseada em **lista encadeada circular**  
- Responsável por armazenar os pontos na ordem do percurso  

Implementa as heurísticas:

- `insertNearest(Point p)`  
- `insertSmallest(Point p)`  

Também calcula o comprimento total do tour.

---

###  Main
Classe principal do programa:
- Lê o arquivo de entrada  
- Constrói os tours com as duas heurísticas  
- Exibe os resultados no terminal  
- Chama o visualizador gráfico  

---

###  TSPVisualizer
Responsável pela visualização gráfica:
- Desenha os pontos e as conexões  
- Compara os dois tours lado a lado  
- Permite zoom e movimentação  

---

###  Classes auxiliares (In, StdIn, StdOut, StdDraw)
Classes padrão baseadas no **algs4**:
- Leitura de arquivos  
- Entrada e saída  
- Desenho gráfico  

---
 

---

## 🚀 Como rodar o projeto

### 1️⃣ Entrar na pasta do código

```bash
cd t4-tsp
cd src
2️⃣ Compilar os arquivos Java
javac Main.java Point.java Tour.java TSPVisualizer.java In.java StdIn.java StdOut.java StdDraw.java
3️⃣ Executar o programa
java Main ../dados/tsp10.txt
