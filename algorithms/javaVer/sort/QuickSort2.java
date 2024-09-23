package sort;

import java.util.Scanner;
import java.util.Random;

public class QuickSort2 {

	private static Random random = new Random();

	public static void quickSort(int[] arr, int left, int right) {

		if (left < right) {
			// 랜덤으로 피벗 선택
			int pivotIndex = left + random.nextInt(right - left + 1);
			int pivotNewIndex = partition(arr, left, right, pivotIndex);

			// 피벗을 기준으로 분할하여 정렬
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}
	}

	public static int partition(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		swap(arr, pivotIndex, right);
		int storeIndex = left;

		for (int i = left; i < right; i++) {
			if (arr[i] < pivotValue) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}

		swap(arr, storeIndex, right);
		return storeIndex;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		quickSort(arr, 0, arr.length - 1);

		for (int num : arr) {
			System.out.println(num);
		}
	}
}
