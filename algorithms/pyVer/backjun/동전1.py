import sys
import psutil

# sys.stdin = open("input.txt","r")
sys.setrecursionlimit(100000)
# 실패했음

def memory_usage(message: str = 'debug'):
    # 현재 램 사용량
    p = psutil.Process()
    rss = p.memory_info().rss / 2 ** 20 # Bytes to MB
    print(f"[{message}] memory usage: {rss: 10.5f} MB")
    return


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
    n = list(map(int, sys.stdin.readline().rstrip().split()))

    coins = [0] * n[0]
    money = n[1]

    for i in range(n[0]):
        coins[i] = int(input())

    # Initialize memoization dictionary
    memo = {}

    idx = 0
    print(coin_counter(money, coins, idx, memo))
    print(memo)
    memory_usage('#1')