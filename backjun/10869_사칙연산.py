from os.path import split

a = input()

a,b = a.split(' ')
print(int(a) + int(b))
print(int(a) - int(b))
print(int(a) * int(b))
print(int(a) // int(b))
print(int(a) % int(b))

# print(a+b)
# print(a-b)
# print(a*b)
# print(a//b)
# print(a%b)