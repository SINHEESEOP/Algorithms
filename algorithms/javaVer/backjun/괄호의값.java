package backjun;

import java.util.Stack;

public class 괄호의값 {

	public static void main(String[] args) {
		String input = "(()[[]])([])";
		System.out.println(calculateBracketValue(input));
	}

	public static int calculateBracketValue(String s) {
		Stack<Character> stack = new Stack<>();
		int temp = 1; // 현재 괄호의 곱셈 값
		int result = 0; // 최종 결과 값

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
				temp *= 2; // 여는 소괄호를 만나면 2배
			} else if (c == '[') {
				stack.push(c);
				temp *= 3; // 여는 대괄호를 만나면 3배
			} else if (c == ')') {
				// 스택이 비어있지 않고, 여는 소괄호인지 확인
				if (stack.isEmpty() || stack.peek() != '(') {
					return 0; // 잘못된 괄호 쌍
				}
				// 이전 괄호가 올바른 쌍이라면
				if (s.charAt(i - 1) == '(') {
					result += temp;
				}
				stack.pop(); // 짝이 맞으면 pop
				temp /= 2; // 소괄호 계산을 마쳤으므로 2로 나눈다.
			} else if (c == ']') {
				// 스택이 비어있지 않고, 여는 대괄호인지 확인
				if (stack.isEmpty() || stack.peek() != '[') {
					return 0; // 잘못된 괄호 쌍
				}
				// 이전 괄호가 올바른 쌍이라면
				if (s.charAt(i - 1) == '[') {
					result += temp;
				}
				stack.pop(); // 짝이 맞으면 pop
				temp /= 3; // 대괄호 계산을 마쳤으므로 3으로 나눈다.
			}
		}

		// 스택이 비어있지 않으면 올바르지 않은 괄호 문자열
		if (!stack.isEmpty()) {
			return 0;
		}

		return result;
	}
}
