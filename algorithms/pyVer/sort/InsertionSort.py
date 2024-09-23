
arr = [9, 8, 6, 7, 4, 3]

def inserttionSort(arr):

    for i in range(1, len(arr)):
        j = i - 1
        key = arr[i]

        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1

        arr[j + 1] = key

    return arr

print(inserttionSort(arr))