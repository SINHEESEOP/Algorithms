import sys

input = list(map(int, sys.stdin.readline().strip().split()))

n = input[0]
k = input[1]

dp = [0] * (k + 1)
dp2 = [0] * (k + 1)

for i in range(n):
    w, v = map(int, sys.stdin.readline().strip().split())
    dp[w] = v


for i in range(len(dp) + 1):
    for j in range(0, i + 1):
        if i + j < len(dp):
            if dp2[i + j] < dp[i] + dp[j]:
                dp2[i + j] = dp[i] + dp[j]

print(dp)
print(dp2)