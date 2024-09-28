
def coin_counter(money, coins):
    # DP 배열 생성, money+1 크기로 0으로 초기화
    dp = [0] * (money + 1)
    # 기본 경우: 금액이 0일 경우 방법은 1가지 (동전을 하나도 사용하지 않는 방법)
    dp[0] = 1

    # 각 동전에 대해 경우의 수 계산
    for coin in coins:
        for i in range(coin, money + 1):
            dp[i] += dp[i - coin]

    return dp[money]


if __name__ == '__main__':
    import sys
    n = list(map(int, sys.stdin.readline().rstrip().split()))

    coins = [0] * n[0]
    money = n[1]

    for i in range(n[0]):
        coins[i] = int(input())

    print(coin_counter(money, coins))
