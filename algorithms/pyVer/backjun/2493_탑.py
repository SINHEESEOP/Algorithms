import sys
from collections import deque

stack = []
chk = []
list = []

n = int(sys.stdin.readline())
tower = sys.stdin.readline().strip().split(" ")

print(tower)

for i in range(n):
    num = tower[i]
    while stack:
        if num > stack[-1]:
            stack.pop()
            chk.pop()
        else:
            list.append(chk[-1])
            break

    if not stack: list.append(0);
    stack.append(num)
    chk.append(i + 1)

print(list)