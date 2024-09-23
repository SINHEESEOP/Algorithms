package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐2 {

	static int[] queue;
	static int capacity = 2000000;  // 큐의 최대 크기 설정
	static int front = 0;
	static int rear = 0;
	static int num = 0;

	static void push(int x) {
		queue[rear++] = x;
		num++;

		if (rear == capacity) {
			rear = 0;
		}
	}

	static int pop() {
		if (num == 0) {
			return -1;
		}

		int x = queue[front++];
		num--;

		if (front == capacity) {
			front = 0;
		}

		return x;
	}

	static int size() {
		return num;
	}

	static int empty() {
		return num == 0 ? 1 : 0;
	}

	static int front() {
		if (num == 0) {
			return -1;
		}
		return queue[front];
	}

	static int back() {
		if (num == 0) {
			return -1;
		}
		return queue[(rear == 0 ? capacity : rear) - 1];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		queue = new int[capacity];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				push(x);
			} else if (command.equals("pop")) {
				sb.append(pop()).append('\n');
			} else if (command.equals("size")) {
				sb.append(size()).append('\n');
			} else if (command.equals("empty")) {
				sb.append(empty()).append('\n');
			} else if (command.equals("front")) {
				sb.append(front()).append('\n');
			} else if (command.equals("back")) {
				sb.append(back()).append('\n');
			}
		}

		System.out.println(sb);
	}
}
