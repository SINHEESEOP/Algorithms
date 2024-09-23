package sort;

import java.util.Arrays;

public class SelectionSort {

	int[] sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}


			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

}

class Main2 {
	public static void main(String[] args) {

		SelectionSort selectionSort = new SelectionSort();

		int[] arr = { 9, 8, 6, 7, 4, 3};

		System.out.println(Arrays.toString(selectionSort.sort(arr)));

	}

}
