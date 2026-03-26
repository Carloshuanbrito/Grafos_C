package src;

import java.util.*;

public class BreadthFirstPaths {

   
    private boolean[] marked;

    // guarda de onde viemos 
    private int[] edgeTo;

    // distância da origem até cada vértice
    private int[] distTo;

    // vértice de origem
    private final int s;

    // construtorm recebe o grafo e o vértice inicial
    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];

        bfs(G, s);
    }

    // algoritmo BFS 
    private void bfs(Graph G, int s) {

        // fila usada para controlar a ordem de visita
        Queue<Integer> queue = new LinkedList<>();

        // começa pelo vértice inicial
        marked[s] = true;
        distTo[s] = 0;
        queue.add(s);

        // enquanto tiver vértices na fila
        while (!queue.isEmpty()) {

            // pega o primeiro da fila
            int v = queue.poll();

            // percorre todos os vizinhos de v
            for (int w : G.adj(v)) {

                // se ainda não foi visitado
                if (!marked[w]) {

                    marked[w] = true;        // marca como visitado
                    edgeTo[w] = v;           // guarda de onde veio
                    distTo[w] = distTo[v] + 1; // calcula a distância
                    queue.add(w);            // adiciona na fila
                }
            }
        }
    }

    // verifica se existe caminho da origem até v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // retorna a distância da origem até v
    public int distTo(int v) {
        return distTo[v];
    }

    // retorna o caminho da origem até v
    public Iterable<Integer> pathTo(int v) {

        // se não existe caminho, retorna null
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        // volta do destino até a origem usando edgeTo
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        // adiciona a origem no final
        path.push(s);

        return path;
    }
}