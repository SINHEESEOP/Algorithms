public class IntStack {

	private int[] stk; // 스택용 배열
	private int capacity; // 용량
	private int ptr; // 스택 포인트

	// 실행 시 예외 : 스택이 비어 있음.
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}

	// 실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			super("Stack overflow");
		}
	}

	public IntStack(int capacity) {
		ptr = 0;
		this.capacity = capacity;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public int push(int x) {
		if (ptr >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}

	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}

	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1];
	}

	public void clear() {
		ptr = 0;
	}

	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x) {
				return i;
			}
		}
		return -1;
	}


	public int size() {
		return ptr;
	}

	public boolean isEmpty() {
		return ptr == 0;
	}

	public boolean isFull() {
		return ptr >= capacity;
	}

	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		}
		else {
			for (int i = ptr - 1; i >= 0; i--) {
				System.out.print(stk[i] + " ");
			}
		}
	}

	public void dump2() {
		for (int i = 0; i < ptr; i++) {
			System.out.print(i + " ");
		}
	}

}

