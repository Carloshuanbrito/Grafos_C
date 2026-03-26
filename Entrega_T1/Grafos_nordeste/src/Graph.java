package src;
import java.util.*;

public class Graph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = (List<Integer>[]) new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}