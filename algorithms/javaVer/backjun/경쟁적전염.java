package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus implements Comparable<Virus> {
	int x, y, type, time;

	public Virus(int x, int y, int type, int time) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.time = time;
	}

	// 바이러스 종류가 작은 것이 먼저 확산되도록 정렬
	@Override
	public int compareTo(Virus o) {
		return this.type - o.type;
	}
}

public class 경쟁적전염 {

	static int n, k;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동
	static int[] dy = {0, 0, -1, 1};  // 상하좌우 이동

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);  // 시험관의 크기
		k = Integer.parseInt(input[1]);  // 바이러스 종류 수

		map = new int[n][n];
		List<Virus> viruses = new ArrayList<>();

		// 시험관 상태 입력
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] != 0) {
					viruses.add(new Virus(i, j, map[i][j], 0));  // 바이러스 정보 저장
				}
			}
		}

		// S초와 (X, Y) 입력
		String[] sxy = br.readLine().split(" ");
		int S = Integer.parseInt(sxy[0]);  // S초 이후
		int targetX = Integer.parseInt(sxy[1]) - 1;  // X 좌표
		int targetY = Integer.parseInt(sxy[2]) - 1;  // Y 좌표

		// 바이러스 번호 순으로 정렬
		Collections.sort(viruses);

		// BFS 탐색을 위한 큐에 초기 바이러스 위치 삽입
		Queue<Virus> queue = new LinkedList<>(viruses);

		// BFS 실행
		while (!queue.isEmpty()) {
			Virus virus = queue.poll();

			// S초가 지나면 탐색 종료
			if (virus.time == S) break;

			// 현재 바이러스에서 상하좌우로 확산
			for (int i = 0; i < 4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];

				// 시험관의 범위를 벗어나지 않고, 아직 바이러스가 퍼지지 않은 곳일 때
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
					map[nx][ny] = virus.type;  // 바이러스 전파
					queue.add(new Virus(nx, ny, virus.type, virus.time + 1));  // 시간 +1 후 큐에 추가
				}
			}
		}

		// 결과 출력: S초 이후 (targetX, targetY)에 있는 바이러스 종류
		System.out.println(map[targetX][targetY]);
	}
}

