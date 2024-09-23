import sys
from collections import deque

def dfs(node):
    stack = []
    strArr = []

    stack.append(node)
    visited[node] = True
    strArr.append(node)

    while stack:
        flag = False
        check_node = stack[-1]

        for i in edge[check_node]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)
                strArr.append(i)
                flag = True
                break

        if not flag:
            stack.pop()

    result = ' '.join(map(str, strArr))
    print(result)

def bfs(node):
    dq = deque()
    strArr = []

    dq.append(node)
    visited[node] = True
    strArr.append(node)

    while dq:
        check_node = dq.popleft()

        for i in edge[check_node]:
            if not visited[i]:
                visited[i] = True
                dq.append(i)
                strArr.append(i)


    result = ' '.join(map(str, strArr))
    print(result)


if __name__ == "__main__":
    input = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    print()

    edge = [[] for _ in range(input[0] + 1)]
    visited = [False] * (input[0] + 1)


    for i in range(input[1]):
        input2 = list(map(int, sys.stdin.readline().rstrip().split(" ")))
        edge[input2[0]].append(input2[1])
        edge[input2[1]].append(input2[0])


    visited = [False] * (input[0] + 1)
    dfs(input[2])

    print()

    visited = [False] * (input[0] + 1)
    bfs(input[2])
