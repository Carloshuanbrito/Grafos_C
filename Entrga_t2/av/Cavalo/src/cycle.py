from __future__ import annotations

from graph import Graph


class Cycle:
    def __init__(self, graph: Graph) -> None:
        self._marked = [False] * graph.vertices
        self._edge_to = [-1] * graph.vertices
        self._cycle: list[int] = []

        for v in range(graph.vertices):
            if not self._marked[v] and not self._cycle:
                self._dfs(graph, v, -1)

    @property
    def has_cycle(self) -> bool:
        return bool(self._cycle)

    @property
    def cycle_vertices(self) -> list[int]:
        return self._cycle

    def _dfs(self, graph: Graph, v: int, parent: int) -> None:
        self._marked[v] = True

        for w in sorted(graph.neighbors(v), reverse=True):
            if self._cycle:
                return

            if not self._marked[w]:
                self._edge_to[w] = v
                self._dfs(graph, w, v)
            elif w != parent:
                raw_path: list[int] = []
                x = v
                while x != w and x != -1:
                    raw_path.append(x)
                    x = self._edge_to[x]
                raw_path.append(w)

                core = list(reversed(raw_path))
                normalized = self._normalize(core)
                self._cycle = normalized + [normalized[0]]
                return

    def _normalize(self, cycle_without_repeat: list[int]) -> list[int]:
        if not cycle_without_repeat:
            return []

        min_vertex = min(cycle_without_repeat)
        min_index = cycle_without_repeat.index(min_vertex)

        rotated = (
            cycle_without_repeat[min_index:] + cycle_without_repeat[:min_index]
        )

        reversed_cycle = list(reversed(cycle_without_repeat))
        rev_min_index = reversed_cycle.index(min_vertex)
        rev_rotated = reversed_cycle[rev_min_index:] + reversed_cycle[:rev_min_index]

        if rev_rotated < rotated:
            return rev_rotated
        return rotated
