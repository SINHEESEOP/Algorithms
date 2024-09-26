package search;

import java.io.*;
import java.util.StringTokenizer;

public class BinaryTreeTraversal {

	static class ExNode {
		int data;
		ExNode left, right;

		public ExNode(int data) {
			this.data = data;
			left = right = null;
		}
	}

	//	전위 순회 (Pre-order Traversal)
	public void preOrder(ExNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " "); // 루트 방문
		preOrder(node.left);               // 왼쪽 서브트리 순회
		preOrder(node.right);              // 오른쪽 서브트리 순회
	}

	//	중위 순회 (In-order Traversal)
	public void inOrder(ExNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);                // 왼쪽 서브트리 순회
		System.out.print(node.data + " "); // 루트 방문
		inOrder(node.right);               // 오른쪽 서브트리 순회
	}

	//후위 순회 (Post-order Traversal)
	public void postOrder(ExNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);              // 왼쪽 서브트리 순회
		postOrder(node.right);             // 오른쪽 서브트리 순회
		System.out.print(node.data + " "); // 루트 방문
	}


	public static void main(String[] args) {
		ExNode root = new ExNode(1);
		root.left = new ExNode(2);
		root.right = new ExNode(3);
		root.left.left = new ExNode(4);
		root.left.right = new ExNode(5);

		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		System.out.print("Pre-order: ");
		tree.preOrder(root);  // 전위 순회
		System.out.println();

		System.out.print("In-order: ");
		tree.inOrder(root);   // 중위 순회
		System.out.println();

		System.out.print("Post-order: ");
		tree.postOrder(root); // 후위 순회
		System.out.println();
	}

}
