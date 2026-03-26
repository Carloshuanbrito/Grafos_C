package src;

import java.util.Stack;

public class DepthFirstPaths {

    // marca quais vértices já foram visitados
    private boolean[] marked;

    // guarda o caminho (de onde viemos)
    private int[] edgeTo;

    // vértice de origem
    private final int s;

    // construtor
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        dfs(G, s);
    }

    // DFS (busca em profundidade)
    private void dfs(Graph G, int v) {

        // marca o vértice atual
        marked[v] = true;

        // percorre os vizinhos
        for (int w : G.adj(v)) {

            // se ainda não visitou
            if (!marked[w]) {

                edgeTo[w] = v; // guarda de onde veio
                dfs(G, w);     // continua aprofundando
            }
        }
    }

    // verifica se existe caminho até v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // retorna o caminho da origem até v
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        // volta do destino até a origem
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        // adiciona a origem
        path.push(s);

        return path;
    }
}