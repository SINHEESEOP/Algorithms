package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> chk = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			while (! stack.isEmpty()) {
				if (num > stack.peek() ) {
					stack.pop();
					chk.pop();
				}
				else {
					sb.append(chk.peek()).append(" ");
					break;
				}
			}

			if (stack.isEmpty()) sb.append(0).append(" ");
			stack.push(num);
			chk.push(i + 1);
		}
		System.out.println(sb);
	}

}