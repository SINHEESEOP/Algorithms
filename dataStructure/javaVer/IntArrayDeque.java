import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayDeque<T> implements IntDeque<T> {
	private T[] deque;
	private int head, tail, size;
	private static final int DEFAULT_CAPACITY = 16;

	// 생성자
	@SuppressWarnings("unchecked")
	public IntArrayDeque() {
		deque = (T[]) new Object[DEFAULT_CAPACITY];
		head = 0;
		tail = 0;
		size = 0;
	}

	// 크기를 두 배로 늘리는 메서드
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newDeque = (T[]) new Object[deque.length * 2];
		for (int i = 0; i < size; i++) {
			newDeque[i] = deque[(head + i) % deque.length];
		}
		deque = newDeque;
		head = 0;
		tail = size;
	}

	@Override
	public void addFirst(T item) {
		if (size == deque.length) {
			resize();
		}
		head = (head - 1 + deque.length) % deque.length;  // 배열 끝에서 반대쪽으로 삽입
		deque[head] = item;
		size++;
	}

	@Override
	public void addLast(T item) {
		if (size == deque.length) {
			resize();
		}
		deque[tail] = item;
		tail = (tail + 1) % deque.length;
		size++;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		T item = deque[head];
		deque[head] = null;  // 메모리 누수 방지
		head = (head + 1) % deque.length;
		size--;
		return item;
	}


	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		tail = (tail - 1 + deque.length) % deque.length;
		T item = deque[tail];
		deque[tail] = null;  // 메모리 누수 방지
		size--;
		return item;
	}

	@Override
	public T peekFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque[head];
	}

	@Override
	public T peekLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return deque[(tail - 1 + deque.length) % deque.length];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	///////////////////////////////////////////////////////////////////////

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(T item) {
		addLast(item);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean offer(T t) {
		return false;
	}

	@Override
	public T remove() {
		return removeFirst();
	}

	@Override
	public T poll() {
		if (isEmpty()) return null;
		return removeFirst();
	}

	@Override
	public T element() {
		return peekFirst();
	}

	@Override
	public T peek() {
		if (isEmpty()) return null;
		return peekFirst();
	}

	// 메인 메서드로 테스트
	public static void main(String[] args) {
		IntArrayDeque<Integer> deque = new IntArrayDeque<>();
		deque.addFirst(1);
		deque.addLast(2);
		deque.addFirst(0);

		System.out.println(deque.removeFirst());  // 출력: 0
		System.out.println(deque.removeLast());   // 출력: 2
		System.out.println(deque.peekFirst());    // 출력: 1
	}
}

