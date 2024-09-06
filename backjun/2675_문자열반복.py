import sys
n = int(sys.stdin.readline())
data = [sys.stdin.readline().strip().split(" ") for i in range(n)]

for i in data:
    a = int(i[0])
    b = list(i[1])

    str = ""

    for j in b:
        str += j * a

    print(str)