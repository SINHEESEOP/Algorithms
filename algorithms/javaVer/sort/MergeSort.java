package sort;

public class MergeSort {

	// 병합 정렬 함수
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			// 중간 지점 계산

//			수학적으로 증명:
//			두 값의 중간 지점은 **(left + right) / 2**로 계산됩니다.
//
//			left + (right - left) / 2로 계산하는 방법은 이와 동일하게 작동합니다.
//
//			right - left는 두 값의 차이를 구합니다.
//			(right - left) / 2는 그 차이의 절반을 구합니다.
//					left에 그 절반 값을 더하면, 결국 중간 지점을 얻을 수 있습니다.

//			int middle = (left + right) / 2;
			int middle = left + (right - left) / 2;

			// 왼쪽 부분 정렬
			mergeSort(arr, left, middle);

			// 오른쪽 부분 정렬
			mergeSort(arr, middle + 1, right);

			// 정렬된 두 부분 병합
			merge(arr, left, middle, right);
		}
	}

	// 병합 함수 (두 개의 부분 배열을 병합)
	public static void merge(int[] arr, int left, int middle, int right) {
		// 두 부분 배열의 크기 계산
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// 임시 배열 생성
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		// 왼쪽과 오른쪽 배열에 데이터 복사
		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = arr[middle + 1 + j];
		}

		// 임시 배열을 병합하여 원본 배열에 다시 저장
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// 왼쪽 배열에 남은 요소 복사
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		// 오른쪽 배열에 남은 요소 복사
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};

		System.out.println("정렬 전 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		mergeSort(arr, 0, arr.length - 1);

		System.out.println("정렬 후 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}

