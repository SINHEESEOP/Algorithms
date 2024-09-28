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