from collections import deque


def DFS(graph,start):
    visited = set()
    stack = [start]

    while stack:
        node = stack.pop()
        if node not in visited:
            print(node, end=' ')
            visited.add(node)
            stack.extend(reversed(graph[node]))


def BFS(graph, start):
    visited = set()
    dq = deque([start])

    while dq:
        node = dq.popleft()
        if node not in visited:
            print(node, end=' ')
            visited.add(node)
            dq.extend(graph[node])


def graph_search(graph, start, data_structure):
    visited = []
    data_structure.append(start)

    while data_structure:
        node = data_structure.pop()
        if node not in visited:
            visited.append(node)
            for w in graph[node]:
                data_structure.append(w)

    return visited