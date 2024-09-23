
arr = [int(input()) for i in range(0, int(input()))]

def bubblesort(arr):

    temp = 0;

    for i in range(0, len(arr)):
        for j in range(0, len(arr) - i - 1):
            if (arr[j] > arr[j+1]):
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
    return arr

arr = bubblesort(arr)

for i in arr:
    print(i)