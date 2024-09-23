package backjun;

import java.util.*;

public class SnakeGame {

	// 방향 이동: 우, 하, 좌, 상 (동, 남, 서, 북)
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 처리
		int N = sc.nextInt();  // 보드 크기
		int K = sc.nextInt();  // 사과의 개수

		int[][] board = new int[N][N];  // 보드 상태 (0: 빈 칸, 1: 사과)
		for (int i = 0; i < K; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			board[row][col] = 1;  // 사과 위치
		}

		int L = sc.nextInt();  // 방향 전환 정보의 개수
		Map<Integer, Character> turns = new HashMap<>();  // 방향 전환 정보 (시간, 방향)
		for (int i = 0; i < L; i++) {
			int time = sc.nextInt();
			char direction = sc.next().charAt(0);
			turns.put(time, direction);  // 방향 전환 정보를 저장
		}

		System.out.println(simulate(N, board, turns));
	}

	// 게임을 시뮬레이션하는 메서드
	public static int simulate(int N, int[][] board, Map<Integer, Character> turns) {
		Queue<int[]> snake = new LinkedList<>();  // 뱀의 몸을 큐로 관리
		snake.add(new int[]{0, 0});  // 뱀의 시작 위치 (0, 0)

		int direction = 0;  // 처음에 오른쪽(동쪽)으로 이동
		int time = 0;  // 게임 시간
		int x = 0, y = 0;  // 뱀의 머리 위치

		while (true) {
			time++;  // 매초 시간이 흐름
			// 뱀의 새로운 머리 위치
			int nx = x + dx[direction];
			int ny = y + dy[direction];

			// 벽에 부딪히거나 자신의 몸에 부딪히면 게임 종료
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || isCollision(nx, ny, snake)) {
				return time;
			}

			// 뱀의 머리를 새로운 위치로 이동
			snake.add(new int[]{nx, ny});

			// 사과가 있는지 확인
			if (board[nx][ny] == 1) {
				board[nx][ny] = 0;  // 사과를 먹으면 사과가 없어짐
			} else {
				snake.poll();  // 사과가 없으면 꼬리를 줄임
			}

			// 방향 전환 시간이 되었는지 확인
			if (turns.containsKey(time)) {
				char turn = turns.get(time);
				if (turn == 'L') {
					direction = (direction + 3) % 4;  // 왼쪽으로 회전 (90도)
				} else if (turn == 'D') {
					direction = (direction + 1) % 4;  // 오른쪽으로 회전 (90도)
				}
			}

			// 머리 위치 갱신
			x = nx;
			y = ny;
		}
	}

	// 뱀의 몸과 충돌 여부 확인
	public static boolean isCollision(int x, int y, Queue<int[]> snake) {
		for (int[] body : snake) {
			if (body[0] == x && body[1] == y) {
				return true;
			}
		}
		return false;
	}
}
