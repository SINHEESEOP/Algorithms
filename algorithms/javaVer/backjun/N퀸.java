package backjun;

public class N퀸 {

	public static int[] board;  // 각 열(col)에 퀸이 배치된 행(row)의 위치를 저장하는 배열
	public static int N;        // 체스판 크기 (N x N)
	public static int count = 0; // 가능한 퀸 배치의 경우의 수

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		N = sc.nextInt();  // 사용자로부터 N 입력 받기
		board = new int[N]; // N개의 열을 저장할 배열 초기화 (각 열에 퀸이 배치될 행 위치를 저장)
		solveNQueens(0);    // 0번째 열부터 시작하여 퀸을 배치
		System.out.println(count);  // 퀸을 서로 공격하지 않게 배치하는 경우의 수 출력
	}

	// 열(col) 기준으로 퀸 배치를 재귀적으로 해결
	public static void solveNQueens(int col) {
		if (col == N) {
			count++; // 모든 열에 퀸을 배치한 경우 경우의 수 증가
			return;
		}

		// 각 행(row)에서 퀸을 배치할 수 있는지 확인
		for (int row = 0; row < N; row++) {
			if (isSafe(col, row)) {
				board[col] = row; // 해당 열에 퀸을 놓을 수 있으면 행 위치 기록
				solveNQueens(col + 1); // 다음 열로 넘어가서 퀸 배치 시도
			}
		}
	}

	// 퀸을 해당 열(col)의 행(row)에 놓을 수 있는지 확인
	public static boolean isSafe(int col, int row) {
		for (int i = 0; i < col; i++) {
			// i번째 열의 퀸과 현재 놓으려는 퀸이 같은 행에 있거나, 대각선에 있으면 false 반환
			if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
				return false;  // 퀸이 같은 행 또는 대각선에 있어 충돌하면 안전하지 않음
			}
		}
		return true;  // 충돌이 없다면 해당 위치에 퀸을 놓을 수 있음
	}

}
