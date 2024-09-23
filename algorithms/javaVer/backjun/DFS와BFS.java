package backjun;

import java.util.*;

public class DFS와BFS {
	static ArrayList<Integer>[] graph;  // 그래프를 인접 리스트로 표현
	static boolean[] visited;           // 방문 여부를 체크하는 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int start = sc.nextInt(); // 시작 정점

		// 그래프 초기화
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}

		// 정점 번호가 작은 순으로 방문하기 위해 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		// DFS 실행
		visited = new boolean[n + 1]; // 방문 배열 초기화
		dfs(start);
		sb.append("\n");

		// BFS 실행
		visited = new boolean[n + 1]; // 방문 배열 초기화
		bfs(start);

		// 결과 출력
		System.out.println(sb.toString());
	}

	// DFS 구현 (스택을 사용)
	public static void dfs(int node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		visited[node] = true;
		sb.append(node).append(" ");

		while (!stack.isEmpty()) {
			boolean flag = false;
			int current = stack.peek();

			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					stack.push(next);
					sb.append(next).append(" ");
					flag = true;
					break;
				}
			}

			if (!flag) {
				stack.pop();
			}
		}
	}

	// BFS 구현 (큐를 사용)
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append(start).append(" ");

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					sb.append(next).append(" ");
				}
			}
		}
	}
}
