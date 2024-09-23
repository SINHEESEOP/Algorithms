package backjun;

import java.io.*;
import java.util.*;

public class 줄세우기 {
	public static void main(String[] args) throws IOException {
		// 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 학생 수와 비교한 횟수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 그래프와 진입 차수를 저장할 배열
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] inDegree = new int[N + 1];  // 각 학생의 진입 차수

		// 그래프 초기화
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// from 학생이 to 학생보다 먼저 서야 함
			graph.get(from).add(to);
			inDegree[to]++;  // to 학생의 진입 차수 증가
		}

		// 위상 정렬을 위한 큐와 결과 리스트
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		// 진입 차수가 0인 학생을 큐에 삽입
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		// 큐가 빌 때까지 처리
		while (!queue.isEmpty()) {
			int current = queue.poll();
			result.add(current);

			// 현재 학생 이후에 서야 할 학생들의 진입 차수를 감소시키고, 0이 되면 큐에 삽입
			for (int next : graph.get(current)) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int student : result) {
			sb.append(student).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
