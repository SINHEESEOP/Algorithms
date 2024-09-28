package backjun;

import java.util.Scanner;

public class 동전문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			// 동전 종류 개수 입력
			int N = sc.nextInt();

			// 동전 종류 입력
			int[] coins = new int[N];
			for (int i = 0; i < N; i++) {
				coins[i] = sc.nextInt();
			}

			// 목표 금액 입력
			int M = sc.nextInt();

			// 로직
			coinsCnt(coins, M);

		}

	}

	private static int coinsCnt(int[] coins, int M) {
		int cnt = 0;

		while (M <= 0) {

			if ( M % coins[0] != 0 && M % coins[1] != 0) {
				M = M / coins[0];
			}


			if ( M % coins[1] == 0 ) {
				cnt++;
			}

			M = M - coins[0];

		}


		return cnt;
	}


}