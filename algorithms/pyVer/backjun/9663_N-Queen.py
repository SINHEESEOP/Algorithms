# 각 열(col)에 퀸이 배치된 행(row)의 위치를 저장하는 배열과 변수 선언
board = []
N = 0
count = 0  # 가능한 퀸 배치의 경우의 수

# 퀸을 해당 열(col)에 행(row)에 놓을 수 있는지 확인하는 함수
def is_safe(col, row):
    for i in range(col):
        # i번째 열의 퀸과 현재 놓으려는 퀸이 같은 행에 있거나 대각선에 있으면 False 반환
        if board[i] == row or abs(board[i] - row) == abs(i - col):
            return False
    return True  # 충돌이 없다면 True 반환

# 열(col) 기준으로 퀸 배치를 재귀적으로 해결하는 함수
def solve_n_queens(col):
    global count
    if col == N:
        count += 1  # 모든 열에 퀸을 배치한 경우 경우의 수 증가
        return

    for row in range(N):
        if is_safe(col, row):  # 퀸을 놓을 수 있는지 확인
            board[col] = row  # 퀸을 해당 열에 배치
            solve_n_queens(col + 1)  # 다음 열로 넘어가서 퀸 배치 시도

# 메인 함수, 입력을 받고 N-Queens 문제를 해결하는 부분
def main():
    global board, N, count
    N = int(input())  # 사용자로부터 N 입력 받기
    board = [-1] * N  # N개의 열을 저장할 배열 초기화 (각 열에 퀸이 배치될 행 위치 저장)
    solve_n_queens(0)  # 0번째 열부터 시작하여 퀸 배치
    print(count)  # 가능한 퀸 배치의 경우의 수 출력

# 프로그램 실행
if __name__ == "__main__":
    main()




# 핵심은 인덱스를 열로보고 안에 들어간 값을 행으로 본다.
# is_safe 에 for 문의 i 값은 이전 열까지만 비교한다.
# 왜 why? 어차피 이번 열에는 아직 퀸을 놓지 않았기 때문이며, 걍 좀만 생각해도 확인할 필요가 없다..
# 첫 퀸은 무조건 true 로 넘어가기 때문에 인덱스가 0일때 조차 확인하지 않는다.
# 즉 col 이 1까지 넘어오면 0까지 돈다는 소리 즉 전 열까지 확인한다.
# 다시 행 설명으로 넘어가면 행도 for 문이 돌기 때문에
# 재귀로 인해 열은 계속 증가한다.
# 이후 만약 이후 0행 0열에 퀸을 뒀다면, 이후 0행 1열부터 다시 포문이 돈다.
# 다시 말해 0행 1열부터 n행 1열까지 전부 확인 즉 1열에 모든 행을 확인하고
# 행이 같은지 확인하고 같으면 행이 겹치기에 당연히 아웃! 이후 대각선은
# 대각선의 법칙 = 오른쪽 한칸 대각선 증가는 현재행 + 1, 현재열 + 1 일때이다.
# 즉 현재행 -1 과 현재열 -1 이 같다면 대각선이라는 뜻.