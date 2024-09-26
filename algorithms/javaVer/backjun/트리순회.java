package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Node {
	char data;
	Node left, right;

	public Node(char data) {
		this.data = data;
		left = right = null;
	}
}

public class 트리순회 {
	static Map<Character, Node> tree = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 트리 구성
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			char parent = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);

			tree.putIfAbsent(parent, new Node(parent));

			if (left != '.') {
				tree.putIfAbsent(left, new Node(left));
				tree.get(parent).left = tree.get(left);
			}

			if (right != '.') {
				tree.putIfAbsent(right, new Node(right));
				tree.get(parent).right = tree.get(right);
			}
		}

		// 루트 노드는 항상 'A'로 주어짐
		preOrder(tree.get('A'));
		System.out.println();
		inOrder(tree.get('A'));
		System.out.println();
		postOrder(tree.get('A'));
	}

	// 전위 순회: 루트 -> 왼쪽 -> 오른쪽
	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data); // 루트
		preOrder(node.left);         // 왼쪽
		preOrder(node.right);        // 오른쪽
	}

	// 중위 순회: 왼쪽 -> 루트 -> 오른쪽
	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);          // 왼쪽
		System.out.print(node.data); // 루트
		inOrder(node.right);         // 오른쪽
	}

	// 후위 순회: 왼쪽 -> 오른쪽 -> 루트
	public static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);        // 왼쪽
		postOrder(node.right);       // 오른쪽
		System.out.print(node.data); // 루트
	}
}
