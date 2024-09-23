package search;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabeticalDFS {
	private static List<List<Character>> graph = new ArrayList<>();
	private static boolean[] visited = new boolean[26]; // 알파벳 개수만큼의 방문 배열

	public static void main(String[] args) {
		initializeGraph();

		// 그래프 간선 추가
		addEdge('a', 'b');
		addEdge('a', 'c');
		addEdge('b', 'h');
		addEdge('c', 'f');
		addEdge('f', 'e');
		addEdge('e', 'g');
		addEdge('e', 'd');
		addEdge('f', 'd');
		addEdge('h', 'e');

		// 그래프 각 인접 리스트 정렬 (알파벳 순으로 탐색하기 위해)
		for (List<Character> adjList : graph) {
			Collections.sort(adjList);
		}

		System.out.println("DFS 탐색 순서:");
		dfs('a');
	}

	// 간선 추가 함수 (양방향)
	private static void addEdge(char start, char end) {
		graph.get(start - 'a').add(end);
		graph.get(end - 'a').add(start);
	}

	// DFS 함수
	private static void dfs(char node) {
		int index = node - 'a';
		if (visited[index]) return;

		// 현재 노드 방문 처리
		visited[index] = true;
		System.out.print(node + " ");

		// 인접한 노드 재귀 방문
		for (char adjacent : graph.get(index)) {
			if (!visited[adjacent - 'a']) {
				dfs(adjacent);
			}
		}
	}

	// 그래프 초기화
	private static void initializeGraph() {
		for (int i = 0; i < 26; i++) {  // 알파벳 수만큼 리스트 초기화
			graph.add(new ArrayList<>());
		}
	}
}

