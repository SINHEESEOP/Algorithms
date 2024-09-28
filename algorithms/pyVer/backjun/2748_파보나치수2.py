
n = int(input())


def fibonacci_top(n):
    memo = {}

    if n <= 1:
        return n

    if n in memo:
        return memo[n]

    result = fibonacci_top(n-1) + fibonacci_top(n-2)
    memo[n] = result

    return result


def fibonacci_bottom(n):
    if n <= 1:
        return n

    memo = [0] * (n + 1)
    memo[0], memo[1], memo[2] = 0, 1, 1

    for i in range(3, n + 1):
        memo[i] = memo[i - 1] + memo[i - 2]

    return memo[n]


print(fibonacci_bottom(n))
print(fibonacci_top(n))

