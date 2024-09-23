package sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void quickSort_PyVer(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = arr[(left + right) / 2];

		while (arr[pl] < pivot) {
			pl += 1;
		}

		while (arr[pr] > pivot) {
			pr -= 1;
		}

		if (pl <= pr) {
			swap(arr, pl, pr);
			pl += 1;
			pr -= 1;
		}

		if (left < pr) {
			quickSort_PyVer(arr, left, pr);
		}

		if (right > pl) {
			quickSort_PyVer(arr, pl, right);
		}
	}

	// 퀵정렬 메소드
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			// 피벗 인덱스를 중앙값으로 설정
			int pivotIndex = left + (right - left) / 2;
			int pivotNewIndex = partition(arr, left, right, pivotIndex);

			// 피벗을 기준으로 왼쪽과 오른쪽 부분 배열을 각각 정렬
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}
	}

	// 배열을 피벗 기준으로 나누는 메소드
	public static int partition(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		// 피벗을 오른쪽 끝으로 이동
		swap(arr, pivotIndex, right);
		int storeIndex = left;

		// 피벗보다 작은 값들은 왼쪽으로, 큰 값들은 오른쪽으로 이동
		for (int i = left; i < right; i++) {
			if (arr[i] < pivotValue) {
				swap(arr, i, storeIndex);
				storeIndex++; // ㅇ기부터 이해하면됨.
			}
		}

		// 피벗을 최종 위치에 놓기
		swap(arr, storeIndex, right);
		return storeIndex;
	}

	// 두 배열 요소를 교환하는 메소드
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// 테스트 메인 메소드
	public static void main(String[] args) {
//		int[] arr = {34, 7, 23, 32, 5, 62, 32, 4, 1};
//		System.out.println("정렬 전: " + Arrays.toString(arr));
//
//		quickSort(arr, 0, arr.length - 1);
//
//		System.out.println("정렬 후: " + Arrays.toString(arr));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort_PyVer(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
