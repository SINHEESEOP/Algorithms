import sys

data = []
a = 1

while a <= 9:
    data.append(int(sys.stdin.readline()))
    a += 1

max = 0
index = 0

for i in data:
    if i > max:
        max = i

print(max)
print(data.index(max) + 1)