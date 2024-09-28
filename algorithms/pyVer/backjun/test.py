def coin_counter(money, coins):
    # DP 배열 생성, (동전 종류 수 + 1) x (money + 1) 크기로 0으로 초기화
    n = len(coins)
    dp = [[0] * (money + 1) for _ in range(n + 1)]

    # 기본 경우: 금액이 0일 경우 방법은 1가지 (동전을 하나도 사용하지 않는 경우)
    for i in range(n + 1):
        dp[i][0] = 1

    # 각 동전에 대해 경우의 수 계산
    for i in range(1, n + 1):
        for j in range(1, money + 1):
            # 이전 동전을 사용할 수 있는 경우
            dp[i][j] = dp[i-1][j]
            # 현재 동전을 사용하는 경우
            if j - coins[i-1] >= 0:
                dp[i][j] += dp[i][j - coins[i-1]]


    print(dp)
    return dp[n][money]

if __name__ == '__main__':
    import sys
    n = list(map(int, sys.stdin.readline().rstrip().split()))

    coins = [0] * n[0]
    money = n[1]

    for i in range(n[0]):
        coins[i] = int(input())

    print(coin_counter(money, coins))
