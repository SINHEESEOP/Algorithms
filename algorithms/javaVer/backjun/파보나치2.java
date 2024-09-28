package backjun;

import java.util.HashMap;
import java.util.Map;

public class 파보나치2 {

	static HashMap<Integer,Integer> memo = new HashMap<>();

	private static int fibonacciTop(int n) {
		if (n <= 1) return n;

		if (memo.containsKey(n)) return memo.get(n);

		int result =  fibonacciTop(n - 1) + fibonacciTop(n - 2);
		memo.put(n, result);

		return result;
	}


	private static int fibonacciBottom(int n) {
		if (n <= 1) return n;

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(fibonacciTop(10));
	}

}
