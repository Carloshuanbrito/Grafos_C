# 🐎 Grafo do Cavalo em Tabuleiro 3x3

## 👥 Integrantes do Grupo C
José Eugênio — 2320466  
Mateus Rocha Lessa — 2410456  
Carlos Huan Celestino de Brito — 2320478  
Lucas de Vasconcelos Barreira Carvalho — 2410424  

---

🎥 **Vídeo explicativo do projeto:**  
https://www.youtube.com/watch?v=jQPCcL3kYCA

##  Descrição do Projeto

Este projeto foi desenvolvido para a disciplina de Grafos.

O objetivo é modelar um grafo onde:

- Vértices representam as casas de um tabuleiro `3x3`
- Arestas representam os movimentos válidos do cavalo no xadrez

A partir dessa modelagem, aplicamos algoritmos clássicos de grafos para analisar propriedades estruturais.

---

##  Conceitos Aplicados

- **DFS (Depth-First Search)** → Busca em profundidade  
- **BFS (Breadth-First Search)** → Busca em largura  
- **Componentes conexas**  
- **Caminho mínimo**  
- **Detecção de ciclos**

---

##  O que o programa responde

O programa realiza as seguintes análises:

-  Lista de adjacência do grafo  
-  Identificação das componentes conexas  
-  Distância mínima entre `(0,0)` e `(2,2)`  
-  Verificação se o grafo possui ciclo  
-  Apresentação de um ciclo encontrado  

---

##  Modelagem do Problema

A numeração dos vértices segue a ordem de leitura do tabuleiro:

```
(0,0)=0  (0,1)=1  (0,2)=2
(1,0)=3  (1,1)=4  (1,2)=5
(2,0)=6  (2,1)=7  (2,2)=8
```

O vértice **4** não possui movimentos válidos do cavalo, sendo uma componente isolada.

---

## ⚙️ Explicação das Classes

### 🔹 Graph
Representa o grafo utilizando lista de adjacência (padrão algs4).

Responsável por:
- armazenar vértices e arestas  
- adicionar conexões entre vértices  
- validar entradas  

---

### 🔹 BFSShortestPath (BFS)

Implementa a busca em largura:

- Explora o grafo em níveis  
- Garante o menor caminho em número de arestas  
- Calcula a distância mínima entre dois vértices  

---

### 🔹 CC (Componentes Conexas)

Implementa DFS para:

- identificar grupos de vértices conectados  
- determinar quantas componentes existem no grafo  

---

### 🔹 Cycle

Responsável por:

- detectar ciclos no grafo  
- reconstruir um ciclo encontrado  

---

### 🔹 Main

Classe principal:

- lê o grafo do arquivo  
- executa todos os algoritmos  
- exibe os resultados de forma organizada  

---

---

##  Formato do Arquivo de Entrada

O arquivo segue o padrão algs4:

```
9
8
0 7
0 5
1 8
1 6
2 7
2 3
3 8
5 6
```

---

##  Como clonar e executar o projeto

```bash
# 1️⃣ Clonar o repositório
git clone https://github.com/netoeugenio/Grafos_C.git

# 2️⃣ Acessar a pasta do projeto
cd Grafos_C/Entrga_t2/Cavalo

# 3️⃣ Entrar na pasta do código
cd src

# 4️⃣ Executar o programa
python main.py
```

---
