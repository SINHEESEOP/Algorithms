import sys
from collections import deque


def edge_add(node1, node2, in_degree):
    graph[node1].append(node2)
    in_degree[node2] += 1


if __name__ == "__main__":

    read = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    node_n = read[0]
    edge_m = read[1]

    in_degree = [0] * (node_n + 1)
    graph = [[0] for _ in range(node_n + 1)]

    dq = deque()
    result_list = []

    for i in range(edge_m):
        read = list(map(int, sys.stdin.readline().rstrip().split(" ")))
        edge_add(read[0], read[1], in_degree)


    for i in range(1, node_n + 1):
        if in_degree[i] == 0:
            dq.append(i)

    while dq:
        current = dq.popleft()
        result_list.append(current)

        for next in graph[current]:
            in_degree[next] -= 1
            if in_degree[next] == 0:
                dq.append(next)

    result = ' '.join(map(str, result_list))
    print(result)
