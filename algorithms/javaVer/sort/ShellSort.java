package sort;

public class ShellSort {

	// 셸 정렬 구현
	public static void shellSort(int[] arr) {
		int n = arr.length;

		// Knuth Sequence로 초기 간격 설정 (h = 3*h + 1)
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;  // 1, 4, 13, 40, 121, ...
			System.out.println("h in = " + h);
		}
		System.out.println("h out = " + h);
		// 간격 h를 점점 줄이면서 정렬
		while (h >= 1) {
			// h 간격으로 삽입 정렬 수행
			for (int i = h; i < n; i++) {
				int temp = arr[i];
				int j = i;

				// arr[j - h]가 temp보다 크면 j에서 h만큼 간격을 뒤로 밀고 temp 삽입
				// j >= h 이 부분은 필요 없지만 혹시 모를 예외를 위해 만든 안전장치다.
				// 즉 쉘코드 내부에서는 예외가 발생할 일이 없지만 외부에서의 문제로
				// 예외가 생길 경우를 대비해 넣어두는 방어적인 코드 기법이다...(하..)
				while (j >= h && arr[j - h] > temp) {
					arr[j] = arr[j - h];
					j -= h;
				}

				arr[j] = temp;
			}
			h = h / 3;  // 간격을 줄임
		}
	}

	// 메인 함수에서 셸 정렬 실행
	public static void main(String[] args) {
		int[] arr = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};

		System.out.println("정렬 전 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		shellSort(arr);  // 셸 정렬 실행

		System.out.println("정렬 후 배열:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
