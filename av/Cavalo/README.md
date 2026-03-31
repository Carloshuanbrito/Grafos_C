# T2 - Grafo do Cavalo (3x3)

Implementacao em Python para modelar o movimento do cavalo em um tabuleiro 3x3 como grafo nao direcionado.

## Estrutura

- `dados/entrada.txt`: entrada no formato algs4 (V, E e lista de arestas)
- `src/main.py`: ponto de entrada
- `src/graph.py`: representacao do grafo por lista de adjacencia e leitura do arquivo
- `src/cc.py`: componentes conexas (DFS)
- `src/bfs.py`: distancia minima entre vertices (BFS)
- `src/cycle.py`: deteccao de ciclo e recuperacao de um ciclo encontrado

## Como executar

No terminal, dentro da pasta `t2-cavalo`:

```bash
python src/main.py
```

## Formato da entrada (algs4)

```text
V
E
v1 w1
v2 w2
...
```

## Grafo usado no trabalho

Vertices: 9 (0 a 8)
Arestas: 8

Arestas manuais:

```text
0 7
0 5
1 8
1 6
2 7
2 3
3 8
5 6
```

## Complexidade

- Componentes conexas (DFS): tempo O(V + E), espaco O(V)
- Distancia minima (BFS): tempo O(V + E), espaco O(V)
- Deteccao de ciclo (DFS): tempo O(V + E), espaco O(V)
