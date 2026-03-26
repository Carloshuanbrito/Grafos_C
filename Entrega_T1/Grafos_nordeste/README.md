#  **Grafos - Região Nordeste do Brasil**

## 👥 **Grupo C**

### **Integrantes**

- **José Eugênio** — 2320466  
- **Mateus Rocha Lessa** — 2410456  
- **Carlos Huan Celestino de Brito** — 2320478  
- **Lucas de Vasconcelos Barreira Carvalho** — 2410424  

---

## 📌 **Sobre o Projeto**

Este projeto foi desenvolvido para a disciplina de **Grafos**.

A proposta é modelar um grafo representando os estados da região Nordeste do Brasil, considerando suas fronteiras terrestres, e aplicar algoritmos de busca para análise de caminhos e conectividade.

---

##  **O que representa o grafo**

Neste problema:

- **Vértices** → Estados do Nordeste  
- **Arestas** → Fronteiras terrestres entre os estados  

Ou seja, se dois estados fazem fronteira, existe uma aresta conectando eles no grafo.

---

## ⚙️ **Estrutura do Projeto**

A implementação foi feita em **Java**, utilizando lista de adjacência.

As principais classes são:

### **Graph**
Responsável por representar o grafo, armazenando:
- número de vértices  
- número de arestas  
- lista de adjacência (vizinhos de cada estado)  

---

### **DepthFirstPaths (DFS)**
Implementa a busca em profundidade, utilizada para:
- verificar conectividade  
- encontrar caminhos no grafo  

---

### **BreadthFirstPaths (BFS)**
Implementa a busca em largura, utilizada para:
- encontrar o menor caminho entre dois estados  

---

### **Main**
Classe principal responsável por:
- ler o arquivo com os dados do grafo  
- receber o estado inicial e destino  
- executar DFS e BFS  
- exibir os resultados  

---

## 📂 **Arquivo de Entrada**

O grafo é construído a partir do arquivo:

```
dados/nordeste.txt
```

Formato:

```
9
13
0 1
0 5
...
```

- Primeira linha → número de vértices  
- Segunda linha → número de arestas  
- Demais linhas → conexões entre estados  

---

## ▶️ **Como executar**

### 1️⃣ Acessar a pasta do projeto

```
cd src
```

### 2️⃣ Compilar os arquivos

```
javac *.java
```

### 3️⃣ Executar o programa

```
java Main
```

---

## 💻 **Funcionamento**

O programa solicita:

- Estado inicial  
- Estado de destino  

E retorna:

- Se existe caminho entre os estados  
- Caminho encontrado com DFS  
- Caminho encontrado com BFS  
- Estados alcançáveis  
- Ordem de visita do DFS  
- Ordem de visita do BFS  

---

## 🎥 **Vídeo Explicativo**

Link do vídeo com a explicação da solução (2 minutos):

👉 *(adicione aqui o link do vídeo)*
