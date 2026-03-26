package src;

import java.util.*;
import java.io.*;

public class main {

    static String[] estados = {
        "AL","BA","CE","MA","PB","PE","PI","RN","SE"
    };

    public static void main(String[] args) throws Exception {

        Scanner file = new Scanner(new File("../dados/nordeste.txt"));

        int V = file.nextInt();
        Graph G = new Graph(V);

        int E = file.nextInt();

        for (int i = 0; i < E; i++) {
            int v = file.nextInt();
            int w = file.nextInt();
            G.addEdge(v, w);
        }

        file.close();

        Scanner sc = new Scanner(System.in);

        System.out.print("Estado inicial: ");
        String origem = sc.next();

        System.out.print("Estado que deseja chegar: ");
        String destino = sc.next();

        int s = indexOf(origem);
        int d = indexOf(destino);

        DepthFirstPaths dfs = new DepthFirstPaths(G, s);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        // existe caminho
        System.out.print("\nExiste caminho? ");
        if (dfs.hasPathTo(d)) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }

        // caminho DFS
        System.out.print("Caminho encontrado (DFS): ");
        printPath(dfs.pathTo(d));

        // caminho BFS
        System.out.print("Caminho encontrado (BFS): ");
        printPath(bfs.pathTo(d));

        // alcançáveis
        System.out.print("Estados alcançáveis a partir de " + origem.toUpperCase() + ": ");
        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.print(estados[v] + " ");
            }
        }

        // ordem DFS
        System.out.print("\nOrdem de visita (DFS): ");
        dfsOrdem(G, s, new boolean[G.V()]);

        // ordem BFS
        System.out.print("\nOrdem de visita (BFS): ");
        bfsOrdem(G, s);
    }

    static int indexOf(String sigla) {
        for (int i = 0; i < estados.length; i++) {
            if (estados[i].equalsIgnoreCase(sigla)) return i;
        }
        return -1;
    }

    static void printPath(Iterable<Integer> path) {

        if (path == null) {
            System.out.println("Não existe caminho");
            return;
        }

        boolean primeiro = true;

        for (int v : path) {
            if (!primeiro) {
                System.out.print(" -> ");
            }
            System.out.print(estados[v]);
            primeiro = false;
        }

        System.out.println();
    }

    static void dfsOrdem(Graph G, int v, boolean[] marked) {
        marked[v] = true;
        System.out.print(estados[v] + " ");

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfsOrdem(G, w, marked);
            }
        }
    }

    static void bfsOrdem(Graph G, int s) {
        boolean[] marked = new boolean[G.V()];
        Queue<Integer> q = new LinkedList<>();

        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(estados[v] + " ");

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }
}