import sys

class Stack:
    def __init__(self, capacity):
        self.stack = []  # 스택은 리스트로 구현
        self.capacity = capacity  # 자바 코드에서의 capacity, 파이썬에서는 직접 사용하지 않지만 유지
        self.ptr = 0  # 스택의 현재 위치 (포인터)

    def push(self, x):
        self.stack.append(x)  # 스택에 값 추가
        self.ptr += 1  # 포인터 증가

    def pop(self):
        if self.ptr == 0:  # 스택이 비어있는 경우
            return -1
        self.ptr -= 1  # 포인터 감소
        return self.stack.pop()  # 스택에서 값 제거 및 반환

    def size(self):
        return self.ptr  # 스택의 크기 반환

    def isEmpty(self):
        return 1 if self.ptr == 0 else 0  # 스택이 비었으면 1, 아니면 0 반환

    def top(self):
        if self.ptr == 0:  # 스택이 비어있으면
            return -1
        return self.stack[-1]  # 스택의 최상단 값 반환

def main():
    n = int(sys.stdin.readline())  # 명령어의 수 입력
    stack = Stack(n)  # 스택 객체 생성
    result = []

    for _ in range(n):
        command = sys.stdin.readline().split()

        if command[0] == "push":
            stack.push(int(command[1]))
        elif command[0] == "pop":
            result.append(stack.pop())
        elif command[0] == "size":
            result.append(stack.size())
        elif command[0] == "empty":
            result.append(stack.isEmpty())
        elif command[0] == "top":
            result.append(stack.top())

    print(result)
    # 최종 결과 출력
    sys.stdout.write("\n".join(map(str, result)) + "\n")

if __name__ == "__main__":
    main()
