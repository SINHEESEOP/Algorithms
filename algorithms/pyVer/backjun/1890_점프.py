
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[0]*n for _ in range(n)]
dp[0][0] = 1

for i in range(n):

    for j in range(n):

        k = board[i][j] # 이동할 칸수

        if dp[0][0] == 0 or k == 0: #이동할 칸수가 0이거나, 애초에 루트가 아닌 곳은 건너뜀.
            continue

        if j + k < n: # 오른쪽으로 이동하는 경우
            dp[i][j + k] += dp[i][j]

        if i + k < n: # 아래로 이동하는 경우
            dp[i + k][j] += dp[i][j]

print(dp[-1][-1])
