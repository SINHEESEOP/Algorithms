import java.util.Arrays;

public class StackMain {

	public static void main(String[] args) {
		IntStack stack = new IntStack(10);

		for (int i = 1; i < 11; i++) {
			stack.push(i);
		}
		stack.dump();

	}

}
