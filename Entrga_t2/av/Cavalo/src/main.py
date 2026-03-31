from __future__ import annotations

from pathlib import Path

from bfs import BFSShortestPath
from cc import CC
from cycle import Cycle
from graph import read_algs4_graph


def coord_to_vertex(row: int, col: int, board_size: int = 3) -> int:
    return row * board_size + col


def main() -> None:
    project_root = Path(__file__).resolve().parents[1]
    input_file = project_root / "dados" / "entrada.txt"

    graph = read_algs4_graph(str(input_file))

    print("Lista de adjacencia:")
    for line in graph.adjacency_lines(descending=True):
        print(line)

    cc = CC(graph)
    print(f"Componentes conexas: {cc.count}")
    for component in range(cc.count):
        vertices = cc.vertices_in_component(component)
        print(f"Vertices da componente {component}: {' '.join(map(str, vertices))}")

    source = coord_to_vertex(0, 0)
    target = coord_to_vertex(2, 2)
    bfs = BFSShortestPath(graph, source)
    min_distance = bfs.distance_to(target)
    print(
        f"Distancia minima entre (0,0) e (2,2): {min_distance}"
    )

    cycle = Cycle(graph)
    print(f"O grafo possui ciclo: {'Sim' if cycle.has_cycle else 'Nao'}")
    if cycle.has_cycle:
        print(f"Um ciclo encontrado: {' '.join(map(str, cycle.cycle_vertices))}")

    print("Analise de complexidade:")
    print("CC (DFS): tempo O(V + E), espaco O(V)")
    print("Distancia minima (BFS): tempo O(V + E), espaco O(V)")
    print("Deteccao de ciclo (DFS): tempo O(V + E), espaco O(V)")


if __name__ == "__main__":
    main()
