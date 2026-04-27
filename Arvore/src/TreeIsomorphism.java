import java.util.*;

public class TreeIsomorphism {
    private final Graph graph;
    private String validationMessage = "";

    public TreeIsomorphism(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException("graph nao pode ser nulo");
        }
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    // =========================
    // 1. VALIDAR ÁRVORE
    // =========================
    public boolean isTree() {
        int V = graph.V();
        int E = graph.E();

        if (E != V - 1) {
            validationMessage = "Nao eh arvore: numero de arestas diferente de V-1";
            return false;
        }

        boolean[] visited = new boolean[V];
        dfs(0, visited);

        for (boolean v : visited) {
            if (!v) {
                validationMessage = "Nao eh arvore: grafo nao eh conexo";
                return false;
            }
        }

        validationMessage = "Grafo valido: eh uma arvore";
        return true;
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    // =========================
    // 2. CENTROS
    // =========================
    public int[] getCenters() {
        int n = graph.V();
        int[] degree = new int[n];

        Queue<Integer> leaves = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int w : graph.adj(i)) degree[i]++;
            if (degree[i] <= 1) leaves.add(i);
        }

        int processed = leaves.size();

        while (processed < n) {
            Queue<Integer> newLeaves = new LinkedList<>();

            while (!leaves.isEmpty()) {
                int leaf = leaves.poll();

                for (int neighbor : graph.adj(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }

            processed += newLeaves.size();
            leaves = newLeaves;
        }

        int[] centers = new int[leaves.size()];
        int i = 0;
        for (int c : leaves) centers[i++] = c;

        return centers;
    }

    // =========================
    // 3. CODIFICAÇÃO CANÔNICA
    // =========================
    public String getCanonicalEncoding() {
        if (!isTree()) {
            throw new IllegalStateException("Grafo nao eh arvore. Nao pode codificar.");
        }

        int[] centers = getCenters();
        List<String> codes = new ArrayList<>();

        for (int c : centers) {
            codes.add(encode(c, -1));
        }

        Collections.sort(codes);
        return codes.get(0);
    }

    private String encode(int root, int parent) {
        List<String> labels = new ArrayList<>();

        for (int neighbor : graph.adj(root)) {
            if (neighbor != parent) {
                labels.add(encode(neighbor, root));
            }
        }

        Collections.sort(labels);

        StringBuilder sb = new StringBuilder();
        for (String s : labels) sb.append(s);

        return "(" + sb.toString() + ")";
    }
}