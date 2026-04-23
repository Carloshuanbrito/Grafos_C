import sys
from graph import Graph
from dsatur import dsatur, is_valid_coloring

states = [
    "AC","AL","AM","AP","BA","CE","DF","ES","GO","MA",
    "MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN",
    "RO","RR","RS","SC","SE","SP","TO"
]


def read_graph(file_path):
    with open(file_path, 'r') as f:
        V = int(f.readline())
        E = int(f.readline())

        g = Graph(V)

        for _ in range(E):
            v, w = map(int, f.readline().split())
            g.add_edge(v, w)

    return g


def main():
    if len(sys.argv) < 2:
        print("Uso: python main.py brasil.txt")
        return

    file_path = sys.argv[1]
    graph = read_graph(file_path)

    print("Lista de adjacência:")
    for v in range(graph.V):
        print(f"{states[v]}: {[states[w] for w in graph.neighbors(v)]}")

    color, order = dsatur(graph)

    print("\nOrdem de coloração:")
    print([states[v] for v in order])

    print("\nCores atribuídas:")
    for v in range(graph.V):
        print(f"{states[v]} -> Cor {color[v]}")

    total_colors = max(color) + 1
    print(f"\nTotal de cores usadas: {total_colors}")

    print("Coloração válida?", is_valid_coloring(graph, color))


if __name__ == "__main__":
    main()