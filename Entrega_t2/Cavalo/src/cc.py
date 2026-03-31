from __future__ import annotations

from graph import Graph


class CC:
    def __init__(self, graph: Graph) -> None:
        self._marked = [False] * graph.vertices
        self._id = [-1] * graph.vertices
        self._count = 0

        for v in range(graph.vertices):
            if not self._marked[v]:
                self._dfs(graph, v)
                self._count += 1

    @property
    def count(self) -> int:
        return self._count

    def component_id(self, v: int) -> int:
        return self._id[v]

    def vertices_in_component(self, component: int) -> list[int]:
        return [v for v, cid in enumerate(self._id) if cid == component]

    def _dfs(self, graph: Graph, source: int) -> None:
        stack = [source]
        self._marked[source] = True

        while stack:
            v = stack.pop()
            self._id[v] = self._count
            for w in sorted(graph.neighbors(v), reverse=True):
                if not self._marked[w]:
                    self._marked[w] = True
                    stack.append(w)
