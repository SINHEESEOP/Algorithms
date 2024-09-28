import sys

a = sys.stdin.readline().strip()
b = sys.stdin.readline().strip()

dp = [[0 for _ in range(len(b) + 1)] for _ in range(len(a) + 1)]

la, lb = len(a), len(b)

for i in range(1, la + 1):
    for j in range(1, lb + 1):

        if a[i - 1] == b[j - 1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[la][lb])