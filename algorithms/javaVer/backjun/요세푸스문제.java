package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스문제 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		sb.append("<");
		while (queue.size() > 1) {

			for (int i = 0; i < k-1; i++) {
				queue.offer(queue.poll());
			}

			sb.append(queue.poll()).append(", ");
		}

		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}



}
