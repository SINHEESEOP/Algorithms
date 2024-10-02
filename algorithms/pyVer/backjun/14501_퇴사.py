from sys import stdin
input = stdin.readline

# n = int(input())
# arr = [[0, 0]]
# for _ in range(n):
#     arr.append(list(map(int, input().split())))
#
# dp = [0 for _ in range(n+1)]
#
# for i in range(n+1): # 상담에 필요한 기간이 퇴사날을 벗어나는 경우 제거
#     if i + arr[i][0] > n+1:
#         arr[i][1] = 0
#
# for i in range(n): # dp를 이용해 각 날짜의 최댓값을 구하기
#     for j in range(i+arr[i][0], n+1):
#         if dp[j] < dp[i] + arr[j][1]:
#             dp[j] = dp[i] + arr[j][1]
#
# print(max(dp)) # dp의 최댓값 -> 최대비용


# n = int(input())
# arr = [[0, 0]]
# for _ in range(n):
#     arr.append(list(map(int, input().split())))
#
# dp = [0 for _ in range(n+1)]
#
# for i in range(n):  # 상담에 필요한 기간이 퇴사일을 넘지 않는 경우에만 처리
#     if i + arr[i][0] <= n:  # 상담이 가능한 경우에만 dp 갱신
#         for j in range(i + arr[i][0], n + 1):
#             dp[j] = max(dp[j], dp[i] + arr[i][1])
#
# print(max(dp))

# 그나마 내가 할 수 있는 최적화 ver
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]  # 0-based index로 저장

dp = [0] * (n + 1)

for i in range(n):
    # 상담이 끝나는 날이 퇴사일을 넘지 않는 경우에만 처리
    if i + arr[i][0] <= n:
        dp[i + arr[i][0]] = max(dp[i + arr[i][0]], dp[i] + arr[i][1])
    dp[i + 1] = max(dp[i + 1], dp[i])  # 다음 날의 최대값 유지

print(dp[n])


# 최적화 ver
# from sys import stdin
# input = stdin.readline
#
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * (n + 1)

for i in range(n):
    t, p = arr[i]  # 미리 값을 변수에 저장하여 메모리 접근 줄이기
    if i + t <= n:
        dp[i + t] = max(dp[i + t], dp[i] + p)
    dp[i + 1] = max(dp[i + 1], dp[i])

print(dp[n])
