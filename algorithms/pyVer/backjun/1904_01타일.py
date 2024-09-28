

def fibonacci(n):
    if (n <= 1):
        return 1

    memo = [0] * (n + 1)
    memo[1] = 1
    memo[2] = 2

    for i in range(3, n + 1):
        memo[i] = (memo[i - 1] + memo[i - 2]) % 15746

    return memo[n]

if __name__ == "__main__":
    n = int(input())
    print(fibonacci(n))