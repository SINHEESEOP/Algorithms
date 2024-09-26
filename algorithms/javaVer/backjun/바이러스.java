//package backjun;
//
//import java.util.*;
//
//public class 바이러스 {
//
//	static ArrayList<Integer>[] graph;  // 그래프를 인접 리스트로 표현
//	static List<Integer>[] visited;           // 방문 여부를 체크하는 배열
//	static StringBuilder sb = new StringBuilder();
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt(); // 정점의 개수
//		int m = sc.nextInt(); // 간선의 개수
//		int start = sc.nextInt(); // 시작 정점
//
//
//		// 그래프 초기화
//		graph = new ArrayList[n + 1];
//		for (int i = 1; i <= n; i++) {
//			graph[i] = new ArrayList<>();
//		}
//
//		// 간선 입력
//		for (int i = 0; i < m; i++) {
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//			graph[u].add(v);
//			graph[v].add(u);
//		}
//
//		// DFS 실행
//		visited = new ArrayList[n + 1]; // 방문 배열 초기화
//		dfs(start);
//		sb.append("\n");
//
//	}
//
//	static void dfs(int start) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(start);
//
//		while (!stack.isEmpty()) {
//			int node = stack.pop();
//			if (!visited[node]) {
//
//			}
//		}
//	}
//
//}
