package sort;

import java.util.Arrays;

public class InsertionSort {


	// 삽입 정렬 함수
	static int[] insertionSort(int[] arr) {
		// 배열의 두 번째 요소부터 시작
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];  // 정렬할 값 (삽입할 값)
			int j = i - 1;

			// key보다 작은 값을 만나면 멈추고 그 앞까지 이동
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];  // 한 칸씩 오른쪽으로 이동
				j--;
			}

			// 빈 자리에 key 삽입
			arr[j + 1] = key;
		}

		return arr;
	}


	public static void main(String[] args) {


		System.out.println(
				Arrays.toString(
						insertionSort( new int[] {9, 8, 6, 7, 4, 3}) ));

	}

}


