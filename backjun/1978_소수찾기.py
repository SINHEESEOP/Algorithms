import sys

a = int(sys.stdin.readline())
data = list(map(int,sys.stdin.readline().split()))

def sieve_of_eratosthenes(max_num):
    is_prime = [True] * (max_num + 1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(max_num**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, max_num + 1, i):
                is_prime[j] = False

    return is_prime


def count_primes_in_list(data):
    if not data:
        return 0

    max_num = max(data)
    is_prime = sieve_of_eratosthenes(max_num)

    prime_count = sum(1 for num in data if is_prime[num])
    return prime_count


# 소수의 개수를 구함
prime_count = count_primes_in_list(data)
print(prime_count)


# 다시 풀어보기 ------------------------------------------------------------------------------




















