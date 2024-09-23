from collections import deque

snake = deque()

# 오 아 왼 위
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def IsCollision(snake, nx, ny):
    for body in snake:
        if nx == body[0] and ny == body[1]:
            return True
    return False




def simulate(N, board, turns):
    snake.append([0, 0])

    x, y = 0, 0
    direction = 0
    time = 0


    while True:
        time += 1

        ny = y + dy[direction]
        nx = x + dx[direction]

        if nx < 0 or nx >= N or ny < 0 or ny >= N or IsCollision(snake, nx, ny):
            return time

        snake.append([ny, nx])

        if board[ny][nx] == 1:
            board[ny][nx] = 0
        else:
            snake.pop()

        if turns.__contains__(time):
            if turns.get(time) == 'L':
                direction = (direction + 3) % 4
            if turns.get(time) == 'D':
                direction = (direction + 1) % 4

        x = nx
        y = ny


if __name__ == '__main__':
    N = int(input())
    K = int(input())

    board = [[0 for _ in range(N)] for _ in range(N)]

    for i in range(K):
        col, row = map(int, input().split())
        board[col - 1][row - 1] = 1

    L = int(input())
    turns = {}

    for i in range(L):
        time, direction = input().split()
        turns[int(time)] = direction

    print(simulate(N, board, turns))