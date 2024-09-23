package backjun;

import java.io.*;

public class 수정렬2 {
	public static void main(String[] args) throws IOException {
		// 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 숫자의 개수 N 입력
		int N = Integer.parseInt(br.readLine());

		// 카운트 배열 생성 (1부터 1,000,000까지)
		int[] count = new int[1000001]; // 각 수의 빈도수를 저장

		// N개의 숫자 입력 및 카운트 배열 갱신
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			count[number]++;
		}

		// 카운트 배열을 순회하며 정렬된 결과 출력
		for (int i = 1; i < count.length; i++) {
			while (count[i] > 0) {
				bw.write(i + "\n");
				count[i]--;
			}
		}

		// BufferedWriter를 닫기 전에 남아있는 데이터를 출력
		bw.flush();
		bw.close();
		br.close();
	}
}