import sys

sys.setrecursionlimit(100000)

def coin_counter(money, coins, idx, memo):

    if (money, idx) in memo:
        return memo[(money, idx)]
    if money == 0:
        return 1
    if money < 0 or idx == len(coins):
        return 0
    result = coin_counter(money, coins, idx + 1, memo) + coin_counter(money - coins[idx], coins, idx, memo)
    memo[(money, idx)] = result

    return result


if __name__ == '__main__':
    # 입력받기
    t = int(sys.stdin.readline().strip())  # 테스트 케이스의 수

    for _ in range(t):
        n = int(sys.stdin.readline().strip())  # 동전의 종류 수
        coins = list(map(int, sys.stdin.readline().strip().split()))  # 동전 종류
        money = int(sys.stdin.readline().strip())  # 목표 금액

        memo = {}

        idx = 0
        print(coin_counter(money, coins, idx, memo))

