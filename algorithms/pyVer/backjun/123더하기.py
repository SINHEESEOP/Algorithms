
T = int(input())

n = [int(input()) for _ in range(T)]

dp = [0] * (max(n) + 1)

# dp[0] = 1
# dp[1] = 1
# if len(dp) >= 2:
#     dp[2] = 2
#
# if len(dp) >= 3:
#     for i in range(3, n[-1] + 1):
#         dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
#
# for Tn in n:
#     print(dp[Tn])

# 기본값 설정
dp[1] = 1
if len(dp) > 2:
    dp[2] = 2
if len(dp) > 3:
    dp[3] = 4

# dp 테이블 채우기
for i in range(4, max(n) + 1):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

# 각 테스트 케이스에 대한 결과 출력
for Tn in n:
    print(dp[Tn])
