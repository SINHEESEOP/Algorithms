from collections import deque

def dfs(graph, start):
    stack = [start]
    visited = set()

    while stack:
        node = stack.pop()
        if node not in visited:
            print(node, end=" ")
            visited.add(node)
            stack.extend(reversed(graph[node]))


def bfs(graph, start):
    dq = deque([start])