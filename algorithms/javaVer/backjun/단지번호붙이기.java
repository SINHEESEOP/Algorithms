package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {

	static int n;  // 지도의 크기
	static int[][] map;  // 지도 정보
	static boolean[][] visited;  // 방문 여부 체크
	static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동을 위한 배열
	static int[] dy = {0, 0, -1, 1};  // 상하좌우 이동을 위한 배열
	static ArrayList<Integer> result;  // 단지 내 집의 수를 저장할 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		result = new ArrayList<>();

		// 지도 정보 입력
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';  // 문자 '1' 또는 '0'을 숫자로 변환
			}
		}

		// 지도 전체를 순회하면서 단지 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {  // 집이 있고, 방문하지 않은 곳이면
					int houseCount = dfs(i, j);  // 단지 내 집의 수를 세기
					result.add(houseCount);  // 단지 결과 저장
				}
			}
		}

		// 결과 출력
		Collections.sort(result);  // 단지 내 집의 수를 오름차순 정렬
		System.out.println(result.size());  // 단지 수 출력
		for (int count : result) {
			System.out.println(count);  // 각 단지 내 집의 수 출력
		}
	}

	// DFS를 통해 연결된 집을 탐색하는 함수
	static int dfs(int x, int y) {
		visited[x][y] = true;  // 현재 위치 방문 처리
		int count = 1;  // 현재 집을 포함한 카운트

		// 상하좌우로 이동하면서 연결된 집들을 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 지도의 범위를 벗어나지 않고, 집이 있으며, 방문하지 않은 곳을 탐색
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					count += dfs(nx, ny);  // 연결된 집이 있으면 카운트를 증가시킴
				}
			}
		}

		return count;  // 총 집의 수 반환
	}
}

