from collections import deque
import sys

dq = deque()

s = (sys.stdin.readline().rstrip())
weight = 1
result = 0

for i in range(len(s)):

    if s[i] == '(':
        dq.append(s[i])
        weight *= 2
    elif s[i] == '[':
        dq.append(s[i])
        weight *= 3
    elif s[i] == ')':

        if not dq or dq[-1] != "(":
            result = 0
            break

        if s[i-1] == "(":
            result += weight

        dq.pop()
        weight //= 2

    elif s[i] == "]":

        if not dq and dq[-1] != '[':
            result = 0
            break

        if s[i-1] == "[":
            result += weight

        dq.pop()
        weight //= 3

if dq:
    print(0)
else:
    print(result)

