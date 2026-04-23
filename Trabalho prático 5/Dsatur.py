def dsatur(graph):
    V = graph.V

    color = [-1] * V
    saturation = [0] * V
    degrees = [graph.degree(v) for v in range(V)]

    
    first = max(range(V), key=lambda v: degrees[v])
    color[first] = 0

    order = [first]

    while -1 in color:
        for v in range(V):
            if color[v] == -1:
                neighbor_colors = set(
                    color[n] for n in graph.neighbors(v) if color[n] != -1
                )
                saturation[v] = len(neighbor_colors)

        candidates = [v for v in range(V) if color[v] == -1]

        v = max(candidates, key=lambda x: (saturation[x], degrees[x]))

        used_colors = set(color[n] for n in graph.neighbors(v) if color[n] != -1)

        c = 0
        while c in used_colors:
            c += 1

        color[v] = c
        order.append(v)

    return color, order


def is_valid_coloring(graph, color):
    for v in range(graph.V):
        for w in graph.neighbors(v):
            if color[v] == color[w]:
                return False
    return True