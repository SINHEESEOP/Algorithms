package backjun;

public class 하노이의탑 {

	static int cnt;

	static void hanoi(int top,int start, int end, int temp) {
		cnt++;
		if (top <= 1) {
			System.out.println(start + " " + end);
			return;
		}
		hanoi(top-1,start, temp, end);
		System.out.println(start + " " + end);
		hanoi(top-1,temp, end, start);
	}



	public static void main(String[] args) {

		hanoi(3, 1, 3, 2);
		System.out.println(cnt);

	}


}


//n > end 로 가면 종료
//start > end 로 갔다가 > end 에서 sub 로 갔다가 > 마지막 n > end 로 가면 >