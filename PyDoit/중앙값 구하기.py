

def med3(a, b, c):
    if (b >= a and c <= a ) or (b <= a and c >= a):
        return "a"
    elif (a > b and c < b) or (a < b and c > b):
        return "b"
    pass

print(med3(2,3,3))