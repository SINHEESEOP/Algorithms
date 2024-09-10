import sys

a = int(input())
n = []

for i in range(1,a+1):
    n.append(int(sys.stdin.readline()))

def prime_factors(n):
    is_prime = [True] * (n+1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int((n**0.5) + 1)):
        if is_prime[i]:
            for j in range(i*i, n + 1, i):
                is_prime[j] = False

    return is_prime


def prime_numbers(n):
    is_prime = prime_factors(n)
    is_prime_number = []

    for i in range(2, len(is_prime)):
        if is_prime[i]:
            is_prime_number.append(i)

    return is_prime_number


def goldbach_conjecture(n):

    prime_numbers2 = prime_numbers(n)

    prime_list = []

    for i in range(0, len(prime_numbers2)):
        for j in range(0, len(prime_numbers2)):
            if prime_numbers2[i] + prime_numbers2[j] == n:
                prime_list.append([prime_numbers2[i], prime_numbers2[j]])
                # return str(prime_numbers2[i]) + str(" ") + str(prime_numbers2[j])

    return prime_list

def last_goldbach_conjecture(n):
    gold_list = goldbach_conjecture(n)
    min_gold = max(gold_list[0]) - min(gold_list[0])
    index = 0

    for i in range(0, len(gold_list)):
        if min_gold > max(gold_list[i]) - min(gold_list[i]):
            min_gold = max(gold_list[i]) - min(gold_list[i])
            index = i

    return gold_list[index]

for i in range(0,a):
    last_gold = last_goldbach_conjecture(n[i])
    print(str(last_gold[0]) + ' ' + str(last_gold[1]))