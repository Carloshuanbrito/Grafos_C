# 🇧🇷 Coloração de Grafos – Mapa do Brasil com DSatur

## 👥 Integrantes do Grupo
José Eugênio — 2320466  
Mateus Rocha Lessa — 2410456  
Carlos Huan Celestino de Brito — 2320478  
Lucas de Vasconcelos Barreira Carvalho — 2410424  

---

## 🎥 Vídeo explicativo do projeto:
https://drive.google.com/file/d/13800XQjfp-kOkwZvMVNyLng99kgxHyEi/view?usp=sharing



---


Dado um arquivo de entrada no padrão do algs4, o programa:

- Lê o número de vértices e arestas  
- Constrói o grafo usando **lista** de adjacência  
- Aplica o algoritmo **DSatur** 
- Determina a ordem de coloração dos vértices  
- Atribui cores válidas aos estados  
- Calcula o número total de cores utilizadas  
- Verifica se a coloração é válida  
- Exibe os resultados no terminal  

---

## Graph
Representa o grafo:

- Implementado com lista de adjacência  
- Armazena os vértices e suas conexões  

Métodos principais:

- `add_edge(v, w)` → adiciona uma aresta  
- `neighbors(v)` → retorna vizinhos  
- `degree(v)` → retorna o grau do vértice  

---

## DSatur
Responsável pela coloração do grafo:

Implementa o algoritmo DSatur:

- Seleciona o vértice com maior saturação  
- Saturação = número de cores diferentes nos vizinhos  
- Critério de desempate: maior grau  
- Atribui a menor cor disponível  

Também:

- Retorna a ordem de coloração  
- Garante que não haja conflito entre vizinhos  

---

## Main
Classe principal do programa:

- Lê o arquivo de entrada (`brasil.txt`)  
- Constrói o grafo  
- Mapeia índices para estados brasileiros  
- Executa o DSatur  
- Exibe:
  - Lista de adjacência  
  - Ordem de coloração  
  - Cores atribuídas  
  - Total de cores usadas  
  - Validação da solução  

---
Cada linha representa uma conexão entre estados
##  Como rodar o projeto
1️⃣ Entrar na pasta do código
cd projeto-grafos
2️⃣ Executar o programa
python main.py dados/brasil.txt
