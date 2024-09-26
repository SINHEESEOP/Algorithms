import sys

n = int(input())

arr = [[] * n]

for i in range(n):
    for j in range(n):
        arr[i][j] = int(input())


print(arr)