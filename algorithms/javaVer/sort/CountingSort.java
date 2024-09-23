package sort;

public class CountingSort {
	public static void countingSort(int[] arr) {
		// 배열에서 최대값 찾기
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// 카운트 배열 초기화 (0 ~ max 값까지)
		int[] count = new int[max + 1];

		// 각 요소의 빈도수 카운트
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

//		int[] arr = {4, 2, 2, 8, 3, 3, 1};

		// 정렬된 배열 생성
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				arr[index++] = i;
				count[i]--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 2, 2, 8, 3, 3, 1};
		System.out.println("정렬 전 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}

		countingSort(arr);

		System.out.println("\n정렬 후 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}

