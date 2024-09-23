import java.util.Queue;

public interface IntDeque<T> extends Queue<T> {
	// 앞쪽에 삽입
	void addFirst(T item);

	// 뒤쪽에 삽입
	void addLast(T item);

	// 앞쪽에서 원소 제거
	T removeFirst();

	// 뒤쪽에서 원소 제거
	T removeLast();

	// 앞쪽 원소 확인 (제거하지 않음)
	T peekFirst();

	// 뒤쪽 원소 확인 (제거하지 않음)
	T peekLast();
}
