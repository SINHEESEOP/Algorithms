package sort;

import java.util.Arrays;

public class BubbleSort {

	int[] bubbleSort(int[] intArray) {

		int temp = 0;
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray.length - i - 1; j++) {
				if (intArray[j] > intArray[j + 1]) {
					temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
		}
		return intArray;
	}
}

class Main {
	public static void main(String[] args) {

		int[] intArray = {4, 2, 1, 4, 3, 9, 7, 8, 6, 10};

		BubbleSort bubbleSort = new BubbleSort();

		System.out.println(Arrays.toString(bubbleSort.bubbleSort(intArray)));

	}
}