package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스택 {

	int capacity;
	int[] stack;
	int ptr;

	public 스택(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		ptr = 0;
	}

	public void push(int x) {
		stack[ptr++] = x;
	}

	public int pop() {
		if (ptr == 0) return -1;
		return stack[--ptr];
	}

	public int size() {
		return ptr;
	}

	public int isEmpty() {
		return ptr == 0 ? 1 : 0;
	}

	public int top() {
		if (ptr == 0) return -1;
		return stack[ptr - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();  // 출력 최적화를 위한 StringBuilder 사용
		int n = Integer.parseInt(br.readLine());  // 명령어의 수

		// 스택을 구현했다고 가정
		스택 스택 = new 스택(n);

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
				case "push":
					스택.push(Integer.parseInt(command[1]));
					break;
				case "pop":
					sb.append(스택.pop()).append('\n');
					break;
				case "size":
					sb.append(스택.size()).append('\n');
					break;
				case "empty":
					sb.append(스택.isEmpty()).append('\n');
					break;
				case "top":
					sb.append(스택.top()).append('\n');
					break;
			}
		}

		System.out.print(sb);  // 최종 결과 출력
	}
}
