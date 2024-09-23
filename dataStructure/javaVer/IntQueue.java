public class IntQueue {

	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;

	public class EmptyIntQueue extends RuntimeException {
		public EmptyIntQueue() {}
	}

	public class OverflowIntQueue extends RuntimeException {
		public OverflowIntQueue() {}
	}

	public IntQueue(int capacity) {
		num = front = rear = 0;
		this.capacity = capacity;
		try{
			que = new int[capacity];
		} catch (OutOfMemoryError e){
			capacity = 0;
		}
	}

	public int enque(int x) throws OverflowIntQueue{
		if (num >= capacity) throw new OverflowIntQueue();

		que[rear++] = x;
		num++;

		if (rear == capacity) rear = 0;

		return x;
	}

	public int deque() throws EmptyIntQueue{
		if (num <= 0) throw new EmptyIntQueue();

		int x = que[front++];
		num--;
		if (front == capacity) front = 0;

		return x;
	}

	public int peek() throws EmptyIntQueue{
		if (num <= 0) throw new EmptyIntQueue();
		return que[front];
	}

	public void clear() {
		num = front = rear = 0;
	}

	public int indexOf(int x) {
		if (num <= 0) throw new EmptyIntQueue();
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x) return idx;
		}
		return -1;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return num;
	}


	// isFull, isEmpty, dump 등등 추가 구현 가능.
	public int search(int x) {
		if (num <= 0) throw new EmptyIntQueue();
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x) {

				return idx;
			}
		}
		return 0;
	}


}
