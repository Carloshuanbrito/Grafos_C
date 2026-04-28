import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

    public static void printGraph(Graph g) {
        for (int v = 0; v < g.V(); v++) {
            System.out.print(v + ": ");
            for (int w : g.adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Uso: java Main arquivo1.txt arquivo2.txt");
            return;
        }

        Graph g1;
        Graph g2;

        try {
            g1 = new Graph(new in(args[0]));
            g2 = new Graph(new in(args[1]));
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Erro ao ler os arquivos de entrada: " + e.getMessage());
            return;
        }

        System.out.println("=== Arvore 1 ===");
        printGraph(g1);

        System.out.println("\n=== Arvore 2 ===");
        printGraph(g2);

        TreeIsomorphism t1 = new TreeIsomorphism(g1);
        TreeIsomorphism t2 = new TreeIsomorphism(g2);

        boolean v1 = t1.isTree();
        boolean v2 = t2.isTree();

        System.out.println("\nValidacao:");
        System.out.println("Arvore 1: " + t1.getValidationMessage());
        System.out.println("Arvore 2: " + t2.getValidationMessage());

        if (!v1 || !v2) {
            System.out.println("\nUma das entradas nao representa uma arvore.");
            return;
        }

        System.out.println("\nCentros:");
        System.out.println("Arvore 1: " + Arrays.toString(t1.getCenters()));
        System.out.println("Arvore 2: " + Arrays.toString(t2.getCenters()));

        String c1 = t1.getCanonicalEncoding();
        String c2 = t2.getCanonicalEncoding();

        System.out.println("\nCodificacao canonica:");
        System.out.println("Arvore 1: " + c1);
        System.out.println("Arvore 2: " + c2);

        System.out.println("\nResultado:");
        if (c1.equals(c2)) {
            System.out.println("As arvores sao isomorfas");
        } else {
            System.out.println("As arvores NAO sao isomorfas");
        }
    }
}
