

arr = [9, 8, 6, 7, 4, 3]

def selectionSort(arr):
    for i in range(0, len(arr) - 1):
        minIndex = i
        for j in range(0 + i + 1, len(arr)):
            if arr[j] < arr[minIndex]:
                minIndex = j

        temp = arr[minIndex]
        arr[minIndex] = arr[i]
        arr[i] = temp
    return arr

print(selectionSort(arr))