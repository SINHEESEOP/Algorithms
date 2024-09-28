package backjun;

import java.util.Scanner;

public class 영일타일 {


//	1 , 2, 3, 5, 8

	static int fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}

		int[] memo = new int[n + 1];
		memo[1] = 1;
		memo[2] = 2;

		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 15746;
		}

		return memo[n];
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
	}

}
