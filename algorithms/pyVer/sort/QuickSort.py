

arr = [10, 9, 8, 3, 5, 6, 7, 2, 4]

def quick_sort(arr, left, right):
    pl = left
    pr = right
    pivot = arr[(left + right) // 2]

    while arr[pl] < pivot:
        pl += 1

    while arr[pr] > pivot:
        pr -= 1

    if pl <= pr:
        temp = arr[pl]
        arr[pl] = arr[pr]
        arr[pr] = temp
        pr -= 1
        pl += 1

    if left < pr:
        quick_sort(arr, left, pr)

    if pl < right:
        quick_sort(arr, pl, right)

    return arr

print(quick_sort(arr, 0, len(arr) -1))