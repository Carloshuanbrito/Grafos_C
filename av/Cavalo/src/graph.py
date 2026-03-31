from __future__ import annotations

from dataclasses import dataclass, field


@dataclass
class Graph:
    vertices: int
    adj: list[list[int]] = field(init=False)
    edges: int = 0

    def __post_init__(self) -> None:
        self.adj = [[] for _ in range(self.vertices)]

    def add_edge(self, v: int, w: int) -> None:
        self._validate_vertex(v)
        self._validate_vertex(w)
        self.adj[v].append(w)
        self.adj[w].append(v)
        self.edges += 1

    def neighbors(self, v: int) -> list[int]:
        self._validate_vertex(v)
        return self.adj[v]

    def adjacency_lines(self, descending: bool = True) -> list[str]:
        lines: list[str] = []
        for v in range(self.vertices):
            neighbors = sorted(self.adj[v], reverse=descending)
            if neighbors:
                lines.append(f"{v}: {' '.join(map(str, neighbors))}")
            else:
                lines.append(f"{v}:")
        return lines

    def _validate_vertex(self, v: int) -> None:
        if v < 0 or v >= self.vertices:
            raise ValueError(f"Vertice invalido: {v}")


def read_algs4_graph(file_path: str) -> Graph:
    with open(file_path, "r", encoding="utf-8") as f:
        non_empty = [line.strip() for line in f if line.strip()]

    if len(non_empty) < 2:
        raise ValueError("Arquivo de entrada invalido: faltam V e E")

    v_count = int(non_empty[0])
    e_count = int(non_empty[1])

    if len(non_empty) != 2 + e_count:
        raise ValueError("Arquivo de entrada invalido: quantidade de arestas difere de E")

    graph = Graph(v_count)
    for idx in range(2, 2 + e_count):
        v_str, w_str = non_empty[idx].split()
        graph.add_edge(int(v_str), int(w_str))

    return graph
