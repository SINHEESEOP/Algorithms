package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥장식 {

	static int n, m;
	static char[][] floor;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] dimensions = br.readLine().split(" ");
		n = Integer.parseInt(dimensions[0]);  // 행
		m = Integer.parseInt(dimensions[1]);  // 열

		floor = new char[n][m];
		visited = new boolean[n][m];

		// 바닥 정보 입력
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				floor[i][j] = row.charAt(j);
			}
		}

		int count = 0;

		// 전체 바닥을 순회하며 판자 카운팅
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					count++;  // 새로운 판자 발견 시 카운팅

					// 가로 판자인 경우
					if (floor[i][j] == '-') {
						dfsRow(i, j);  // 가로로 연결된 판자 방문 처리
					}
					// 세로 판자인 경우
					if (floor[i][j] == '|') {
						dfsColumn(i, j);  // 세로로 연결된 판자 방문 처리
					}
				}
			}
		}

		System.out.println(count);
	}

	// 가로로 연결된 '-'를 모두 방문 처리
	static void dfsRow(int x, int y) {
		visited[x][y] = true;

		// 같은 행에서 오른쪽으로 계속 연결된 '-' 찾기
		for (int j = y + 1; j < m; j++) {
			if (floor[x][j] == '-') {
				visited[x][j] = true;
			} else {
				break;
			}
		}
	}

	// 세로로 연결된 '|'를 모두 방문 처리
	static void dfsColumn(int x, int y) {
		visited[x][y] = true;

		// 같은 열에서 아래쪽으로 계속 연결된 '|' 찾기
		for (int i = x + 1; i < n; i++) {
			if (floor[i][y] == '|') {
				visited[i][y] = true;
			} else {
				break;
			}
		}
	}
}
