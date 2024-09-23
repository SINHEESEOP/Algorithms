package backjun;

// 1110

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int sum(int a, int b) {


		String check = "";

		if (b == -1) {
			check = (a + b) + "";
		} else {
			check = a + "" + b;
		}


		String sum2 = "";
		int sum = 0;
		int count = 0;
		String temp = "";

		if (a == 0) {
			return 1;
		}

		while (true) {

			sum = a + b;
			sum2 = a + "" + b;
			a = b;
			if (check.equals(sum2) && count >= 1) break;
//			if (count == 0) check = sum2;

			temp = sum + "";
			if (temp.length() == 2 && temp.charAt(1) != '0') {
				b = Integer.parseInt(String.valueOf(temp.charAt(1)));
			} else {
				b = sum;
			}
			count++;
		}

		return count;
	}

	public static int sum2(int a, int b) {

		String check = a + "" + b;

		String sum2 = "";
		int sum = 0;
		int count = 0;
		String temp = "";

		if (a == 0) {
			return 1;
		}

		while (true) {

			sum = a + b;
			sum2 = sum + "";
			a = b;
			if (check.equals(sum2) && count >= 1) break;
//			if (count == 0) check = sum2;

			temp = sum + "";
			if (temp.length() == 2 && temp.charAt(1) != '0') {
				b = Integer.parseInt(String.valueOf(temp.charAt(1)));
			} else {
				b = sum;
			}
			count++;
		}

		return count;
	}


	public static void main(String[] args) throws IOException {

		String[] input = br.readLine().split("");
		int a = Integer.parseInt(input[0]);
		int b = 0;

		if (input.length == 1) {
			a = Integer.parseInt(input[0]);
			b = -1;
		}
		if (input.length == 2) {
			b = Integer.parseInt(input[1]);
		}

		if (b == 0 && input.length == 2) {
			System.out.println(sum2(a, b));
		} else {
			System.out.println(sum(a, b));
		}

	}

}
