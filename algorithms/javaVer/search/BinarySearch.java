package search;

public class BinarySearch {

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return mid;  // 값 찾음
			} else if (arr[mid] < target) {
				left = mid + 1;  // 오른쪽에서 탐색
			} else {
				right = mid - 1;  // 왼쪽에서 탐색
			}
		}

		return -1;  // 값을 찾지 못한 경우
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		int target = 13;
		int result = binarySearch(arr, target);
		System.out.println("이진 검색 결과: " + result);  // 출력: 6 (target 13의 인덱스)
	}
}

