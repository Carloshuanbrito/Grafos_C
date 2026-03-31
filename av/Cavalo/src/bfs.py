from __future__ import annotations

from collections import deque

from graph import Graph


class BFSShortestPath:
    def __init__(self, graph: Graph, source: int) -> None:
        self._source = source
        self._dist_to = [-1] * graph.vertices
        self._edge_to = [-1] * graph.vertices
        self._bfs(graph, source)

    def distance_to(self, v: int) -> int:
        return self._dist_to[v]

    def path_to(self, v: int) -> list[int]:
        if self._dist_to[v] == -1:
            return []

        path: list[int] = []
        current = v
        while current != self._source:
            path.append(current)
            current = self._edge_to[current]
        path.append(self._source)
        path.reverse()
        return path

    def _bfs(self, graph: Graph, source: int) -> None:
        queue: deque[int] = deque([source])
        self._dist_to[source] = 0

        while queue:
            v = queue.popleft()
            for w in sorted(graph.neighbors(v), reverse=True):
                if self._dist_to[w] == -1:
                    self._dist_to[w] = self._dist_to[v] + 1
                    self._edge_to[w] = v
                    queue.append(w)
