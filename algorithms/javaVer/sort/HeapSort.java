package sort;

import java.util.Arrays;

public class HeapSort {
	//

	static void heapSort(int[] arr, int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			shiftDown(arr, i, size);
		}

		int temp;
		for (int i = size - 1; i >= 0; i--) {
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			shiftDown(arr, 0, i);
		}

	}

	static void shiftDown(int[] arr, int parentIdx, int size) {
		int leftChildIdx = parentIdx * 2 + 1;
		int rightChildIdx = leftChildIdx + 1;
		int maxChildIdx = -1;

		if (leftChildIdx < size) {
			maxChildIdx = leftChildIdx;
		}

		if (rightChildIdx < size && arr[leftChildIdx] < arr[rightChildIdx]) {
			maxChildIdx = rightChildIdx;
		}

		int temp;
		if (maxChildIdx != -1 && arr[maxChildIdx] > arr[parentIdx]) {
			temp = arr[parentIdx];
			arr[parentIdx] = arr[maxChildIdx];
			arr[maxChildIdx] = temp;
			shiftDown(arr, maxChildIdx, size);
		}

	}


	public static void main(String[] args) {

		int[] arr = { 6, 4, 8, 2, 5, 10, 9, 1, 3, 7 };
		System.out.println("변경 전 : " + Arrays.toString(arr));
		heapSort(arr, arr.length);
		System.out.println("변경 후 : " + Arrays.toString(arr));
	}


}
