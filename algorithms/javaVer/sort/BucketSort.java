package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static void bucketSort(float[] arr) {
		int n = arr.length;

		// 빈 버킷 리스트 생성
		ArrayList<Float>[] buckets = new ArrayList[n];

		// 각 버킷 초기화
		for (int i = 0; i < n; i++) {
			buckets[i] = new ArrayList<>();
		}

		// 데이터를 버킷에 분배
		for (int i = 0; i < n; i++) {
			int bucketIndex = (int) (n * arr[i]);  // 배열 원소를 버킷 인덱스로 변환
			buckets[bucketIndex].add(arr[i]);
		}

		// 각 버킷을 정렬
		for (int i = 0; i < n; i++) {
			Collections.sort(buckets[i]);  // 각 버킷 내에서 정렬
		}

		// 모든 버킷의 데이터를 하나의 배열로 합치기
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (Float num : buckets[i]) {
				arr[index++] = num;
			}
		}
	}

	public static void main(String[] args) {
		float[] arr = {0.897f, 0.565f, 0.656f, 0.123f, 0.665f, 0.343f};
		System.out.println("정렬 전 배열:");
		for (float num : arr) {
			System.out.print(num + " ");
		}

		bucketSort(arr);

		System.out.println("\n정렬 후 배열:");
		for (float num : arr) {
			System.out.print(num + " ");
		}
	}
}

