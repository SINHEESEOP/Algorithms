package sort;

import java.util.*;

public class kahnTopologicalSort {
	public static void main(String[] args) {
		// 정점 수와 간선 수
		int vertices = 6;

		// 그래프를 인접 리스트로 표현
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 추가 (방향 그래프)
		graph.get(5).add(2);
		graph.get(5).add(0);
		graph.get(4).add(0);
		graph.get(4).add(1);
		graph.get(2).add(3);
		graph.get(3).add(1);

		// 위상 정렬 수행
		List<Integer> topologicalOrder = kahnsTopologicalSort(graph, vertices);
		if (topologicalOrder != null) {
			System.out.println("위상 정렬 결과: " + topologicalOrder);
		} else {
			System.out.println("사이클이 존재하여 위상 정렬이 불가능합니다.");
		}
	}

	public static List<Integer> kahnsTopologicalSort(ArrayList<ArrayList<Integer>> graph, int vertices) {
		// 진입 차수 배열을 초기화
		int[] inDegree = new int[vertices];

		// 각 정점의 진입 차수를 계산
		for (int i = 0; i < vertices; i++) {
			for (int neighbor : graph.get(i)) {
				inDegree[neighbor]++;
			}
		}

		// 진입 차수가 0인 정점을 큐에 추가
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < vertices; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		// 위상 정렬 결과를 저장할 리스트
		List<Integer> result = new ArrayList<>();

		// 큐가 빌 때까지 처리
		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);

			// 인접한 정점들의 진입 차수를 감소시키고, 진입 차수가 0이 되면 큐에 추가
			for (int neighbor : graph.get(node)) {
				inDegree[neighbor]--;
				if (inDegree[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
		}

		// 사이클이 있는지 확인 (처리한 정점 수가 전체 정점 수와 다르면 사이클이 존재)
		if (result.size() != vertices) {
			return null; // 사이클 존재
		}

		return result;
	}
}

