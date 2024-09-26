import sys

n, m = tuple(map(int, sys.stdin.readline().strip().split(' ')))
data = [sys.stdin.readline().strip() for _ in range(n)]
visited = [[False] * m for _ in range(n)]
direction = {
    '-': [0, 1],
    '|': [1, 0]
}

result = 0

def check(y, x):
    return 0 <= y and y < n and 0 <= x and x < m


for y in range(n):
    for x in range(m):
        if visited[y][x]:
            continue

        visited[y][x] = True
        result += 1
        i = 1

        while True:
            dy, dx = direction[data[y][x]]
            ny, nx = y + (dy * i), x + (dx * i)
            if not check(ny, nx):
                break
            if data[y][x] != data[ny][nx]:
                break
            visited[ny][nx] = True
            i += 1

print(result)