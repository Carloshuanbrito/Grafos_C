@SuppressWarnings("unchecked")
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Numero de vertices nao pode ser negativo");
        }

        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(in in) {
        this(in.readInt());
        int edges = in.readInt();

        if (edges < 0) {
            throw new IllegalArgumentException("Numero de arestas nao pode ser negativo");
        }

        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException(
                "Vertice invalido: " + v + ". Os vertices devem estar entre 0 e " + (V - 1)
            );
        }
    }
}
